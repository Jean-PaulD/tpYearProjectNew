/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.tpnew.config.factory;

import com.mycompany.tpnew.domain.Notification;

/**
 *
 * @author JEAN-PAUL
 */
public class NotificationFactory {
    public static Notification createAccount(String username,String comment, String password){

        Notification notification = new Notification
                .Builder(username)
                .comment(comment)
                .build();
                
        return notification;
    }
}
