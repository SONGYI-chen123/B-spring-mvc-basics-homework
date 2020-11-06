package com.thoughtworks.capacity.gtb.mvc.domain;

import lombok.*;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class User {

    private Integer id;

    @NotNull
    @Pattern(regexp = "[0-9a-zA-Z_]{3,10}")
    private String username;

    @NotNull
    @Length(min=5,max=12)
    private String password;

    @Email
    private String email;
}
