package com.kishore.AdminThymeleaf.DAO;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kishore.AdminThymeleaf.Entity.Hotels;

import jakarta.persistence.EntityManager;

@Repository
public class AdminDAOImpl implements AdminDAO{

	private EntityManager entitymanager;

	// set up constructor injection
	@Autowired
	public AdminDAOImpl(EntityManager theEntityManager) {
		entitymanager = theEntityManager;
	}
	@Override
	public List<Hotels> findAll(){
		Session currentSession = entitymanager.unwrap(Session.class);

		// create a query
		Query<Hotels> query = currentSession.createQuery("from Hotels", Hotels.class);

		// execute the query and get result
		List<Hotels> hotels = query.getResultList();

		// return the results
		return hotels;
	}
	
	@Override
	public void save(Hotels theHotels) {
		Session currentSession=entitymanager.unwrap(Session.class);	
		currentSession.save(theHotels);
	}
	
	@Override
	public Hotels findById(int theId) {
		Session currentSession=entitymanager.unwrap(Session.class);	
		Hotels theHotels=currentSession.get(Hotels.class, theId);
		return theHotels;
	}
	
	@Override
	public void deleteById(int theId) {
		Session currentSession=entitymanager.unwrap(Session.class);	
		Query<Hotels> query=currentSession.createQuery("delete from Hotels where id=:HotelId");
		query.setParameter("HotelId", theId);
		query.executeUpdate();
	}
}
