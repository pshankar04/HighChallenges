package Serials;

import java.io.Serializable;

public class Employee implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public String name;
	public String car;
	
	public String getName(){
		return name;
	}
	
	public void setName(String empName){
		this.name = empName;
	}
 
	public Employee(String empName , String carName){
		this.name = empName;
		this.car = carName;
	}

	 


}
