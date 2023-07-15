package com.cwc.studentmangement.controller;

import java.util.List;

import javax.validation.Valid;
import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cwc.studentmangement.model.SendSMS;
import com.cwc.studentmangement.model.Student;
import com.cwc.studentmangement.services.StudentService;

@RestController 
@RequestMapping("/api/v1/student")
public class StudentController {
	@Autowired
	private StudentService studentService; 
	
	/* @PostMapping // For Add
	 * @PutMapping // For Update
	 * @GetMapping // For Get Data from DB
	 * @DeleteMapping // For Delete
	*/
	
	@PostMapping("/sendsms")
	public ResponseEntity<SendSMS> sendsms(@RequestBody SendSMS sendSMS){
		SendSMS sendMessage = this.studentService.sendMessage(sendSMS);
		return new ResponseEntity<SendSMS>(sendMessage,HttpStatus.CREATED);
	}
	
	@PostMapping("/")//http://localhost:8089/api/v1/student/
	public ResponseEntity<Student> saveStudent(@Valid @RequestBody Student student){
		Student addedStudent = this.studentService.addStudent(student);
		return new ResponseEntity<Student>(addedStudent,HttpStatus.CREATED);
	}
	
	@PutMapping("/update/{stdId}") //http://localhost:8089/api/v1/student/update/1
	public ResponseEntity<Student> updateStudent(@PathVariable("stdId") Integer stdId, @RequestBody Student student){
		System.out.println(student.getStdName());
		Student updatedStudent = this.studentService.updateStudent(stdId, student);
		return new ResponseEntity<Student>(updatedStudent,HttpStatus.CREATED);
	}
	
	
	@GetMapping("/{stdId}")//http://localhost:8089/api/v1/student/1
	public ResponseEntity<Student> getSingleStudentById(@PathVariable("stdId") Integer stdId) {
		Student singleStudent = this.studentService.getSingleStudent(stdId);
		return new ResponseEntity<Student>(singleStudent,HttpStatus.FOUND);
	}
	
	@GetMapping("/")//http://localhost:8089/api/v1/student/
	public ResponseEntity<List<Student>> getAllStudents(){
		List<Student> allStudent = this.studentService.getAllStudent();
		return new ResponseEntity<List<Student>>(allStudent,HttpStatus.FOUND);
	}
	
	@DeleteMapping("/{stdId}")//http://localhost:8089/api/v1/student/101
	public void deleteStudent(@PathVariable Integer stdId) {
		this.studentService.deleteStudent(stdId);
	}
	
	
	@GetMapping("/count")//http://localhost:8089/api/v1/student/count
	public Long countStudents() {
		long studentCount = this.studentService.studentCount();
		System.out.println(studentCount);
		return studentCount;
	}
	
	@GetMapping("/search") //http://localhost:8089/api/v1/student/search?=keyword
	public ResponseEntity<List<Student>> searchByKeyword(@PathParam("keyword") String keyword){
		//Change query String into small case
		String smallCase = keyword.toLowerCase();
		
		List<Student> studentName = this.studentService.searchByStudentName(smallCase);
		return new ResponseEntity<List<Student>>(studentName,HttpStatus.FOUND);
	}
	
	@GetMapping("/number/{rollNo}")//http://localhost:8089/api/v1/student/number/101
	public ResponseEntity<Student> searchByRollNumber(@PathVariable("rollNo")int rollNo){
		Student studentRollNo = this.studentService.searchByStudentRollNo(rollNo);
		return new ResponseEntity<Student>(studentRollNo,HttpStatus.FOUND);
	}
	
	
	@GetMapping("/sectionwise") //http://localhost:8089/api/v1/student/sectionwise?=query
	public ResponseEntity<List<Student>> searchBySection(@PathParam("query") String query){
		//Change query String into upper case
		String upperCase = query.toUpperCase();
		
		List<Student> section = this.studentService.filterBySection(upperCase);
		
		return new ResponseEntity<List<Student>>(section,HttpStatus.FOUND);
	}

}
