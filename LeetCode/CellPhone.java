package Serials;

public class CellPhone implements Cloneable {
	
	public int areaCode ;
	public int prefix ;
	public int lineNumber ;
	
	 
	public CellPhone(int area,int pre,int number){
		this.areaCode = area;
		this.prefix = pre;
		this.lineNumber = number;
	}
	public static void main(String[] args) throws CloneNotSupportedException {
		CellPhone cp1 = new CellPhone(968,646,8915);
		CellPhone cp2 = cp1.clone();
		System.out.println("Current phone Number :"+cp1+"Cloned :"+cp2);
	 
		 

	}
	
	public String toString(){
		return String.format("(%03d) %03d-%04d",this.areaCode,this.prefix,this.lineNumber);
	}
	
	public CellPhone clone() throws CloneNotSupportedException{
		return (CellPhone) super.clone();
	}

}
