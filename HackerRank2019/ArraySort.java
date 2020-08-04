package HackerRank;

 

public class ArraySort {

	public static void main(String[] args) {
		int[] a = {-12, 0, 1, -899, 23, 45, 96, 10, 75, 23, 0, 33};
		try{
			
			print(a,100);
		}catch(Exception e){
			System.out.println(e.getClass().getName());
		}
		

	}
	
	public static void print(int[] a, int index){
		
		
		 
		try{
			System.out.println(a[index]);
		}catch(Exception ae){
			 throw new ArrayIndexOutOfBoundsException();
		}finally{
			java.util.Arrays.sort(a);
			System.out.println(a[a.length - 1]+" "+a[0]);
			 
		}
	}

}
