package com.tarea1.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tarea1.dao.IVentaDao;
import com.tarea1.model.Venta;
import com.tarea1.service.IVentaService;

@Service
public class IVentaServiceImpl implements IVentaService{
	
	@Autowired
	IVentaDao dao;

	@Override
	public Venta registrar(Venta t) {
		t.getListDetalles().forEach(det -> det.setIdVenta(t));
		return dao.save(t);
	}

	@Override
	public List<Venta> consultar() {
		return dao.findAll();
	}
	
	
	@Override
	public Venta modificar(Venta t) {
		return null;
	}

	@Override
	public boolean eliminar(Integer id) {
		return false;
	}


	@Override
	public Venta consultarPorId(Integer id) {
		return null;
	}

}
