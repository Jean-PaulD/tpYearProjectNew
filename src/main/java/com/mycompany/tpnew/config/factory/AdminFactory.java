/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.tpnew.config.factory;

import com.mycompany.tpnew.domain.Admin;

/**
 *
 * @author JEAN-PAUL
 */
public class AdminFactory {
    public static Admin createAdmin(String username,String post){

        Admin admin = new Admin
                .Builder(username)
                .post(post)
                .build();
        return admin;
    }
}
