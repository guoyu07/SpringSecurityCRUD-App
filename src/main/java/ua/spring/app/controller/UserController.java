package ua.spring.app.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ua.spring.app.entity.User;
import ua.spring.app.service.AutoLoginService;
import ua.spring.app.service.UserService;
import ua.spring.app.validator.UserValidator;

@Controller
@RequestMapping("/registration")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private AutoLoginService autoLoginService;

    @Autowired
    private UserValidator validator;


    @GetMapping
    public ModelAndView registration(ModelAndView modelAndView, String error) {
        if (error != null) modelAndView.addObject("message", "User with this login already exist!");
        modelAndView.setViewName("registration");
        modelAndView.addObject("userForRegist", new User());

        return modelAndView;
    }

    @PostMapping
    public String addUser(@ModelAttribute("userForRegist") User user, BindingResult bindingResult) {
        if (userService.getUserById(user.getLogin()) != null) return "redirect:/registration?error";
        validator.validate(user, bindingResult);
        if (bindingResult.hasErrors()) {
            return "registration";
        }
        userService.saveUser(user);
        autoLoginService.autoLogin(user.getLogin(), user.getPassword());
        return "redirect:/products";
    }
}
