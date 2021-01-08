package com.ecommerce.loginjwt.repository;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ecommerce.loginjwt.entity.Rol;
import com.ecommerce.loginjwt.entity.Usuario;

@Repository
public interface RolRepository extends JpaRepository<Rol, Integer>{

	Rol findByNombre(String string);

	Set<Rol> findByUsuarios(Usuario u);

}
