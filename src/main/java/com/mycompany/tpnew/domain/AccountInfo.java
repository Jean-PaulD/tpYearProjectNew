/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.tpnew.domain;

import java.io.Serializable;
import java.util.List;
import javax.persistence.*;


/**
 *
 * @author JEAN-PAUL
 */
@Entity
public class AccountInfo implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(unique = true)
    
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="Account_ID")
    private Admin admin;
    
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="Account_ID")
    private User user;
    
    
    private String username;
    private String password;
    private String dateCreated;

    
    private AccountInfo(){
        
    }
    
    public AccountInfo(Builder builder) {
        id = builder.id;
        username = builder.username;
        password = builder.password;
        dateCreated = builder.dateCreated;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getDateCreated() {
        return dateCreated;
    }

    public Admin getAdmin() {
        return admin;
    }

    public User getUser() {
        return user;
    }

    public static class Builder {

        private Long id;
        private String username;
        private String password;
        private String dateCreated;
        
        public Builder(String username) {
            this.username = username;
        }
        
        public Builder id(Long value){
            this.id=value;
            return this;
        }

        public Builder password(String value){
            this.password=value;
            return this;
        }
        
        public Builder dateCreated(String value){
            this.dateCreated=value;
            return this;
        }
        
        public Builder copy(AccountInfo value){
            this.username=value.getUsername();
            this.password=value.getPassword();
            this.dateCreated=value.getDateCreated();
            this.id=value.getId();
            return this;
        }
        
        public AccountInfo build(){
            return new AccountInfo(this);
        }
        
        
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof AccountInfo)) {
            return false;
        }

        AccountInfo account = (AccountInfo) o;

        return !(id != null ? !id.equals(account.id) : account.id != null);

    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Course{"
                + "id=" + id
                + ", username='" + username + '\''
                + '}';
    }

    public Long getId() {
        return id;
    }

}
