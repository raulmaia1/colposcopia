package br.com.colposcopia.dao;

import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ExameColposcopioFactory {
	private static Optional<EntityManager> entityManager = Optional.empty();
	
	public static EntityManager carregaBanco() {
		
		if (!entityManager.isPresent()) {
			EntityManagerFactory emf = Persistence.createEntityManagerFactory("exame_colposcopico");			
			entityManager = Optional.ofNullable(emf.createEntityManager());
		}
		
		return entityManager.get();

	}

}
