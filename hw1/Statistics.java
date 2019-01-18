package hw1;

import java.util.Scanner;

public class Statistics { 

	public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        System.out.print("Please input num1: ");
        int num1 = scan.nextInt();

        System.out.print("Please input num2: ");
        int num2 = scan.nextInt();

        System.out.print("Please input num3: ");
        int num3 = scan.nextInt();
        
        Statistics.display_statistics(num1, num2, num3);
        scan.close();
    }
    
    public static void display_statistics( int num1, int num2, int num3 ) {

    	int sum = num1 + num2 + num3;
    	System.out.println("The sum is " + sum);
    	
    	// max(num1, num2, num3) = max(max(num1, num2), num3)
    	int tempmax = Math.max(num1, num2);
    	int max = Math.max(tempmax, num3);
    	System.out.println("The maximum is " + max);
    	
    	// min(num1, num2, num3) = min(min(num1, num2), num3)
    	int tempmin = Math.min(num1, num2);
    	int min = Math.min(tempmin, num3);
    	
    	int range = max - min;
    	System.out.println("The range is " + range);
    	
    	double mean = (double) sum / 3;
    	String strMean = String.format("%.4f", mean);
    	System.out.println("The mean is " + strMean);
    	
    	double var = (Math.pow((double)(num1 - mean), 2.0) + 
    			      Math.pow((double)(num2 - mean), 2.0) + 
    			      Math.pow((double)(num3 - mean), 2.0))/3;
    	double stdev = Math.sqrt(var);
    	String strStdev = String.format("%.4f", stdev);
    	System.out.println("The (population) standard deviation is " + strStdev);
    	
    	int median = sum - max - min;
    	System.out.println(min + " " + median + " " + max);
    }
}
