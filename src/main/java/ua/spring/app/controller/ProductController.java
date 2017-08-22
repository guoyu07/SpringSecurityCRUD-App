package ua.spring.app.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ua.spring.app.entity.Product;
import ua.spring.app.service.ProductService;


@Controller
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ModelAndView addProduct(@ModelAttribute("prod_from_ui") Product product) {

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("index");
        modelAndView.addObject("prod_from_ui", new Product());
        productService.create(product);

        return modelAndView;
    }

    @RequestMapping("delete/{id}")
    public String remove(@PathVariable("id") int id) {

        productService.delete(id);

        return "redirect:/products/allprod";
    }


    @RequestMapping(value = "/allprod", method = RequestMethod.GET)
    public String getAllproducts(Model model) {
        model.addAttribute("products", productService.getAllProducts());
        return "allproducts";
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public ModelAndView edit(@PathVariable("id") int id) {
        ModelAndView modelAndView = new ModelAndView();
        Product product = productService.read(id);
        modelAndView.setViewName("edit_page");
        modelAndView.addObject("prod_for_edit", product);
        return modelAndView;
    }

    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public String addEdited(@ModelAttribute("prod_for_edit") Product product) {
        productService.update(product);
        return "redirect:/products/allprod";
    }

    @RequestMapping(value = "/searching", method = RequestMethod.GET)
    @ResponseBody
    public Product searchById(@ModelAttribute("id") int id) {
        Product product = productService.read(id);
        return product;
    }

}
