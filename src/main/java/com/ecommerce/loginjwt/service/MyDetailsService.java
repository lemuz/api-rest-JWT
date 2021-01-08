package com.ecommerce.loginjwt.service;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.ecommerce.loginjwt.entity.MyUserDetails;
import com.ecommerce.loginjwt.entity.Rol;
import com.ecommerce.loginjwt.entity.Usuario;
import com.ecommerce.loginjwt.repository.RolRepository;
import com.ecommerce.loginjwt.repository.UserRepository;

@Service
public class MyDetailsService implements UserDetailsService{
	
	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private RolRepository rolRepo;

	@Override
	public UserDetails loadUserByUsername(String nickname) throws UsernameNotFoundException {
		final Usuario u = userRepo.findByNickname(nickname);
		if (u == null) {
			throw new UsernameNotFoundException("Invalid username or password");
		}
		Set<Rol> roles = rolRepo.findByUsuarios(u);
		u.setRoles(roles);
		MyUserDetails userDet = new MyUserDetails(u);
		return userDet;
	}
}
