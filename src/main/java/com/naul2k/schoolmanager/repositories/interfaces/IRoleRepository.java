package com.naul2k.schoolmanager.repositories.interfaces;

import com.naul2k.schoolmanager.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRoleRepository extends JpaRepository<Role, Integer> {
}
