package net.tutorit.checkpoint5;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class Checkpoint5Application {
        @Autowired
        Populate pop;
        
	public static void main(String[] args) {
		SpringApplication.run(Checkpoint5Application.class, args);
	}

}
