package com.hiring.portal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class AcmsHiringPortalApplication extends SpringBootServletInitializer{
	public static void main(String[] args) {
//		new File(APIController.uploadDirectory).mkdir();
		SpringApplication.run(AcmsHiringPortalApplication.class, args);
	}
}

