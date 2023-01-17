package com.mb.api.business.service;

import java.util.List;
import com.mb.api.business.exception.CustomException;
import com.mb.api.persistance.entity.Admin;
import com.mb.api.web.model.AdminModel;

public interface AdminService
{
	String registerAdmin(AdminModel adminModel) throws CustomException;
	
	List<Admin> getAllAdmins();
}
