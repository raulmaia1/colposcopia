package br.com.colposcopia.managedbean;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import br.com.colposcopia.bean.ExameColposcopico;

@ManagedBean(name = "impressao")
@ViewScoped
public class ImpressaoColposcopico {
	
	private ExameColposcopico exame;

	@PostConstruct
	private void init() {
		this.exame = (ExameColposcopico) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("exame");
	}
	
	public ExameColposcopico getExame() {
		return exame;
	}
}
