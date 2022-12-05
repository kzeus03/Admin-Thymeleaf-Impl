package com.kishore.AdminThymeleaf.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kishore.AdminThymeleaf.DAO.AdminDAO;
import com.kishore.AdminThymeleaf.Entity.Hotels;

import jakarta.transaction.Transactional;

@Service
public class AdminServiceImpl implements AdminService {

	
private AdminDAO AdminDAO;
	
	@Autowired
	public AdminServiceImpl(AdminDAO theAdminDAO) {
		AdminDAO=theAdminDAO;
	}
	
	@Override
	@Transactional
	public List<Hotels> findAll() {
		return AdminDAO.findAll();
	}
	
	@Override
	@Transactional
	public void save(Hotels theHotles) {
		AdminDAO.save(theHotles);
	}
	
	@Override
	@Transactional
	public Hotels findById(int theId) {
		return AdminDAO.findById(theId);
	}
	
	@Override
	@Transactional
	public void deleteById(int theId) {
		AdminDAO.deleteById(theId);

	}

}
