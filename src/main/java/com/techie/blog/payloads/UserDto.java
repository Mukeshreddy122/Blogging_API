package com.techie.blog.payloads;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Setter
@Getter
public class UserDto {

    private Integer Id;
    private String Name;
    private String Email;
    private String Password;
    private String About;
}
