package com.quiz.service;


import java.util.HashSet;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

import com.quiz.model.Question;
import com.quiz.model.Student;

public class QuizService {
	private static final int maxq = 10;

	public Student startQuiz(Map<Integer, Question> map, Student student) {
		try(Scanner sc = new Scanner(System.in)){
			
		Set<Integer> askedQuestionIds = new HashSet<Integer>();
		int count = 0;
		while (askedQuestionIds.size() < maxq && askedQuestionIds.size() < map.size()) {
			int questionId = new Random().nextInt(map.size() + 1);

			if (!askedQuestionIds.contains(questionId) && questionId != 0) {
				Question question = map.get(questionId);
				count++;
				System.out.print("Q." + count+" ");
				System.out.println(question.getQuestion_text());
				System.out.println("A. " + question.getQoption1());
				System.out.println("B. " + question.getQoption2());
				System.out.println("C. " + question.getQoption3());
				System.out.println("D. " + question.getQoption4());

				System.out.println("enter your  answer: ");
				
				String ansStr = sc.next();
				Character ans = ansStr.charAt(0);
				String answer = "";

				switch (Character.toUpperCase(ans)) {
				case 'A':
					answer = question.getQoption1();
					break;
				case 'B':
					answer = question.getQoption2();
					break;
				case 'C':
					answer = question.getQoption3();
					break;
				case 'D':
					answer = question.getQoption4();
					break;
				default:

					answer = ansStr + ", which is a wrong input";
					break;
				}

				System.out.println("Your answer is: " + answer);

				if (answer.equals(question.getAnswer())) {
					System.out.println("Correct answer");
					int marks = student.getMarks() + 1;
					student.setMarks(marks);

				} else {
					System.out.println("Wrong answer");
					System.out.println("Correct answer is: " + question.getAnswer());
				}
				System.out.println();
				askedQuestionIds.add(questionId);
			}
		}
		System.out.println("Quiz completed");
		}
		return student;

	}

}
