package br.com.alurafood.pagamentos.configuration;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigurationBeans {

	@Bean
	public ModelMapper getModelMapper() {
		return new ModelMapper();
	}
}
