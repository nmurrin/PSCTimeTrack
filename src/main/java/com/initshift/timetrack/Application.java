package com.initshift.timetrack;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.thymeleaf.extras.java8time.dialect.Java8TimeDialect;

import com.initshift.timetrack.domain.TimeEntry;
import com.initshift.timetrack.repository.TimeEntryRepository;

import java.time.LocalDateTime;

@SpringBootApplication
public class Application {

	private static final Logger log = LoggerFactory.getLogger(Application.class);

	public static void main(String[] args) {
		SpringApplication.run(Application.class);
	}

    @Bean
    public Java8TimeDialect java8TimeDialect() {
        return new Java8TimeDialect();
    }
    
	@Bean
	public CommandLineRunner demo(TimeEntryRepository repository) {
		return (args) -> {
			/*
			// save a couple of customers
			repository.save(new TimeEntry("Administrative", "Time Entry", LocalDateTime.now(), LocalDateTime.now()));
			repository.save(new TimeEntry("Administrative", "Read through emails", LocalDateTime.now(), LocalDateTime.now()));
			repository.save(new TimeEntry("Website", "Implement responsive", LocalDateTime.now(), LocalDateTime.now()));

			// fetch all customers
			log.info("Time entries found with findAll():");
			log.info("-------------------------------");
			for (TimeEntry timeEntry : repository.findAll()) {
				log.info(timeEntry.toString());
			}
			log.info("");

			// fetch an individual customer by ID
			TimeEntry timeEntry = repository.findOne(1L);
			log.info("TimeEntry found with findOne(1L):");
			log.info("--------------------------------");
			log.info(timeEntry.toString());
			log.info("");

			// fetch customers by last name
			log.info("TimeEntry found with findByTask('Administrative'):");
			log.info("--------------------------------------------");
			for (TimeEntry administrative : repository.findByTask("Administrative")) {
				log.info(administrative.toString());
			}
			log.info("");
			*/
		};
	}

}
