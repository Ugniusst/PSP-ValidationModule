package com.example.thirdtask.validators;

import ValidationLibrary.src.EmailValidator;
import ValidationLibrary.src.PasswordChecker;
import ValidationLibrary.src.PhoneValidator;
import com.example.thirdtask.customExceptions.notValidateUserException;

public class UserValidator {

    public void validateEmail(String email) throws notValidateUserException {

        EmailValidator emailValidator = new EmailValidator();

        if(!emailValidator.hasEtaSymbol(email)) {
            throw new notValidateUserException("No eta signs");
        }
        if(!emailValidator.hasOnlyRightSymbols(email)) {
            throw new notValidateUserException("Email has invalid signs");
        }
        if(!emailValidator.hasRightDomain(email)) {
            throw new notValidateUserException("Email's domain is invalid");
        }
    }
    public void validatePassword(String password) throws notValidateUserException {

        PasswordChecker passwordChecker = new PasswordChecker();
        int minimumLength = 8;

        if(!passwordChecker.passwordLenght(password,minimumLength)) {
            throw new notValidateUserException(String.format("Password is too short, it should contain at least %d characters", minimumLength));
        }
        if(!passwordChecker.hasSpecialSymbols(password)) {
            throw  new notValidateUserException("Password must contain at least one special character");
        }
        if(!passwordChecker.hasUppercase(password)) {
            throw  new notValidateUserException("Password must contain at least one upper case letter");
        }
    }
    public void validatePhoneNumber(String phoneNumber) throws notValidateUserException {

        PhoneValidator phoneValidator = new PhoneValidator();

        if(phoneNumber.startsWith("8")) {
            phoneNumber = phoneValidator.changeToLithuanianPrefix(phoneNumber);
        }
        if(!phoneValidator.hasOnlyNumbers(phoneNumber)) {
            throw new notValidateUserException("Phone numbers must contains only numbers (+ is allowed in front)");
        }

    }
}
