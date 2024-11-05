package com.example.SpringBoot_Table_task.dto;


import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Dto {
    private String product_name;
    private Long sale;
    private Long mrp;
    private double amount;
}