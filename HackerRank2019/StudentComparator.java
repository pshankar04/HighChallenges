package HackerRank;

import java.util.Comparator;

public class StudentComparator implements Comparator<Student>{
	
	public int compare(Student s1, Student s2) {
		int value1 = (s2.getCgpa()).compareTo(s1.getCgpa());
		if (value1 == 0) {
			int value2 = s1.getName().compareTo(s2.getName());
			if (value2 == 0) {
				return s1.getTokenNumber().compareTo(s2.getTokenNumber());
			} else {
				return value2;
			}
		}
		return value1;
	}
}
