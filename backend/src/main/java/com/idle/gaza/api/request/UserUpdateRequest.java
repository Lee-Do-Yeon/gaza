package com.idle.gaza.api.request;

import lombok.Setter;

@Setter
public class UserUpdateRequest {

    String name;

    String phone_number;

    String picture;

    String email;

    String email_domain;
}
