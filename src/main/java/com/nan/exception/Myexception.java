package com.nan.exception;

public class Myexception extends Exception {
	
     /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Myexception() {
    	 super("自定义异常触发！！！");
     }
     
     public Myexception(String message) {
    	 super(message);
     }
}
