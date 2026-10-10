package com.jcoronel.coffeebear.dto.modifier;

public class ModifierResponseDto {
    private String name;
    private Boolean enabled;

    public ModifierResponseDto() {
    }

    public ModifierResponseDto(String name, Boolean enabled) {
        this.name = name;
        this.enabled = enabled;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }
}
