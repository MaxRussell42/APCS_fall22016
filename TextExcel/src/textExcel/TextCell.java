package textExcel;

public class TextCell {
	private String textCell;
	public TextCell(String inputText){
		textCell = inputText;
	}
	
	public String abbreviatedCellText(){
		String abbreviatedCell = ((textCell+"          ".substring(0,10)));
		return abbreviatedCell;
	}
	public String fullCellText(){
		return textCell;
	}
	
}
