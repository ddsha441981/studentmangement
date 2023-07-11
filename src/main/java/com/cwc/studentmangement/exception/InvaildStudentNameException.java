package com.cwc.studentmangement.exception;

public class InvaildStudentNameException  extends RuntimeException{


    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public InvaildStudentNameException() {
        super();
    }

    public InvaildStudentNameException(String message) {
        super(message);
    }

}
