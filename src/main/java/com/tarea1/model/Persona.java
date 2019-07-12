package com.tarea1.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;

import io.swagger.annotations.ApiModelProperty;

@Entity
@Table(name="persona")
public class Persona {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idPersona;
	
	@Column(nullable = true, length = 150)
	@ApiModelProperty(notes ="maximo 150 caracteres" )
	@Size(min=3,max=150,message = "direccion válida entre 3 y 150 caracteres")
	private String direccion;
	
	@Column(nullable = false, length = 8)
	@ApiModelProperty(notes ="3 a 8 caracteres" )
	@NotNull(message="dni no puede estar vacio")
	@Size(min=3,message = "dni debe ser 3 a 8 caracteres",max=8)
	private String dni;
	
	@Column(nullable = true, length = 70)
	@ApiModelProperty(notes ="maximo 70 caracteres" )
	@Size(min=3,message = "nombre minimo 3 caracteres")
	private String nombres;
	
	@Column(nullable = false, length = 70)
	@Size(min=3,message = "apellidos minimo 3 caracteres")
	@NotNull(message="apellidos no puede estar vacio")
	private String apellidos;
	
	@Column(nullable = true, length = 9)
	@ApiModelProperty(notes ="5 a 9 caracteres" )
	@Size(min=5,message = "telefono debe ser 5 a 9 caracteres",max=9)
	private String telefono;
	
	@Column(nullable = true, length = 55)
	@Pattern(regexp="^\\w+([-+.']\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*$", message="Email no válido")
	private String email;
	
	
	
	
	public Integer getIdPersona() {
		return idPersona;
	}
	public void setIdPersona(Integer idPersona) {
		this.idPersona = idPersona;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public String getNombres() {
		return nombres;
	}
	public void setNombres(String nombres) {
		this.nombres = nombres;
	}
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	
}
