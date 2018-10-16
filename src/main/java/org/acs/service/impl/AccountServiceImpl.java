package org.acs.service.impl;

import org.acs.domain.model.Account;
import org.acs.domain.repository.AccountRepository;
import org.acs.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author GenCloud
 * @date 10/2018
 */
@Service
public class AccountServiceImpl implements AccountService {
	private final AccountRepository accountRepository;

	@Autowired
	public AccountServiceImpl(AccountRepository accountRepository) {
		this.accountRepository = accountRepository;
	}

	@Override
	public Account loadUserByUsername(String username) {
		return accountRepository.findAccountByUsername(username);
	}

	@Override
	public Account findOne(long mAccountId) {
		return accountRepository.findOne(mAccountId);
	}

	@Override
	public List<Account> findAll() {
		return accountRepository.findAll();
	}

	@Override
	public void save(Account user) {
		accountRepository.saveAndFlush(user);
	}

	@Override
	public void delete(Account mAccount) {
		accountRepository.delete(mAccount);
	}
}
