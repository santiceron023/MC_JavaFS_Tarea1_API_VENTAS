package com.tarea1.model;

import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="detalle_venta")
public class DetalleVenta {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idDetalleVenta;
	
	//muchos detalles en una misma venta
	@ManyToOne
	@JoinColumn(foreignKey = @ForeignKey(name="detalle_consulta"))
	@JsonIgnore
	private Venta idVenta;
	
	@ManyToOne
	@JoinColumn(foreignKey = @ForeignKey(name="DetalleVenta_producto"))
	private Producto idProducto;
		
	private Integer cantidad;

	
	
	public Producto getIdProducto() {
		return idProducto;
	}

	public void setIdProducto(Producto idProducto) {
		this.idProducto = idProducto;
	}

	public Integer getIdDetalleVenta() {
		return idDetalleVenta;
	}

	public void setIdDetalleVenta(Integer idDetalleVenta) {
		this.idDetalleVenta = idDetalleVenta;
	}

	public Venta getIdVenta() {
		return idVenta;
	}

	public void setIdVenta(Venta idVenta) {
		this.idVenta = idVenta;
	}

	public Integer getCantidad() {
		return cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}
	
	

	
}
