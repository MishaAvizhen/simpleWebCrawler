package com.netcracker.miavstoapp.dao;

import com.netcracker.miavstoapp.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleDao extends JpaRepository<Role, Integer> {
}