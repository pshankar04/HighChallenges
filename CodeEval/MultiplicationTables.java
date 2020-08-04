package CodeEval;

public class MultiplicationTables {

	public static void main(String[] args) {
		
		for(int i = 1 ; i < 13 ; i++){
			for(int j = 1 ; j < 13 ; j++){
				System.out.print(String.format("%4s",(i*j)+" "));
			}
			System.out.println();
		}

	}

}
