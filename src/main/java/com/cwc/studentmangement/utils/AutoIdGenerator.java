package com.cwc.studentmangement.utils;

import java.util.UUID;

import org.hibernate.mapping.IdGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//@Configuration
public class AutoIdGenerator {
	
//	@Bean
	public String idGenerator() {
		String id = UUID.randomUUID().toString();
		System.out.println(id);
		return id;	
	}
	
	public static void main(String[] args) {
		AutoIdGenerator ag = new AutoIdGenerator();
		ag.idGenerator();
	}

}
