package com.klef.Skill8;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductRepository repository;

    // Add product
    @PostMapping
    public Product addProduct(@RequestBody Product product) {
        return repository.save(product);
    }

    // Category search
    @GetMapping("/category/{category}")
    public List<Product> getByCategory(@PathVariable String category) {
        return repository.findByCategory(category);
    }

    // Price range filter
    @GetMapping("/filter")
    public List<Product> filterPrice(@RequestParam double min,
                                     @RequestParam double max) {
        return repository.findByPriceBetween(min, max);
    }

    // Sorted products
    @GetMapping("/sorted")
    public List<Product> getSortedProducts() {
        return repository.findAllSortedByPrice();
    }

    // Expensive products
    @GetMapping("/expensive/{price}")
    public List<Product> expensiveProducts(@PathVariable double price) {
        return repository.findExpensiveProducts(price);
    }

}