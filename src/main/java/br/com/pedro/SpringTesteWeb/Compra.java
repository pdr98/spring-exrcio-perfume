package br.com.pedro.SpringTesteWeb;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.SplittableRandom;


public class Compra {
	
	private Long id;
	private PessoaFisica cliente;
	private List<ItemCompra> itens;

	public Compra(Perfume perfume, Integer qtd) {
		this.itens = new ArrayList<>();
		this.id = new SplittableRandom().nextLong(1, Long.MAX_VALUE);
		this.addProduto(perfume, qtd);
	}
	
	public void addProduto(Perfume perfume, Integer qtd) {
		this.itens.add(new ItemCompra(perfume, qtd));
	}

	public PessoaFisica getCliente() {
		return cliente;
	}

	public Long getId() {
		return id;
	}

	public List<ItemCompra> getItens() {
		return itens;
	}

	public BigDecimal getTotal() {
		BigDecimal soma = BigDecimal.ZERO;
		for (ItemCompra i : itens) {
			soma = soma.add(i.getTotal());
		}
		return soma;
	}
}