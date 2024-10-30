package com.example.Spring_task_interview.dTO;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@Setter
@Getter
@NoArgsConstructor
public class BillOutputDTO
{
    private Long billId;
    private String billDate;
    private String station;
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

}

