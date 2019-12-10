/**
 * @author Mr. Rasmussen
 */

package fracCalc;
import java.util.Scanner;

public class FracCalc {
 
    public static void main(String[] args)
    {
        Scanner userInput = new Scanner (System.in);
        System.out.println("Hi! Welcome to the FracCalc!");
        System.out.print("Please enter a fraction problem: ");
        String userResponse = userInput.nextLine();
        while (!userResponse.equals("quit")) {
            System.out.println(produceAnswer(userResponse));
            System.out.print("Please enter a fraction problem: ");
            userResponse = userInput.nextLine();
           
        }
       
 
    }
 
    // ** IMPORTANT ** DO NOT DELETE THIS FUNCTION.  This function will be used to test your code
    // This function takes a String 'input' and produces the result
    //
    // input is a fraction string that needs to be evaluated.  For your program, this will be the user input.
    //      e.g. input ==> "1/2 + 3/4"
    //
    // The function should return the result of the fraction after it has been calculated
    //      e.g. return ==> "1_1/4"
    public static String produceAnswer(String input) {
        boolean term1Neg = false;
        boolean term2Neg = false;
       
        // identifies operator
        String op = input.substring(input.indexOf(" ") + 1);
        op = op.substring(0, op.indexOf(" "));
       
        // identifies 1st and 2nd term
        String term1 = input.substring(0, input.indexOf(" "));
       
        String term2 = input.substring(input.indexOf(" ") + 1);
        term2 = term2.substring(term2.indexOf(" ") + 1);
 
        // separates into numerators and denominators
        int num1;
        int num2;
        if(term1.indexOf("-") != -1 && term1.indexOf("_") != -1) {
            num1 = (Integer.parseInt(findWhole(term1)) * 
            		Integer.parseInt(findDenom(term1))) - 
            		Integer.parseInt(findNum(term1));    
        } else {
            num1 = Integer.parseInt(findNum(term1)) + 
            		(Integer.parseInt(findWhole(term1)) * 
            				Integer.parseInt(findDenom(term1)));    
        }
        if(term2.indexOf("-") != -1 && term2.indexOf("_") != -1) {
            num2 = (Integer.parseInt(findWhole(term2)) * 
            		Integer.parseInt(findDenom(term2))) - 
            		Integer.parseInt(findNum(term2));        
        } else {
            num2 = Integer.parseInt(findNum(term2)) + 
            		(Integer.parseInt(findWhole(term2)) * 
            				Integer.parseInt(findDenom(term2)));
        }
       
        int denom1 = Integer.parseInt(findDenom(term1));
        int denom2 = Integer.parseInt(findDenom(term2));
       
     // calculations
        int finalNum, finalDenom;
        
        if(op.equals("+")) {
        	
        	//reduce
        	String reduced = reduce(((num1 * denom2) + (num2 * denom1)), (denom1 * denom2));
        	
            finalNum = (num1 * denom2) + (num2 * denom1);
            finalDenom = denom1 * denom2;
            
         // what if the denominator is negative but numerator is positive?
            if (finalDenom < 0) {
            	return reduce(-finalNum, Math.abs(finalDenom));
            }
            
        } else if(op.equals("-")) {
        	
        	//reduce
        	String reduced = reduce((num1 * denom2), (num2 * denom1));
        	
            finalNum = (num1 * denom2) - (num2 * denom1);
            finalDenom = denom1 * denom2;
            
         // what if the denominator is negative but numerator is positive?
            if (finalDenom < 0) {
            	return reduce(-finalNum, Math.abs(finalDenom));
            }
            
        } else if(op.equals("/")) {
        	
        	//reduce
        	String reduced = reduce((num1 * denom2), (num2 * denom1));
        	
            finalNum = num1 * denom2;
            finalDenom = num2 * denom1;
            
            // what if the denominator is negative but numerator is positive?
            if (finalDenom < 0) {
            	return reduce(-finalNum, Math.abs(finalDenom));
            }
            
        } else if(op.equals("*")) {
        	
        	String reduced = reduce((num1 * num2), (denom1 * denom2));
            finalNum = num1 * num2;
            finalDenom = denom1 * denom2;
            
            // what if the denominator is negative but numerator is positive?
            if (finalDenom < 0) {
            	return reduce(-finalNum, Math.abs(finalDenom));
            }
            
        } else {
        	
           return "Invalid expression";   
        }
                   
        return reduce(finalNum, finalDenom);
        
    }
    public static int gcf(int numerator, int denominator) {
   	 
    	int temp; 
    	while (numerator != 0 && denominator != 0) {
    		
    		temp = denominator;
    		denominator = numerator % denominator;
    		numerator = temp;
    		
    	}
    	
    	return Math.abs(numerator + denominator);
    }
   public static String reduce(int num, int den) { //not reduced numerator and denominator
	   
	   int gcf = gcf(num, den);
	   num = num/ gcf;
	   den = den / gcf;
	  
	   // what if denominator is 1?
	 if (den == 1) {
		   
		   return "" + num;
		   
		  // simplify to a whole number ex: 4/2 -> 2
       } else if (num % den == 0 && den != 0) {
	 
    		   return "" + (num / den);
 
    	   // simplify to a mixed fraction ex: 17/8 -> 2_1/8
       } else if (num % den != 0 || -(num % den) != 0) {
    
    	   //unless the mixed fraction can be simplified into a whole number
    	   if ((num / den) == 0) {
    		   
    		   return num + "/" + den;
    	   }
    	   int numRemainder = Math.abs(num % den);
    	   return (num / den) + "_" + numRemainder + "/" + Math.abs(den);
    	     	   
       } else {
		   
	   return num + "/" + Math.abs(den);
	   
	   }
	   
   }
   
    public static String findWhole(String a) {
           
        if (a.indexOf('_') != -1) {
            //mixed number example: 6_3/4
           
            String underscore = a.substring(0, a.indexOf('_'));
        return underscore;
       
        } else if (a.indexOf('/') != -1) {
            //fraction example: 4/5
           
        String frac = a.substring(0, a.indexOf('/'));
       
        return "0";
       
        } else {
            // whole number
           
            return a;
       
    }          
}
    public static String findNum(String b) {
         
        if (b.indexOf('_') != -1) {
            // mixed number
           
        String mixed = b.substring(b.indexOf('_') + 1, b.indexOf('/'));
       
        return mixed;
        } else if (b.indexOf('/') != -1) {    
            //fraction
           
            String fract = b.substring(0, b.indexOf('/'));
            return fract;
                   
        } else {
            //whole number
           
            return "0";
           
        }      
    }
   
    public static String findDenom(String c) {
       
        if (c.indexOf('/') != -1) {
            //mixed number and fraction
           
            String mF = c.substring(c.indexOf('/') + 1);
           
            return mF;
           
        } else {
            //whole number
           
            return "1";
        }
       
       
    }
 
}
