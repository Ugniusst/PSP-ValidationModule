package com.example.thirdtask.services;

import ValidationLibrary.src.EmailValidator;
import com.example.thirdtask.customExceptions.notValidateUserException;
import com.example.thirdtask.entities.User;
import com.example.thirdtask.repositories.UserRepository;
import com.example.thirdtask.validators.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public User findById(int id) {
        return userRepository.findById(id);
    }

    public Iterable<User> findAll() {
        return userRepository.findAll();
    }

    public  User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public User save(User user) throws notValidateUserException {

        UserValidator userValidator = new UserValidator();

        userValidator.validateEmail(user.getEmail());
        userValidator.validatePassword(user.getPassword());
        userValidator.validatePhoneNumber(user.getTelephoneNumber());

        if(userRepository.findByEmail(user.getEmail()) != null) {
            throw new notValidateUserException("Email is already used");
        }

        return userRepository.save(user);

    }
    public User update(int id, User user) throws notValidateUserException {
        if(userRepository.findById(id) == null) {
            throw new notValidateUserException("Updatable user is not found, consider creating a new usre");
        }

        UserValidator userValidator = new UserValidator();

        userValidator.validateEmail(user.getEmail());
        userValidator.validatePassword(user.getPassword());
        userValidator.validatePhoneNumber(user.getTelephoneNumber());
        user.setId(id);

        //if email is already used and not used by updatable user
        if(userRepository.findByEmail(user.getEmail()) != null && userRepository.findByEmail(user.getEmail()) == user) {
            throw new notValidateUserException("Email is already used");
        }
        return userRepository.save(user);
    }
    public void deleteById(int id) throws notValidateUserException {
        if(userRepository.findById(id) == null) {
            throw new notValidateUserException("The user with this id is not found");
        }
        userRepository.deleteById(id);
    }
}
