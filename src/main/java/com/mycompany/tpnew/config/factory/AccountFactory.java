/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.tpnew.config.factory;

import com.mycompany.tpnew.domain.AccountInfo;

/**
 *
 * @author JEAN-PAUL
 */
public class AccountFactory {
    public static AccountInfo createAccount(String username,String datecreated, String password){

        AccountInfo accountInfo = new AccountInfo
                .Builder(username)
                .dateCreated(username)
                .password(password)
                .build();
                
        return accountInfo;
    }
}
