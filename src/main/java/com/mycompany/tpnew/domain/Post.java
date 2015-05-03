/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.tpnew.domain;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

/**
 *
 * @author JEAN-PAUL
 */
@Entity
public class Post implements Serializable {
@   Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id; 
    
    
    @OneToMany
    @JoinColumn(name="Post_ID")   
    private List<PostComments> postComments;
    
    
    private String username;
    private String post;
    private boolean accept;
    private int acceptNum;
private User user;
    private Post() {

    }

    public Post(Builder builder) {
        id = builder.id;
        username = builder.username;
        post = builder.post;
        accept = builder.accept;
        acceptNum = builder.acceptNum;
        user = builder.user;
        postComments = builder.postComments;
    }

    public String getUsername() {
        return username;
    }

    public String getPost() {
        return post;
    }

    public boolean isAccept() {
        return accept;
    }

    public int getAcceptNum() {
        return acceptNum;
    }

    public Long getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public List<PostComments> getPostComments() {
        return postComments;
    }

    public static class Builder {

        private Long id;
        private String username;
        private String post;
        private boolean accept;
        private int acceptNum;
private User user;
private List<PostComments> postComments;

        public Builder(String username) {
            this.username = username;
        }

        public Builder id(List<PostComments> value) {
            this.postComments = value;
            return this;
        }
        
        public Builder id(User value) {
            this.user = value;
            return this;
        }
        
        public Builder id(Long value) {
            this.id = value;
            return this;
        }

        public Builder username(String value) {
            this.username = value;
            return this;
        }

        public Builder post(String value) {
            this.post = value;
            return this;
        }

        public Builder accept(boolean value) {
            this.accept = value;
            return this;
        }

        public Builder acceptNum(int value) {
            this.acceptNum = value;
            return this;
        }

        public Builder copy(Post value) {
            this.id = value.getId();
            this.accept = value.isAccept();
            this.acceptNum = value.getAcceptNum();
            this.post = value.getPost();
            this.username = value.getUsername();
            this.user = value.getUser();
            this.postComments = value.getPostComments();
            return this;
        }

        public Post build() {
            return new Post(this);
        }

    }
}
