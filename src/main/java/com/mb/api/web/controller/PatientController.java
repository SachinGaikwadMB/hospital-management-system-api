package com.mb.api.web.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.mb.api.business.constant.GenericConstant.PATIENTS;

@RestController
@RequestMapping(PATIENTS)
public class PatientController extends BaseController
{

}
