package com.tarea1.model;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;

@Table(name="venta")
@Entity
public class Venta {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idVenta;

	@JsonSerialize(using = ToStringSerializer.class)
	private LocalDateTime fecha;

	@ManyToOne
	@JoinColumn(foreignKey = @ForeignKey(name="venta_persona"))
	private	Persona idPersona;
	
	public Persona getIdPersona() {
		return idPersona;
	}

	public void setIdPersona(Persona idPersona) {
		this.idPersona = idPersona;
	}

	private Double importe;
	
	
	@OneToMany(mappedBy = "idVenta",cascade = CascadeType.ALL, 
			fetch = FetchType.LAZY,orphanRemoval=true)
	private List<DetalleVenta> listDetalles;
	

	public List<DetalleVenta> getListDetalles() {
		return listDetalles;
	}

	public void setListDetalles(List<DetalleVenta> listDetalles) {
		this.listDetalles = listDetalles;
	}

	public Integer getIdVenta() {
		return idVenta;
	}

	public void setIdVenta(Integer idVenta) {
		this.idVenta = idVenta;
	}

	public LocalDateTime getFecha() {
		return fecha;
	}

	public void setFecha(LocalDateTime fecha) {
		this.fecha = fecha;
	}

	public Double getImporte() {
		return importe;
	}

	public void setImporte(Double importe) {
		this.importe = importe;
	}



}
