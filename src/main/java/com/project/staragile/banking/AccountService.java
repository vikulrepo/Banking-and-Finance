package com.project.staragile.banking;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountService {
	
	@Autowired
	AccountRepository accountRepository;
	
	public Account createAccount() {
		Account account = new Account(1010101010,"Shubham","Saving Account",20000.0);
		return accountRepository.save(account);
	}

	public Account registerAccount(Account account) {
		return accountRepository.save(account);
	}

	public Account getAccountDetails(int accountId) {
		return accountRepository.findById(accountId).get();
	}
	
	public Account registerDummyAccount() {
		Account account = new Account(1010101010,"Shubham","Saving Account",20000.0);
		return account;
	}
	
	public Account updateAccoubtDetails(Account account, int accountNumber) {
		Account ac = accountRepository.findById(accountNumber).get();
		ac.setAccountBalance(account.getAccountBalance());
		ac.setAccountName(account.getAccountName());
		ac.setAccountNumber(account.getAccountNumber());
		ac.setAccountType(account.getAccountType());
		accountRepository.save(ac);
		return ac;
    }

	public String deleteAccountDetails(int accountNumber) {
		if(!(accountRepository.findById(accountNumber).isPresent()))
		{
			return "Account does not exist";
		}
		accountRepository.deleteById(accountNumber);
		return "Account Deleted Successfully";

	}

}
