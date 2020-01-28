package com.controller;

import com.dto.request.AuthenticationRequestDto;
import com.dto.response.AuthenticationResponseDto;
import com.exceptions.AppInternalErrorException;
import com.service.UserService;
import com.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
public class AuthenticationController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserService userService;

    @Autowired
    PasswordEncoder passwordEncoder;


    @CrossOrigin(origins = "http://localhost:3000")
    @RequestMapping(value = "/authenticate", method = RequestMethod.POST)
    public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequestDto authenticationRequest) throws Exception {

        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authenticationRequest.getEmail(), authenticationRequest.getPassword())
            );
        }
        catch (BadCredentialsException e) {
            throw new AppInternalErrorException("Incorrect username or password",HttpStatus.BAD_REQUEST);
        }
        catch(LockedException e){
            throw new AppInternalErrorException("User account is locked, pls try again sometime or contact admin");
        }
        catch(Exception e){
            throw new AppInternalErrorException("Error authenticating, pls contact admin");
        }


        final UserDetails userDetails = userService
                .loadUserByUsername(authenticationRequest.getEmail());

        final String jwt = JwtUtil.generateToken(userDetails);

        return ResponseEntity.ok(new AuthenticationResponseDto(jwt));
    }
}
