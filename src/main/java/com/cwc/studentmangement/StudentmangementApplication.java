package com.cwc.studentmangement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class StudentmangementApplication {

	public static void main(String[] args) {
		SpringApplication.run(StudentmangementApplication.class, args);
	}

	//Request By using Postman(Client) -> Controller(EndPoints) -> Service(Business Logic) -> Repository -> Database
	//Response -> Database -> Repository -> Service -> Controller -> Postman
	
}
