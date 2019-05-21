package com.tarea1.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.tarea1.dao.IProductoDao;
import com.tarea1.model.Producto;
import com.tarea1.service.IProdutoService;

@Service
public class IProductoServiceImpl implements IProdutoService {
	
	@Autowired
	IProductoDao dao;

	@Override
	public Producto registrar(Producto t) {
		return dao.save(t);
	}

	@Override
	public Producto modificar(Producto t) {
		return dao.save(t);
	}

	@Override
	public boolean eliminar(Integer id) {
		if(dao.findOne(id) != null) {
			dao.delete(id);
			return true;
		}else {
			return false;
		}
	}

	@Override
	public List<Producto> consultar() {
		return dao.findAll();
	}

	@Override
	public Producto consultarPorId(Integer id) {
		return dao.findOne(id);
	}


}
