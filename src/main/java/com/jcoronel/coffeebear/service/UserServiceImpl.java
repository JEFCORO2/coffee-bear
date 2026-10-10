package com.jcoronel.coffeebear.service;

import com.jcoronel.coffeebear.dto.user.UserRequestDto;
import com.jcoronel.coffeebear.dto.user.UserResponseDto;
import com.jcoronel.coffeebear.entity.User;
import com.jcoronel.coffeebear.exception.ResourceNotFoundException;
import com.jcoronel.coffeebear.mapper.UserMapper;
import com.jcoronel.coffeebear.repository.UserRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public UserServiceImpl(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    @Override
    public Page<UserResponseDto> findAll(Integer page, Integer size) {
        //crear exepciones para validar page y size
        final Pageable pageable = PageRequest.of(page,size);
        return userRepository.findAll(pageable).map(userMapper::userToDto);
    }

    @Override
    public UserResponseDto findById(Integer id) {
        return userMapper.userToDto(userRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException(User.class.getSimpleName())));
    }

    @Override
    public UserResponseDto saveUser(UserRequestDto userRequestDto) {
        User user = userMapper.dtoToUser(userRequestDto);
        userRepository.save(user);
        return userMapper.userToDto(user);
    }

    @Override
    @Transactional
    public UserResponseDto updateUser(Integer id, UserRequestDto userRequestDto) {
        User user = userRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException(User.class.getSimpleName()));

        user.setName(userRequestDto.getName());
        user.setLastname(userRequestDto.getLastname());
        user.setEmail(userRequestDto.getEmail());
        user.setDni(userRequestDto.getDni());

        return userMapper.userToDto(user);
    }

    @Override
    public void deleteUser(Integer id) {
        User user = userRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException(User.class.getSimpleName()));
        userRepository.delete(user);
    }
}
