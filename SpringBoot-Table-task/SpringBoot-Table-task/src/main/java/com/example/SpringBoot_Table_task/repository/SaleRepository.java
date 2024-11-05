package com.example.SpringBoot_Table_task.repository;

import com.example.SpringBoot_Table_task.entity.Sale;
import com.example.SpringBoot_Table_task.entity.Store;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SaleRepository extends JpaRepository<Sale, Long> {
    List<Sale> findByStore(Store store);
}