package com.example.SpringBoot_Table_task.controller;


import com.example.SpringBoot_Table_task.dto.Dto;
import com.example.SpringBoot_Table_task.service.LogicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class LogicController {

    @Autowired
    private LogicService logicService;

    @GetMapping("/output")
    public ResponseEntity<List<Dto>> getOutput(@RequestParam String name) {
        return new ResponseEntity<>(logicService.getoutput(name), HttpStatus.OK);
    }
}