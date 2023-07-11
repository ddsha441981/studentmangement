package com.cwc.studentmangement.exception;

public class RollNumberNotFoundException extends RuntimeException {
	
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public RollNumberNotFoundException() {
        super();
    }

    public RollNumberNotFoundException(String message) {
        super(message);
    }

}
