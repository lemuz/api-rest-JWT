package com.ecommerce.loginjwt.entity;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="rol")
public class Rol implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_rol")
	private Integer id;
	
	@Column(name="nombre_rol")
	private String nombre;
	
	@ManyToMany
    @JoinTable(
        name = "rol_privilegio", 
        joinColumns = @JoinColumn(
          name = "id_rol", referencedColumnName = "id_rol"), 
        inverseJoinColumns = @JoinColumn(
          name = "id_privilegio", referencedColumnName = "id_privilegio"))
    private Collection<Privilegio> privilegios;
	
	@ManyToMany 
    @JoinTable( 
        name = "usuario_rol", 
        joinColumns = @JoinColumn(
          name = "id_rol", referencedColumnName = "id_rol"), 
        inverseJoinColumns = @JoinColumn(
          name = "id_usuario", referencedColumnName = "id_usuario")) 
    private Collection<Usuario> usuarios;

	public Rol() {
		
	}

	public Rol(Integer id, String nombre, Collection<Privilegio> privileges) {
		this.id = id;
		this.nombre = nombre;
		this.privilegios = privileges;
	}

	public Rol(String nombre) {
		this.nombre = nombre;
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

	public Collection<Privilegio> getPrivileges() {
		return privilegios;
	}

	public void setPrivileges(Collection<Privilegio> privileges) {
		this.privilegios = privileges;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Rol other = (Rol) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Rol [id=" + id + ", nombre=" + nombre + ", privileges=" + privilegios + "]";
	}
}