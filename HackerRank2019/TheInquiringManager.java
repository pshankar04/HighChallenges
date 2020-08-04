package HackerRank;

import java.util.LinkedList;
import java.util.Scanner;

public class TheInquiringManager {

	public static LinkedList<String> orderList  = new LinkedList<String>(); 
	public static long maxOrder = 0;

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int total = Integer.parseInt(input.nextLine());
		long orderTime = 0 ,currentTime = 0 , orderPrice = 0 , lastOrderTime = 0;
		String data = "";

		for(int i = 0 ; i < total ; i++){
			data = input.nextLine();
			if(data.charAt(0) == '1'){
				orderPrice = Integer.parseInt(data.split(" ")[1]);
				orderTime = Integer.parseInt(data.split(" ")[2]);
				currentTime = orderTime;
				orderList = updateOrderList(currentTime);
				orderList.add(orderPrice+","+orderTime);
				if(orderPrice > maxOrder){
					maxOrder = orderPrice;
				}
				lastOrderTime = currentTime;
			}else{
				currentTime = Integer.parseInt(data.split(" ")[1]);
				orderList = updateOrderList(currentTime);
				if((currentTime - lastOrderTime) <= 59){
					System.out.println(maxOrder);
				}else{
					System.out.println("-1");
				} 
			}
		}
		input.close();
	}

	public static LinkedList<String> updateOrderList(long currTime){
		LinkedList<String> newOrderList = new LinkedList<String>();
		long ordTime = 0 , orderCost = 0;
		maxOrder = 0;
		for(String order : orderList){
			ordTime = Long.parseLong(order.split(",")[1]);
			orderCost = Long.parseLong(order.split(",")[0]);
			if((currTime - ordTime) <= 59){
				newOrderList.add(order);
				if(orderCost > maxOrder){
					maxOrder = orderCost;
				}
			}
		}
		return newOrderList;
	}
}

