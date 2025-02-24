package com.todo.todo.services.auth;


import com.todo.todo.dto.SignUpRequest;
import com.todo.todo.dto.UserDto;

public interface AuthService {
    UserDto createdDataEntry(SignUpRequest signuprequest);
    UserDto createdAdmin(SignUpRequest signuprequest);
    boolean hasAdminwithemail(String email);
}
