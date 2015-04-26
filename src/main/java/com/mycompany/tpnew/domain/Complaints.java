/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.tpnew.domain;

import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author JEAN-PAUL
 */
public class Complaints implements Serializable {

    private Long id;
    private String username;
    private String timestamp;
    private String complaint;

    public Complaints(Builder builder){
        id = builder.id;
        username = builder.username;
        complaint = builder.complaint;
        timestamp = builder.timestamp;
    }
    
    public String getComplaint() {
        return complaint;
    }

    private Complaints() {

    }

    public Long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public static class Builder {

        private Long id;
        private String username;
        private String timestamp;
        private String complaint;

        public Builder(String username) {
            this.username = username;
        }

        public Builder id(Long value) {
            this.id = value;
            return this;
        }

        public Builder timeStamp(String value) {
            this.timestamp = value;
            return this;
        }
        
        public Builder complaint(String value) {
            this.complaint = value;
            return this;
        }

        public Builder copy(Complaints value) {
            this.username = value.getUsername();
            this.id = value.getId();
            return this;
        }
        
        public Complaints build(){
            return new Complaints(this);
        }

    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 61 * hash + Objects.hashCode(this.id);
        hash = 61 * hash + Objects.hashCode(this.username);
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
        final Complaints other = (Complaints) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.username, other.username)) {
            return false;
        }
        return true;
    }
    
    
}
