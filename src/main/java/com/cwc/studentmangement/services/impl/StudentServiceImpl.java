package com.cwc.studentmangement.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cwc.studentmangement.exception.DuplicateRollNumberFound;
import com.cwc.studentmangement.exception.InvaildStudentNameException;
import com.cwc.studentmangement.exception.ResourceNotFoundException;
import com.cwc.studentmangement.exception.RollNumberNotFoundException;
import com.cwc.studentmangement.model.SendSMS;
import com.cwc.studentmangement.model.Student;
import com.cwc.studentmangement.repository.SendSMSRepository;
import com.cwc.studentmangement.repository.StudentRepository;
import com.cwc.studentmangement.services.StudentService;

@Service
public class StudentServiceImpl implements StudentService {

	// Field Injection
	@Autowired
	private StudentRepository studentRepository;
	
	@Autowired 
	private SendSMSRepository sendSMSRepository;
	

	// Save || Update -> save
	
	
	
	@Override
	public SendSMS sendMessage(SendSMS sendSMS) {
		return this.sendSMSRepository.save(sendSMS);
	}
	

	@Override
	public Student addStudent(Student student) {
		
		//Check duplicate roll number
		Student existingRollNo = this.studentRepository.findByStudentRollNo(student.getRollNo()).orElse(null);
		 if(existingRollNo == null)
		        //RollNumber does not already exist so save the new Roll Number
			 return this.studentRepository.save(student);
		 //Duplicate found then, don't add a duplicate and throw exception
		 throw new DuplicateRollNumberFound("duplicate roll number found");
	}

	@Override
	public Student updateStudent(int stdId, Student student) {
		Student studentById = this.studentRepository.findById(stdId)
				.orElseThrow(() -> new ResourceNotFoundException("Resource not found by given id{}" + stdId));

		studentById.setRollNo(student.getRollNo());
		studentById.setStdName(student.getStdName());
		studentById.setSection(student.getSection());
		studentById.setBranch(student.getBranch());
		studentById.setStandard(student.getStandard());

//		Student student2 = studentById.builder().rollNo(student.getRollNo()).stdName(student.getStdName()).section(student.getSection())
//				.branch(student.getBranch()).standard(student.getStandard()).build();
//		Student updatedStudent = this.studentRepository.save(student2);

		return this.studentRepository.save(studentById);
	}

	@Override
	public Student getSingleStudent(int stdId) {
		Student student = this.studentRepository.findById(stdId)
				.orElseThrow(() -> new ResourceNotFoundException("Resource not found by given id{}" + stdId));
		return student;
	}

	@Override
	public List<Student> getAllStudent() {
		return this.studentRepository.findAll();

	}

	@Override
	public void deleteStudent(int stdId) {
		this.studentRepository.deleteById(stdId);
	}

	@Override
	public long studentCount() {
		return this.studentRepository.count();
	}

	@Override
	public List<Student> searchByStudentName(String keyword) {
		List<Student> stdNameList = this.studentRepository.searchBystdName("%" + keyword + "%");
		if (stdNameList.isEmpty()) 
			throw new InvaildStudentNameException("Invaild student name");
		return stdNameList;
	}

	@Override
	public Student searchByStudentRollNo(int rollNo) {
		return this.studentRepository.findByRollNo(rollNo)
				.orElseThrow(() -> new RollNumberNotFoundException("This roll number not found"));
	}

	@Override
	public List<Student> filterBySection(String query) {
		return this.studentRepository.findBySection(query);
	}

	

}
