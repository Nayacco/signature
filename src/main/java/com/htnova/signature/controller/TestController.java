package com.htnova.signature.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/test")
public class TestController {

    @GetMapping("/1")
    public String test1(String param){
        return param;
    }

    @PostMapping("/2")
    public String test2(@RequestBody String param){
        return param;
    }
}
