package org.acs.service;

import org.acs.domain.model.Account;

import java.util.List;

/**
 * @author GenCloud
 * @date 10/2018
 */
public interface AccountService {
	Account loadUserByUsername(String username);

	Account findOne(long mAccountId);

	List<Account> findAll();

	void save(Account user);

	void delete(Account mAccount);
}
