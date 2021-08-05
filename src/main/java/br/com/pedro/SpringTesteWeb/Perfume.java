package br.com.pedro.SpringTesteWeb;

import java.math.BigDecimal;
import java.util.SplittableRandom;

import lombok.Getter;

@Getter
public class Perfume {

    private Long id = 0L;
    private String nome;
    private BigDecimal valor;
    private EnumTipoPerfume tipo;
    public static Long contador = 1L;

    public Perfume(String nome, BigDecimal valor, EnumTipoPerfume tipo) {
        this.id = contador++;
        this.nome = nome;
        this.valor = valor;
        this.tipo = tipo;
    }
    
    public BigDecimal getValor() {
    	return valor;
    }
    
    public String getNome() {
    	return nome;
    }
    
    public EnumTipoPerfume getTipo() {
    	return tipo;
    }
    
    public Long getID() {
    	return id;
    }
    public void alterar(String nome, BigDecimal valor, EnumTipoPerfume tipo) {
    	this.nome = nome;
    	this.valor = valor;
    	this.tipo = tipo;
    }

	public void remove() {
		
		
	}
    
}

