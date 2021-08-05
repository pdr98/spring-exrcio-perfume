package br.com.pedro.SpringTesteWeb;
import java.util.Objects;
import java.util.SplittableRandom;

import br.com.pedro.SpringTesteWeb.model.PessoaModel;

public class PessoaFisica extends PessoaModel {
	
	public PessoaFisica(String nome, String documento) {
		super(nome, documento);
	}

	public Boolean validarDocumento() {
		
		if (Objects.isNull(super.getDocumento()) || 
				super.getDocumento().length() != 11) {
			return false;
		}
		String preDocumento = super.getDocumento().substring(0, 9);
		String documentoGerado = this.geraDocumento(preDocumento);
		return super.getDocumento().equals(documentoGerado);
	}

	public String gerarDocumento() {
		SplittableRandom sr = new SplittableRandom();
		String preDoc = "";
		for (int i = 0; i < 9; i++) {
			preDoc = preDoc + sr.nextInt(0, 10);
		}
		return this.geraDocumento(preDoc);
	}

	private String geraDocumento(String preDoc1) {
		
		char[] numeros = preDoc1.toCharArray();
		Integer soma = 0;
		for (int i = numeros.length; i > 0; i--) {
			Integer num = Integer.valueOf(String.valueOf(numeros[i - 1]));
			soma += (num * i);
		}
		Integer dv1 = soma % 11;
		
		String preDoc2 = preDoc1 + (dv1.equals(10) ? 0 : dv1);
		
		numeros = preDoc2.toCharArray();
		soma = 0;
		for (int i = numeros.length - 1; i >= 0; i--) {
			Integer num = Integer.valueOf(String.valueOf(numeros[i]));
			soma += (num * i);
		}
		Integer dv2 = soma % 11;
		
		return preDoc2 + (dv2.equals(10) ? 0 : dv2);
	}

	@Override
	public String geraDocumento() {
		// TODO Auto-generated method stub
		return null;
	}
}