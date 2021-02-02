package com.Bruno.h2.api.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Vendedor {

	@Id
	@GeneratedValue
	public long vendedorId;
	public String vendedorNome;
	
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
