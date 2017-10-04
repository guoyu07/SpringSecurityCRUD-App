package ua.spring.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/")
public class LoginController {


//    @RequestMapping(value = "/login", method = RequestMethod.GET)
//    public String login(Model model, String error, String logout) {
//        if (error != null) model.addAttribute("error", "Username or password incorrect.");
//        if (logout != null) model.addAttribute("message", "Logout is successfull.");
//        return "login_page";
//    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String login(Model model, String error, String logout) {
        if (error != null) model.addAttribute("error", "Username or password incorrect.");
        if (logout != null) model.addAttribute("message", "Logout is successfull.");
        return "login_page";
    }
}
