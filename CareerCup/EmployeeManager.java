package CareerCup;

 
import java.util.Hashtable;

public class EmployeeManager {

	public static void main(String[] args) {
		Employee e1 = new Employee(1,"Puneeth",28,23000.50);
		Employee e2 = new Employee(1,"Puneeth",28,23000.50);
		Employee e3 = new Employee(3,"Pramod",24,13000.50);
		String a = new String("10001d");
		Hashtable<Employee,Integer> empSet = new Hashtable<Employee,Integer>();
		empSet.put(e1,1);
		empSet.put(e2,2);
		empSet.put(e3,3);
		
		System.out.println(e1.equals(e2)+" "+e1.hashCode());
		System.out.println(e1.equals(e3)+" "+e2.hashCode());
		System.out.println(e3.equals(e2)+" "+e3.hashCode());
		
		 
		System.out.println(empSet.size());
		System.out.println(a.hashCode());
	}

}
