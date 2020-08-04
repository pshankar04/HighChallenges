package CodeEval;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;


public class TimeToEat implements Comparable<TimeToEat>{

	public String dateTime ;

	public TimeToEat(String d){
		dateTime = d;
	}

	public String getDateTime() {
		return dateTime;
	}

	public void setDateTime(String datetime) {
		this.dateTime = datetime;
	}

	public static void main(String[] args) {

		File file = new File(args[0]);
		try{
			BufferedReader buffer = new BufferedReader(new FileReader(file));
			String line;
			while ((line = buffer.readLine()) != null) {
				line = line.trim();
				printNow(sortTimeStamps(line));
				System.out.println();
			}
			buffer.close();

		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public int compareTo(TimeToEat m1) {
		return this.getDateTime().compareTo(m1.getDateTime());
	}

	public static List<TimeToEat> sortTimeStamps(String timeString){
		List<TimeToEat> dates = new ArrayList<TimeToEat>();
		String[] times =  timeString.split(" ");
		for(int i = 0 ; i < times.length ; i++){
			dates.add(new TimeToEat(times[i]));
		}
		Collections.sort(dates);

		return dates;
	}

	public static void printNow(List<TimeToEat> datesList){

		ListIterator<TimeToEat> listItr = datesList.listIterator();
		while(listItr.hasNext()){
			listItr.next();
		}

		while(listItr.hasPrevious()){
			System.out.print(listItr.previous().getDateTime()+" ");
		}

	}
}
