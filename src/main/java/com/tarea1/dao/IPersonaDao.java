package com.tarea1.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tarea1.model.Persona;

//@Repository se hereda al poner jpa
public interface IPersonaDao extends JpaRepository<Persona, Integer> {

}
