package com.Bruno.h2.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.Bruno.h2.api.dao.VendaRepo;
import com.Bruno.h2.api.model.Venda;

@RestController
public class VendaController {
	
	@Autowired
	private VendaRepo repo;
	
	@PostMapping("/gerarVenda")
	public String gerarVenda(@RequestBody Venda venda)
	{
		try 
		{
			repo.save(venda);
			return "Venda Concluida";
		} 
		catch (Exception e)
		{
			throw e;
		}
	}
	
	@GetMapping("/getAll")
	public List<Venda> getAll()
	{
		try 
		{
			return repo.findAll();
		}
		catch (Exception e)
		{
			throw e;
		}
	}
	
	@GetMapping("/getVenda")
	public List<Venda> getVenda()
	{
		try 
		{
			List<Venda> vendas = repo.findAll();
			
			return repo.findAll();
		}
		catch (Exception e)
		{
			throw e;
		}
	}
}
