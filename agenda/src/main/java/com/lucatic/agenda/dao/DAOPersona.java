package com.lucatic.agenda.dao;

import java.sql.ResultSet;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.lucatic.agenda.model.Persona;

//utilizamos repository para los DAOS
@Repository

public class DAOPersona implements IDAOPersona {

	//Inyeccion automatica de dependencias
	@Autowired
	//Esta clase contiene m�todos para leer, guardar o borrar entidades sobre la base de datos.
	private SessionFactory sessionFactory;

	public DAOPersona (){

	}

	public DAOPersona(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	//poner en las implementaciones de las interfaces
	@Transactional
	public Persona findById(int key) {
		Session session = null;
		session = sessionFactory.openSession();
		//Session session = sessionFactory.openSession();
		Persona p = (Persona) session
		.createCriteria(Persona.class)
		.add(Restrictions.eq("id", key)).uniqueResult();
		session.disconnect();
		return p;
		
/*		Persona p=null;
		String hq1 ="FROM Persona WHERE id="+key;
		Query query = sessionFactory.getCurrentSession().createQuery(hq1);

		p = (Persona)query.uniqueResult();*/
/*		///creamos un array y metemos los resultados de la query
		List<Object[]> list = query.list(); 

		for (Object[] row : list) {
			p= new Persona();
			p.setId((int) row[0]);
			p.setNombre((String) row[1]);
			p.setApellido1((String) row[2]);
			p.setApellido2((String) row[3]);
			p.setDni((String) row[4]);
			p.setFechaNacimiento((String) row[5]);
			p.setIdEmpleado((int) row[6]);

		}*/
		//si todo va bien es posible que esto nos devuelva el objeto con toda la info de la tabla
	}

	@Override
	@Transactional
	public List<Persona> findAll() {
		Session session = null;
		session = sessionFactory.openSession();
		//Session session = sessionFactory.getCurrentSession();
		@SuppressWarnings("unchecked")
		List<Persona> listp = (List<Persona>) session
		.createCriteria(Persona.class)
		.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
System.out.println("LISTANDO Personal:");
System.out.println(listp.toString());
		session.disconnect();
		return listp;

	}
	
	@Override
	@Transactional
	public void saveOrUpdate(Persona persona) {
		Session session = null;
		session = sessionFactory.openSession();
		//Session session = sessionFactory.getCurrentSession();
		//sessionFactory.getCurrentSession().saveOrUpdate(persona);
		session.saveOrUpdate(persona);
		session.flush();
		session.disconnect();
		//session.close();
	}
/*
	@Override
	public int insert(Persona ov) {
		// TODO Auto-generated method stub
		return 0;
	}
	*/

	@Override
	@Transactional
	public void delete(Persona persona) {
		Session session = null;
		session = sessionFactory.openSession();
		//Session session = sessionFactory.getCurrentSession();
		session.delete(persona);
		session.flush();
		session.disconnect();
		//session.close();
	}

/*	@Override
	public int insert(Persona ov) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(Persona ov) {
		// TODO Auto-generated method stub
		return 0;
	}
*/
	/*	@Override
	@Transactional
	public List<Personas> findAll() {


		@SuppressWarnings("unchecked")
		List<Persona> listp = (List<Persona>) sessionFactory.getCurrentSession()
		.createCriteria(Persona.class)
		.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();

		return listp;

	}

	@Override
	@Transactional
	public int delete(Persona ov) {
		//cruzar los dedos para que funcione
		sessionFactory.getCurrentSession().delete(ov.getIdpersonas());
		return 0;
	}


	@Override
	@Transactional
	public int insert(Persona ov) {

		String hq1 ="INSERT INTO usuario(nombre, apellido1, apellido2, dni, fechaNacimiento) VALUES ('"
				+ ov.getNombre() + "','" + ov.getApellido1() + "','" + ov.getApellido2() + "','" + ov.getDni() + "','"
				+ ov.getFecha() +"')";
		Query query = sessionFactory.getCurrentSession().createQuery(hq1);


		return query.getMaxResults();
	}

	@Override
	public int update(Persona ov) {
		sessionFactory.getCurrentSession().saveOrUpdate(ov);
		return 0;
	}
	 */
}
