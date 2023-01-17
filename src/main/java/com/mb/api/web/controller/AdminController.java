package com.mb.api.web.controller;

import static com.mb.api.business.constant.GenericConstant.ADMINS;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.mb.api.business.service.AdminService;
import com.mb.api.persistance.entity.Admin;
import com.mb.api.web.model.AdminModel;

@RestController
@RequestMapping(ADMINS)
public class AdminController extends BaseController
{
	@Autowired
	private AdminService adminService;
	
	/**
	 * New Admin can register from this api.
	 * 
	 * **/
	@PostMapping
	public ResponseEntity<String> test(@RequestBody AdminModel adminModel)
	{
		return new ResponseEntity<>(adminService.registerAdmin(adminModel), HttpStatus.CREATED)	;
	}
	
	/**
	 * Loggeed in admin can 
	 * view all other admins details who have aceess to the platforms.
	 * 
	 * **/
	public ResponseEntity<List<Admin>> getAllAdmins() {
		return new ResponseEntity<>(adminService.getAllAdmins(), HttpStatus.OK);
	}
	
}
