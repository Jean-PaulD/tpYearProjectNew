/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.tpnew.domain;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

/**
 *
 * @author JEAN-PAUL
 */

@Entity
public class PostComments implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    private Post postObj;
    
    
      private String post;
      private String comment;
      
    
    private PostComments(){
        
    }
    
    public PostComments(Builder builder) {
        id = builder.id;
        post = builder.post;
        comment = builder.comment;
        postObj = builder.postObj;
    }

    public String getPost() {
        return post;
    }

    public String getComment() {
        return comment;
    }

    public Long getId() {
        return id;
    }

    public Post getPostObj() {
        return postObj;
    }


    public static class Builder {
private Post postObj;
        private Long id;
        private String post;
      private String comment;
        public Builder(String post) {
            this.post = post;
        }
        
        public Builder postObj(Post value){
            this.postObj=value;
            return this;
        }
        
        public Builder id(Long value){
            this.id=value;
            return this;
        }

        public Builder post(String value){
            this.post=value;
            return this;
        }
        
         public Builder comment(String value){
            this.comment=value;
            return this;
        }
        
        public Builder copy(PostComments value){
         
            this.id=value.getId();
            this.comment = value.comment;
            this.post = value.post;
            return this;
        }
        
        public PostComments build(){
            return new PostComments(this);
        }
        
        
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 83 * hash + Objects.hashCode(this.id);
        hash = 83 * hash + Objects.hashCode(this.post);
        hash = 83 * hash + Objects.hashCode(this.comment);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final PostComments other = (PostComments) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.post, other.post)) {
            return false;
        }
        if (!Objects.equals(this.comment, other.comment)) {
            return false;
        }
        return true;
    }
    
    
}
