//Max Russell APCS Period 2 12/1/16
package fracCalc;
import java.util.*;

public class FracCalc {

    public static void main(String[] args) 
    {
        // TODO: Read the input from the user and call produceAnswer with an equation
    Scanner userInput = new Scanner(System.in);
    String input = userInput.nextLine();
    while (input != "quit"){
    	System.out.println("Enter an expression. When you're done, enter quit");
    	String output = produceAnswer(input);
    	System.out.println(output);
    	System.out.println("How 'bout another?");
    	input = userInput.nextLine();
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
    	//add test to check for fractions
    	String[] splitInput = input.split(" "); 			//splits the operand and inputed fractions
    	int[] firstSplitFrac = parseInput(splitInput[0]);	//separates individual values for processing before calculation
    	int[] secondSplitFrac = parseInput(splitInput[2]);
    	int gcf = (gcf(firstSplitFrac[2],  secondSplitFrac[2]));
    	int[] impFrac1 = toImproperFrac(firstSplitFrac, gcf);	//converts values to improper fractions
    	int[] impFrac2 = toImproperFrac(secondSplitFrac, gcf);
    	boolean add = splitInput[1].equals("+");			//tests operand to find proper method to use
    	boolean subtract = splitInput[1].equals("-"); ;
    	boolean multiply = splitInput[1].equals("*");;
    	boolean divide = splitInput[1].equals("/");;
    	if (add == true){
    		String calculated = addFrac(impFrac1, impFrac2);
    	}
    	else if (subtract == true){
    		String calculated = subtractFrac(impFrac1, impFrac2);
    	}
    	else if (multiply == true){
    		String calculated = multiplyFrac(impFrac1, impFrac2);
    	}
    	else if (divide == true){
    		String calculated = divideFrac(impFrac1, impFrac2);
       	}
    	String finalAnswer = calculated;
    	return finalAnswer;
    }

    public static int[] parseInput(String input){ //separates fractions into a whole number, numerator, and denominator
    	String[] numDenomSplit = input.split("/"); 
    	String[] wholeNumbSplit = input.split("_"); 
    	int[] parsedFrac = new int [3];
    	parsedFrac[0] = Integer.parseInt(numDenomSplit[0]); //numerator 
    	parsedFrac[1] = Integer.parseInt(numDenomSplit[1]); //denominator 
    	parsedFrac[2] = Integer.parseInt(wholeNumbSplit[0]); //whole number
    	return parsedFrac;
    }
    public static int gcf(int denominator1, int denominator2){
    	int gcf = denominator1 * denominator2;
    	return gcf;
    }
   
    //receives fraction and uses gcf to convert the mixed number into the proper improper fraction
    public static int[] toImproperFrac(int[] mixedFrac, int gcf){ 
    	int wholeNum = (mixedFrac[0]);
    	boolean negative;
    	if (wholeNum < 0){
    		negative = true; 
    	}
    	if (negative = true){
    		wholeNum *= -1;
    	}
    	int numerator = (mixedFrac[1]);
    	int denominator = (mixedFrac[2]);
    	int numConversion = gcf / denominator; 
    	int finalNumerator = (denominator * wholeNum) + (numConversion * numerator);
    	if (negative = true){
    		finalNumerator *= -1;
    	}
    	int finalDenominator = gcf;
    	int[] improperFrac = new int [2];	
    	improperFrac[0] = finalNumerator;
    	improperFrac[1] = finalDenominator;
    	return improperFrac;
    }
    //Receives array from produceAnswer() and adds proper values
    public static String addFrac(int[] impFrac1, int[] impFrac2){
    	int numerator1 = (impFrac1[0]);
    	int finalDenominator = (impFrac1[1]);
    	int numerator2 = (impFrac2[0]);
    	int calculate = numerator1 + numerator2; 
    	String finalFrac = calculate + "/" + finalDenominator;
    	return finalFrac;
    }
    //Receives array from produceAnswer() and subtracts values
    public static String subtractFrac(int[] impFrac1, int[] impFrac2){
    	int numerator1 = (impFrac1[0]);
    	int finalDenominator = (impFrac1[1]);
    	int numerator2 = (impFrac2[0]);
    	int calculate = numerator1 - numerator2; 
    	String finalFrac = calculate + "/" + finalDenominator;
    	return finalFrac;
    }
    //receive array from produceAnswer, divide values and return
    public static String divideFrac(int[] impFrac1, int[] impFrac2){
    	int numerator1 = (impFrac1[0]);
    	int denominator1 = (impFrac1[1]);
    	int numerator2 = (impFrac2[0]);
    	int denominator2 = (impFrac2[1]);
    	int divideFracFlip = numerator1;	//switches second fractions values to allow for fraction division
    	numerator1 = denominator2;
    	denominator2 = divideFracFlip;
    	int calculateNum = (numerator1 * numerator2); 
    	int calculateDenom = (denominator1 * denominator2);
    	String finalFrac = calculateNum + "/" + calculateDenom;
    	return finalFrac;
    	
    }
    //receive array, multiply values, return to produceAnswer()
    public static String multiplyFrac(int[] impFrac1, int[] impFrac2){
    	int numerator1 = (impFrac1[0]);
    	int denominator1 = (impFrac1[1]);
    	int numerator2 = (impFrac2[0]);
    	int denominator2 = (impFrac2[1]);
    	int calculateNum = (numerator1 * numerator2); 
    	int calculateDenom = (denominator1 * denominator2);
    	String finalFrac = calculateNum + "/" + calculateDenom;
    	return finalFrac;
    }
    
}
