package HackerRank;

import java.util.Scanner;

public class ZalandoDoesItFit {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String stdDim = input.nextLine();
		int stdWidth = Integer.parseInt(stdDim.split(" ")[0]);
		int stdHeight = Integer.parseInt(stdDim.split(" ")[1]);
		int totalItems = Integer.parseInt(input.nextLine());
		int width = 0 , height = 0 , radius = 0;
		String dims = "" ;
		for(int i = 0 ; i < totalItems ; i++){
			dims = input.nextLine();
			if(dims.contains("R")){
				width = Integer.parseInt(dims.split(" ")[1]);
				height = Integer.parseInt(dims.split(" ")[2]);
		
				if((width <= stdWidth && height <= stdHeight) || (width <= stdHeight && height <= stdWidth) || 
						(width < Math.sqrt((stdWidth * stdWidth) + (stdHeight * stdHeight)) && height <= stdHeight) ||
						(height < Math.sqrt((stdWidth * stdWidth) + (stdHeight * stdHeight)) && width <= stdWidth)){
					System.out.println("YES");
				}else {
					System.out.println("NO");
				}
			}else if(dims.contains("C")){
				radius = Integer.parseInt(dims.split(" ")[1]);
				if(((radius * 2) <= stdHeight) && ((radius * 2) <= stdWidth)){
					System.out.println("YES");
				}else{
					System.out.println("NO");
				}
			}
		}
		input.close();
	}
}
