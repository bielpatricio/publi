package br.com.matrix.publi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class PubliApplication {

	public static void main(String[] args) {
		SpringApplication.run(PubliApplication.class, args);
	}

}
