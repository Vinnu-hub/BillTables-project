package com.example.Spring_task_interview.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Entity
@Table(name = "bill_child")
public class BillChild {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "bill_id")
    private Long billId; // Reference to BillParent

    private String category;
    private String subcategory;
    private String origin;
    private String manufacturing;
    private String hsnCode;
    private String store;
    private String name;
    private String size;
    private double mrp;
    private int qty;

    @ManyToOne
    @JoinColumn(name = "bill_id", referencedColumnName = "billId", insertable = false, updatable = false)
    private BillParent billParent;

}

