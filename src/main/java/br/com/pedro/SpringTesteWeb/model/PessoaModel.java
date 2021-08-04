package br.com.pedro.SpringTesteWeb.model;

import java.util.SplittableRandom;

public abstract class PessoaModel {

	private final long id;
	private final String nome;
	private final String documento;
	
	public PessoaModel(String documento) {
		this.id = new SplittableRandom().nextLong(0, Long.MAX_VALUE);
		this.nome = "Pedro";
		this.documento = documento;
	}

	public long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}
	
	public String getDocumento() {
		return this.documento;
	}
	
	public Boolean getValido() {
		return validarDocumento();
	}
	
	
	public abstract Boolean validarDocumento();
	public abstract String gerarDocumento();
	public abstract String geraDocumento();
	
}