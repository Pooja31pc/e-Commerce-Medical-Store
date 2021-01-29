package com.meddeli.onlinemedicalstore;

import org.hibernate.sql.Delete;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class OnlinemedicalstoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(OnlinemedicalstoreApplication.class, args);
	}

	//for auth configuration
	@Bean
	public BCryptPasswordEncoder bCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}

	//for auth configuration
	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				//registry.addMapping("/**").allowedOrigins("http://localhost:4200").allowedMethods("GET","POST","PUT", "DELETE");
				registry.addMapping("/**").allowedOrigins(accessUrl).allowedMethods("GET","POST","PUT", "DELETE");

			}
		};
	}

	@Value("${url}")
	private String accessUrl;

}
