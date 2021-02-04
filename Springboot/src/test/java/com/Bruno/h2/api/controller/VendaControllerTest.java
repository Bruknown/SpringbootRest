package com.Bruno.h2.api.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.context.junit4.SpringRunner;

import com.Bruno.h2.api.model.Venda;
import com.Bruno.h2.api.model.Vendedor;
import com.fasterxml.jackson.databind.ObjectMapper;


import static io.restassured.module.mockmvc.RestAssuredMockMvc.*;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class VendaControllerTest {
	
	@Autowired
	private MockMvc mvc;
	
	
	@Before
	public void setup() {
		standaloneSetup(new Venda(1, "Bruno", 100), new VendedorController());
		
	}
	
	@Test
	public void test() {
		try 
		{
			MvcResult result1 = mvc.perform(MockMvcRequestBuilders
					.post("/gerarVendedor")
					.content(asJsonString(new Vendedor(1, "Bruno")))
					.contentType(MediaType.APPLICATION_JSON)
					.accept(MediaType.APPLICATION_JSON))
			.andReturn();
			
			String content1 = result1.getResponse().getContentAsString();
			
			System.out.println(content1);
			
			MvcResult result2 = mvc.perform(MockMvcRequestBuilders
					.post("/gerarVenda")
					.content(asJsonString(new Venda(1, "Bruno", 100)))
					.contentType(MediaType.APPLICATION_JSON)
					.accept(MediaType.APPLICATION_JSON))
			.andReturn();
			
			String content2 = result2.getResponse().getContentAsString();
			
			System.out.println(content2);
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
	public static String asJsonString(final Object obj) {
	    try {
	        return new ObjectMapper().writeValueAsString(obj);
	    } catch (Exception e) {
	        throw new RuntimeException(e);
	    }
	}
}
