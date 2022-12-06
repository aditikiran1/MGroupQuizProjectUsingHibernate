package com.quiz.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Question {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int question_id;
	private String question_text;
	private String qoption1;
	private String qoption2;
	private String qoption3;
	private String qoption4;
	private String answer;

	public int getQuestion_id() {
		return question_id;
	}

	public void setQuestion_id(int question_id) {
		this.question_id = question_id;
	}

	public String getQuestion_text() {
		return question_text;
	}

	public void setQuestion_text(String question_text) {
		this.question_text = question_text;
	}

	public String getQoption1() {
		return qoption1;
	}

	public void setQoption1(String qoption1) {
		this.qoption1 = qoption1;
	}

	public String getQoption2() {
		return qoption2;
	}

	public void setQoption2(String qoption2) {
		this.qoption2 = qoption2;
	}

	public String getQoption3() {
		return qoption3;
	}

	public void setQoption3(String qoption3) {
		this.qoption3 = qoption3;
	}

	public String getQoption4() {
		return qoption4;
	}

	public void setQoption4(String qoption4) {
		this.qoption4 = qoption4;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	@Override
	public String toString() {
		return "Question [question_id=" + question_id + ", question_text=" + question_text + ", qoption1=" + qoption1
				+ ", qoption2=" + qoption2 + ", qoption3=" + qoption3 + ", qoption4=" + qoption4 + ", answer=" + answer
				+ "]";
	}

	public Question(int question_id, String question_text, String qoption1, String qoption2, String qoption3,
			String qoption4, String answer) {
		super();
		this.question_id = question_id;
		this.question_text = question_text;
		this.qoption1 = qoption1;
		this.qoption2 = qoption2;
		this.qoption3 = qoption3;
		this.qoption4 = qoption4;
		this.answer = answer;
	}

	public Question() {
		super();
	}

}
