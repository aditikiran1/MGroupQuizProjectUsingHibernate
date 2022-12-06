package com.quiz.model;

import java.util.Comparator;

public class AscMarksComparator implements Comparator<Student> {

	@Override
	public int compare(Student s1, Student s2) {

		return s1.getMarks() - s2.getMarks();
	}

}
