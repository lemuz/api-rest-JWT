package com.ecommerce.loginjwt.entity;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name ="privilegio")
public class Privilegio{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_privilegio")
	private Integer id;

	@Column(name="nombre_privilegio")
	private String nombre;

	@ManyToMany
	@JoinTable(
	        name = "rol_privilegio", 
	        joinColumns = @JoinColumn(
	          name = "id_privilegio", referencedColumnName = "id_privilegio"), 
	        inverseJoinColumns = @JoinColumn(
	          name = "id_rol", referencedColumnName = "id_rol"))
	private Collection<Rol> roles;

	public Privilegio(Integer id, String nombre) {
		this.id = id;
		this.nombre = nombre;
	}

	public Privilegio(String nombre) {
		this.nombre = nombre;
	}

	public Privilegio() {
	}
	
	

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Collection<Rol> getRoles() {
		return roles;
	}

	public void setRoles(Collection<Rol> roles) {
		this.roles = roles;
	}

	@Override
	public String toString() {
		return "Privilegio [id=" + id + ", nombre=" + nombre + "]";
	}
}
