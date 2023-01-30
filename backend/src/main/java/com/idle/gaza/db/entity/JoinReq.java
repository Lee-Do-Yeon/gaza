package com.idle.gaza.db.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@ToString
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class JoinReq {
    int userId;

    String name;

    String phone_number;

    String id;

    String pw;

    String gender;

    Date birthday;

    String picture;

    String email;

    String email_domain;

    String state;
}
