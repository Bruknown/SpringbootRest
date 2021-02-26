package com.Bruno.h2.api.dao;

import org.apache.tomcat.jni.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.Bruno.h2.api.model.Venda;

public interface VendaRepo extends JpaRepository<Venda, Long> {
	

}
