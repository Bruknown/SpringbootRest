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
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;


import static io.restassured.module.mockmvc.RestAssuredMockMvc.*;

import java.util.Calendar;
import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class VendaControllerTest {

	@Autowired
	private MockMvc mvc;

	@Before
	public void setup() {
		standaloneSetup(new Venda(1, "Bruno", 100), new VendaController());

	}
	
	@PersistenceContext
	EntityManager em;

	@Test
	public void test() {
		try {
			MvcResult result2 = mvc
					.perform(
							MockMvcRequestBuilders.post("/gerarVenda").content(asJsonString(new Venda(1, "Bruno", 100)))
									.contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON))
					.andReturn();
			MvcResult result3 = mvc
					.perform(
							MockMvcRequestBuilders.post("/gerarVenda").content(asJsonString(new Venda(1, "Bruno", 100)))
									.contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON))
					.andReturn();
			MvcResult result4 = mvc
					.perform(
							MockMvcRequestBuilders.post("/gerarVenda").content(asJsonString(new Venda(2, "Gean", 100)))
									.contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON))
					.andReturn();
			MvcResult result5 = mvc
					.perform(
							MockMvcRequestBuilders.post("/gerarVenda").content(asJsonString(new Venda(2, "Gean", 100)))
									.contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON))
					.andReturn();
			MvcResult result6 = mvc
					.perform(
							MockMvcRequestBuilders.post("/gerarVenda").content(asJsonString(new Venda(3, "Giuseppe", 100)))
									.contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON))
					.andReturn();
			MvcResult result7 = mvc
					.perform(
							MockMvcRequestBuilders.post("/gerarVenda").content(asJsonString(new Venda(3, "Giuseppe", 100)))
									.contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON))
					.andReturn();
			MvcResult result8 = mvc
					.perform(
							MockMvcRequestBuilders.post("/gerarVenda").content(asJsonString(new Venda(3, "Giuseppe", 100)))
									.contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON))
					.andReturn();
			MvcResult result9 = mvc
					.perform(
							MockMvcRequestBuilders.post("/gerarVenda").content(asJsonString(new Venda(1, "Bruno", 100)))
									.contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON))
					.andReturn();
			

			MvcResult result = mvc
					.perform(MockMvcRequestBuilders.get("/getAll").contentType(MediaType.APPLICATION_JSON)).andReturn();
			String content = result.getResponse().getContentAsString();
			System.out.println(content);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void test2() {
		try {
			MvcResult result2 = mvc
					.perform(
							MockMvcRequestBuilders.post("/gerarVenda").content(asJsonString(new Venda(1, "abcdefghijklmnopqrstuvwxyz", 100)))
									.contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON))
					.andReturn();

			String content2 = result2.getResponse().getContentAsString();

			System.out.println(content2);
			
			MvcResult result = mvc
					.perform(MockMvcRequestBuilders.get("/getAll").contentType(MediaType.APPLICATION_JSON)).andReturn();
			String content = result.getResponse().getContentAsString();
			System.out.println(content);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void test3() {
		try {
			Date inicio = new java.sql.Date(Calendar.getInstance().getFirstDayOfWeek());
			Date fim = new java.sql.Date(Calendar.getInstance().getTime().getTime());
			
			MvcResult result9 = mvc
					.perform(
							MockMvcRequestBuilders.get("/getVenda").content(asJsonString(new tempo(inicio, fim)))
									.contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON))
					.andReturn();
			
			
		} catch (Exception e) {
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

@JsonSerialize
class tempo
{
	Date inicio;
	Date fim;
	
	public tempo(Date inicio, Date fim)
	{
		String inicioS = inicio.toString();
		String fimS = fim.toString();
	}
}
