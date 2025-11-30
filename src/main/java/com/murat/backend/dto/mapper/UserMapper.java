package com.murat.backend.dto.mapper;

import com.murat.backend.domain.Role;
import com.murat.backend.domain.User;
import com.murat.backend.domain.enums.RoleType;
import com.murat.backend.dto.UserDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Mapper(componentModel = "spring")
public interface UserMapper {


    @Mapping(target = "roles", expression = "java(mapRoles(user.getRoles()))")
    UserDTO userToUserDTO(User user);


    List<UserDTO> map(List<User> users);


    default Set<String> mapRoles(Set<Role> roles) {
        Set<String> rolesStr = new HashSet<>();

        for (Role r : roles) {
            if (r.getName().equals(RoleType.ROLE_ADMIN)) {
                rolesStr.add("Administrator");
            } else {
                rolesStr.add("Customer");
            }
        }

        return rolesStr;
    }
}
