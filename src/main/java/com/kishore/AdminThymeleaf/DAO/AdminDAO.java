package com.kishore.AdminThymeleaf.DAO;

import java.util.List;

import com.kishore.AdminThymeleaf.Entity.Hotels;

public interface AdminDAO {

	public List<Hotels> findAll();
	public void save(Hotels theHotels);
	public Hotels findById (int theId);
	public void deleteById(int theId);
}

