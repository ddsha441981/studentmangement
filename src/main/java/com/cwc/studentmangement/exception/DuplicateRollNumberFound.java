package com.cwc.studentmangement.exception;

public class DuplicateRollNumberFound extends RuntimeException{


    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public DuplicateRollNumberFound() {
        super();
    }

    public DuplicateRollNumberFound(String message) {
        super(message);
    }

}
