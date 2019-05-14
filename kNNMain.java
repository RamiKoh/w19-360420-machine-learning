import java.util.List;
import java.io.FileNotFoundException;
import java.util.Arrays;



public class kNNMain
{

  public static void main(String... args) throws FileNotFoundException
  {   
	  double [] array = new double [1000];
      for ( int v = 0 ; v < 1000; v++)
	  {
    // TASK 1: Use command line arguments to point DataSet.readDataSet method to
    // the desired file. Choose a given DataPoint, and print its features and label
    	  
	   String datapath = args[0] ; 
	   List <DataPoint> Data = DataSet.readDataSet(datapath);
	   System.out.println(datapath);
	   
	   DataPoint a = Data.get(70); 
	   String flower = Arrays.toString(a.getX()) ;
	   //System.out.println ( "Label "+ a +  flower);
     	  
	   
	   
	//TASK 2:Use the DataSet class to split the fullDataSet into Training and Held Out Test Dataset
	
	List < DataPoint> test =  DataSet.getTestSet(Data, 0.3); 
	List < DataPoint> training =  DataSet.getTrainingSet(Data, 0.7); 

    // TASK 4: write a new method in DataSet.java which takes as arguments to DataPoint objects,
    // and returns the Euclidean distance between those two points (as a double)
		//DONE

    // TASK 5: Use the KNNClassifier class to determine the k nearest neighbors to a given DataPoint,
    // and make a print a predicted target label
	      DataPoint point =  test.get(10);
		  KNNClassifier mine = new KNNClassifier (3); 
		  String myprecious = mine.predict(training,point); 
         // System.out.print(myprecious);
        	

    // TASK 6: loop over the datapoints in the held out test set, and make predictions for Each
    // point based on nearest neighbors in training set. Calculate accuracy of model.
		  double gold= 0.0;
		  double k = 0.0;
		 
		  for ( int i=0; i< test.size() ; i++)
		  {
			 KNNClassifier Thorin = new KNNClassifier (9); 
			 DataPoint Gandalf = test.get(i);  
			 String Dwallin = Gandalf.getLabel(); 
			 String hobbit = Thorin.predict(training,Gandalf);
			  
			   
			   if(hobbit.equals(Dwallin))
			   {
					gold++;
			   }		
			   k++;
		  }//end for
			array[v] = (( gold/k)*100);
			
			System.out.println("Number of Iteration "+ (v+1));
			System.out.println("The Accuracy: " + array[v]);
		
	    }//end for for 1000
			System.out.println( "mean equals  "+ mean(array));
			System.out.println( " Standard deviation equals " + standardDeviation(array));			
}//end main



 public static double mean(double[] arr)
 {
	   
	    /*Method that takes as an argument an array of doubles
	    Returns: average of the elements of array, as a double*/
	    
	    double sum = 0.0;

	    for (double a : arr)
		{
	      sum += a;
	    }
	    return (double)sum/arr.length;
	 }

	  public static double standardDeviation(double[] arr)
	  {
	    
	   /* Method that takes as an argument an array of doubles
	    Returns: standard deviation of the elements of array, as a double
	    Dependencies: requires the *mean* method written above*/
	    
	    double avg = mean(arr);
	    double sum = 0.0;
	    for (double a : arr)
		{
	      sum += Math.pow(a-avg,2);
	    }
	    return (double)sum/arr.length;
	  }
}