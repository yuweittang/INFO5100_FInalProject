package studentManagementSystem;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.SQLException;

public class Student {
	private String name;
	private String StudentID;
	private String Birthday;
	private String major;
	private String gender;
	private double creditsGained;
	private double totalGrades;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}

	public Student(String name, String studentID, String birthday, String major, String gender,
			double creditsGained, double totalGrades) {
		super();
		this.name = name;
		StudentID = studentID;
		Birthday = birthday;
		this.major = major;
		this.gender = gender;
		this.creditsGained = creditsGained;
		this.totalGrades = totalGrades;
	}
	public void input() throws IOException, SQLException {
		MySQLDemo ms=new MySQLDemo();
		ms.createStd(this.name, this.StudentID, this.Birthday, this.major, this.gender, 0, 0);
		
	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStudentID() {
		return StudentID;
	}

	public void setStudentID(String studentID) {
		StudentID = studentID;
	}

	public String getBirthday() {
		return Birthday;
	}

	public void setBirthday(String birthday) {
		Birthday = birthday;
	}

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public double getCreditsGained() {
		return creditsGained;
	}

	public void setCreditsGained(double creditsGained) {
		this.creditsGained = creditsGained;
	}

	public double getTotalGrades() {
		return totalGrades;
	}

	public void setTotalGrades(double totalGrades) {
		this.totalGrades = totalGrades;
	}
	

}
