package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
    private Calculator calculator;

    @Autowired
    public HomeController(Calculator calculator) {
        this.calculator = calculator;
    }

    @GetMapping("/canbac2")
    public String tinhCanBacHai(@RequestParam("a") double a) {
        return "Can bac 2 cua " + a + " la " + calculator.canBacHai(a);
    }
    @GetMapping("/binhphuong")
    public String tinhBinhPhuong(@RequestParam("a") double a) {
        return "Binh phuong cua " + a + " la " + calculator.binhPhuong(a);
    }
}
