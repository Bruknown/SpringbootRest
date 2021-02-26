package com.Bruno.h2.api.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Vendedor {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "vendedorId", nullable = false, unique = true)
	private long vendedorId;
	
	@Column(name = "vendedorNome", nullable = false, length = 10)
	private String vendedorNome;
	
	@ManyToOne
	private Venda venda;

	public Vendedor() {
	}

	public Vendedor(long vendedorId, String vendedorNome) {
		super();
		this.vendedorId = vendedorId;
		this.vendedorNome = vendedorNome;
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

}
