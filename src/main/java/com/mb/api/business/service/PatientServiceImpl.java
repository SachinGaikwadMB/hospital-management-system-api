package com.mb.api.business.service;

import org.springframework.stereotype.Repository;
import com.mb.api.business.exception.CustomException;
import com.mb.api.web.model.PatientModel;

@Repository
public class PatientServiceImpl implements PatientService
{

	@Override
	public String registerPatient(PatientModel patientModel) throws CustomException
	{
		
		return null;
	}

}
