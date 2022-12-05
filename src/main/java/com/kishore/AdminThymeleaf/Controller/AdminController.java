package com.kishore.AdminThymeleaf.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.kishore.AdminThymeleaf.Entity.Hotels;
import com.kishore.AdminThymeleaf.Service.AdminService;


@RestController
public class AdminController {
	private AdminService adminService;
	
	@Autowired
	public AdminController(AdminService theAdminService) {
		adminService = theAdminService;
	}
	@GetMapping("/")
	public ModelAndView HomePage() {
		ModelAndView view=new ModelAndView("HomePage");
		return view;
	}
	
	
	@GetMapping("/list")
	public ModelAndView ShowHotels() {
		ModelAndView view=new ModelAndView("HotelsList");
		List<Hotels> list=adminService.findAll();
		view.addObject("hotels",list);
		return view;
	}
	
	@GetMapping("/addHotel")
	public ModelAndView AddHotel() {
		ModelAndView view = new ModelAndView("AddHotelPage");
		Hotels hotels = new Hotels();
		view.addObject("hotels",hotels);
		return view;
	}
	
	@PostMapping("/saveHotel")
	public ModelAndView Save(@ModelAttribute Hotels hotels) {
		ModelAndView view = new ModelAndView("Success");
		adminService.save(hotels);
		return view;
	}
	
	@GetMapping("/showUpdateForm")
	public ModelAndView Update(@RequestParam int hotelId) {
		ModelAndView view = new ModelAndView("AddHotelPage");
		Hotels hotels=adminService.findById(hotelId);
		view.addObject("hotels",hotels);
		return view;
	}
	
	@GetMapping("/deleteEmployee")
	public ModelAndView Delete(@RequestParam int hotelId) {
		ModelAndView view =new ModelAndView("DeleteInfo");		
		adminService.deleteById(hotelId);
		return view;
	}	

	
}
