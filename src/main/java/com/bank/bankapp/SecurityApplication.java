package com.bank.bankapp;

import com.bank.bankapp.role.Role;
import com.bank.bankapp.role.RoleRepo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.scheduling.annotation.EnableAsync;

@EnableJpaAuditing
@EnableAsync
@SpringBootApplication
public class SecurityApplication {

	public static void main(String[] args) {
		SpringApplication.run(SecurityApplication.class, args);
	}

	@Bean
	public CommandLineRunner runner(RoleRepo roleRepo) {
		return args -> {
			if(roleRepo.findByName("USER").isEmpty()){
				roleRepo.save(
						Role.builder().name("USER").build()
				);
			}
		};
	}

}

