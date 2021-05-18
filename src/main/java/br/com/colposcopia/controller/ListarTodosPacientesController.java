package br.com.colposcopia.controller;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;

import br.com.colposcopia.bean.ExameColposcopico;
import br.com.colposcopia.dao.ExameColposcopioFactory;

public class ListarTodosPacientesController {
	private static final String SQL = "select exame from ExameColposcopico exame";
	
	private Optional<List<ExameColposcopico>> lista = Optional.empty();
	
	
	public List<ExameColposcopico> carregarTodosPacientes() {
		EntityManager entityManager = ExameColposcopioFactory.carregaBanco();
		
		
		List<ExameColposcopico> list = entityManager.createQuery(SQL,ExameColposcopico.class).getResultList();
		
		this.lista = Optional.ofNullable(list);
		
		return lista.get();
	
	}
	
}
