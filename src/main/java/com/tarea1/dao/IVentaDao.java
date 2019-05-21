package com.tarea1.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tarea1.model.Venta;


public interface IVentaDao extends JpaRepository<Venta, Integer>{

}
