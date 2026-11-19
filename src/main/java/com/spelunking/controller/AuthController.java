package com.spelunking.controller;

import com.spelunking.dto.AuthResponse;
import com.spelunking.dto.LoginRequest;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.jwt.JwtClaimsSet;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.JwtEncoderParameters;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.List;

@RestController
public class AuthController {

    private final AuthenticationManager authenticationManager;
    private final JwtEncoder jwtEncoder;

    public AuthController(
            AuthenticationManager authenticationManager,
            JwtEncoder jwtEncoder
    ) {
        this.authenticationManager = authenticationManager;
        this.jwtEncoder = jwtEncoder;
    }

    @PostMapping({"/auth/login", "/auth.login"})
    public AuthResponse login(@Valid @RequestBody LoginRequest request) {
        Authentication authentication;

        try {
            authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            request.username(),
                            request.password()
                    )
            );
        } catch (BadCredentialsException exception) {
            throw new ResponseStatusException(
                    HttpStatus.UNAUTHORIZED,
                    "Invalid username or password"
            );
        }

        Instant issuedAt = Instant.now();
        Instant expiresAt = issuedAt.plus(15, ChronoUnit.MINUTES);

        List<String> roles = authentication.getAuthorities().stream()
                .map(authority -> authority.getAuthority())
                .toList();

        JwtClaimsSet claims = JwtClaimsSet.builder()
                .issuer("spelunking-api")
                .issuedAt(issuedAt)
                .expiresAt(expiresAt)
                .subject(authentication.getName())
                .claim("roles", roles)
                .build();

        String token = jwtEncoder
                .encode(JwtEncoderParameters.from(claims))
                .getTokenValue();

        return new AuthResponse(token, "Bearer", 900);
    }
}