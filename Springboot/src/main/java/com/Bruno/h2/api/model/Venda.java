package com.Bruno.h2.api.model;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Venda {
	@Id
	@GeneratedValue
	private long vendaId;
	private long vendedorId;
	private String vendedorNome;
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date data;
	private float valor;
	
	
	public Venda(long vendaId, long vendedorId, String vendedorNome, Date data, float valor)
	{
		this.vendaId = vendaId;
		this.vendedorId = vendedorId;
		this.vendedorNome = vendedorNome;
		this.data = data;
		this.valor = valor;
	}
	
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	public long getVendaId() {
		return vendaId;
	}
	public void setVendaId(long vendaId) {
		this.vendaId = vendaId;
	}
	public long getVendedorId() {
		return vendedorId;
	}
	public void setVendedorId(long vendedorId) {
		this.vendedorId = vendedorId;
	}
	public String getVendedorNome() {
		return vendedorNome;
	}
	public void setVendedorNome(String vendedorNome) {
		this.vendedorNome = vendedorNome;
	}
	public float getValor() {
		return valor;
	}
	public void setValor(float valor) {
		this.valor = valor;
	}
}
