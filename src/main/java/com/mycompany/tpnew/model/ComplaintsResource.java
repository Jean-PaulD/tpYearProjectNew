package com.mycompany.tpnew.model;

import com.mycompany.tpnew.domain.User;

/**
 * Created by user on 5/24/15.
 */
public class ComplaintsResource {


    private Long resid;

    private User user;

    public User getUser() {
        return user;
    }

    private String username;
    private String timestamp;
    private String complaint;

    public ComplaintsResource(Builder builder) {
        resid = builder.resid;
        username = builder.username;
        complaint = builder.complaint;
        timestamp = builder.timestamp;
        user = builder.user;
    }

    public String getComplaint() {
        return complaint;
    }

    private ComplaintsResource() {

    }

    public Long getResid() {
        return resid;
    }

    public String getUsername() {
        return username;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public static class Builder {

        private Long resid;
        private String username;
        private String timestamp;
        private String complaint;
        private User user;

        public Builder user(User value) {
            this.user = value;
            return this;
        }

        public Builder(String username) {
            this.username = username;
        }

        public Builder id(Long value) {
            this.resid = value;
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

        public Builder copy(ComplaintsResource value) {
            this.username = value.getUsername();
            this.resid = value.getResid();
            this.user = value.getUser();
            return this;
        }

        public ComplaintsResource build() {
            return new ComplaintsResource(this);
        }

    }


}
