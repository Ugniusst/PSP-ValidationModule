package com.example.thirdtask.services;

import com.example.thirdtask.customExceptions.notValidateUserException;
import com.example.thirdtask.entities.User;
import com.example.thirdtask.repositories.UserRepository;
import com.example.thirdtask.customExceptions.notValidateUserException;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;
import static org.junit.jupiter.api.Assertions.*;


import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class UserServiceMockTest {

    @Mock
    UserRepository userRepository;

    @InjectMocks
    UserService userService;

    private User user;
    private List<User> userList;

    @BeforeAll
    void setup() throws SQLException {
        User user = new User(1, "Kasparas","+37062475204", "Kasparas@gmail.com", "Vilnius", "Password123!");
        this.user = user;
        this.userList = new ArrayList<>();
        this.userList.add(user);
        this.userList.add(new User(2,"Tomas","+44062475204", "Tomas@gmail.com", "Vilnius", "Password123!"));
    }
    @Test
    void testFindById() {
        when(userRepository.findById(Mockito.anyInt())).thenReturn(user);
        User found = userService.findById(Mockito.anyInt());
        verify(userRepository).findById(Mockito.anyInt());
        assertNotNull(found);
    }
    @Test
    void testFindAll() {
        when(userRepository.findAll()).thenReturn(userList);
        List<User> found = (List<User>) userService.findAll();
        verify(userRepository).findAll();
        assertEquals(2, found.size());
    }
    @Test
    void testFindByEmail() {
        when(userRepository.findByEmail(Mockito.anyString())).thenReturn(user);
        User found = userService.findByEmail(Mockito.anyString());
        verify(userRepository).findByEmail(Mockito.anyString());
        assertNotNull(found);
    }
    @Test
    void testSave_ValidUser() throws notValidateUserException {
        User user = new User(3, "Patrikas","+37062475204", "Kasparas1@gmail.com", "Vilnius", "Password123!");
        try {
            userService.save(user);
        } catch (notValidateUserException e) {
            fail();
        }
        verify(userRepository).save(Mockito.any(User.class));
    }
    @Test
    void testSave_InvalidEmail() throws notValidateUserException {
        User user = new User(3, "Patrikas","+37062475204", "Kasparas!gmail.com", "Vilnius", "Password123!");
        try {
            userService.save(user);
        } catch (notValidateUserException e) {
            return;
        }
        fail();
    }
    @Test
    void testSave_InvalidPhoneNumber() throws notValidateUserException {
        User user = new User(3, "Patrikas","+370a2475204", "Kasparas1@gmail.com", "Vilnius", "Password123!");
        try {
            userService.save(user);
        } catch (notValidateUserException e) {
            return;
        }
        fail();
    }
    @Test
    void testSave_InvalidPassword() throws notValidateUserException {
        User user = new User(3, "Patrikas","+37062475204", "Kasparas1@gmail.com", "Vilnius", "password123");
        try {
            userService.save(user);
        } catch (notValidateUserException e) {
            return;
        }
        fail();
    }
    @Test
    void testUpdate_ValidUser() throws notValidateUserException {
        User user = new User(2,"Toma","+44062475204", "Tomas1@gmail.com", "Vilnius", "Password123!");
        when(userRepository.findById(Mockito.anyInt())).thenReturn(user);
        try {
            userService.update(2, user);
        } catch (notValidateUserException e) {
            fail();
        }
        verify(userRepository).save(Mockito.any(User.class));
    }
    @Test
    void testUpdate_InvalidEmail() throws notValidateUserException {
        User user = new User(2,"Tomas","+44062475204", "Tomas!gmail.com", "Vilnius", "Password123!");
        try {
            userService.save(user);
        } catch (notValidateUserException e) {
            return;
        }
        fail();
    }
    @Test
    void testUpdate_InvalidPhoneNumber() throws notValidateUserException {
        User user = new User(2,"Tomas","+4406ab475204", "Tomas@gmail.com", "Vilnius", "Password123!");
        try {
            userService.save(user);
        } catch (notValidateUserException e) {
            return;
        }
        fail();
    }
    @Test
    void testUpdate_InvalidPassword() throws notValidateUserException {
        User user = new User(2,"Tomas","+44062475204", "Tomas@gmail.com", "Vilnius", "password123");
        try {
            userService.save(user);
        } catch (notValidateUserException e) {
            return;
        }
        fail();
    }
    @Test
    void testDelete() {
        try {
            userService.deleteById(2);
        } catch (notValidateUserException e) {
            fail()
        }
        verify(userRepository).delete(Mockito.any(User.class));
    }
}
