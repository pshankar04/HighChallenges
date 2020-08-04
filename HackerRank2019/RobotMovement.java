package HackerRank;

import java.util.Scanner;

public class RobotMovement {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String str = input.nextLine();
		findNewPos(str.toCharArray(),"N",0,0,0);
		input.close();
	}

	public static void findNewPos(char[] str, String orgDirection, int orgX, int orgY , int maxRadius) {
		int i, len, x, y; 
		String dir = orgDirection;
		x = orgX;
		y = orgY;

		len = str.length;
		i=0;

		if(len == 1 && ((str[0] == 'L') || (str[0] == 'R')) && (str[0] != 'G')){
			System.out.println("YES");
		}else{
			//Iterate through each character
			while(i < len) {
				String c = str[i]+"";

				switch(c) {
				case "L": // Turn left
					switch(dir) {
					case "N":
						x--;
						dir = "W";
						break;
					case "S":
						x++;
						dir = "E";
						break;
					case "E":
						y++;
						dir = "N";
						break;
					case "W":
						y--;
						dir = "S";
						break;
					}
					break;

				case "R": // Turn right
					switch(dir) {
					case "N":
						x++;
						dir = "E";
						break;
					case "S":
						x--;
						dir = "W";
						break;
					case "E":
						y--;
						dir = "S";
						break;
					case "W":
						y++;
						dir = "N";
						break;
					}
					break;

				case "G": // Go forward
					switch(dir) {
					case "N":
						y++;
						dir = "N";
						break;
					case "S":
						y--;
						dir = "S";
						break;
					case "E":
						x++;
						dir = "E";
						break;
					case "W":
						x--;
						dir = "W";
						break;
					}
					break;
				}

				// Update max radius till now
				int rad = x*x + y*y;
				if(rad > maxRadius)
					maxRadius = rad;
				i++;
			}

			if((y == x || y == (-1 * x)) && (dir == orgDirection || dir.equals("N") || dir.equals("S"))){
				System.out.println("YES");
			}else{
				System.out.println("NO");
			}
		}
	}


}
