package com.tarea1.service;

import java.util.List;

//OPERACIONES COMUNES
public interface ICRUD <T> {
	T registrar(T t);
	T modificar(T t);
	boolean eliminar(Integer id);
	List<T> consultar();
	T consultarPorId(Integer id);
}


