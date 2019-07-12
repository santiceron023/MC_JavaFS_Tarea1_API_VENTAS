package com.tarea1;

import java.util.ArrayList;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

	public static final Contact contacto = new Contact("Santago Felipe Ceron Araujo", "https://github.com/santiceron023", "Santiceron023@gmail.com");
	public static final ApiInfo info = new ApiInfo("Aplicación para manejo de ventas", "BackEnd Rest", "version 1.1", 
			"termsOfServiceUrl",contacto, " uso educativo, APACHE 2.0"," http://www.apache.com", 
			new ArrayList<VendorExtension>());

	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2).apiInfo(info);
	}
}