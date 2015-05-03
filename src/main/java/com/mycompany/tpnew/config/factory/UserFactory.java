/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.tpnew.config.factory;

import com.mycompany.tpnew.domain.User;

/**
 *
 * @author JEAN-PAUL
 */
public class UserFactory {
    public static User createUser(String username, int age, 
            String datecreated, String experienceLevel, String email, String privillageLevel,
    String name, String surname ){

        User user = new User
                .Builder(username)
                .age(age)
                .dateCreted(datecreated)
                .experienceLevel(experienceLevel)
                .email(email)
                .privillageLevel(privillageLevel)
                .name(name)
                .surname(name)
                .build();
                
                
               
                
                
                
        return user;
    }
}
