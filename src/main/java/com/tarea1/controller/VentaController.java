package com.tarea1.controller;

import java.net.URI;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.tarea1.model.Venta;
import com.tarea1.service.IVentaService;

@RestController
@RequestMapping("/ventas")
public class VentaController {

	@Autowired
	IVentaService servicio;

	@GetMapping
	public ResponseEntity<List<Venta>> listar(){		
		return new ResponseEntity< List<Venta> > (servicio.consultar(),HttpStatus.OK);
	}


	@PostMapping
	public ResponseEntity<Venta> registrar(@RequestBody Venta prod) {

		Venta prodSaved = servicio.registrar(prod);
		//original + id 
		URI uriLocation = ServletUriComponentsBuilder.fromCurrentRequest().
				path("/{id}").buildAndExpand(prodSaved.getIdVenta()).toUri();

		return ResponseEntity.created(uriLocation).build();
	}

}
