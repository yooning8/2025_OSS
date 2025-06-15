package com.example.re_wear.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SignUpDTO {
    private String userId;
    private String email;
    private String password;
    private String name;
    private String address;
    private String addressZipcode;
}
