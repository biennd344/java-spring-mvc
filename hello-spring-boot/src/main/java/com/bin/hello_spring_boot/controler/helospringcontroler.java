package com.bin.hello_spring_boot.controler;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class helospringcontroler {
    @GetMapping("/hello")
    String sayhello(){
        return "xin chao";
    }
}
