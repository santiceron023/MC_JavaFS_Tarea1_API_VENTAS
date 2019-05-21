package com.tarea1.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.tarea1.model.Producto;

public interface IProductoDao extends JpaRepository<Producto, Integer> {

}
