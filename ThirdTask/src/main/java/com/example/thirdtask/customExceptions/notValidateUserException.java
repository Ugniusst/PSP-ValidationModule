package com.example.thirdtask.customExceptions;

public class notValidateUserException  extends Exception{
    public notValidateUserException(String errorMessage) {
        super(errorMessage);
    }
}
