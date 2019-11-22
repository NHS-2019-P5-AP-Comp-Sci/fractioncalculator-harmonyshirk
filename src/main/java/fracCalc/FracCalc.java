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
       
    	String temp = input;
    	String operand1 = temp.substring(0, temp.indexOf(' '));
    	temp = temp.substring(temp.indexOf(' ') + 1);
    	String operator = temp.substring(0, temp.indexOf(' '));
    	temp = temp.substring(temp.indexOf(' ') + 1);
    	String operand2 = temp;
    	
    	String op2Whole = findWhole(operand2);
    	String op2Numerator = findNumerator(operand2);
    	String op2Denominator = findDenominator(operand2);
    	
        String answer = "whole:" + op2Whole + " " + "numerator:" + 
        				op2Numerator + " " + "denominator:" + op2Denominator;
        
        return answer;
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
    public static String findNumerator(String b) {
    	 
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
    
    public static String findDenominator(String c) {
    	
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
