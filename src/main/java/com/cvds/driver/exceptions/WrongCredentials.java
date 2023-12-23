package com.cvds.driver.exceptions;

public class WrongCredentials extends RuntimeException{
    public WrongCredentials(String mssg) {
        super(mssg);
    }
}
