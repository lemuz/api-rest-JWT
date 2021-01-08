package com.ecommerce.loginjwt.entity;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="usuario")
public class Usuario implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario")
	private Integer id;
	
	@Column(name="nickname")
	private String nickname;
	
	@Column(name="contrasena_usuario")
	private String password;
	
	@Column(name="edad_usuario")
	private Integer edad;
	
	@Column(name="nombre_usuario")
	private String nombre;
	
	@Column(name="apellido_usuario")
	private String apellido;
	
	@Column(name="correo_usuario")
	private String email;
	
	@Column(name="telefono_usuario")
	private String telefono;
	
	@Column(name="direccion_usuario")
	private String direccion;
	
	@Column(name="pais_usuario")
	private char[] pais;
	
	@Column(name="provincia_usuario")
	private String provincia;
	
	@Column(name="ciudad_usuario")
	private String ciudad;
	
	@Column(name="identificacion_usuario")
	private String identificacion;
	
	@ManyToMany
    @JoinTable( 
        name = "usuario_rol", 
        joinColumns = @JoinColumn(
          name = "id_usuario", referencedColumnName = "id_usuario"), 
        inverseJoinColumns = @JoinColumn(
          name = "id_rol", referencedColumnName = "id_rol")) 
    private Set<Rol> roles;
	
	@Column(name="enabled")
	private boolean enabled;

	@Transient
	private String jwt;
	
	public Usuario() {
		
	}

	

	public Usuario(Integer id, String nickname, String password, Integer edad, String nombre, String apellido,
			String email, String telefono, String direccion, char[] pais, String provincia, String ciudad,
			String identificacion, Set<Rol> roles, String jwt, boolean enabled) {
		this.id = id;
		this.nickname = nickname;
		this.password = password;
		this.edad = edad;
		this.nombre = nombre;
		this.apellido = apellido;
		this.email = email;
		this.telefono = telefono;
		this.direccion = direccion;
		this.pais = pais;
		this.provincia = provincia;
		this.ciudad = ciudad;
		this.identificacion = identificacion;
		this.roles = roles;
		this.jwt = jwt;
		this.enabled = enabled;
	}



	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getEdad() {
		return edad;
	}

	public void setEdad(Integer edad) {
		this.edad = edad;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public char[] getPais() {
		return pais;
	}

	public void setPais(char[] pais) {
		this.pais = pais;
	}

	public String getProvincia() {
		return provincia;
	}

	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public String getIdentificacion() {
		return identificacion;
	}

	public void setIdentificacion(String identificacion) {
		this.identificacion = identificacion;
	}

	public String getJwt() {
		return jwt;
	}

	public void setJwt(String jwt) {
		this.jwt = jwt;
	}

	public Set<Rol> getRoles() {
		return roles;
	}

	public void setRoles(Set<Rol> roles) {
		this.roles = roles;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
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
		Usuario other = (Usuario) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Usuario [id=" + id + ", nickname=" + nickname + ", password=" + password + ", edad=" + edad
				+ ", nombre=" + nombre + ", apellido=" + apellido + ", email=" + email + ", telefono=" + telefono
				+ ", direccion=" + direccion + ", pais=" + Arrays.toString(pais) + ", provincia=" + provincia
				+ ", ciudad=" + ciudad + ", identificacion=" + identificacion + ", jwt=" + jwt
				+ ", enabled=" + enabled + "]";
	}
}