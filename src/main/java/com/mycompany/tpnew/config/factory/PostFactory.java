/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.tpnew.config.factory;

import com.mycompany.tpnew.domain.Post;

/**
 *
 * @author JEAN-PAUL
 */
public class PostFactory {
    public static Post createPost(String username,boolean accept, int acceptNum, String post){

        Post post1 = new Post
                .Builder(username)
                .accept(accept)
                .acceptNum(acceptNum)
                .post(post)
                .build();
                
        return post1;
    }
}
