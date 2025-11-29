package com.murat.backend.service;

import com.murat.backend.domain.Role;
import com.murat.backend.domain.User;
import com.murat.backend.domain.enums.RoleType;
import com.murat.backend.dto.request.RegisterRequest;
import com.murat.backend.exception.ConflictException;
import com.murat.backend.exception.ResourceNotFoundException;
import com.murat.backend.exception.message.ErrorMessage;
import com.murat.backend.repository.RoleRepository;
import com.murat.backend.repository.UserRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;

    public void register(RegisterRequest registerRequest) {

        if (userRepository.existsByEmail(registerRequest.getEmail())) {
            throw new ConflictException(String.format(ErrorMessage.EMAIL_ALREADY_EXIST, registerRequest.getEmail()));
        }

        String encodedPassword = passwordEncoder.encode(registerRequest.getPassword());

        Role role = roleRepository.findByName(RoleType.ROLE_CUSTOMER).orElseThrow(() -> new ResourceNotFoundException(String.format(ErrorMessage.RESOURCE_NOT_FOUND_MESSAGE, RoleType.ROLE_CUSTOMER.name())));

        Set<Role> roles = new HashSet<>();
        roles.add(role);

        User user = new User();
        user.setFirstName(registerRequest.getFirstName());
        user.setLastName(registerRequest.getLastName());
        user.setEmail(registerRequest.getEmail());
        user.setPassword(encodedPassword);
        user.setPhoneNumber(registerRequest.getPhoneNumber());
        user.setAddres(registerRequest.getAddress());
        user.setZipCode(registerRequest.getZipcode());
        user.setRoles(roles);
        userRepository.save(user);
    }

}
