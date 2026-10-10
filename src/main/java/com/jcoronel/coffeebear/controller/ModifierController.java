package com.jcoronel.coffeebear.controller;

import com.jcoronel.coffeebear.dto.ApiResponse;
import com.jcoronel.coffeebear.dto.modifier.ModifierRequestDto;
import com.jcoronel.coffeebear.dto.modifier.ModifierResponseDto;
import com.jcoronel.coffeebear.service.ModifierService;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/modifiers")
public class ModifierController {
    private final ModifierService modifierService;

    public ModifierController(ModifierService modifierService) {
        this.modifierService = modifierService;
    }

    @GetMapping
    public ResponseEntity<Page<ModifierResponseDto>> findAll(@RequestParam Integer page, @RequestParam Integer size){
        return ResponseEntity.ok().body(modifierService.findAll(page,size));
    }

    //validar que solo sean numeros
    @GetMapping("/{id}")
    public ResponseEntity<ModifierResponseDto> findById(@PathVariable Integer id){
        return  ResponseEntity.ok().body(modifierService.findById(id));
    }

    @PostMapping
    public ResponseEntity<ModifierResponseDto> save(@Valid @RequestBody ModifierRequestDto modifierRequestDto){
        return  ResponseEntity.ok().body(modifierService.saveModifier(modifierRequestDto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ModifierResponseDto> update(@PathVariable Integer id, @Valid @RequestBody ModifierRequestDto modifierRequestDto){
        return  ResponseEntity.ok().body(modifierService.updateModifier(id,modifierRequestDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Void>> delete(@PathVariable Integer id){
        modifierService.deleteModifier(id);
        return ResponseEntity.ok().body(new ApiResponse<>(HttpStatus.OK.value(), "Modifier successfully deleted",null));
    }
}
