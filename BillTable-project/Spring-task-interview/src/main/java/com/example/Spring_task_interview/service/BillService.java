package com.example.Spring_task_interview.service;


import com.example.Spring_task_interview.dTO.BillOutputDTO;
import com.example.Spring_task_interview.repository.BillParentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BillService
{

    @Autowired
    private BillParentRepository billParentRepository;

    public List<BillOutputDTO> getAllBillOutputs() {
        return billParentRepository.findAllBillOutputs();
    }
}