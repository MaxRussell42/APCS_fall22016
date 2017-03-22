package textExcel;
import java.util.*;
// Update this file with your own code.

public class Spreadsheet implements Grid
{
	private Cell[][]sheet = new Cell[20][12];
	
	public Spreadsheet(){
		for(int i = 0; i < getRows(); i++){
			for(int j = 0; j < getCols(); j++){
				sheet[i][j] = new EmptyCell();
			}
		}
	}
	@Override
	public String processCommand(String command)
	{
		String[] trueCommand = command.split(" ");
		if(trueCommand[0].toLowerCase().equals("clear")){		//for clearing entire sheet
			if(trueCommand.length==1){
				for(int i = 0; i < this.getRows(); i++){
					for(int j = 0; j < this.getCols(); j++){
						sheet[i][j] = new EmptyCell();
					}
				}
			}else{							//for clearing a specific cell
				trueCommand[1] = trueCommand[1].toUpperCase();
				SpreadsheetLocation loc= new SpreadsheetLocation(trueCommand[1]);
				sheet[loc.getRow()][loc.getCol()]=new EmptyCell();
			}
		}
		return command;
	}

	@Override
	public int getRows()
	{
		return sheet.length;
	}

	@Override
	public int getCols()
	{
		return sheet[0].length;
	}

	@Override
	public Cell getCell(Location loc)
	{
		int row = loc.getRow();
		int cols = loc.getCol();
		return(sheet[row][cols]);
	}

	@Override
	public String getGridText()
	{
		String wholeSheet = "";					//initialize sheet for string and first header pipe
		String header = "   |";
		char col = 'A';
		for(int i = 0; i <this.getCols(); i++){			//format for lettered columns
			header += ((char)(col)) + "         |";
			col += 1;
		}
		header += "\n";						//moves to next line
		for(int i = 0; i < this.getRows(); i++){		//formats for different row numbers
			if(i < 9){
				header += (i + 1) + "  |";
			} else {
				header += (i + 1) + " |";
			}
			for(int j = 0; j > this.getCols(); j++){
				header += sheet[i][j].abbreviatedCellText() + "|";
			}
			header += "\n";
		}
		return wholeSheet;
	}	
}


