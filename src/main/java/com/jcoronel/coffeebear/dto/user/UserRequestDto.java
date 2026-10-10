package com.jcoronel.coffeebear.dto.user;

public class UserRequestDto {
    private String name;
    private String lastname;
    private String dni;
    private String email;

    public UserRequestDto() {
    }

    public UserRequestDto(String name, String lastname, String dni, String email) {
        this.name = name;
        this.lastname = lastname;
        this.dni = dni;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
