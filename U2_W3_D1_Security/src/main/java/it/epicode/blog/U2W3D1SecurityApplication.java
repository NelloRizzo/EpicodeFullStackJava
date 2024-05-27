package it.epicode.blog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@SpringBootApplication
@EnableWebSecurity
public class U2W3D1SecurityApplication {

	public static void main(String[] args) {
		SpringApplication.run(U2W3D1SecurityApplication.class, args);
	}

}
