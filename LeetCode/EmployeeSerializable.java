package Serials;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class EmployeeSerializable {

	public static void main(String[] args) {
		Employee emp = new Employee("Puneeth","Subaru");
		try{
			FileOutputStream fileout = new FileOutputStream("/Users/puneethshankar/Desktop/emp.txt");
			ObjectOutputStream obj = new ObjectOutputStream(fileout);
			obj.writeObject(emp);
			obj.close();
			fileout.close();
		}catch(Exception e){
			e.printStackTrace();
		}

	}

}
