package HackerEarth;

 
import java.util.HashSet;
import java.util.Scanner;

public class MonkDiscovery {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String data = input.nextLine();
		long total = Long.parseLong(data.split(" ")[0]);
		long queries = Long.parseLong(data.split(" ")[1]);
		 
		HashSet<Long> numSet = new HashSet<Long>();
		for(int i = 0 ; i < total ; i++){
			numSet.add(input.nextLong());
		}
		for(long i = 0 ; i < queries ; i++){
			if(numSet.contains(input.nextLong())){
				System.out.println("YES");
			}else{
				System.out.println("NO");
			}
		}
		System.out.println(numSet.size());
		input.close();
	}

}
