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
public class Notification implements Serializable {

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 31 * hash + Objects.hashCode(this.id);
        hash = 31 * hash + Objects.hashCode(this.comment);
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
        final Notification other = (Notification) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.comment, other.comment)) {
            return false;
        }
        if (!Objects.equals(this.username, other.username)) {
            return false;
        }
        return true;
    }

    private Long id;
    private String comment;
    private String username;

    private Notification() {

    }

    public Notification(Builder builder) {
        id = builder.id;
        comment = builder.comment;
        username = builder.username;
    }

    public Long getId() {
        return id;
    }

    public String getComment() {
        return comment;
    }

    public String getUsername() {
        return username;
    }

    public static class Builder {

        private Long id;

        private String comment;
        private String username;

        public Builder(String username) {
            this.username = username;
        }

        public Builder id(Long value) {
            this.id = value;
            return this;
        }
        
        public Builder comment(String value) {
            this.comment = value;
            return this;
        }

        public Builder copy(Notification value) {

            this.id = value.getId();
            this.username = value.getUsername();
            this.comment = value.getComment();
            return this;
        }

        public Notification build() {
            return new Notification(this);
        }

    }
}
