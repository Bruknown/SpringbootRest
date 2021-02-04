package com.Bruno.h2.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.Bruno.h2.api.dao.VendedorRepo;
import com.Bruno.h2.api.model.Vendedor;

@RestController
public class VendedorController 
{
	@Autowired
	private VendedorRepo Vrepo;
	
	@PostMapping("/gerarVendedor")
	public String gerarVendedor(@RequestBody Vendedor vendedor)
	{
		try 
		{
			Vrepo.save(vendedor);
			return "Vendedor Registrado com sucesso";
//			if (Vrepo.existsById(vendedor.vendedorId))
//			{
//				return "Vendedor ja registrador";
//			}
//			else
//			{
//				
//			}
		} 
		catch (Exception e)
		{
			throw e;
		}
	}
}
