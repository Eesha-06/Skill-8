package com.klef.Skill8;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ProductRepository extends JpaRepository<Product, Integer> {

    // Derived Query Methods
    List<Product> findByCategory(String category);

    List<Product> findByPriceBetween(double min, double max);

    // JPQL Query - Sorting by price
    @Query("SELECT p FROM Product p ORDER BY p.price ASC")
    List<Product> findAllSortedByPrice();

    // JPQL Query - Expensive products
    @Query("SELECT p FROM Product p WHERE p.price > ?1")
    List<Product> findExpensiveProducts(double price);

    // JPQL Query - Products by category
    @Query("SELECT p FROM Product p WHERE p.category = ?1")
    List<Product> getProductsByCategory(String category);

}
