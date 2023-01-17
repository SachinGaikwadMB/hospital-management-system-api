package com.mb.api.business.service;

import com.mb.api.business.exception.CustomException;
import com.mb.api.web.model.PatientModel;

public interface PatientService
{
	String registerPatient(PatientModel patientModel)throws CustomException;
}
