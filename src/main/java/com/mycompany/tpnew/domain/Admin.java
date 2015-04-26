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
public class Admin implements Serializable {

    private Long id;
    private String AdminID;
    private String username;
    private String post;

    public Admin(Builder builder) {
        id = builder.id;
        username = builder.username;
        AdminID = builder.AdminID;
        post = builder.post;
    }

    public Long getId() {
        return id;
    }

    public String getAdminID() {
        return AdminID;
    }

    public String getUsername() {
        return username;
    }

    public String getPost() {
        return post;
    }

    private Admin() {

    }

    public static class Builder {

        private Long id;
        private String AdminID;
        private String username;
        private String post;

        public Builder(String username) {
            this.username = username;
        }

        public Builder id(Long value) {
            this.id = value;
            return this;
        }

        public Builder post(String post) {
            this.post = post;
            return this;
        }

        public Builder copy(Admin value) {
            this.username = value.getUsername();
            this.post = value.getPost();
            this.id = value.getId();
            this.AdminID = value.getAdminID();
            return this;
        }

        public Admin build() {
            return new Admin(this);
        }
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + Objects.hashCode(this.username);
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
        final Admin other = (Admin) obj;
        if (!Objects.equals(this.username, other.username)) {
            return false;
        }
        return true;
    }

}
