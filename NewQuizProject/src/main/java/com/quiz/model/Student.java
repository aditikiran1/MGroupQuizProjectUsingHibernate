package com.quiz.model;

//import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
//import javax.persistence.SequenceGenerator;

//import org.hibernate.annotations.GenericGenerator;
//import org.hibernate.annotations.Parameter;

@Entity
public class Student {
	@Id
	/*@GenericGenerator(
			name = "sequence_generator", strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
			parameters = {
					@Parameter(name = "sequence_name", value = "user_sequence"),
					@Parameter(name = "initial_value", value = "101") 
					}
			)
	@GeneratedValue(generator = "sequence_generator")*/
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int stud_id;
	private String stud_name;
	private int marks;

	public int getStud_id() {
		return stud_id;
	}

	public void setStud_id(int stud_id) {
		this.stud_id = stud_id;
	}

	public String getStud_name() {
		return stud_name;
	}

	public void setStud_name(String stud_name) {
		this.stud_name = stud_name;
	}

	public int getMarks() {
		return marks;
	}

	public void setMarks(int marks) {
		this.marks = marks;
	}

	@Override
	public String toString() {
		return "Student [stud_id=" + stud_id + ", stud_name=" + stud_name + ", marks=" + marks + "]";
	}

	public Student(int stud_id, String stud_name, int marks) {
		super();
		this.stud_id = stud_id;
		this.stud_name = stud_name;
		this.marks = marks;
	}

	public Student() {
		super();
	}
	
	
	
}
