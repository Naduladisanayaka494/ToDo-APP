package com.todo.todo.services.auth;


import com.todo.todo.dto.SignUpRequest;
import com.todo.todo.dto.UserDto;
import com.todo.todo.entity.User;
import com.todo.todo.enums.UserRole;
import com.todo.todo.repository.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service

public class AuthServiceImpl implements AuthService{
    private final UserRepository userRepository;

    public AuthServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDto createdDataEntry(SignUpRequest signuprequest) {
        User user = new User();
        user.setName(signuprequest.getName());
        user.setEmail(signuprequest.getEmail());
        user.setPassword(new BCryptPasswordEncoder().encode(signuprequest.getPassword()));
        user.setUserRole(UserRole.DataEntry);
        User createduser  =userRepository.save(user);
        UserDto userdto = new UserDto();
        userdto.setId(createduser.getId());
        return userdto;
    }

    @Override
    public UserDto createdAdmin(SignUpRequest signuprequest) {
        User user = new User();
        user.setName(signuprequest.getName());
        user.setEmail(signuprequest.getEmail());
        user.setPassword(new BCryptPasswordEncoder().encode(signuprequest.getPassword()));
        user.setUserRole(UserRole.ADMIN);
        User createduser  =userRepository.save(user);
        UserDto userdto = new UserDto();
        userdto.setId(createduser.getId());
        return userdto;
    }

    @Override
    public boolean hasAdminwithemail(String email) {
        return userRepository.findByEmail(email).isPresent();
    }
}

