package com.kishore.AdminThymeleaf.Service;

import java.util.List;

import com.kishore.AdminThymeleaf.Entity.Hotels;

public interface AdminService {
	
	public List<Hotels> findAll();
	public void save(Hotels theHotles);
	public Hotels findById(int theId);
	public void deleteById(int theId);
}
