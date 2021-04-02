package com.example.myshop.controller;

import com.example.myshop.domain.Product;
import com.example.myshop.domain.User;
import com.example.myshop.repo.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

@Controller
public class MainController {
    @Autowired
    private ProductRepo productRepo;

    @GetMapping("/")
    public String greeting(String name, Map<String, Object> model) {

        return "greeting";
    }

    @GetMapping("/main")
    public String main(@RequestParam(required = false, defaultValue = "") String filter, Model model) throws IOException {
        Iterable<Product> products = productRepo.findAll();

        if (filter != null && !filter.isEmpty()) {
            products = productRepo.findByProductName(filter);

        } else {

            products = productRepo.findAll();
        }


        int i = filter.indexOf("https://happywear.ru");

        if (filter != null && !filter.isEmpty() && i > -1 ){
            Product product = new Product().link(filter);
            model.addAttribute("product", product);
        }
        System.out.println(products);
        model.addAttribute("products", products);
        model.addAttribute("filter", filter);

        return "main";
    }

    @PostMapping("/main")
    public String addProduct(
            @AuthenticationPrincipal User user,
            @RequestParam("productName") String productName,
            @RequestParam("photo") String photo,
            @RequestParam("productSize") String productSize,
            @RequestParam("quantity") int quantity,
            @RequestParam("productPrice") String productPrice,
            @RequestParam("productLink") String productLink,
            @Valid Product product, BindingResult bindingResult, Model model) {
       product.setCustomer(user);

        if (bindingResult.hasErrors()) {
            Map<String, String> errorsMap = ControllerUtils.getErrors(bindingResult);
           model.addAllAttributes(errorsMap);
          model.addAttribute("product", product);

       }else {
            model.addAttribute("product", null);
            productRepo.save(product);
            }

        Iterable<Product> products = productRepo.findAll();
        model.addAttribute("products", products);





        return "main";
    }

    @GetMapping("/user-products/{user}")
    public String userProduct(
            @AuthenticationPrincipal User currentUser,
            @PathVariable User user,
            Model model,
            @RequestParam(required = false) Product product
    ) {
        Set<Product> products = user.getProducts();

        model.addAttribute("products", products);
        model.addAttribute("product", product);
        model.addAttribute("isCurrentUser", currentUser.equals(user));

        return "userProducts";
    }

    @PostMapping("/user-products/{user}")
    public String updateProduct(
            @AuthenticationPrincipal User currentUser,
            @PathVariable Long user,
            @RequestParam("id") Product product,
            @RequestParam("productName") String productName,
            @RequestParam("photo") String photo,
            @RequestParam("productSize") String productSize,
            @RequestParam("quantity") int quantity,
            @RequestParam("productPrice") Double productPrice,
            @RequestParam("productLink") String productLink
    ) throws IOException {


        if (product.getCustomer().equals(currentUser)) {
            if (!StringUtils.isEmpty(productName)) {
                product.setProductName(productName);
            }

            if (!StringUtils.isEmpty(productSize)) {
                product.setProductSize(productSize);
            }

            if (!StringUtils.isEmpty(quantity)) {
                product.setQuantity(quantity);
            }

            if (!StringUtils.isEmpty(productPrice)) {
                product.setProductPrice(productPrice);
            }

            if (!StringUtils.isEmpty(productLink)) {
                product.setProductLink(productLink);
            }
            productRepo.save(product);
        }
        return "redirect:/user-products/" + user;
    }

    @PostMapping("/user-products-delete/{user}")
    public String deleteProduct(
            @AuthenticationPrincipal User currentUser,
            @PathVariable Long user,
            @RequestParam("id") Product product)  {

            productRepo.delete(product);

        return "redirect:/user-products/" + user;
    }

}