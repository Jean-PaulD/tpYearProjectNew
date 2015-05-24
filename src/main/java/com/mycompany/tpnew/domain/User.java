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
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(unique = true)

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "User_ID")
    private List <Post> post;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "User_ID")
    private List <Complaints> complaints;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "User_ID")
    private Notification notification;

    private String username;
    private String name;
    private String surname;
    private int age;
    private String email;
    private String privillageLevel;
    private String dateCreted;
    private String experienceLevel;

    private User() {

    }

    public User(Builder builder) {
        id = builder.id;
        username = builder.username;
        name = builder.name;
        surname = builder.surname;
        age = builder.age;
        email = builder.email;
        privillageLevel = builder.privillageLevel;
        dateCreted = builder.dateCreted;
        experienceLevel = builder.experienceLevel;
    }

    public String getUsername() {
        return username;

    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public int getAge() {
        return age;
    }

    public String getEmail() {
        return email;
    }

    public String getPrivillageLevel() {
        return privillageLevel;
    }

    public String getDateCreted() {
        return dateCreted;
    }

    public String getExperienceLevel() {
        return experienceLevel;
    }

    public Long getId() {
        return id;
    }

    public List<Post> getPost() {
        return post;
    }

    public List<Complaints> getComplaints() {
        return complaints;
    }

    public Notification getNotification() {
        return notification;
    }

    public static class Builder {

        private Long id;
        private String username;
        private String name;
        private String surname;
        private int age;
        private String email;
        private String privillageLevel;
        private String dateCreted;
        private String experienceLevel;
        private List <Post> post;
        private List<Complaints> complaints;
        private Notification notification;

        public Builder post(List <Post> value) {
            this.post= value;
            return this;
        }
        
        public Builder complaints(List<Complaints> value) {
            this.complaints = value;
            return this;
        }
        
        public Builder notification(Notification value) {
            this.notification = value;
            return this;
        }

        
        
        public Builder(String username) {
            this.username = username;
        }

        public Builder id(Long value) {
            this.id = value;
            return this;
        }

        public Builder name(String value) {
            this.name = value;
            return this;
        }

        public Builder surname(String value) {
            this.surname = value;
            return this;
        }

        public Builder age(int value) {
            this.age = value;
            return this;
        }

        public Builder email(String value) {
            this.email = value;
            return this;
        }

        public Builder privillageLevel(String value) {
            this.privillageLevel = value;
            return this;
        }

        public Builder dateCreted(String value) {
            this.dateCreted = value;
            return this;
        }

        public Builder experienceLevel(String value) {
            this.experienceLevel = value;
            return this;
        }

        public Builder copy(User value) {

            this.id = value.getId();
            this.username = value.getUsername();
            this.name = value.getName();
            this.surname = value.getSurname();
            this.age = value.getAge();
            this.email = value.getEmail();
            this.privillageLevel = value.getPrivillageLevel();
            this.dateCreted = value.getDateCreted();
            this.experienceLevel = value.getExperienceLevel();
            this.complaints = value.getComplaints();
            this.post = value.getPost();
            return this;
        }

        public User build() {
            return new User(this);
        }

    }

}
