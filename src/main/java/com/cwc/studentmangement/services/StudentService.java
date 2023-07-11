package com.cwc.studentmangement.services;

import java.util.List;

import com.cwc.studentmangement.model.SendSMS;
import com.cwc.studentmangement.model.Student;

public interface StudentService {
	
	
	
	//send sms
	public SendSMS sendMessage(SendSMS sendSMS);
	
	//Add Student
	public Student addStudent(Student student);
	
	//Update Student
	public Student updateStudent(int stdId,Student student);
	
	//Get Single Student
	public Student getSingleStudent(int stdId);
	
	//Get All Student
	public List<Student> getAllStudent();
	
	// Delete Student
	public void deleteStudent(int stdId);
	

	//Business logic methods
	
	public long studentCount();
	public List<Student> searchByStudentName(String keyword);
	public Student searchByStudentRollNo(int  rollNo);
	//Filter data section wise
	public List<Student> filterBySection(String query);
	
}
