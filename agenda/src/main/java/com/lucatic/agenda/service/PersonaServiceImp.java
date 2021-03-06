package com.lucatic.agenda.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lucatic.agenda.dao.DAOPersona;
import com.lucatic.agenda.dao.IDAOPersona;
import com.lucatic.agenda.model.Persona;

@Service
@Transactional
public class PersonaServiceImp implements IPersonaService {

	@Autowired
	private IDAOPersona daoPersona;
	
	@Override
	public List<Persona> list() {
		// TODO Auto-generated method stub
		return daoPersona.findAll();
	}

	@Override
	public Persona get(int i) {
		// TODO Auto-generated method stub
		return daoPersona.findById(i);
	}
	
	@Override
	public void saveOrUpdate(Persona persona) {
		daoPersona.saveOrUpdate(persona);
		
	}
	
	@Override
	public void delete(Persona persona) {
		daoPersona.delete(persona);
		
	}

	
}
	
