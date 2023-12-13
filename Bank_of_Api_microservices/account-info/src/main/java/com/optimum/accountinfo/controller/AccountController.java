package com.optimum.accountinfo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.optimum.accountinfo.account.Account;
import com.optimum.accountinfo.account.AccountDTO;
import com.optimum.accountinfo.account.ObjectMapperUtils;
import com.optimum.accountinfo.service.AccountService;
@RestController
@RequestMapping("/accountdb")
@CrossOrigin
public class AccountController {

    @Autowired
    private AccountService accountService;

    @GetMapping(value = "/")
    public List<AccountDTO> getAllAccount() {
        return ObjectMapperUtils.mapAll(accountService.findAll(), AccountDTO.class);
    }

    @GetMapping(value = "/byaccountId/{accountId}")
    public AccountDTO getAccountByAccountId(@PathVariable("accountId") int accountId) {
        return ObjectMapperUtils.map(accountService.findByAccountId(accountId), AccountDTO.class);
    }

    @GetMapping(value = "/byaccountType/{accountType}")
    public AccountDTO getAccountByAccountType(@PathVariable("accountType") String accountType) {
        return ObjectMapperUtils.map(accountService.findByAccountType(accountType), AccountDTO.class);
    }
    
    @GetMapping(value = "/byuserId/{userId}")
    public AccountDTO getAccountByUserId(@PathVariable("userId") int userId) {
        return ObjectMapperUtils.map(accountService.findByUserId(userId), AccountDTO.class);
    }

    

    @PostMapping(value = "/save")
    public ResponseEntity<String> saveOrUpdateAccount(@RequestBody Account AccountDTO) {
        accountService.saveAccount(ObjectMapperUtils.map(AccountDTO, Account.class));
        return new ResponseEntity<String>("Account added successfully", HttpStatus.OK);
    }


}
