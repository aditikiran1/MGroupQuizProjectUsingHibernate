package com.quiz.service;

/*import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;*/
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

//import com.quiz.model.AscMarksComparator;
import com.quiz.model.DescMarksComparator;
import com.quiz.model.Student;
import com.quiz.util.IncorrectIdException;
import com.quiz.util.SessionUtility;

public class StudentService {

	public Student getStudentEntry()throws IncorrectIdException {
		//Student student = null;
		System.out.println("enter your id: ");
		Scanner sc = new Scanner(System.in);
		int stud_id = sc.nextInt();
		Session session = SessionUtility.getSession();
		Student student = (Student) session.get(Student.class, stud_id);
		/*Connection con = ConnectionUtility.getConnection();
		String query = "select * from student where stud_id=?";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, stud_id);
			rs = pstmt.executeQuery();
			while (rs != null && rs.next()) {
				System.out.println("Hello, " + rs.getString("stud_name"));

				student = new Student();
				student.setStud_id(rs.getInt("stud_id"));
				student.setStud_name(rs.getString("stud_name"));
				student.setMarks(rs.getInt("marks"));
			}*/
			if (student == null) {

				//System.out.println("Invalid Id.");
				throw new IncorrectIdException("Invalid id");
						
				//return student;

			}

		/*} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}*/
			
		return student;
			
	}

	public void updateStudentDB(Student student) {
		
		Session session = SessionUtility.getSession();
		Transaction transaction = session.beginTransaction();
		session.update(student);
		transaction.commit();
		/*Connection con = ConnectionUtility.getConnection();
		String query = "update student set marks=? where stud_id=?";
		try {
			PreparedStatement pstmt = con.prepareStatement(query);
			pstmt.setInt(1, student.getMarks());
			pstmt.setInt(2, student.getStud_id());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}*/

	}

	public void showStudentResult(Student student) {
		System.out.println("Marks obtained are: " + student.getMarks());
		System.out.println("Class obtained is: " + getStudentMarksClass(student));

	}

	public String getStudentMarksClass(Student student) {
		String marksClass = null;
		int marks = student.getMarks();
		if (marks >= 8 && marks <= 10) {
			marksClass = "A";
		} else if (marks == 6 || marks == 7) {
			marksClass = "B";
		} else if (marks == 5) {
			marksClass = "C";
		} else {
			marksClass = "D";
		}
		return marksClass;
	}

	

	public void getStudentScoreList() {
		System.out.println("List of Student Marks: ");

		//LinkedList<Student> list = new LinkedList<Student>();
		Session session = SessionUtility.getSession();
		Query query = session.createQuery("from Student");
		List<Student> list = query.list();
		/*Connection con = ConnectionUtility.getConnection();
		String query = "select * from student order by marks desc";
		try {
			PreparedStatement pstmt = con.prepareStatement(query);
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				Student student = new Student();
				student.setStud_id(rs.getInt("stud_id"));
				student.setStud_name(rs.getString("stud_name"));
				student.setMarks(rs.getInt("marks"));

				list.add(student);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}*/
		Collections.sort(list,new DescMarksComparator());
		System.out.println("Id\t" + "Name\t" + "Marks");
		for (Student student : list) {
			System.out.println(student.getStud_id() + "\t" + student.getStud_name() + "\t" + student.getMarks());
		}

	}
}
