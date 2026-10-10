package com.jcoronel.coffeebear.service;

import com.jcoronel.coffeebear.dto.options.ModifierOptionResponseDto;
import org.springframework.data.domain.Page;

public interface ModifierOptionService {
    Page<ModifierOptionResponseDto> findAll(Integer page, Integer size);
}
