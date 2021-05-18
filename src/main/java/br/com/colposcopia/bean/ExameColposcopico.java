package br.com.colposcopia.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "exame_colposcopico")
public class ExameColposcopico {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;
	@Column(nullable = true)
	private String nomePaciente, dataNascimento, descricaoMacroscopica, avaliacao, achadosColposcopicosNormais, achadosColposcopicosAnormais,
			outrosAnormais, conclusao;

	public String getDataNascimento() {
		return dataNascimento;
	}
	
	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	
	public String getNomePaciente() {
		return nomePaciente;
	}
	
	public void setNomePaciente(String nomePaciente) {
		this.nomePaciente = nomePaciente;
	}
	
	public String getDescricaoMacroscopica() {
		return descricaoMacroscopica;
	}

	public void setDescricaoMacroscopica(String descriçãoMacroscopica) {
		this.descricaoMacroscopica = descriçãoMacroscopica;
	}

	public String getAvaliacao() {
		return avaliacao;
	}
	
	public void setAvaliacao(String avaliacao) {
		this.avaliacao = avaliacao;
	}

	public String getAchadosColposcopicosNormais() {
		return achadosColposcopicosNormais;
	}

	public void setAchadosColposcopicosNormais(String achadosColposcopicosNormais) {
		this.achadosColposcopicosNormais = achadosColposcopicosNormais;
	}

	public String getAchadosColposcopicosAnormais() {
		return achadosColposcopicosAnormais;
	}

	public void setAchadosColposcopicosAnormais(String achadosColposcópicosAnormais) {
		this.achadosColposcopicosAnormais = achadosColposcópicosAnormais;
	}

	public String getOutrosAnormais() {
		return outrosAnormais;
	}

	public void setOutrosAnormais(String outrosAnormais) {
		this.outrosAnormais = outrosAnormais;
	}

	public String getConclusao() {
		return conclusao;
	}

	public void setConclusao(String conclusao) {
		this.conclusao = conclusao;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((descricaoMacroscopica == null) ? 0 : descricaoMacroscopica.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ExameColposcopico other = (ExameColposcopico) obj;
		if (descricaoMacroscopica == null) {
			if (other.descricaoMacroscopica != null)
				return false;
		} else if (!descricaoMacroscopica.equals(other.descricaoMacroscopica))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
