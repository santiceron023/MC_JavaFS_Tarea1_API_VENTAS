package com.tarea1.exception;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

//estructura de mensage de error a enviar por rest
public class ExceptionResponse {
	
	private String timeStamp;
	private String mensaje;
	private String descripcion;
	DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	
	
	
	public ExceptionResponse(Date timeStamp, String mensaje, String detalle) {
		super();
		this.timeStamp = dateFormat.format(timeStamp);
		this.mensaje = mensaje;
		this.descripcion = detalle;
	}
	
	
	public String getTimeStamp() {
		return timeStamp;
	}
	public void setTimeStamp(Date timeStamp) {
		this.timeStamp = dateFormat.format(timeStamp);
	}
	public String getMensaje() {
		return mensaje;
	}
	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String detalle) {
		this.descripcion = detalle;
	}
	
	

}
