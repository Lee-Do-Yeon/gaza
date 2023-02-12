package com.idle.gaza.api.request;

import lombok.Setter;
import lombok.Getter;

@Setter
@getter
public class UserUpdateRequest {

    String name;

    String phone_number;

    String picture;

    String email;

    String email_domain;
}
