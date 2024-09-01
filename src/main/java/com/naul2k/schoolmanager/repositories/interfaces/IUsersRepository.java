package com.naul2k.schoolmanager.repositories.interfaces;

import com.naul2k.schoolmanager.entities.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUsersRepository extends JpaRepository<Users, Integer> {
}
