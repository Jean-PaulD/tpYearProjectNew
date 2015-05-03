/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.tpnew.domain;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author JEAN-PAUL
 */

@Entity
public class NoticeBoard implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String notice;

    public String getNotice() {
        return notice;
    }
    
    public NoticeBoard(Builder builder){
    
        id = builder.id;
        notice = builder.notice;
    }
    
    private NoticeBoard(){
    
    }
    
    public static class Builder{
        private String notice;
        private Long id;
        public Builder(String username) {
            this.notice = username;
        }
        
        public Builder id(Long value){
            this.id=value;
            return this;
        }

        
        public Builder copy(NoticeBoard value){
            this.id = value.id;
            this.notice = value.notice;
            return this;
        }
        
        public NoticeBoard build(){
            return new NoticeBoard(this);
        }
        
    }
    
    

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 19 * hash + Objects.hashCode(this.id);
        hash = 19 * hash + Objects.hashCode(this.notice);
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
        final NoticeBoard other = (NoticeBoard) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.notice, other.notice)) {
            return false;
        }
        return true;
    }

    
    
    
}
