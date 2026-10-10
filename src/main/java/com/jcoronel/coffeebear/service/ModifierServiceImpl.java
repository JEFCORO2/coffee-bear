package com.jcoronel.coffeebear.service;


import com.jcoronel.coffeebear.dto.modifier.ModifierRequestDto;
import com.jcoronel.coffeebear.dto.modifier.ModifierResponseDto;
import com.jcoronel.coffeebear.entity.Modifier;
import com.jcoronel.coffeebear.exception.ResourceNotFoundException;
import com.jcoronel.coffeebear.mapper.ModifierMapper;
import com.jcoronel.coffeebear.repository.ModifierRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ModifierServiceImpl implements ModifierService{
    private final ModifierRepository modifierRepository;
    private final ModifierMapper modifierMapper;

    public ModifierServiceImpl(ModifierRepository modifierRepository, ModifierMapper modifierMapper) {
        this.modifierRepository = modifierRepository;
        this.modifierMapper = modifierMapper;
    }

    @Override
    public Page<ModifierResponseDto> findAll(Integer page, Integer size) {
        //crear exepciones para validar page y size
        final Pageable pageable = PageRequest.of(page,size);
        return modifierRepository.findAll(pageable).map(modifierMapper::modifierToDto);
    }

    @Override
    public ModifierResponseDto findById(Integer id) {
        return modifierMapper.modifierToDto(modifierRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException(Modifier.class.getSimpleName())));
    }

    @Override
    public ModifierResponseDto saveModifier(ModifierRequestDto modifierRequestDto) {
        Modifier modifier = modifierMapper.dtoToModifier(modifierRequestDto);
        modifierRepository.save(modifier);
        return modifierMapper.modifierToDto(modifier);
    }

    @Override
    @Transactional
    public ModifierResponseDto updateModifier(Integer id, ModifierRequestDto modifierRequestDto) {
        Modifier modifier = modifierRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException(Modifier.class.getSimpleName()));

        modifier.setName(modifierRequestDto.getName());
        modifier.setEnabled(modifierRequestDto.getEnabled());

        return modifierMapper.modifierToDto(modifier);
    }

    @Override
    public void deleteModifier(Integer id) {
        Modifier modifier = modifierRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException(Modifier.class.getSimpleName()));
        modifierRepository.delete(modifier);
    }
}
