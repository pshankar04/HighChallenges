package HackerRank;

import java.util.Scanner;

public class DaysBetweenDates {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int year1 = Integer.parseInt(input.nextLine());
		int month1 = Integer.parseInt(input.nextLine());
		int day1 = Integer.parseInt(input.nextLine());
		int year2 = Integer.parseInt(input.nextLine());
		int month2 = Integer.parseInt(input.nextLine());
		int day2 = Integer.parseInt(input.nextLine());

		System.out.println(DaysBetween(year1,month1,day1,year2,month2,day2));
		input.close();
	}

	public static int DaysBetween(int year1, int month1, int day1, int year2, int month2, int day2) {

		int diffInYears = year2 - year1;
		int days = 0;
		int monthCount = 12;

		for(int i = 0 ; i <= diffInYears ; i++){
			
			if(year1 != year2){
				for(int j = month1 ; j <= monthCount ; j++){
					days = days + DaysInMonth(j,year1);
				}
				month1 = 1;
			}else{
				monthCount = month2;
				for(int j = month1 ; j < monthCount ; j++){
					days = days + DaysInMonth(j,year1);
				}
				month1 = 1;
			}
			System.out.println("Year1 : "+year1 +" days :"+days);
			year1++;

		}

		return days;
	}

	public static int DaysInMonth(int month, int year) {
		int days = 0;

		if(month == 1){
			days = 31;
		}else if(month == 2){
			if((year % 4) == 0){
				days = 29;
			}else{
				days = 28;
			}
		}else if(month == 3){
			days = 31;
		}else if(month == 4){
			days = 30;
		}else if(month == 5){
			days = 31;
		}else if(month == 6){
			days = 30;
		}else if(month == 7){
			days = 31;
		}else if(month == 8){
			days = 31;
		}else if(month == 9){
			days = 30;
		}else if(month == 10){
			days = 31;
		}else if(month == 11){
			days = 30;
		}else if(month == 12){
			days = 31;
		} 

		return days;
	}
}
