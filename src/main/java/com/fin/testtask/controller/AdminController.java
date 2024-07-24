package com.fin.testtask.controller;

import com.fin.testtask.dto.AccountUserDTO;
import com.fin.testtask.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private AccountService accountService;

    @GetMapping("/accounts")
    public ResponseEntity<List<AccountUserDTO>> getAllAccounts() {
        List<AccountUserDTO> accounts = accountService.getAllAccountsWithUsers();
        return ResponseEntity.ok(accounts);
    }

    @PostMapping("/block/{accountId}")
    public ResponseEntity<Void> blockAccount(@PathVariable Long accountId) {
        System.out.println("Received POST request to block account with ID: " + accountId);
        accountService.blockAccount(accountId);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/unblock/{accountId}")
    public ResponseEntity<Void> unblockAccount(@PathVariable Long accountId) {
        accountService.unblockAccount(accountId);
        return ResponseEntity.noContent().build();
    }
}
