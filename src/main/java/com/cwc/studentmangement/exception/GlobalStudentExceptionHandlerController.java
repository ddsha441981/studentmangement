package com.cwc.studentmangement.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalStudentExceptionHandlerController {

	@ExceptionHandler(DuplicateRollNumberFound.class)
	public ResponseEntity<ApiResponse> handleduplicateRollNumber(DuplicateRollNumberFound rollNumberFound) {
		
		ApiResponse api = new ApiResponse();
		api.setError(rollNumberFound.toString());
		api.setMessage(rollNumberFound.getMessage());
		return new ResponseEntity<ApiResponse>(api,HttpStatus.BAD_REQUEST);
		
	}
}
