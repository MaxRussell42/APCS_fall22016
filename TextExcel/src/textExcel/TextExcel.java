package textExcel;
import java.util.Scanner;

public class TextExcel
{

	public static void main(String[] args)
	{
		Spreadsheet spreadsheet = new Spreadsheet();
		Scanner userInput = new Scanner(System.in);		//create scanner
		String input = userInput.nextLine();			
		String command = "";					//create string for input commands
		while (input != "quit"){				//loop for command processing
		    	command = input;
			System.out.println(spreadsheet.processCommand(command));
		    }
	}
}
