package com.example.SpringBoot_Table_task.entity;

import com.example.SpringBoot_Table_task.entity.Product;
import com.example.SpringBoot_Table_task.entity.Store;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
@Entity
public class Sale {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    //    private Long product_id;
    private Long sale_quantity;
//    private Long store_id;

    @ManyToOne
    @JoinColumn(name = "s_id")
    @JsonBackReference
    private Store store;

    @ManyToOne
    @JoinColumn(name = "p_id")
    @JsonBackReference
    private Product product;
}
