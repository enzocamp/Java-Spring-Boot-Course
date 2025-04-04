package application;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

import entities.Student;

public class Program {

	public static void main(String[] args) {
		
		
		Scanner sc = new Scanner(System.in);
		
		Set<Student> students = new HashSet<>();
		
		List<String> courses = new ArrayList<>();
		
		courses.add("A");
		courses.add("B");
		courses.add("C");
		
		for( String course : courses) {
		
			System.out.print("How many students for course " + course + "? ");
			int number = sc.nextInt();
			
			for (int i = 1; i <= number; i++) {
				int id = sc.nextInt();
				students.add(new Student(id));
			}
			
		}
		
		System.out.println(students.size());
		
		
		sc.close();
	}

}
