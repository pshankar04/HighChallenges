package HackerRank;

import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;

public class StudentQueue {

	public static LinkedList<Student> studentList ;
	public static LinkedList<String> eventsList ;

	public static void main(String[] args){
		studentList = new LinkedList<Student>();
		eventsList = new LinkedList<String>();
		Scanner input = new Scanner(System.in);
		int total = Integer.parseInt(input.nextLine());
		String eventString = "";
		if(total >=2 && total <= 1000){
			for(int i = 0 ; i < total ; i++){
				eventString = input.nextLine();
				eventsList.add(eventString);
			}
			processEvents(eventsList);
		}
		input.close();
	}

	public static void processEvents(LinkedList<String> events){

		for(String event : events){
			if(event.contains("ENTER")){
				studentList.add(new Student(event.split(" ")[1],Double.parseDouble(event.split(" ")[2]),Integer.parseInt(event.split(" ")[3])));
			}else{
				if(studentList.size() > 0){
					if(studentList.size() >= 2){
						Collections.sort(studentList, new StudentComparator());
					}
					//serveOnPriority(studentList);
					studentList.removeFirst();
				}
			}
		}
		 
		if(studentList.size() > 0){
			for(Student s : studentList){
				System.out.println(s.getName());
			}
		}else{
			System.out.println("EMPTY");
		}
	}

	 
	public static void serveOnPriority(LinkedList<Student> students){
		
		
		if(students.size() > 1){
			Double maxCgpa = students.getLast().getCgpa();
			Student lastStudent = students.getLast(); 
			String name = students.getLast().getName();
			Integer token = students.getLast().getTokenNumber();
			 
			for(Student s : students){
				if(((s.getCgpa()).equals(maxCgpa))){ 
					if((((s.getName()).compareTo(name)) < 0)){
						name = s.getName();
						token = s.getTokenNumber();
						lastStudent = s;
					}else if((((s.getName()).compareTo(name)) == 0) && (s.getTokenNumber() < token)){
						name = s.getName();
						token = s.getTokenNumber();
						lastStudent = s;
					}
				}
			}
			students.remove(lastStudent);
		}else{
			students.removeFirst();
		}
	}
}
