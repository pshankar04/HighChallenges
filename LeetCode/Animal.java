package Serials;

public class Animal implements Cloneable {
	
	public String name;
	public String sex;
	
	public Animal(String animalName,String animalSex){
		this.name = animalName;
		this.sex = animalSex;
	}
//	
//	public Animal clone(){
//		System.out.println("CLONING OBJECT");
//		
//		//Animal a = new Animal(this.name,this.sex);
//		//return a;
//		try {
//			return (Animal) super.clone();
//		} catch (CloneNotSupportedException e) {
//			return null;
//		}
//	}
		
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}
 
	public static void main(String[] args)  {
		Animal animal = new Animal("Horse","Male");
		Animal animal1 = null;
		try {
			animal1 = (Animal)animal.clone();
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		System.out.println("Name :"+animal.getName());
		System.out.println("Sex :"+animal.getSex());
		
		System.out.println("Cloned Object");
		System.out.println("Name :"+animal1.getName());
		System.out.println("Sex :"+animal1.getSex());
		
	}

}
