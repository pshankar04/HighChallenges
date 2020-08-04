package Serials;


import java.util.List;

public class CheckCloning {
	public static String[] value ;
	public static void main(String[] args) {
	 
 
		checkValues();
	}
	
	
	public static void checkValues(){
	for(String i : value){
		System.out.println("Name : "+i);
	}
	value[1] = "shivam";
	
	for(String i : value){
		System.out.println("Name : "+i);
	}
	}

}
