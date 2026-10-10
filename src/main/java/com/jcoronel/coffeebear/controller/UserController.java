package com.jcoronel.coffeebear.controller;

import com.jcoronel.coffeebear.dto.ApiResponse;

import com.jcoronel.coffeebear.dto.user.UserRequestDto;
import com.jcoronel.coffeebear.dto.user.UserResponseDto;
import com.jcoronel.coffeebear.service.UserService;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<Page<UserResponseDto>> findAll(@RequestParam Integer page, @RequestParam Integer size){
        return ResponseEntity.ok().body(userService.findAll(page,size));
    }

    //validar que solo sean numeros
    @GetMapping("/{id}")
    public ResponseEntity<UserResponseDto> findById(@PathVariable Integer id){
        return  ResponseEntity.ok().body(userService.findById(id));
    }

    @PostMapping
    public ResponseEntity<UserResponseDto> save(@Valid @RequestBody UserRequestDto userRequestDto){
        return  ResponseEntity.ok().body(userService.saveUser(userRequestDto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserResponseDto> update(@PathVariable Integer id, @Valid @RequestBody UserRequestDto userRequestDto){
        return  ResponseEntity.ok().body(userService.updateUser(id,userRequestDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Void>> delete(@PathVariable Integer id){
        userService.deleteUser(id);
        return ResponseEntity.ok().body(new ApiResponse<>(HttpStatus.OK.value(), "User successfully deleted",null));
    }
}
