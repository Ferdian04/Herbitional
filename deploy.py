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

# Transform the input text using the loaded vectorizer
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
    print(predicted_labels)
    selected_ids = []  # Initialize an empty list

    for name in predicted_labels:
        selected_ids.extend(khasiat.loc[khasiat['nama_obat'] == name, 'id'].tolist())
    print(selected_ids)

    # Return the top 5 predicted labels, their probabilities, and IDs
    return predicted_labels[::-1], top_k_probabilities[::-1]


# Test the prediction function
input_text = 'sakit'
predicted_labels, probabilities = predict(input_text)

# Print the results
print(f"User input: {input_text}")
print("Top 5 Predicted Labels:")
for label, probability in zip(predicted_labels, probabilities):
    if probability >= 0:
        print(f"{label}: {probability:.4f}")
