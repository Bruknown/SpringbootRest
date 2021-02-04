package com.Bruno.h2.api.controller;

import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.Bruno.h2.api.dao.VendaRepo;
import com.Bruno.h2.api.dao.VendedorRepo;
import com.Bruno.h2.api.model.Venda;
import org.jinq.*;

@RestController
public class VendaController {
	
	@Autowired
	private VendaRepo repo;
	
	@Autowired
	private VendedorRepo Vrepo;
	
	@PostMapping("/gerarVenda")
	public String gerarVenda(@RequestBody Venda venda)
	{
		try 
		{
			if (Vrepo.existsById(venda.vendedorId))
			{
				java.sql.Date date = new java.sql.Date(Calendar.getInstance().getTime().getTime());		
				venda.data = date;
				repo.save(venda);
				return "Venda Concluida";
			}
			else
			{
				return "Vendedor não existe";
			}
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
//			stream().where(c -> c)
			return repo.findAll();
		}
		catch (Exception e)
		{
			throw e;
		}
	}
}
