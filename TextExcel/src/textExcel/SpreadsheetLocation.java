package textExcel;

//Update this file with your own code.

public class SpreadsheetLocation implements Location
{
	private int row;
	private int col;
	
    @Override
    public int getRow()
    {
        // TODO Auto-generated method stub
        return row;
    }

    @Override
    public int getCol()
    {
        // TODO Auto-generated method stub
        return col;
    }
    
    public SpreadsheetLocation(String cellName)
    {
       row = Integer.parseInt(cellName.substring(1))-1;
       col = cellName.charAt(0)-'A';
    }
}
