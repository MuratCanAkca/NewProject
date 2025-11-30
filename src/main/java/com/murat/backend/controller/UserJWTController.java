package com.murat.backend.controller;

import com.murat.backend.dto.request.LoginRequest;
import com.murat.backend.dto.request.RegisterRequest;
import com.murat.backend.dto.response.LoginResponse;
import com.murat.backend.dto.response.MBResponse;
import com.murat.backend.dto.response.ResponseMessage;
import com.murat.backend.security.jwt.JwtUtils;
import com.murat.backend.service.UserService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
@RequiredArgsConstructor
public class UserJWTController {

    private final UserService userService;
    private final AuthenticationManager authenticationManager;
    private final JwtUtils jwtUtils;

    @PostMapping("/register")
    public ResponseEntity<MBResponse> register(@Valid @RequestBody RegisterRequest registerRequest) {

        userService.register(registerRequest);
        MBResponse response = new MBResponse();
        response.setMessage(ResponseMessage.REGISTER_RESPONSE_MESSAGE);
        response.setSuccess(true);
        return new ResponseEntity<>(response, HttpStatus.CREATED);

    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> authenticate(@Valid @RequestBody LoginRequest loginRequest) {

        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getEmail(), loginRequest.getPassword()));
        String token = jwtUtils.generateJwtToken(authentication);
        LoginResponse response = new LoginResponse();
        response.setToken(token);
        return new ResponseEntity<>(response, HttpStatus.OK);

    }

}
