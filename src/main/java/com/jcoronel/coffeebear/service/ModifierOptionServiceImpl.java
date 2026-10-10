package com.jcoronel.coffeebear.service;

import com.jcoronel.coffeebear.dto.options.ModifierOptionResponseDto;
import com.jcoronel.coffeebear.mapper.ModifierOptionMapper;
import com.jcoronel.coffeebear.repository.ModifierOptionRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

public class ModifierOptionServiceImpl implements ModifierOptionService{
    private ModifierOptionRepository modifierOptionRepository;
    private ModifierOptionMapper modifierOptionMapper;

    public ModifierOptionServiceImpl(ModifierOptionRepository modifierOptionRepository, ModifierOptionMapper modifierOptionMapper) {
        this.modifierOptionRepository = modifierOptionRepository;
        this.modifierOptionMapper = modifierOptionMapper;
    }

    @Override
    public Page<ModifierOptionResponseDto> findAll(Integer page, Integer size) {
        final Pageable pageable = PageRequest.of(page,size);

        return null;
    }
}
