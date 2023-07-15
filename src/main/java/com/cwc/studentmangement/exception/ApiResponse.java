package com.cwc.studentmangement.exception;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class ApiResponse {

	private int statusCode;
	private Date timestamp;
	private String message;
	private String description;
	private String path;
}
