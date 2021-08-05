package br.com.pedro.SpringTesteWeb;

import java.math.BigDecimal;
import java.util.SplittableRandom;

public class ItemCompra {

	private Long id;
	private Perfume perfume;
	private Integer qtd;
	private BigDecimal total;

	public ItemCompra(Perfume p, Integer qtd) {
		this.id = new SplittableRandom().nextLong(1, Long.MAX_VALUE);
		this.perfume = p;
		this.qtd = qtd;
		this.total = p.getValor().multiply(BigDecimal.valueOf(qtd));
	}

	public Long getId() {
		return id;
	}

	public Perfume getPerfume() {
		return perfume;
	}

	public Integer getQtd() {
		return qtd;
	}

	public BigDecimal getTotal() {
		return total;
	}
}

