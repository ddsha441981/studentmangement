package com.cwc.studentmangement.exception;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalStudentExceptionHandlerController{// extends ResponseEntityExceptionHandler{

	@ExceptionHandler(DuplicateRollNumberFound.class)
	public ResponseEntity<ApiResponse> handleduplicateRollNumber(DuplicateRollNumberFound rollNumberFound, WebRequest request) {
		
		ApiResponse api = new ApiResponse();
		api.setStatusCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
		api.setTimestamp(new Date());
		api.setMessage(rollNumberFound.getMessage());
		api.setDescription(rollNumberFound.toString());
		api.setPath(request.getDescription(false));
		return new ResponseEntity<ApiResponse>(api,HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<Map<String, String>> handleMethodArgsNotValidException(MethodArgumentNotValidException ex) {
		Map<String, String> resp = new HashMap<>();
		ex.getBindingResult().getAllErrors().forEach((error) -> {
			String fieldName = ((FieldError) error).getField();
			String message = error.getDefaultMessage();
			resp.put(fieldName, message);
		});

		return new ResponseEntity<Map<String, String>>(resp, HttpStatus.BAD_REQUEST);
	}
	
	
	
	/*
	 * @Override protected ResponseEntity<Object>
	 * handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders
	 * headers, HttpStatus status, WebRequest request) {
	 * 
	 * Map<String, String> errors = new HashMap<>();
	 * ex.getBindingResult().getAllErrors().forEach((error) ->{
	 * 
	 * String fieldName = ((FieldError) error).getField(); String message =
	 * error.getDefaultMessage(); errors.put(fieldName, message); }); return new
	 * ResponseEntity<Object>(errors, HttpStatus.BAD_REQUEST); }
	 */
	
	
//	 @Override
//	    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException exception,
//	            HttpHeaders httpHeaders, HttpStatus httpStatus, WebRequest webRequest) {
//	        Map<String, Object> objectBody = new LinkedHashMap<>();
//	        objectBody.put("Current Timestamp", new Date());
//	        objectBody.put("Status", httpStatus.value());
//	  
//	        // Get all errors
//	        List<String> exceptionalErrors = exception.getBindingResult()
//	                .getFieldErrors()
//	                .stream()
//	                .map(x -> x.getDefaultMessage())
//	                .collect(Collectors.toList());
//	 
//	        objectBody.put("Errors", exceptionalErrors);
//	 
//	        return new ResponseEntity<>(objectBody, httpStatus);
//	    }
}
