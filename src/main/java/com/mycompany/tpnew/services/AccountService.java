package com.mycompany.tpnew.services;

import com.mycompany.tpnew.domain.AccountInfo;
import com.mycompany.tpnew.domain.User;

import java.util.List;

/**
 * Created by user on 5/17/15.
 */
public interface AccountService {
    List<AccountInfo> getAccountInfo();
    List<User> getUsername();
}
