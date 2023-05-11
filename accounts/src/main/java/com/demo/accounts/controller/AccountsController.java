package com.demo.accounts.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.demo.accounts.model.Accounts;
import com.demo.accounts.model.Customer;
import com.demo.accounts.repository.AccountsRepository;

@RestController
public class AccountsController {
	@Autowired
	private AccountsRepository accountsRepository;

	@PostMapping("/myAccount")
	public Accounts getAccountDetails(@RequestBody Customer customer) {

		Accounts accounts = accountsRepository.findByCustomerId(customer.getCustomerId());
		System.out.println("accounts"+accounts.getAccountNumber());
		if (accounts != null) {
			return accounts;
		} else {
			return null;
		}

	}
}
