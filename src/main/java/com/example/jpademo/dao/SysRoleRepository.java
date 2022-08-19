package com.example.jpademo.dao;

import com.example.jpademo.entity.SysRole;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SysRoleRepository extends JpaRepository<SysRole, Long> {
}