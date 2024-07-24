package com.fin.testtask.controller;

import com.fin.testtask.dto.AccountUserDTO;
import com.fin.testtask.dto.AmountDTO;
import com.fin.testtask.entity.User;
import com.fin.testtask.repository.UserRepository;
import com.fin.testtask.service.AccountService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private AccountService accountService;

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/account")
    public ResponseEntity<AccountUserDTO> getAccount(@AuthenticationPrincipal UserDetails userDetails) {
        String username = userDetails.getUsername();
        User user = userRepository.findByUsername(username);
        AccountUserDTO accountUserDTO = accountService.getAccountWithUser(user.getId());
        return ResponseEntity.ok(accountUserDTO);
    }

    @PostMapping("/deposit")
    public ResponseEntity<Void> deposit(@AuthenticationPrincipal UserDetails userDetails,
                                        @RequestBody AmountDTO amountDTO
    ) {

        String username = userDetails.getUsername();
        User user = userRepository.findByUsername(username);
        accountService.deposit(accountService.getAccountByUserId(user.getId()).getId(), amountDTO.getAmount());
        return ResponseEntity.noContent().build();
    }

    @PostMapping(value = "/withdraw")
    public ResponseEntity<Void> withdraw(@AuthenticationPrincipal UserDetails userDetails,
                                         @RequestBody(required = false) AmountDTO amountDTO) {

        String username = userDetails.getUsername();
        User user = userRepository.findByUsername(username);
        accountService.withdraw(accountService.getAccountByUserId(user.getId()).getId(), amountDTO.getAmount());
        return ResponseEntity.noContent().build();
    }
}
