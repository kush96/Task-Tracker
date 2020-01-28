package com.service;

import com.dto.request.UserRequestDto;
import com.dto.response.ResponseMessage;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {
    ResponseMessage addUser(UserRequestDto requestDto);
}
