package com.example.demo.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.repository.Account;
import com.example.demo.repository.AccountRepository;

@RestController
public class AccountController {
    private final AccountRepository accountRepository;

    public AccountController(AccountRepository accountRepository) {this.accountRepository = accountRepository;}

    @GetMapping("/account/all")
    public Iterable<Account> getAccount() {
        return accountRepository.findAll();
    }
}
