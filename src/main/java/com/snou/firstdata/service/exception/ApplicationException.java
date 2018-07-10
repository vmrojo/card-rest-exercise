package com.snou.firstdata.service.exception;

public class ApplicationException extends Exception {

    private static final long serialVersionUID = 1L;

    public ApplicationException(String message) {
        super(message);
    }
    
    public ApplicationException(Throwable e) {
        super(e);
    }
    
    public ApplicationException(String message, Throwable e) {
        super(message, e); 
    }
    
}
