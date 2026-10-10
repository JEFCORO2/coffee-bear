package com.jcoronel.coffeebear.dto.user;

public class UserResponseDto {
    private String name;
    private String lastname;
    private String dni;
    private String email;
    private Boolean enabled;

    public UserResponseDto() {
    }

    public UserResponseDto(String name, String lastname, String dni, String email, Boolean enabled) {
        this.name = name;
        this.lastname = lastname;
        this.dni = dni;
        this.email = email;
        this.enabled = enabled;
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

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }
}
