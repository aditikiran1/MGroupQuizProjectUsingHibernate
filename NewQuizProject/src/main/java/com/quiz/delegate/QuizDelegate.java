package com.quiz.delegate;

//import java.util.HashMap;
import java.util.Map;

import com.quiz.model.Question;
import com.quiz.model.Student;
import com.quiz.service.QuestionsService;
import com.quiz.service.QuizService;
import com.quiz.service.StudentService;
import com.quiz.util.ConsoleUtil;
import com.quiz.util.IncorrectIdException;

public class QuizDelegate {

	public static void execute() {

		Student student = null;
		int num = ConsoleUtil.getMenuOption();
		switch (num) {
		case 1:
			StudentService studentService = new StudentService();
			try {
				student = studentService.getStudentEntry();
				student.setMarks(0);
				QuestionsService questionsDelegate = new QuestionsService();
				Map<Integer, Question> questionsMap = questionsDelegate.getQuestions();
				QuizService quizService = new QuizService();
				student = quizService.startQuiz(questionsMap, student);
				studentService.updateStudentDB(student);
				studentService.showStudentResult(student);

			} catch (IncorrectIdException e) {
				System.out.println(e.getMessage());
			}
			break;
		case 2:
			StudentService studentService2 = new StudentService();
			try {
				student = studentService2.getStudentEntry();
				studentService2.showStudentResult(student);
			} catch (IncorrectIdException e) {
				System.out.println(e.getMessage());
			}
			break;
		case 3:
			StudentService studentService3 = new StudentService();
			studentService3.getStudentScoreList();
			break;
		case 4:
			System.exit(0);
			break;
		default:
			System.out.println(num + " is an invalid input");
			System.out.println("please enter correct choice");
			break;
		}
		ConsoleUtil.doYouWantToContinue();
		

	}

}
