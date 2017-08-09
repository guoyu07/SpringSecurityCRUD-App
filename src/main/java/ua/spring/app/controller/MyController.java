package ua.spring.app.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ua.spring.app.entity.Product;
import ua.spring.app.service.MyService;



@Controller
@RequestMapping("/products")
public class MyController {

    @Autowired
    private MyService myService;

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ModelAndView addProduct(@ModelAttribute("prod_from_ui") Product product) {

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("index");
        modelAndView.addObject("prod_from_ui", new Product());
        myService.create(product);

        return modelAndView;
    }

    @RequestMapping("delete/{id}")
    public String remove(@PathVariable("id") int id){

        myService.delete(id);

        return "redirect:/products/allprod";
    }


    @RequestMapping(value = "/allprod", method = RequestMethod.GET)
    public ModelAndView getAllproducts(Model model) {

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("products", myService.getAllProducts());
        modelAndView.setViewName("allproducts");

        return modelAndView;
    }

}
