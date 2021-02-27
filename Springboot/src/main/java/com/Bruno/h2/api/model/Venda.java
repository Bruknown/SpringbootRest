package com.Bruno.h2.api.model;

import java.sql.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

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
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long vendaId;

	@Column(name = "vendedorId", nullable = false)
	private long vendedorId;

	@Column(name = "vendedorNome", nullable = false, length = 10)
	private String vendedorNome;

	@Column(name = "data", nullable = false)
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date data;

	@Column(name = "valor", nullable = false)
	private float valor;

	@OneToMany(mappedBy = "venda")
	private List<Vendedor> vendedor;

	public List<Vendedor> getVendedor() {
		return vendedor;
	}

	public void setVendedor(List<Vendedor> vendedor) {
		this.vendedor = vendedor;
	}

	public Venda() {
	}

	public Venda(long vendedorId, String vendedorNome, float valor) {
		super();
		this.vendedorId = vendedorId;
		this.vendedorNome = vendedorNome;
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
