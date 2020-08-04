package HackerRank;

public class Student implements Comparable<Student>{

	public String name ;
	public Double cgpa ;
	public Integer tokenNumber;
	 
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getCgpa() {
		return cgpa;
	}

	public void setCgpa(Double cgpa) {
		this.cgpa = cgpa;
	}

	public Integer getTokenNumber() {
		return tokenNumber;
	}

	public void setTokenNumber(Integer tokenNumber) {
		this.tokenNumber = tokenNumber;
	}

	public Student(String studentName, Double studentCGPA,Integer token){
		
		this.name = studentName;
		this.cgpa = studentCGPA;
		this.tokenNumber = token;
	}
	@Override
	public int compareTo(Student st) {
		
		double compareQuantity = ((Student) st).getCgpa(); 
		if((this.cgpa - compareQuantity) < 0){
			return -1;
		}else if((this.cgpa - compareQuantity) > 0){
			return 1;
		}else{
			return 0;
		}
	
	}
}
	


