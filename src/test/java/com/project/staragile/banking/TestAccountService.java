package com.project.staragile.banking;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class TestAccountService {

	@Autowired
	AccountService accountService;
	
	@Test
	public void testAccountRegistraiton() {
		Account account = new Account(1010101010,"Shubham","Saving Account",20000.0);
		assertEquals(account.getAccountNumber(),accountService.registerDummyAccount().getAccountNumber());
		assertEquals(account.getAccountName(),accountService.registerDummyAccount().getAccountName());
	}
	
	@Test
	public void testUpdateAccount() {
		Account accountUpdated = new Account(1010101010,"Shubham","Saving Account",20000.0);
		Account account = new Account(1010101010,"Shubham","Saving Account",20000.0);
		accountService.registerAccount(account);
		assertEquals(accountService.updateAccoubtDetails(accountUpdated, 1010101010).getAccountName(), accountUpdated.getAccountName());

	}

	@Test
	public void testViewAccount() {
		Account account = new Account(1010101010,"Shubham","Saving Account",20000.0);
		accountService.registerAccount(account);
		assertEquals(accountService.getAccountDetails(1010101010).getAccountName(), account.getAccountName());
	}

	@Test
	public void testDeleteAccount() {
		Account account = new Account(1010101010,"Shubham","Saving Account",20000.0);
		accountService.registerAccount(account);
		String expect = "Account Deleted Successfully";
		assertEquals(expect, accountService.deleteAccountDetails(1010101010));
	}
}
