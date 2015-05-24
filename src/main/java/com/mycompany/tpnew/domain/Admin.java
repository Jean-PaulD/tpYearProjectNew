/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.tpnew.domain;

import org.hibernate.annotations.CascadeType;

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
public class Admin implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(unique = true)
    private String AdminID;
    private String username;
    @OneToOne
    @JoinColumn(name="Admin_ID")
    private AccountInfo accouuntInfo;
    
    

    private String post;

    public Admin(Builder builder) {
        id = builder.id;
        username = builder.username;
        AdminID = builder.AdminID;
        post = builder.post;
        accouuntInfo = builder.accouuntInfo;
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

    public AccountInfo getAccouuntInfo() {
        return accouuntInfo;
    }

    public static class Builder {

        private Long id;
        private String AdminID;
        private String username;
        private String post;
        private AccountInfo accouuntInfo;
        
        public Builder(String username) {
            this.username = username;
        }

        public Builder accouuntInfo(AccountInfo value) {
            this.accouuntInfo = value;
            return this;
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
