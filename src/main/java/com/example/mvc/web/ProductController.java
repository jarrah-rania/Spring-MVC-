package com.example.mvc.web;


import com.example.mvc.entities.Product;
import com.example.mvc.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.Model;

import java.util.List;

@Controller
public class ProductController {
    //pour l'injection des dépendances: 2facons @Authowired ou bien ajouter constructeur

    @Autowired
    private ProductRepository productRepository;
    @GetMapping("/index")
    public String index(Model model){
        List<Product> products = productRepository.findAll();
        model.addAttribute ("listProducts",products);
        return "products";

    }
    @GetMapping("/delete") //si on a une requete avec /delete c'est la methode suivante qui sera exécuter
    public String delete(@RequestParam(name="id") Long id)
    {
       productRepository.deleteById(id);
       return "redirect:/index";
    }
}
