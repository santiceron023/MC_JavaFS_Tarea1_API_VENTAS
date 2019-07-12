package com.tarea1.controller;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

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

	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> listar(){		
		try {
			return new ResponseEntity< List<Persona> > (servicio.consultar(),HttpStatus.OK);
		}catch (Exception e) {
			return new ResponseEntity< String > (
					"Error interno"+ e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping(value = "/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> listarPorId(@PathVariable("id") Integer id){

		Persona persona = servicio.consultarPorId(id);

		try {
			if (persona == null) {
				return new ResponseEntity<String>("No encontrado",HttpStatus.NOT_FOUND);
			}
			else {
				return new ResponseEntity<Persona>(persona,HttpStatus.OK);
			}

		} catch (Exception e) {
			return new ResponseEntity< String > (
					"Error interno"+ e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> registrar(@RequestBody @Valid Persona per) {

		try {
			Persona perSaved = servicio.registrar(per);
			//original + id 
			URI uriLocation = ServletUriComponentsBuilder.fromCurrentRequest().
					path("/{id}").buildAndExpand(perSaved.getIdPersona()).toUri();

			return ResponseEntity.created(uriLocation).build();

		} catch (Exception e) {
			return new ResponseEntity< String > (
					"Error interno"+ e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}


	@DeleteMapping(value = "/{id}")
	public ResponseEntity<?> eliminarPorId(@PathVariable("id") Integer id){
		try {

			if(servicio.consultarPorId(id) != null) {
				servicio.eliminar(id);
				return new ResponseEntity<String>("Eliminado correctamente",HttpStatus.OK);
			}else {
				return new ResponseEntity<String>("Id no encontrado",HttpStatus.NOT_FOUND);
			}
		} catch (Exception e) {
			return new ResponseEntity< String > (
					"Error interno"+ e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> modificar(@RequestBody @Valid Persona per) {
		try {
			Persona perSaved = servicio.modificar(per);
			return new ResponseEntity<String>("Actualizado correctamente",HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity< String > (
					"Error interno"+ e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}


	}
