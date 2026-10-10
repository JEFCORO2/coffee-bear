package com.jcoronel.coffeebear.repository;

import com.jcoronel.coffeebear.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}
