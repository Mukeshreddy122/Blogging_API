package com.techie.blog.payloads;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Setter
@Getter
public class UserDto {

    private Integer Id;
    @NotEmpty
    @Size(min =4,message = "User name must be >=4")
    private String Name;
    @jakarta.validation.constraints.Email(message = "Email address is not valid")
    private String Email;
    @NotEmpty(message = "Password should be filled")
    @Size(min=3,max=10,message = "Password must min 3 or max 10 chars")
    private String Password;
    @NotNull
    private String About;
}
