package ua.spring.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ua.spring.app.entity.User;
import ua.spring.app.service.AutoLoginService;
import ua.spring.app.service.UserService;

@Controller
@RequestMapping("/registration")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private AutoLoginService autoLoginService;


    @GetMapping
    public ModelAndView registration(ModelAndView modelAndView) {
        modelAndView.setViewName("registration");
        modelAndView.addObject("userForRegist", new User());

        return modelAndView;
    }

    @PostMapping
    public String addUser(@ModelAttribute("userForRegist") User user) {
        userService.saveUser(user);
        autoLoginService.autoLogin(user.getLogin(),user.getPassword());
        return "redirect:/products";
    }
}
