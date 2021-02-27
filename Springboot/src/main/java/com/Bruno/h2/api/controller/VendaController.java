package com.Bruno.h2.api.controller;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

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

	@PersistenceContext
	EntityManager em;
	
	@PostMapping("/gerarVenda")
	public String gerarVenda(@RequestBody Venda venda) {
		try {
			java.sql.Date date = new java.sql.Date(Calendar.getInstance().getTime().getTime());
			venda.setData(date);
			repo.save(venda);
			return "Venda Concluida";
		} catch (Exception e) {
			throw e;
		}
	}

	@GetMapping("/getAll")
	public List<Venda> getAll() {
		try {
			return repo.findAll();
		} catch (Exception e) {
			throw e;
		}
	}

	@GetMapping("/getVenda")
	public List<Venda> getVenda(@RequestBody Date inicio, Date fim) {
		try {
			Query query = em.createQuery("select p from Venda p where p.data BETWEEN " + inicio.toString() + " AND " + fim.toString());
			List result = query.getResultList();
			
			return repo.findAll();
		} catch (Exception e) {
			throw e;
		}
	}
}
