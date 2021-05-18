package br.com.colposcopia.controller;

import javax.persistence.EntityManager;

import br.com.colposcopia.bean.ExameColposcopico;
import br.com.colposcopia.dao.ExameColposcopioFactory;

public class ExameBeanController {

	// aqui vou fazer o insert via HQL
	public void adicionaExame(ExameColposcopico exame) {
		EntityManager entityManager = ExameColposcopioFactory.carregaBanco();
//		https://www.guj.com.br/t/hibernate-jsf-erro-ao-persistir-objeto/337939
		if (!entityManager.getTransaction().isActive()) 
			entityManager.getTransaction().begin();
		entityManager.persist(exame);
		entityManager.getTransaction().commit();
	}
	
}
