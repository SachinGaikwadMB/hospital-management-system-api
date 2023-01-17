package com.mb.api.web.model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class AdminModel
{
	@NotBlank(message = "This field should not be empty.")
	private String firstName;
	
	@NotBlank(message = "This field should not be empty.")
	private String lastName;
		
	@Email(message = "Please enter correct email address.")
	private String email;
	
	@NotBlank(message = "This field should not be empty.")
	private String mobileNumber;
	
	@NotBlank(message = "This field should not be empty.")
	private String password;
	
}
