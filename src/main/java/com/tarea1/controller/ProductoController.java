package com.tarea1.controller;

import java.net.URI;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.tarea1.model.Producto;
import com.tarea1.service.IProdutoService;

@RestController
@RequestMapping("/productos")
public class ProductoController {

	@Autowired
	IProdutoService servicio;

	@GetMapping
	public ResponseEntity<List<Producto>> listar(){		
		return new ResponseEntity< List<Producto> > (servicio.consultar(),HttpStatus.OK);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<?> listarPorId(@PathVariable("id") Integer id){

		Producto prod = servicio.consultarPorId(id);

		if (prod == null) {
			return new ResponseEntity<String>("no encontrado",HttpStatus.NOT_FOUND);
		}
		else {
			return new ResponseEntity<Producto>(prod,HttpStatus.OK);
		}
	}

	@PostMapping
	public ResponseEntity<Producto> registrar(@RequestBody Producto prod) {

		Producto prodSaved = servicio.registrar(prod);
		//original + id 
		URI uriLocation = ServletUriComponentsBuilder.fromCurrentRequest().
				path("/{id}").buildAndExpand(prodSaved.getIdProducto()).toUri();

		return ResponseEntity.created(uriLocation).build();
	}


	@DeleteMapping(value = "/{id}")
	public ResponseEntity<?> eliminarPorId(@PathVariable("id") Integer id){

		if(servicio.consultarPorId(id) != null) {
			servicio.eliminar(id);
			return new ResponseEntity<String>("Eliminado",HttpStatus.OK);
		}else {
			return new ResponseEntity<String>("no encontrado",HttpStatus.NOT_FOUND);
		}
	}

	@PutMapping
	public ResponseEntity<Producto> modificar(@RequestBody Producto pac) {
		return new ResponseEntity<> ( servicio.modificar(pac), HttpStatus.OK);
	}


}
