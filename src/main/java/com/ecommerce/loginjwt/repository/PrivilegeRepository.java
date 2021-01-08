package com.ecommerce.loginjwt.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ecommerce.loginjwt.entity.Privilegio;

@Repository
public interface PrivilegeRepository extends JpaRepository<Privilegio, Integer>{

	Privilegio findByNombre(String name);

}
