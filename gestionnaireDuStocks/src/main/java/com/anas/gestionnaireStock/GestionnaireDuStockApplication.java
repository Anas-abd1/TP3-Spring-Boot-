package com.anas.gestionnaireStock;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.anas.gestionnaireStock.Services.GestionnaireStockServices;
import com.anas.gestionnaireStock.entities.GestionnaireStock;

@SpringBootApplication
public class GestionnaireDuStockApplication implements CommandLineRunner {
	
	@Autowired
	GestionnaireStockServices gestionnaireStockService;
	
	public static void main(String[] args) {
		SpringApplication.run(GestionnaireDuStockApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		gestionnaireStockService.saveProduit(new GestionnaireStock("Delice", new Date(),14,573.0,74) );
		gestionnaireStockService.saveProduit(new GestionnaireStock("Candia", new Date(),20,573.0,53) );
		gestionnaireStockService.saveProduit(new GestionnaireStock("equipmments informatiques", new Date(),30,773.0,84) );
		
	}



}
