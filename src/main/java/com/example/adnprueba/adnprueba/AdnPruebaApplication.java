package com.example.adnprueba.adnprueba;

import com.example.adnprueba.adnprueba.service.AdnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class AdnPruebaApplication {

	@Autowired
	private AdnService adnService;

	public static void main(String[] args) {
		SpringApplication.run(AdnPruebaApplication.class, args);
	}



}
