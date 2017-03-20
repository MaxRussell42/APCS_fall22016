package textExcel;

public class RealCell implements Cell{
      	private String realCell;
	      public realCell(String inputText){
		          realCell = inputText;					//base string for manipulation
	            }
              
              public double getDoubleValue(){                 //format string to the form of a double for manipulation
                    return Double.parseDouble(realCell);
              }
              
            	public String abbreviatedCellText(){
		          String abbreviatedCell = realCell.getdoubleValue();
                    if(abbreviatedCell.length()<10){			//makes cell equal 10
                          while(abbreviatedCell.length()<10){
			            	            abbreviatedCell += " "; 
                    }
	              		return abbreviatedCell;
                    } else if(abbreviatedCell.length > 10){
                          abbreviatedCell = abbreviatedCell.substring(0, 10);
                          return abbreviatedCell;					//returns if already true
                    } else {
                          return abbreviatedCell;         //cell is already proper length
             	}
                    
              public String fullCellText(){		
		          return realCell;					//no change needed 
              }
	
      }
      










