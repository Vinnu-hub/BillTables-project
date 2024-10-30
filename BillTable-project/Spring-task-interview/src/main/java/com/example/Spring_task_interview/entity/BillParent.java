package com.example.Spring_task_interview.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "bill_parent")
public class BillParent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long billId;

    private String billDate;
    private String station;


    // @OneToMany when:
    //You have an entity that can relate to multiple instances of another entity.
    // For example, a single bill can have multiple items.

    @OneToMany(mappedBy = "billParent", cascade = CascadeType.ALL)
    private List<BillChild> billChildren;

}