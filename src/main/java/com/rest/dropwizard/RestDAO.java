package com.rest.dropwizard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RestDAO {

	public static Map<Integer, Student> students = new HashMap<Integer, Student>();
	static {
		students.put(1, new Student(1, "ABCD", "XYZ", "abcd.xyz@gmail.com"));
		students.put(2, new Student(2, "QWE", "RTY", "qwerty@gmail.com"));
		students.put(3, new Student(3, "PQRS", "TUV", "pqrs@gmail.com"));
	}

	private RestDAO() {
	}

	public static List<Student> getStudents() {
		return new ArrayList<Student>(students.values());
	}

	public static Student getStudent(Integer id) {
		return students.get(id);
	}

	public static void updateStudent(Integer id, Student student) {
		students.put(id, student);
	}

	public static void removeStudent(Integer id) {
		students.remove(id);
	}
}
