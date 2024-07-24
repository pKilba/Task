package com.fin.testtask.service.impl;

import com.fin.testtask.dto.AccountUserDTO;
import com.fin.testtask.entity.Account;
import com.fin.testtask.entity.User;
import com.fin.testtask.repository.AccountRepository;
import com.fin.testtask.repository.UserRepository;
import com.fin.testtask.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AccountServiceImpl implements AccountService {
    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<Account> getAllAccounts() {
        return accountRepository.findAll();
    }

    @Override
    public Account getAccountByUserId(Long userId) {
        return accountRepository.findByUserId(userId);
    }

    @Override
    public void deposit(Long accountId, BigDecimal amount) {
        Account account = accountRepository.findById(accountId).orElseThrow();
        if (account.getBlocked()) {
            throw new IllegalStateException("Account is blocked");
        }
        account.setBalance(account.getBalance().add(amount));
        accountRepository.save(account);
    }

    @Override
    public void withdraw(Long accountId, BigDecimal amount) {
        Account account = accountRepository.findById(accountId).orElseThrow();
        if (account.getBlocked()) {
            throw new IllegalStateException("Account is blocked");
        }
        if (account.getBalance().compareTo(amount) < 0) {
            throw new IllegalStateException("Insufficient balance");
        }
        account.setBalance(account.getBalance().subtract(amount));
        accountRepository.save(account);
    }

    @Override
    public void blockAccount(Long accountId) {
        Account account = accountRepository.findById(accountId).orElseThrow();
        account.setBlocked(true);
        accountRepository.save(account);
    }

    @Override
    public void unblockAccount(Long accountId) {
        Account account = accountRepository.findById(accountId).orElseThrow();
        account.setBlocked(false);
        accountRepository.save(account);
    }

    @Override
    public AccountUserDTO getAccountWithUser(Long userId) {
        Account account = accountRepository.findByUserId(userId);
        User user = userRepository.findById(userId).orElseThrow();

        AccountUserDTO accountUserDTO = new AccountUserDTO();
        accountUserDTO.setAccountId(account.getId());
       // accountUserDTO.setBalance(account.getBalance());
        accountUserDTO.setBlocked(account.getBlocked());
        accountUserDTO.setUserId(user.getId());
        accountUserDTO.setUsername(user.getUsername());

        return accountUserDTO;
    }

    @Override
    public List<AccountUserDTO> getAllAccountsWithUsers() {
        List<Account> accounts = accountRepository.findAll();
        return accounts.stream().map(account -> {
            User user = userRepository.findById(account.getUserId()).orElseThrow();
            AccountUserDTO accountUserDTO = new AccountUserDTO();
            accountUserDTO.setAccountId(account.getId());
        //    accountUserDTO.setBalance(account.getBalance());
            accountUserDTO.setBlocked(account.getBlocked());
            accountUserDTO.setUserId(user.getId());
            accountUserDTO.setUsername(user.getUsername());
            return accountUserDTO;
        }).collect(Collectors.toList());
    }
}
