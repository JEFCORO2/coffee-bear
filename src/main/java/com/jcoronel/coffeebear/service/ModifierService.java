package com.jcoronel.coffeebear.service;

import com.jcoronel.coffeebear.dto.modifier.ModifierRequestDto;
import com.jcoronel.coffeebear.dto.modifier.ModifierResponseDto;
import org.springframework.data.domain.Page;

public interface ModifierService {
    Page<ModifierResponseDto> findAll(Integer page, Integer size);
    ModifierResponseDto findById(Integer id);
    ModifierResponseDto saveModifier(ModifierRequestDto modifierRequestDto);
    ModifierResponseDto updateModifier(Integer id , ModifierRequestDto modifierRequestDto);
    void deleteModifier(Integer id);
}
