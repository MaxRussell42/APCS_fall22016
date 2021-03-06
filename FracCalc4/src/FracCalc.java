package fracCalc;
import java.util.*;


public class FracCalc {
	public static void main(String[] args) 
    {	
    	System.out.println("enter your operation");
    	Scanner input=new Scanner(System.in);//scanner
    	String userInput=input.nextLine();
    	while(userInput.equals("quit")==false){
    		String answer=produceAnswer(userInput);
    		System.out.println(answer);
    		System.out.println("hit me again");
    		userInput=input.nextLine();
    	}
    	System.out.println("THE END");
    }
    public static String produceAnswer(String input)
    {   String answer="";
    	String[] split = input.split(" ");//split to first operand, operator, and second operand
        int[] firstOp=components(split[0]);
        int[] secondOp=components(split[2]);
        convertToImproper(firstOp);
        convertToImproper(secondOp);
        
        int[] finalArray=compute(firstOp,secondOp,split[1]);
        
        answer=finalAnswer(finalArray,firstOp);
        
        
        for(int i=3; i<split.length; i+=2){
        	
        	int[] gArray=components(split[i+1]);
        	if(i==7) System.out.println(Arrays.toString(firstOp));
        	 convertToImproper(firstOp);
        	 if(i==7){
        		 System.out.println(Arrays.toString(firstOp));
        	 }
             convertToImproper(gArray);
             finalArray=compute(firstOp,gArray,split[i]);
             answer=finalAnswer(finalArray,firstOp);
             if(i==7){
            	 System.out.println(Arrays.toString(firstOp));
            	 System.out.println(Arrays.toString(gArray));
            	 System.out.println(Arrays.toString(finalArray));
            	 System.out.println(answer); 
            	 
             }
             
        }
        
        return answer;
    }
    public static int[] compute(int[] first, int[] second, String operator){
    	boolean add=operator.equals("+");
    	boolean subtract=operator.equals("-");
    	boolean multiply=operator.equals("*");
    	boolean divide=operator.equals("/");
    	int numerator=0;
    	int denominator=1;
    	if(add||subtract){
    		denominator = first[2]*second[2];
        	first[1]*=second[2];
        	second[1]*=first[2];
        	if(subtract){
        		second[1]*=-1;
        	}
        	numerator=first[1]+second[1];
    	}
    	if(multiply||divide){
    		if(divide){
    			int a=second[1];
    			int b=second[2];
    			second[2]=a;
    			second[1]=b;
    			if(a<0){
    				second[2]*=-1;
    				second[1]*=-1;
    			}
    		}
    		 numerator=first[1]*second[1];
        	 denominator=first[2]*second[2];	
    	}
    	int[] solution={numerator,denominator};
    	return solution;
    }
    
    public static String finalAnswer(int[] almostDone, int[] freshArray){
    	String answer="";
    	int common=Math.abs(gcf(almostDone[0],almostDone[1]));
    	int numerator=almostDone[0]/common;
    	
    	int denominator=almostDone[1]/common;
    	int whole = numerator/denominator;
    	int remainder = numerator%denominator;
    	freshArray[0]=whole;
    	if(whole==0){
    		freshArray[1]=numerator;
    	} else{
    		freshArray[1]=Math.abs(remainder);
    	}
    	freshArray[2]=denominator;
    	
    	if(whole!=0&&remainder<0){ 
    		remainder*=-1;
    	}
    	if (denominator<0){
    		denominator*=-1;
    	}
    	if(remainder==0){
    			answer+=whole;
    	}
    	else if(whole==0){
    		answer=numerator+"/"+denominator;
    	} else{
    		answer=whole+"_"+remainder+"/"+denominator;
    	}
    	return answer;
    }
    
    public static int[] components(String splitted){
    	String[] part= {"0","0","1"};
    	if(splitted.indexOf("_")==-1&&splitted.indexOf("/")==-1){
    		part[0]=splitted;
    	} else{
    		if (splitted.indexOf("_")!=-1){
    			part[0]=splitted.substring(0, splitted.indexOf("_"));
    			splitted=splitted.substring(splitted.indexOf("_")+1);
    		} 
    		if (splitted.indexOf("/")!=-1){
    			part[1]=splitted.substring(0,splitted.indexOf("/"));
    			part[2]=splitted.substring(splitted.indexOf("/")+1);
    		} 
    	}
    	int[] comp={Integer.parseInt(part[0]),Integer.parseInt(part[1]),Integer.parseInt(part[2])};
    	return comp;	
    }
    public static void convertToImproper(int array[]){//change to improper fraction
    	if (array[0]<0){//negative number check
    		array[1]=array[0]*array[2]-array[1];
    } else{
    	array[1]+=(array[0]*array[2]);
    }
    	array[0]=0;
    }
    public static int gcf(int a, int b){//determines greatest common factor
	    while(a!=0 && b!=0)
	  {int c = b;
	     b = a%b;
	     a = c;
	  }
	  return a+b;
   }
}