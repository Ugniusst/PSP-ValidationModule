package com.example.thirdtask.controllers;

import com.example.thirdtask.customExceptions.notValidateUserException;
import com.example.thirdtask.entities.User;
import com.example.thirdtask.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserControllerMVC {

    @Autowired
    UserService userService;

    private String errors;

    @GetMapping("/all-users")
    public String showUsers(ModelMap model) {
        model.put("users", userService.findAll());
        return "list-users"; // view resolver
    }

    @GetMapping("/")
    public String showHome(ModelMap model) {
        model.put("users", userService.findAll());
        return "list-users"; // view resolver
    }
    @GetMapping("/add-user")
    public String showAddPage(ModelMap model) {
        model.addAttribute("user", new User());
        return "add-user";
    }

    @PostMapping("/add-user")
    public String add(ModelMap model, @ModelAttribute("user") User user, BindingResult result) {

        if(result.hasErrors()) {
            return "add-user";
        }
        try {
            userService.save(user);
        } catch (notValidateUserException e) {
            errors = e.getMessage();
            return "redirect:/validation-error";
        }
        return "redirect:/user/" + user.getId();
    }
    @GetMapping("/update-user/{id}")
    public String showUpdatePage(ModelMap model, @PathVariable int id) {
        model.addAttribute("user", userService.findById(id));
        return "inspect-user";
    }

    @PostMapping("/update-user/{id}")
    public String update(ModelMap model, @ModelAttribute("user") User user, @PathVariable int id,
                         BindingResult result) {
        if(result.hasErrors()) {
            return "inspect-user";
        }
        try {
            userService.update(id, user);
        } catch (notValidateUserException e) {
        errors = e.getMessage();
        return "redirect:/validation-error";
    }

        return "redirect:/update-user/" + user.getId();
    }

    @GetMapping("/delete-user/{id}")
    @Transactional
    public String delete(@PathVariable int id) {
        try {
            userService.deleteById(id);
        } catch (notValidateUserException e) {
            errors = e.getMessage();
            return "redirect:/validation-error";
        }
        return "redirect:/all-users";
    }

    @GetMapping("/validation-error") //
    public String showErrorPage(ModelMap model) {
        model.put("error", errors);
        return "validation-error"; // view resolver
    }
}
