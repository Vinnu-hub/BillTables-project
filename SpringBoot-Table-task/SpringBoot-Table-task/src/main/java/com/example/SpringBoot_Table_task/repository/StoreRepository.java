package com.example.SpringBoot_Table_task.repository;

import com.example.SpringBoot_Table_task.entity.Store;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StoreRepository extends JpaRepository<Store, Long> {
    Store findByName(String name);
}