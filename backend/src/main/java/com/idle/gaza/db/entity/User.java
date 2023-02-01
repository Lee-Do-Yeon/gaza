package com.idle.gaza.db.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int userId;

    String name;

    String phone_number;

    String id;

    @Column(name = "password")
    @JsonIgnore
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    String pw;

    String gender;

    Date birthday;

    String picture;

    String email;

    String email_domain;

    @Column(name = "state_code")
    String state;

    @Builder(builderMethodName = "userBuilder", toBuilder = true)
    public User(int userId, String name, String phone_number, String id, String pw, String gender, Date birthday, String picture, String email, String email_domain, String state) {
        this.userId = userId;
        this.name = name;
        this.phone_number = phone_number;
        this.id = id;
        this.pw = pw;
        this.gender = gender;
        this.birthday = birthday;
        this.picture = picture;
        this.email = email;
        this.email_domain = email_domain;
        this.state = state;
    }
}