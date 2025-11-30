package com.murat.backend.dto;

import com.murat.backend.domain.Role;
import com.murat.backend.domain.enums.RoleType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {

    private Long id;

    private String firstName;

    private String lastName;

    private String email;

    private String phoneNumber;

    private String address;

    private String zipCode;

    private Boolean builtIn;

    private Set<String> roles;



}
