package com.quiz.model;

import java.util.Comparator;

public class DescMarksComparator implements Comparator<Student> {

	@Override
	public int compare(Student s1, Student s2) {

		return s2.getMarks() - s1.getMarks();
	}

}
