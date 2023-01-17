package com.mb.api.business.service;

import java.util.List;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.mb.api.business.constant.StatusCode;
import com.mb.api.business.exception.CustomException;
import com.mb.api.persistance.entity.Admin;
import com.mb.api.persistance.repository.AdminRepository;
import com.mb.api.web.model.AdminModel;

@Service
public class AdminServiceImpl implements AdminService
{
	@Autowired
	private AdminRepository adminRepository;
	
	@Autowired
	private ModelMapper modelMapper;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(AdminServiceImpl.class);
	
	@Override
	public String registerAdmin(AdminModel adminModel)
	{
		LOGGER.info("*--------------------- Admin Register Service -------------------------------*");

		if(adminRepository.existsByEmail(adminModel.getEmail()))
			throw new CustomException(StatusCode.ADMIN_ALREADY_EXIST, "Admin Already Exist!");
		
		try
		{
			//TODO:: encrypt password still left
			adminRepository.save(modelMapper.map(adminModel, Admin.class));
		}
		catch (Exception e)
		{
			throw new CustomException(StatusCode.INTERNAL_SERVER_ERROR, "Something wents wrong !");
		}
		return "Admin registered successfully!";
	}

	@Override
	public List<Admin> getAllAdmins()
	{
		try
		{
			return adminRepository.findAll();
		}
		catch (Exception ex)
		{
			throw new CustomException(StatusCode.INTERNAL_SERVER_ERROR, "Something wents wrong!");
		}
	
	}

}
