package br.com.pedro.SpringTesteWeb.controller;
import java.math.BigDecimal;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.pedro.SpringTesteWeb.Compra;
import br.com.pedro.SpringTesteWeb.EnumTipoPerfume;
import br.com.pedro.SpringTesteWeb.Perfume;
import br.com.pedro.SpringTesteWeb.PessoaFisica;
import br.com.pedro.SpringTesteWeb.Produto;
import br.com.pedro.SpringTesteWeb.armazenamento;

	@RestController
	public class CadastroPessoaController {
		
		
		@GetMapping("/valida-cpf")
		public PessoaFisica validarCPF(@RequestParam(value = "cpf") String cpf) {
			return new PessoaFisica("", cpf);
		}
		
		@GetMapping("/cadastra-perfume")
		public Perfume cadastroPerfume(@RequestParam(value = "nome") String nome,
										@RequestParam(value = "valor") BigDecimal valor,
										@RequestParam(value = "tipo") EnumTipoPerfume tipo) {
			Perfume perfume = new Perfume(nome, valor, tipo);
			armazenamento.perfumesCadastrados.add(perfume);
			return perfume;
		}
		
		@GetMapping("/listar-perfume")
		public List<Perfume> listar() {
			return armazenamento.perfumesCadastrados;
		}
		
		@GetMapping("/editar-perfume")
		public Perfume editar(@RequestParam(value = "id") Long id,
							  @RequestParam(value = "nome") String nome,
							  @RequestParam(value = "valor") BigDecimal valor, 
							  @RequestParam(value = "tipo") EnumTipoPerfume tipo) {
			
			for(Perfume perfume : armazenamento.perfumesCadastrados) {
				if(id.equals(perfume.getID())) {
					perfume.alterar(nome, valor, tipo);
					return perfume;
				}
			}
			return null;
		}
		
		
			
			
		//cadastrar perfume
		//editar perfume
		//delete
		//listar
		//passar produto, quantidade para adicionar ao carrinho
		//finalizar carrinho
		//listar carrinho quando completado e depois deletar
		
}


