package com.mb.api.web.configurations;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMapperBean
{
	@Bean
	public ModelMapper modelmapper() {
		return new ModelMapper();
	}
}
