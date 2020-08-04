package CareerCup;

public class Employee {
	
	public int id;
	public String name;
	public int age;
	public double Salary;
	
	public Employee(int emp_id,String emp_name,int emp_age,double emp_salary){
	this.name = emp_name;
	this.age = emp_age;
	this.Salary = emp_salary;
	this.id = emp_id;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public double getSalary() {
		return Salary;
	}
	public void setSalary(double salary) {
		Salary = salary;
	}
	
	public boolean equals(Object emp){
		if((emp instanceof Employee) && (((Employee)emp).getId() == this.getId())){
			return true;
		}
		return false;
	}
	
	public int hashCode(){
		int hash = 100;
		 if(this instanceof Employee){
			 return (this.getId() + hash);
		 }
		 return 0;
	}
}
