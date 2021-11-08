package com.example.thirdtask.validators;

import com.example.thirdtask.customExceptions.notValidateUserException;

public interface ValidatorUserInterface {
    public void validateEmail(String email) throws notValidateUserException;

    public void validatePhoneNumber(String phoneNumber) throws notValidateUserException;

    public void validatePassword(String password) throws notValidateUserException;
}
