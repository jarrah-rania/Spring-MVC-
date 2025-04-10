package com.example.mvc;

import com.example.mvc.entities.Product;
import com.example.mvc.repository.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MvcApplication {

    public static void main(String[] args) {
        SpringApplication.run(MvcApplication.class, args);
    }
    @Bean
    CommandLineRunner commandLineRunner(ProductRepository productRepository){
        return args ->{
            Product product= Product.builder().name("Computer").price(5000).quantity(11)
                            .build();

productRepository.save(product);
productRepository.save(Product.builder().name("Printer").price(4900).quantity(3).build());
productRepository.save(Product.builder().name("Smart Phone").price(12000).quantity(2).build());
productRepository.findAll().forEach(p->{System.out.println(p.toString());
});
        };
    }

}
