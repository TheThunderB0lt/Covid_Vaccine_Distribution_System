package com.cvds.driver.exceptions;

public class PatientDoesNotExitException extends RuntimeException{
    public PatientDoesNotExitException(String mssg) {
        super(mssg);
    }
}
