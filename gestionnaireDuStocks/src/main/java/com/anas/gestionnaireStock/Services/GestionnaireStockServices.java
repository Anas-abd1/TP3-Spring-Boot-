package com.anas.gestionnaireStock.Services;

import java.util.List;

import org.springframework.data.domain.Page;

import com.anas.gestionnaireStock.entities.GestionnaireStock;

public interface GestionnaireStockServices 
{
	GestionnaireStock saveProduit(GestionnaireStock G);
	GestionnaireStock updateProduit(GestionnaireStock G);
	void deleteProduit(GestionnaireStock G);
	void deleteProduitById(Long id);
	GestionnaireStock getProduit(Long id);
	List<GestionnaireStock> getAllProduits();
	Page<GestionnaireStock> getAllProduitsParPage(int page, int size);
	
}