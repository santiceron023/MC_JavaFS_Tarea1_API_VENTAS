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

import com.tarea1.model.Persona;
import com.tarea1.service.IPersonaService;

@RestController
@RequestMapping("/personas")
public class PersonaController {
	
	@Autowired
	IPersonaService servicio;

	@GetMapping
	public ResponseEntity<List<Persona>> listar(){		
		return new ResponseEntity< List<Persona> > (servicio.consultar(),HttpStatus.OK);
	}
	
	@GetMapping(value = "/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> listarPorId(@PathVariable("id") Integer id){

		Persona per = servicio.consultarPorId(id);

		if (per == null) {
			return new ResponseEntity<String>("no encontrado",HttpStatus.NOT_FOUND);
		}
		else {
			return new ResponseEntity<Persona>(per,HttpStatus.OK);
		}
	}

	@PostMapping
	public ResponseEntity<Persona> registrar(@RequestBody Persona per) {

		Persona perSaved = servicio.registrar(per);
		//original + id 
		URI uriLocation = ServletUriComponentsBuilder.fromCurrentRequest().
				path("/{id}").buildAndExpand(perSaved.getIdPersona()).toUri();

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
	public Persona modificar(@RequestBody Persona pac) {
		return servicio.modificar(pac);
	}
	

}
