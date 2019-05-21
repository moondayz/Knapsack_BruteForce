import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.concurrent.TimeUnit;



public class Knapsack {


	static int capacity ;
	static int n =20;
	static int[][] list = new int[n][2] ;
	static int sumOfValue ;
	static int sumOfWeight;
	static String cVector="" ;
	private static boolean current[];   // true entries = items in current candidate
	private static boolean solution[];  // true entries = items giving best value
    private static int bestSoFar;   // best value found so far
	
	
public static void main(String[] args)  {
		
		
		File infoData = new File("src/1.txt");
		readFile(infoData , list);
		n = list.length; 
		bruteForce(n,capacity);
	
		//------------- Calculating Execution Time ----------------//
		
		 long startTime = System.nanoTime();
		 
		    methodToTime();   //Measure execution time for this method
		 
		    long endTime = System.nanoTime();
		 
		    long durationInNano = (endTime - startTime);  //Total execution time in nano seconds
		 
		    //Same duration in millis
		     
		    long durationInMillis = TimeUnit.NANOSECONDS.toMillis(durationInNano);  //Total execution time in nano seconds
		    
		    System.out.println("----------------------------------------------------------");
		    System.out.println("Duration in nano : " + durationInNano);
		    System.out.println("Duration in miles : " +durationInMillis);
		
	
	}

private static void methodToTime() {
    try {
      TimeUnit.SECONDS.sleep(3);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }
	
	
	
private static void bruteForce(int n2, int capacity2) {
		
	bestSoFar = Integer.MIN_VALUE;
    solution = new boolean[n];
    current = new boolean[n];
    
    solve(n-1);

    printSolution();
	
	
	}


private static void solve(int k) {
	
	if(k<0) {
		 sumOfWeight = 0;
		 sumOfValue = 0; 
		 
		 for (int i = 0; i < n; i++) {
		        if (current[i]) {
		        	sumOfWeight += list[i][1];
		        	sumOfValue += list[i][0];
		        
		        }
		       
		      }

		 // Check to see if we've got a better solution:
	      if (sumOfWeight <= capacity && sumOfValue > bestSoFar) {
	        bestSoFar = sumOfValue;
	        copySolution();
	        
	      }

	      return;
	    }
	
	// Recursive case: there are two possibilities for item k -- either
    // we select it for the knapsack or we don't. Try each possibility:
  current[k] = true; 
	  solve(k-1);
	  

   

   current[k] = false;
	   solve(k-1); 
	  
	
	}
	
private static void copySolution() {
	
	 for (int i = 0; i < n; i++)
	      solution[i] = current[i];
	
}





private static void printSolution() {
	 
	 int sw=0;
	 System.out.println("Capacity : " + capacity);
	 System.out.println("Best value (sum of value): "+ bestSoFar);
	 
	 
	 for (int i = 0; i < n; i++) {
		 if(solution[i]) {
			
			sw += list[i][1];
			cVector += "1";
		 }
		 else {
			 cVector += "0";
		 }
	 }
	 
	 System.out.println("Sum of Weight : " + sw);
	 System.out.println("Characteristic Vector : " + cVector);
	 
}


	private static void readFile(File file,  int[][] list) {
		
		try {
			BufferedReader input = new BufferedReader(new FileReader(file));
			String line;
			int k =1;
			int i =0;
			while((line = input.readLine()) != null ) {
				if(k ==1 ) {
					// reads first line as capacity.
					capacity = Integer.parseInt(line);
					k++;	
				}
				else	{
					
						String[] seperate=line.split(" ");
						list[i][0]= Integer.parseInt(seperate[0]);
						list[i][1]= Integer.parseInt(seperate[1]);
						i++;
					
					
				}
			}
		
		}
		 catch (FileNotFoundException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        } catch (IOException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        }
	}



	

}
