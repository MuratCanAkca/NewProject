package com.murat.backend.security.service;

import com.murat.backend.domain.User;
import com.murat.backend.exception.message.ErrorMessage;
import com.murat.backend.repository.UserRepository;
import lombok.Data;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@Data
public class UserDetailsServiceImpl implements UserDetailsService {

    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user = userRepository.findByEmail(username).orElseThrow(() -> new UsernameNotFoundException(String
                .format(ErrorMessage.USERNAME_NOT_FOUND_MESSAGE, username)));
        return UserDetailsImpl.build(user);
    }
}
