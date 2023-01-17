package com.mb.api.persistance.entity;

import java.util.Date;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "patients")

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Patient
{
	//TODO :: BASE ENTITY LEFT AND JPA AUDITING IS LEFT
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "first_name")
	private String firstName;
	
	@Column(name = "last_name")
	private String lastName;
	
	@Column(name = "email", unique = true)
	private String email;
	
	@Column(name = "register_date")
	private Date registerDate;
	
	@Column(name = "mobile_number")
	private String mobileNumber;
    
	@Column(name = "adress")
	private String address;
	
}
