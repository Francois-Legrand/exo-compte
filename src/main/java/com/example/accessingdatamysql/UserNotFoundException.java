package com.example.accessingdatamysql;

class UserNotFoundException extends RuntimeException{
	
	private static final long serialVersionUID = 1L;

	UserNotFoundException(Integer id) {
	    super("Could not find employee " + id);
	  }
}
