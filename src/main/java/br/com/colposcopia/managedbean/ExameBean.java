package br.com.colposcopia.managedbean;

import java.io.Serializable;
import java.util.Optional;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import br.com.colposcopia.bean.ExameColposcopico;
import br.com.colposcopia.controller.ExameBeanController;

@ManagedBean
@ViewScoped
public class ExameBean implements Serializable{

	private static final long serialVersionUID = 1L;
	private ExameColposcopico exame = new ExameColposcopico();
	
	@PostConstruct
	private void init() {
		Optional<ExameColposcopico> optional = Optional.ofNullable((ExameColposcopico) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("pesquisa"));
		
		optional.ifPresent((e) -> this.exame = e);
		
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("pesquisa", null);
		
	}
	
	
	public String geraExame(){
		ExameBeanController controller = new ExameBeanController();
		
		controller.adicionaExame(exame);
		//https://stackoverflow.com/a/26689334
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("exame", this.exame);
		
		return "impressao";
	}
	
	// Getters and Setters
	
	public ExameColposcopico getExame() {
		return exame;
	}
}
