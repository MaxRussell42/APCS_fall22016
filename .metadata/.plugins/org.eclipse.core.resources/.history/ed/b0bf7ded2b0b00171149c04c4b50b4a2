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
		if(trueCommand.equals("quit")){
			
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
		return(cells[row][cols]);
	}

	@Override
	public String getGridText()
	{
		
		return null;
	}

}
