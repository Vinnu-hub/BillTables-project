package com.example.Spring_task_interview.controller;


import com.example.Spring_task_interview.dTO.BillOutputDTO;
import com.example.Spring_task_interview.service.BillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/bills")
@CrossOrigin("*")
public class BillController {

    @Autowired
    private BillService billService;

    @GetMapping("/output")
    public List<BillOutputDTO> getBillOutputs() {
        return billService.getAllBillOutputs();
    }
}
