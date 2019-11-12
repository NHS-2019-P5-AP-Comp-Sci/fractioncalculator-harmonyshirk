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
        System.out.println(produceAnswer(userResponse));

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
       
    	String temporary = input;
    	String operand1 = temporary.substring(0, temporary.indexOf(' '));
    	temporary = temporary.substring(temporary.indexOf(' ') + 1);
    	String operator = temporary.substring(0, temporary.indexOf(' '));
    	temporary = temporary.substring(temporary.indexOf(' ') + 1);
    	String operand2 = temporary;
    	
    	
    	 /*Scanner userInput = new Scanner(input);
    	String operand1 = userInput.next();
    	String operator = userInput.next();
    	String operand2 = userInput.next(); **/ 
    	
        return operand2;
    }

    // TODO: Fill in the space below with any helper methods that you think you will need

}
