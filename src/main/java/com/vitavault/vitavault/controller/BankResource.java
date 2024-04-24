package com.vitavault.vitavault.controller;

import com.vitavault.vitavault.domain.Bank;
import com.vitavault.vitavault.service.bank.BankServiceImpl;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value = "/api/v3/bank")
@CrossOrigin(origins = "*")
public class BankResource extends BaseControllerImpl<Bank, BankServiceImpl> {
}
