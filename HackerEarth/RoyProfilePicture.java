package HackerEarth;

import java.util.Scanner;

public class RoyProfilePicture {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int length = Integer.parseInt(input.nextLine());
		int totalPhotos = Integer.parseInt(input.nextLine());
		int width = 0 , height = 0;
		String dim = "";
		for(int i = 0 ; i < totalPhotos ; i++){
			dim = input.nextLine();
			width  = Integer.parseInt(dim.split(" ")[0]);
			height = Integer.parseInt(dim.split(" ")[1]);
			if(width < length || height < length){
				System.out.println("UPLOAD ANOTHER");
			}else if(width >= length && height >= length){
				if((width * height) == (width * width)){
					System.out.println("ACCEPTED");
				}else{
					System.out.println("CROP IT");
				}
			}
		}
		input.close();
	}

}
