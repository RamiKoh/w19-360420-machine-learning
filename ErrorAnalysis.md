# Object oriented programming lab report

## Computer Programming - section 02 

## Ikram Kohil and Doria Bouzerar

## Distributions of Model Accuracy


## Analysis of different error types

**Why is the accuracy different with each new run of the classification model?** 
     Because there is a shuffle! In other words, the line “Collections.shuffle(fullDataSet)”   rearranges the elements of the array in a random order every time the getTestSet() method is called. 
Run the entire classification process 1000 times (load data, split into off 30% for a test set, evaluate model performance). Store the results of each run in a double[]; use the mean and standardDeviation methods in kNNMain.java to calculate how much performance can be expected to vary on unseen data.
     The average accuracy is equal to 76.982 % and the standard deviation is equal to 69.820%. A large standard deviation means that the data are further from the mean (more spread out). This means that the model is not as accurate as it would be for a model with a lower standard deviation, in which the data points are near each other. The model therefore does not represent the data properly.   
What is a sensible baseline against which we should compare our model's performance?
     line 200: printLabelFrequencies method, which prints the frequency at which different labels appear (benign and malignant in the case of the breast cancer data set.

**The types of errors that our classifier makes; Accuracy is only one way that we can evaluate model performance. However in the context of medical diagnosis, different types of classification errors carry importances. 
What is a**
     *False Positive:* Is when a patient is falsely diagnosed with a disease, but he/she is in good health.
     *False negative:* Is when a sick patient is not diagnosed sick.

**Extend your analysis in the previous step (with the 1000 runs) to keep track of Recall and Precision as well. What makes these two measures different?**
     *Precision:* Number of correct results (true positives) divided by the number of all results. Equation: True Positives/Actual Results.
     *Recall:* Number of correct results divided by the number of results that should have been returned, so the percentage of results that were correctly classified by the predict() method. Equation: True Positive/Predicted Results.

**What are sensible baselines for each of these measures?**
     The selected elements and the relevant elements 
**How do the above results change with the hyperparameter k? **
