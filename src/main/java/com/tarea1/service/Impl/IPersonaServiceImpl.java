package com.tarea1.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.tarea1.dao.IPersonaDao;
import com.tarea1.model.Persona;
import com.tarea1.service.IPersonaService;

@Service
public class IPersonaServiceImpl implements IPersonaService {
	
	@Autowired
	IPersonaDao dao;

	@Override
	public Persona registrar(Persona t) {
		return dao.save(t);
	}

	@Override
	public Persona modificar(Persona t) {
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
	public List<Persona> consultar() {
		return dao.findAll();
	}

	@Override
	public Persona consultarPorId(Integer id) {
		return dao.findOne(id);
	}


}
