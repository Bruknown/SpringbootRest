package com.Bruno.h2.api.controller;

import static org.junit.Assert.*;

import java.util.Calendar;

import org.junit.Test;

import com.Bruno.h2.api.model.Venda;
import com.Bruno.h2.api.model.Vendedor;

public class VendaControllerTest {

	@Test
	public void test() {
		VendedorController vec = new VendedorController();
		Vendedor vendedor = new Vendedor();
		
		vendedor.vendedorId = 5;
		vendedor.vendedorNome = "Bruno";
		
		String out1 = vec.gerarVendedor(vendedor);
		
		assertEquals("Vendedor Registrado com sucesso", out1);
//
//		Venda venda = new Venda();
//		VendaController vc = new VendaController();
//		venda.data = new java.sql.Date(Calendar.getInstance().getTime().getTime());
//		venda.valor = 100;
//		venda.vendedorId = 5;
//		venda.vendedorNome = "Bruno";
//		
//		
//		String out2 = vc.gerarVenda(venda);
//		
//		assertEquals("Venda Concluida", out2);
	}

}
