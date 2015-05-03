/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.tpnew.config.factory;

import com.mycompany.tpnew.domain.PostComments;

/**
 *
 * @author JEAN-PAUL
 */
public class PostCommentsFactory {
    public static PostComments createAccount(String username,String comment, String post){

        PostComments postComments = new PostComments
                .Builder(username)
                .comment(comment)
                .post(post)
                .build();
        return postComments;
    }
}
