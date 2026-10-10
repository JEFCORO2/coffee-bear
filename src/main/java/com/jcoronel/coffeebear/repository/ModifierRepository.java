package com.jcoronel.coffeebear.repository;

import com.jcoronel.coffeebear.entity.Modifier;
import org.mapstruct.Mapper;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ModifierRepository extends JpaRepository<Modifier, Integer> {
}
