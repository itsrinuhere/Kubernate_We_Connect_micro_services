package com.weconnect.REST;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping(value="/pdf")
public class Controller {
    @RequestMapping("/save")
    @GetMapping
    public String hey(){
        System.out.println("Evoekd");
        return "hi";
    }
}
