package com.hiring.portal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import com.hiring.portal.model.Coordinator;
import com.hiring.portal.service.IAPIService;

@SpringBootApplication
@EnableJpaAuditing
public class AcmsHiringPortalApplication extends SpringBootServletInitializer implements CommandLineRunner{
	public static void main(String[] args) {

		SpringApplication.run(AcmsHiringPortalApplication.class, args);
	}
}
