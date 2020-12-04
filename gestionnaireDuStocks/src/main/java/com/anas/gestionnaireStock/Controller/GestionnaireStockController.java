package com.anas.gestionnaireStock.Controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.anas.gestionnaireStock.Services.GestionnaireStockServices;
import com.anas.gestionnaireStock.entities.GestionnaireStock;

@Controller
public class GestionnaireStockController {
	
	@Autowired
	GestionnaireStockServices GestionnaireStockService;
	
	@RequestMapping("/showCreate")
	public String showCreate()
	{
	return "createProduit";
	}
	
	@RequestMapping("/saveProduit")
	public String saveProduit(@ModelAttribute("produit") GestionnaireStock produit,@RequestParam("date") String date,ModelMap modelMap) throws ParseException
	{
		
		SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
		Date dateRecu = dateformat.parse(String.valueOf(date)); 
		produit.setDaterecu(dateRecu);
	
		GestionnaireStock saveProduit = GestionnaireStockService.saveProduit(produit);
		String msg ="produit enregistré avec Id "+saveProduit.getId();
		modelMap.addAttribute("msg", msg);
		return "createProduit";
	}
	
	@RequestMapping("/ListeProduits")
	public String listeProduits(ModelMap modelMap ,
			@RequestParam (name="page",defaultValue = "0") int page,
			@RequestParam (name="size", defaultValue = "3") int size)
	{
		//Affichages des produits
		Page<GestionnaireStock> prods = GestionnaireStockService.getAllProduitsParPage(page, size);
		modelMap.addAttribute("produits", prods);
		modelMap.addAttribute("pages", new int[prods.getTotalPages()]);
		modelMap.addAttribute("currentPage", page);
		modelMap.addAttribute("size", size);
		return "listeProduits";
	}
	
	@RequestMapping("/supprimerProduit")
	public String supprimerProduit(	@RequestParam("id") Long id,
								    ModelMap modelMap,
									@RequestParam (name="page",defaultValue = "0") int page,
									@RequestParam (name="size", defaultValue = "2") int size
								   )
			
	{
		//Supression des produits 
		GestionnaireStockService.deleteProduitById(id);
		Page<GestionnaireStock> prods = GestionnaireStockService.getAllProduitsParPage(page, size);
		modelMap.addAttribute("produits", prods);
		modelMap.addAttribute("pages", new int[prods.getTotalPages()]);
		modelMap.addAttribute("currentPage", page);
		modelMap.addAttribute("size", size);
		return "listeProduits";
	}
	
	@RequestMapping("/modifierProduit")
	public String editerProduit(@RequestParam("id") Long id,ModelMap modelMap)
	{
		//modification des produits 
		GestionnaireStock p= GestionnaireStockService.getProduit(id);
		modelMap.addAttribute("produit", p);
		return "editerProduit";
	}
	
	@RequestMapping("/updateProduit")
	public String updateProduit(@ModelAttribute("produit") GestionnaireStock produit, @RequestParam("date") String date,ModelMap modelMap) throws ParseException
		{
			//conversion de la date 
			SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
			Date  dateRecu = dateformat.parse(String.valueOf(date));
			produit.setDaterecu( dateRecu);
			GestionnaireStockService.updateProduit(produit);
			List<GestionnaireStock> prods = GestionnaireStockService.getAllProduits();
			modelMap.addAttribute("produits", prods);
			return "listeProduits";
		}
	
	}
	
