package br.com.pedro.SpringTesteWeb.controller;
import java.math.BigDecimal;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.pedro.SpringTesteWeb.Compra;
import br.com.pedro.SpringTesteWeb.PessoaFisica;
import br.com.pedro.SpringTesteWeb.Produto;
import br.com.pedro.SpringTesteWeb.model.PessoaModel;

	@RestController
	public class CadastroPessoaController {
		Produto produtin = new Produto("Monitor", BigDecimal.valueOf(5));
		PessoaFisica pedro = new PessoaFisica("03962673270");
		
		
		@GetMapping("/cpf")
		public Compra validarCPF(@RequestParam(value = "validar") String cpf) {
			return new Compra(pedro, produtin, 2);
	}
}

