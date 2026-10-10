package com.jcoronel.coffeebear.mapper;

import com.jcoronel.coffeebear.dto.user.UserRequestDto;
import com.jcoronel.coffeebear.dto.user.UserResponseDto;
import com.jcoronel.coffeebear.entity.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserResponseDto userToDto(User user);
    User dtoToUser(UserRequestDto userRequestDto);
}
