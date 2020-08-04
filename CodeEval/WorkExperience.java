package CodeEval;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader; 
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class WorkExperience {

	public static ConcurrentHashMap<String, Integer> monthMap = new ConcurrentHashMap<String, Integer>();
	public static ConcurrentHashMap<Integer, Integer> expInYearMap ;
	public static ConcurrentHashMap<String, Integer> periodExpMap;
	 

	static{
		monthMap.put("Jan",1);monthMap.put("Feb",2);monthMap.put("Mar",3);monthMap.put("Apr",4);
		monthMap.put("May",5);monthMap.put("Jun",6);monthMap.put("Jul",7);monthMap.put("Aug",8);
		monthMap.put("Sep",9);monthMap.put("Oct",10);monthMap.put("Nov",11);monthMap.put("Dec",12);
	}

	public static void main(String[] args) {
		File file = new File(args[0]);
		try{
			BufferedReader buffer = new BufferedReader(new FileReader(file));
			String line;
			while ((line = buffer.readLine()) != null && (line.trim().length() > 0)){
				calExperience(line);
			}
			buffer.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	public static void calExperience(String exp){
		periodExpMap = new ConcurrentHashMap<String, Integer>();
		String[] periods = exp.split(";");
		String startMonth = "",endMonth = "" , period = "";
		int startYear = 0, endYear = 0, diffInMonth = 0 ;
		for(int i = 0 ; i < periods.length ; i++){
			period = periods[i].trim();
			startMonth = (period.split("-")[0]).split(" ")[0];
			startYear = Integer.parseInt((period.split("-")[0]).split(" ")[1]);
			endMonth = (period.split("-")[1]).split(" ")[0];
			endYear = Integer.parseInt((period.split("-")[1]).split(" ")[1]);
			diffInMonth = findDifferenceInMonths(startMonth,startYear,endMonth,endYear);

			if(periodExpMap.size() != 0){
				findOverlappingExperience(period,diffInMonth,periodExpMap);
			}else{
				periodExpMap.put(period,diffInMonth);
			}
			 
		}
		//System.out.println(periodExpMap);
		System.out.println((findSumOfExp(periodExpMap))/12);

	}

	public static int findDifferenceInMonths(String beginMonth,int beginYear,String endMonth,int endYear){

		int monthsInBeginYear = 12 - (monthMap.get(beginMonth));
		int monthsInEndYear =  (0 + (monthMap.get(endMonth))); 
		expInYearMap = new ConcurrentHashMap<Integer, Integer>();

		if(beginYear == endYear){
			expInYearMap.put(beginYear, (monthMap.get(endMonth) - monthMap.get(beginMonth)) + 1);
		}else{
			expInYearMap.put(beginYear, monthsInBeginYear + 1);
			beginYear++;
			while(beginYear != endYear){
				expInYearMap.put(beginYear, 12);
				beginYear++;
			}
			expInYearMap.put(beginYear, monthsInEndYear);
		}
		return findSumOfExperiences(expInYearMap);
	}

	public static int findSumOfExperiences(ConcurrentHashMap<Integer, Integer> expMap){
		int sum = 0;
		Set<Map.Entry<Integer,Integer>> entrySet = expMap.entrySet();
		for(Map.Entry<Integer, Integer> entry : entrySet){
			sum = sum + entry.getValue();
		}
		return sum;
	}

	public static int findSumOfExp(ConcurrentHashMap<String, Integer> expMap){
		int sum = 0;
		Set<Map.Entry<String,Integer>> entrySet = expMap.entrySet();
		for(Map.Entry<String, Integer> entry : entrySet){
			sum = sum + entry.getValue();
		}
		return sum;
	}


	public static void findOverlappingExperience(String duration,int months,ConcurrentHashMap<String, Integer> periodsMap){
		String newPeriod = "";
		int firstMonth = 0,lastMonth= 0 ;
		int firstYear = 0, lastYear = 0;
		int newDuration = 0;
		firstMonth = monthMap.get((duration.split("-")[0]).split(" ")[0]);
		firstYear = Integer.parseInt((duration.split("-")[0]).split(" ")[1]);
		lastMonth = monthMap.get((duration.split("-")[1]).split(" ")[0]);
		lastYear = Integer.parseInt((duration.split("-")[1]).split(" ")[1]);

		Set<Map.Entry<String,Integer>> entrySet = periodsMap.entrySet();
		for(Map.Entry<String, Integer> entry : entrySet){
			String period = entry.getKey();
			int periodsFirstYear = Integer.parseInt((period.split("-")[0]).split(" ")[1]);
			int periodsLastYear = Integer.parseInt((period.split("-")[1]).split(" ")[1]);
			int periodsFirstMonth = monthMap.get((period.split("-")[0]).split(" ")[0]);
			int periodsLastMonth = monthMap.get((period.split("-")[1]).split(" ")[0]);

			if((periodsFirstYear == firstYear) && (periodsLastYear == lastYear)){	 
				if((periodsFirstMonth < firstMonth) && ( periodsLastMonth > lastMonth)){
					continue;
				}else if((periodsFirstMonth < firstMonth) && ( periodsLastMonth < lastMonth)){
					newDuration = periodsMap.get(period) + lastMonth - periodsLastMonth;
					newPeriod = replaceperiod(period,duration);
					periodsMap.put(newPeriod, newDuration);
					periodsMap.remove(period);
				}else if((periodsFirstMonth > firstMonth) && ( periodsLastMonth < lastMonth)){
					newDuration = periodsMap.get(period) + (periodsFirstMonth - firstMonth) + (lastMonth - periodsLastMonth) ;
					newPeriod = duration;
					periodsMap.put(newPeriod, newDuration);
					periodsMap.remove(period);
				}else if((periodsFirstMonth > firstMonth) && ( periodsLastMonth > lastMonth)){
					newDuration = periodsMap.get(period) + (periodsFirstMonth - firstMonth) ;
					newPeriod = replaceperiod(period,duration);
					periodsMap.put(newPeriod, newDuration);
					periodsMap.remove(period);
				}
			}else if((periodsFirstYear == firstYear) && (periodsLastYear > lastYear)){
				if(periodsFirstMonth < firstMonth){
					continue;
				}else if(periodsFirstMonth > firstMonth){
					newDuration = periodsMap.get(period) + periodsFirstMonth - firstMonth;
					newPeriod = replaceperiod(period,duration);
					periodsMap.put(newPeriod, newDuration);
					periodsMap.remove(period);
				}
			}else if((periodsFirstYear == firstYear) && (periodsLastYear < lastYear)){
				if(periodsFirstMonth > firstMonth){
					newDuration = periodsMap.get(period) + (periodsFirstMonth - firstMonth);
					newPeriod = duration;
					periodsMap.put(newPeriod, newDuration);
					periodsMap.remove(period);
				}else if(periodsFirstMonth < firstMonth){
					newDuration = (firstMonth - periodsFirstMonth) + months;
					newPeriod = replaceperiod(period,duration);
					periodsMap.put(newPeriod, newDuration);
					periodsMap.remove(period);
				}
			}else if((periodsFirstYear != firstYear) && (periodsLastYear != lastYear)){
					periodsMap.put(duration,months); 
			}
		}
	}

	public static String replaceperiod(String periodInMap, String periodToBeInMap){
		String temp1 = "",temp2 = "";
		int lastmonthOfperiodInMap = 0, firstmonthOfperiodInMap = 0 , lastmonthOfperiodToBeInMap = 0, firstmonthOfperiodToBeInMap = 0;
		int lastyearOfperiodInMap = 0, firstyearOfperiodInMap = 0 , lastyearOfperiodToBeInMap = 0, firstyearOfperiodToBeInMap = 0;

		lastmonthOfperiodInMap = monthMap.get((periodInMap.split("-")[1]).split(" ")[0]);
		firstmonthOfperiodInMap = monthMap.get((periodInMap.split("-")[0]).split(" ")[0]);
		lastmonthOfperiodToBeInMap = monthMap.get((periodToBeInMap.split("-")[1]).split(" ")[0]);
		firstmonthOfperiodToBeInMap = monthMap.get((periodToBeInMap.split("-")[0]).split(" ")[0]);
		

		lastyearOfperiodToBeInMap = Integer.parseInt((periodToBeInMap.split("-")[1]).split(" ")[1]);
		lastyearOfperiodInMap = Integer.parseInt((periodInMap.split("-")[1]).split(" ")[1]);

		if(firstmonthOfperiodInMap > firstmonthOfperiodToBeInMap){
			temp1 = periodToBeInMap.substring(0,periodToBeInMap.indexOf('-')).trim();
			temp2 = periodInMap.substring(periodInMap.indexOf('-')+1).trim();
			return temp1+"-"+temp2;
		}

		if(firstmonthOfperiodInMap < firstmonthOfperiodToBeInMap){
			if(lastmonthOfperiodInMap < lastmonthOfperiodToBeInMap){
				temp1 = periodInMap.substring(0,periodInMap.indexOf('-')).trim();
				temp2 = periodToBeInMap.substring(periodToBeInMap.indexOf('-')+1).trim();
				return temp1+"-"+temp2;
			}
		}
		if((firstmonthOfperiodInMap < firstmonthOfperiodToBeInMap) && (lastyearOfperiodInMap < lastyearOfperiodToBeInMap)){
				temp1 = periodInMap.substring(0,periodInMap.indexOf('-')).trim();
				temp2 = periodToBeInMap.substring(periodToBeInMap.indexOf('-')+1).trim();
				return temp1+"-"+temp2;
		}
		return "";
	}



}
