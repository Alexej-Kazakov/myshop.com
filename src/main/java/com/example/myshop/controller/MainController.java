package com.example.myshop.controller;

import com.example.myshop.domain.Product;
import com.example.myshop.domain.User;
import com.example.myshop.repo.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.util.Map;

@Controller
public class MainController {
    @Autowired
    private ProductRepo productRepo;

    @GetMapping("/")
    public String greeting(String name, Map<String, Object> model) {

        return "greeting";
    }

    @GetMapping("/main")
    public String main(@RequestParam(required = false, defaultValue = "") String filter,  Model model) {
        Iterable<Product> products = productRepo.findAll();

        if (filter != null && !filter.isEmpty()) {
            products = productRepo.findByProductName(filter);

        } else {

            products = productRepo.findAll();

        }

        model.addAttribute("products", products);
        model.addAttribute("filter", filter);

        return "main";
    }

    @PostMapping("/main")
    public String addProduct(
            @AuthenticationPrincipal User user,
            @Valid Product product, BindingResult bindingResult, Model model) {

       product.setCustomer(user);

        if (bindingResult.hasErrors()) {
            Map<String, String> errorsMap = ControllerUtils.getErrors(bindingResult);
           model.addAllAttributes(errorsMap);
          model.addAttribute("products", product);

       }else {
            model.addAttribute("product", null);
            productRepo.save(product);
            }

        Iterable<Product> products = productRepo.findAll();
        model.addAttribute("products", products);

        return "main";
    }

}