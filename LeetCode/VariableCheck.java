package Serials;

public class VariableCheck {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String name = "";
		methodX(name);
		System.out.println("Value in Main :"+name);
		
	}
	
	public static void methodX(String ex){
		ex = "Puneeth";
		System.out.println("Value in Method :"+ex);
	}

}
