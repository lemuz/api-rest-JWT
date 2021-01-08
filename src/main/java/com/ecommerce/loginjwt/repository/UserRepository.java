package com.ecommerce.loginjwt.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ecommerce.loginjwt.entity.Rol;
import com.ecommerce.loginjwt.entity.Usuario;

@Repository
public interface UserRepository extends JpaRepository<Usuario, Integer>{

	@Query(value="SELECT TOP 1 u.* FROM usuario as u WHERE u.nickname = :nickname AND u.contrasena_usuario = :password", nativeQuery = true)
	Usuario login(@Param("nickname") String nickname, @Param("password") String password);
	
	@Query(value="SELECT r.* FROM rol AS r INNER JOIN usuario_rol AS ur ON r.id_rol = ur.id_rol INNER JOIN usuario AS u ON ur.id_usuario = u.id_usuario WHERE u.id_usuario = :id", nativeQuery = true)
	List<Rol> findRoles(@Param("id") Integer idUsuario);
	
	Usuario findByNickname(String nickname);

	Usuario findByRoles(Rol rol);
}