package com.jcoronel.coffeebear.mapper;

import com.jcoronel.coffeebear.dto.modifier.ModifierRequestDto;
import com.jcoronel.coffeebear.dto.modifier.ModifierResponseDto;
import com.jcoronel.coffeebear.entity.Modifier;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ModifierMapper {
    ModifierResponseDto modifierToDto(Modifier modifier);
    Modifier dtoToModifier(ModifierRequestDto modifierRequestDto);
}
