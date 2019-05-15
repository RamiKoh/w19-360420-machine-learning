import java.util.List;
import java.io.FileNotFoundException;
import java.util.Arrays;



public class kNNMain
{
  public static void main(String... args) throws FileNotFoundException
  {
    // TASK 1: Use command line arguments to point DataSet.readDataSet method to
    // the desired file. Choose a given DataPoint, and print its features and label
	 double [] accuracypercent = new double [1000];
	 double [] precision = new double [1000];
	 double [] recall = new double [1000];
	 
	 for (int johncena = 0; johncena < 1000; johncena++) 
	 {
		 String pathToData = args[0];
		 List<DataPoint> Data = DataSet.readDataSet(pathToData);
		 //System.out.println(pathToData);
		 
		 DataPoint randompt = Data.get(75);
		// System.out.println("Printing label: " + randompt.label);
		 
		 String convertedlist = Arrays.toString(randompt.getX());
		 //System.out.println(convertedlist);
	
	    //TASK 2:Use the DataSet class to split the fullDataSet into Training and Held Out Test Dataset
		 double fractionTrainingSet = 0.3;
		 double fractionTestSet = 1.0 - fractionTrainingSet;
		 
		 List<DataPoint> testSet = DataSet.getTestSet(Data, fractionTestSet);
		 List<DataPoint> trainingSet = DataSet.getTrainingSet(Data, fractionTrainingSet);
		 
	
	    // TASK 4: write a new method in DataSet.java which takes as arguments two DataPoint objects,
	    // and returns the Euclidean distance between those two points (as a double)
	
		 /*double dist = DataSet.distanceEuclid();
		 Sytem.out.println("Distance: " + dist);*/
		 //Done in DataSet anyway
	
	    // TASK 5: Use the KNNClassifier class to determine the k nearest neighbors to a given DataPoint,
	    // and make it print a predicted target label
		 
		 DataPoint dp = testSet.get(10);
		 KNNClassifier myObject = new KNNClassifier(3);
		 String stuff = myObject.predict(trainingSet, dp);
		 //System.out.println(stuff);
		 
	
	    // TASK 6: loop over the datapoints in the held out test set, and make predictions for Each
	    // point based on nearest neighbors in training set. Calculate accuracy of model.
	  
	  /*
	  Method that takes as an argument an array of doubles
	  Returns: average of the elements of array, as a double
	  */
	  
	  double norman = 0.0;
	  double reedus= 0.0;
	  double elonmosquito = 0.0;
	  double markzucchini = 0.0; 
	  double DnD = 0.0; 
	  
	  for (int i = 0; i < testSet.size(); i++)
	  {
		  KNNClassifier myObject2 = new KNNClassifier(9);
		  DataPoint apoint = testSet.get(i);
		  String first = apoint.getLabel();
		  String predicted = myObject2.predict(trainingSet, apoint);
		  
		  if (predicted.equals(first))
		  {
			  norman++;
			  if (predicted.equals("malignant"))
			  {
				markzucchini++;
			  }
		  }
		  if (predicted.equals("malignant"))
			{  
				elonmosquito++;
			}
			 if (apoint.equals("malignant"))
			{     
				DnD++;
			}
		  reedus++;
		  //System.out.println(first + "     " + predicted);
	  }
	  accuracypercent[johncena] = (norman/reedus)*100;
	  recall[johncena] = (markzucchini/norman)*100;
	  precision[johncena]= (markzucchini/elonmosquito)*100;
	  
	  System.out.println("Iteration #" + (johncena+1));
	  System.out.println("Accuracy: " + accuracypercent[johncena]);
	  System.out.println("Precision: "+ precision[johncena]);
	  System.out.println("Recall: "+ recall[johncena]);
	}
	  System.out.println("Average Precision: "+ mean(precision));
	  System.out.println("Average Recall: "+ mean(recall));
	  System.out.println("Mean: " + mean(accuracypercent));
	  System.out.println("Standard Deviation: " + standardDeviation(accuracypercent));
}
  
  public static double mean(double[] arr){
	    /*
	    Method that takes as an argument an array of doubles
	    Returns: average of the elements of array, as a double
	    */
	    double sum = 0.0;

	    for (double a : arr){
	      sum += a;
	    }
	    return (double)sum/arr.length;
	  }

	  public static double standardDeviation(double[] arr){
	    /*
	    Method that takes as an argument an array of doubles
	    Returns: standard deviation of the elements of array, as a double
	    Dependencies: requires the *mean* method written above
	    */
	    double avg = mean(arr);
	    double sum = 0.0;
	    for (double a : arr){
	      sum += Math.pow(a-avg,2);
	    }
	    return (double)sum/arr.length;
	  }
}
