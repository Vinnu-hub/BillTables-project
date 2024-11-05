package com.example.SpringBoot_Table_task.repository;

import com.example.SpringBoot_Table_task.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}

