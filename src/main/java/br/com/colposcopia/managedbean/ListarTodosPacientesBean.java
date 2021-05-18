package br.com.colposcopia.managedbean;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import br.com.colposcopia.bean.ExameColposcopico;
import br.com.colposcopia.controller.ListarTodosPacientesController;

@ManagedBean(name = "listarTodos")
@ViewScoped
public class ListarTodosPacientesBean {
	private ListarTodosPacientesController controller = new ListarTodosPacientesController();
	private List<ExameColposcopico> lista;
	private String pesquisaNomePaciente = "";
	
	@PostConstruct
	private void init() {
		lista = controller.carregarTodosPacientes();
		lista.forEach(System.out::println);
	}
		
	public String editaPaciente(ExameColposcopico exame) {
		
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("pesquisa", exame);
		
		return "exame_colposcopico.xhtml";
	}
	
	public List<ExameColposcopico> getLista() {
		System.out.println(pesquisaNomePaciente);
		if(pesquisaNomePaciente.equals("")) {
			return lista;			
		}
		List<ExameColposcopico> listaTemp = new ArrayList<>();
		lista.forEach(exame ->{
			if (exame.getNomePaciente().contains(pesquisaNomePaciente)) {
				listaTemp.add(exame);
			}
		});
		
		return listaTemp;
	}
	
	public String getPesquisaNomePaciente() {
		return pesquisaNomePaciente;
	}
	
	public void setPesquisaNomePaciente(String pesquisaNomePaciente) {
		this.pesquisaNomePaciente = pesquisaNomePaciente;
	}
}
