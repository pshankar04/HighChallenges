package CareerCup;

public class StringOrder {

 	
	public static void main(String[] args) {
		String text = "abcNjhgAhGjhfhAljhRkhgRbhjbevfhjjnjjnO";
		String sample = "NAGARRO";
		int count = 0 ;
		boolean matches = false;
		
		for(int i = 0 , j = 0 ; i < text.length() && j < sample.length() ; i++){
			
			if(text.charAt(i) == sample.charAt(j)){
				count++;
				j++;
			}
//			else if( (i == text.length() - 1) && (count != sample.length())){
//				matches = false;
//			}
			
			if(count == sample.length()){
				matches = true;
				break;
			}
		}
		System.out.println(matches);
	}

}
