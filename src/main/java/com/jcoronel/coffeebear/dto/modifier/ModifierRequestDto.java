package com.jcoronel.coffeebear.dto.modifier;

public class ModifierRequestDto {
    private String name;
    private Boolean enabled;

    public ModifierRequestDto() {
    }

    public ModifierRequestDto(String name, Boolean enabled) {
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
