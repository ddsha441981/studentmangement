package com.cwc.studentmangement.utils;

import java.util.UUID;

//@Configuration
public class AutoIdGenerator {
	
//	@Bean
	public String idGenerator() {
		String id = UUID.randomUUID().toString();
		System.out.println(id);
		return id;	
	}


}
