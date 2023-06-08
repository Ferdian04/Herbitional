document.addEventListener('DOMContentLoaded', async () => {
    // Load the TensorFlow.js model
    const model = await tf.loadLayersModel('tf-model/model.json');
  
    // Function to preprocess the input text
    function preprocessInputText(inputText) {
      // Lowercase the text
      inputText = inputText.toLowerCase();
  
      // Remove special characters and numbers
      inputText = inputText.replace(/\d+|\$/g, '');
      inputText = inputText.replace(/[^\w\s]/g, '');
  
      // Tokenization
      inputText = inputText.split(/\s+/);
  
      // Remove stop words
      const stopWords = new Set(['the', 'and', 'or', 'if', 'in', 'is', 'it', 'an', 'as', 'at', 'of', 'for', 'on', 'by', 'to']);
      inputText = inputText.filter((word) => !stopWords.has(word));
  
      // Lemmatization
      inputText = inputText.map((word) => {
        // Perform lemmatization for each word using your own rules or a lemmatization library
  
        // Example using a simple lemmatization rule
        if (word.endsWith('s')) {
          return word.slice(0, -1); // Remove the 's' suffix
        }
        return word;
      });
  
      // Convert the preprocessed data back to string
      inputText = inputText.join(' ');
  
      return inputText;
    }
  
    // Function to predict labels based on input text
    function predict(inputText) {
      // Preprocess the input text
      inputText = preprocessInputText(inputText);
  
      // Transform the input text into a tensor
      const inputTensor = tf.tensor2d([inputText]);
  
      // Make predictions using the loaded model
      const predictions = model.predict(inputTensor);
  
      // Get the top predicted label
      const topPrediction = predictions.argMax(1).dataSync()[0];
  
      // Map the predicted label index to the actual label
      const labelMap = {0: 'Label 1', 1: 'Label 2', 2: 'Label 3', 3: 'Label 4', 4: 'Label 5'};
      const predictedLabel = labelMap[topPrediction];
  
      // Display the predicted label
      const resultsElement = document.getElementById('results');
      resultsElement.innerText = `Predicted Label: ${predictedLabel}`;
    }
  
    // Handle the predict button click event
    const predictButton = document.getElementById('predict-button');
    predictButton.addEventListener('click', () => {
      const inputText = document.getElementById('input-text').value;
      predict(inputText);
    });
  });
  