package textExcel;

public class EmptyCell implements Cell{
	public String abbreviatedCellText(){
		String emptyCell = "          ";
		return emptyCell;
	}
	public String fullCellText(){
		String emptyCell = " ";
		return emptyCell;
	}
}
