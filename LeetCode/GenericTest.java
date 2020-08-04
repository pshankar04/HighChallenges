package Serials;

 

public class GenericTest<T,U> {

	T obj1;
	U obj2;
	
	public GenericTest(T ob1, U ob2){
		this.obj1 = ob1;
		this.obj2 = ob2;
	}
	
	public void print(){
		System.out.println(obj1.getClass().getName()+" = "+obj1);
		System.out.println(obj2.getClass().getName()+" = "+obj2);
	}
	public static void main(String[] args) {
		GenericTest<Integer,String> gt1 = new GenericTest<Integer,String>(28,"Puneeth");
		GenericTest<Double,Integer> gt2 = new GenericTest<Double,Integer>(4.2,28);
		gt1.print();
		gt2.print();
	}

}
