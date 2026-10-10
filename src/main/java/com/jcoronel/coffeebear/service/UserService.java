package com.jcoronel.coffeebear.service;

import com.jcoronel.coffeebear.dto.user.UserRequestDto;
import com.jcoronel.coffeebear.dto.user.UserResponseDto;
import org.springframework.data.domain.Page;

public interface UserService {
    Page<UserResponseDto> findAll(Integer page, Integer size);
    UserResponseDto findById(Integer id);
    UserResponseDto saveUser(UserRequestDto userRequestDto);
    UserResponseDto updateUser(Integer id , UserRequestDto userRequestDto);
    void deleteUser(Integer id);
}
