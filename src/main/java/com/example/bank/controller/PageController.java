package com.example.bank.controller;

import com.example.bank.dto.Bank;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;


@Controller
public class PageController {

    @Autowired
    private RestTemplate restTemplate;

    private static final String API_URL = "https://api.nbrb.by/bic";

    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }
    @GetMapping("/banks")
    public String getAllBanks(Model model) {
        Bank[] banks = restTemplate.getForObject(API_URL, Bank[].class);
        model.addAttribute("banks", Arrays.asList(banks));
        return "bankList";
    }

    @GetMapping("/register")
    public String registerPage() {
        return "register";
    }

}
