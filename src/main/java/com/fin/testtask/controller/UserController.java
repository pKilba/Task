package com.fin.testtask.controller;

import com.fin.testtask.dto.AccountUserDTO;
import com.fin.testtask.dto.AmountDTO;
import com.fin.testtask.entity.User;
import com.fin.testtask.repository.UserRepository;
import com.fin.testtask.service.AccountService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping("/user")
public class UserController {

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

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
                                        @RequestBody(required = false) AmountDTO amountDTO,
                                        HttpServletRequest request) {
        if ("GET".equals(request.getMethod())) {
            logger.info("GET");
        } else {
            logger.info("Post");
        }
//
//        // Логирование тела запроса
//        if (amountDTO == null) {
//            logger.error("AmountDTO is null");
//            return ResponseEntity.badRequest().build();
//        } else {
//            logger.info("Received amount: " + amountDTO.getAmount());
//        }
        logger.info("AmountDTO " + amountDTO);
        String username = userDetails.getUsername();
        logger.info("username " + username);
        User user = userRepository.findByUsername(username);
        //     accountService.deposit(accountService.getAccountByUserId(user.getId()).getId(), amountDTO.getAmount());
        return ResponseEntity.noContent().build();
    }

    @RequestMapping(value = "/withdraw", method = {RequestMethod.GET, RequestMethod.POST})
    public ResponseEntity<Void> withdraw(@AuthenticationPrincipal UserDetails userDetails,
                                         @RequestBody(required = false) AmountDTO amountDTO,
                                         HttpServletRequest request) {
        if ("GET".equals(request.getMethod())) {
            return ResponseEntity.badRequest().build();
        }

        // Логирование тела запроса
        if (amountDTO == null) {
            logger.error("AmountDTO is null");
            return ResponseEntity.badRequest().build();
        } else {
            logger.info("Received amount: " + amountDTO.getAmount());
        }

        String username = userDetails.getUsername();
        User user = userRepository.findByUsername(username);
        //   accountService.withdraw(accountService.getAccountByUserId(user.getId()).getId(), amountDTO.getAmount());
        return ResponseEntity.noContent().build();
    }
}
