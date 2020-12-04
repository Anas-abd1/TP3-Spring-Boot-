package com.anas.gestionnaireStock;

import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.anas.gestionnaireStock.repos.GestionnaireStockRepository;
import org.springframework.data.domain.Page;
import com.anas.gestionnaireStock.Services.GestionnaireStockServices;
import com.anas.gestionnaireStock.entities.*;

@SpringBootTest
class GestionnaireDuStockApplicationTests {
	
	@Autowired
	private GestionnaireStockRepository gestionnaireStockRepository;
	private GestionnaireStockServices 	gestionnaireStockServices;
	
	@Test
	public void testCreateProduit() {
	GestionnaireStock Commande = new GestionnaireStock("voitures",new Date(),15,15.21,7);
	gestionnaireStockRepository.save(Commande);
	}
	
	@Test
	public void testFindProduits()
	{ GestionnaireStock Commande = gestionnaireStockRepository.findById(1L).get(); 
	System.out.println(Commande);
	}
	
	@Test
	public void testUpdateProduits()
	{
		GestionnaireStock Commande = gestionnaireStockRepository.findById(1L).get();
		Commande.setTaxe(1000.5); 
		gestionnaireStockRepository.save(Commande);
	}
	
	@Test
	public void testDeleteProduit() 
	{
		{
			gestionnaireStockRepository.deleteById(1L);
		}
	}
	
	@Test
	public void testListerTousProduits()
	{
		List<GestionnaireStock> prods = gestionnaireStockRepository.findAll();
		for (GestionnaireStock p : prods)
			{
				System.out.println(p);
			}
	}
	
	@Test
	public void testFindByNomProduitContains()
	{
		Page<GestionnaireStock> prods = gestionnaireStockServices.getAllProduitsParPage(0,2);
		System.out.println(prods.getSize());
		System.out.println(prods.getTotalElements()); 
		System.out.println(prods.getTotalPages());
		prods.getContent().forEach(p -> {System.out.println(p.toString());
	});
	
		 
	/*Page<GestionnaireStock> prods=gestionnaireStockServices.getAllProduitsParPage(0,2);*/
	/*for (GestionnaireStock p : prods)
	{
	System.out.println(p);
	} 
	
	}*/
	}
	
}


