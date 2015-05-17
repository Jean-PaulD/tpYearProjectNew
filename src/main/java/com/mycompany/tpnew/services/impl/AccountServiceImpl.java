package com.mycompany.tpnew.services.impl;

import com.mycompany.tpnew.domain.AccountInfo;
import com.mycompany.tpnew.domain.User;
import com.mycompany.tpnew.repository.AccountInfoRepository;
import com.mycompany.tpnew.services.AccountService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by user on 5/17/15.
 */
@Service
public class AccountServiceImpl implements AccountService{


    private AccountInfoRepository repository;
    @Override
    public List<AccountInfo> getAccountInfo() {
        List<AccountInfo> accountInfo = new ArrayList<>();
        Iterable<AccountInfo> values = repository.findAll();
        for (AccountInfo value: values) {
            accountInfo.add(value);
        }

        return accountInfo;
    }

    @Override
    public List<User> getUsername() {
        return null;
    }
}
