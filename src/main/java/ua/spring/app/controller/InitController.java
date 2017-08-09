package ua.spring.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import ua.spring.app.entity.Product;

@Controller(value = "/")
public class InitController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView setModelAndView() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("prod_from_ui", new Product());
        modelAndView.setViewName("index");

        return modelAndView;
    }
}
