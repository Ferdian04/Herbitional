import numpy as np
import pandas as pd
import re
import string
import nltk
from nltk.corpus import stopwords
from nltk.tokenize import word_tokenize
import tensorflow as tf
from sklearn.feature_extraction.text import TfidfVectorizer
from sklearn.preprocessing import LabelEncoder
import joblib
from flask import Flask, jsonify, request
from flask_mysqldb import MySQL

# Download NLTK resources
nltk.download('punkt')
nltk.download('stopwords')
nltk.download('wordnet')

def preprocess_input_text(input_text):
    # Lowercase the text
    input_text = input_text.lower()

    # Remove special characters and numbers
    input_text = re.sub(r'\d+|\$', '', input_text)
    input_text = input_text.translate(str.maketrans('', '', string.punctuation))

    # Tokenization
    input_text = word_tokenize(input_text)

    # Remove stop words
    stop_words = set(stopwords.words('indonesian'))
    input_text = [word for word in input_text if word not in stop_words]

    # Convert the preprocessed data back to string
    input_text = ' '.join(input_text)

    return input_text

# Load the saved model
model = tf.keras.models.load_model('tf-model/artikel-obat-model.h5')

# Load the vectorizer and label encoder
vectorizer = joblib.load('tf-model/vectorizer.pkl')
label_encoder = joblib.load('tf-model/label_encoder.pkl')

# Load the preprocessed data
khasiat = pd.read_csv('khasiat.csv')

# Set up Flask application and MySQL connection
app = Flask(__name__)
app.config['MYSQL_HOST'] = 'localhost'  # MySQL server host
app.config['MYSQL_USER'] = 'fahrialmd'  # MySQL username
app.config['MYSQL_PASSWORD'] = '7'  # MySQL password
app.config['MYSQL_DB'] = 'herb'  # MySQL database name

mysql = MySQL(app)

# Transform the input text using the loaded vectorizer and retrieve row from MySQL based on predicted ID
def predict(input_text):
    input_text = preprocess_input_text(input_text)
    input_text_tfidf = vectorizer.transform([input_text])

    # Make predictions using the loaded model
    predictions = model.predict(input_text_tfidf.toarray())

    # Get the top 5 predicted labels and their corresponding probabilities
    top_k = 10
    top_k_indices = np.argsort(predictions, axis=1)[:, -top_k:][0]
    top_k_probabilities = predictions[0, top_k_indices]

    # Convert the predicted label indices to category labels
    predicted_labels = label_encoder.inverse_transform(top_k_indices)

    # Retrieve the IDs of the predicted labels
    predicted_ids = khasiat.loc[top_k_indices, 'id']

    # Connect to the database
    conn = mysql.connection
    cursor = conn.cursor()

    # Retrieve the entire row from MySQL based on the predicted ID
    results = []
    for predicted_id in predicted_ids:
        cursor.execute(f"SELECT * FROM tabel_artikel WHERE id = {predicted_id}")
        row = cursor.fetchone()
        if row:
            results.append(row)

    cursor.close()

    # Return the top 5 predicted labels, their probabilities, and the retrieved rows
    return predicted_labels[::-1], top_k_probabilities[::-1], results[::-1]

# Define a route to handle incoming requests
@app.route('/predict', methods=['POST'])
def handle_prediction():
    # Get the input text from the request
    input_text = request.json['input-text']

    # Perform prediction and retrieve rows from the database
    predicted_labels, probabilities, results = predict(input_text)

    # Create a response JSON
    response = {
        'input_text': input_text,
        'predictions': []
    }

    # Add predictions and retrieved rows to the response JSON
    for label, probability, result in zip(predicted_labels, probabilities, results):
        if probability >= 0.1:
            prediction = {
                'predicted_id': result[0],  # Assuming ID is the first column in your_table
                'label': label,
                'probability': probability.item(),
                'row': result  # Entire row from the database
            }
            response['predictions'].append(prediction)

    # Return the response as JSON
    return jsonify(response)

@app.route('/')
def index():
    return 'Hello, World!'

# Run the Flask application
if __name__ == '__main__':
    app.run(debug=True, port=8080)
