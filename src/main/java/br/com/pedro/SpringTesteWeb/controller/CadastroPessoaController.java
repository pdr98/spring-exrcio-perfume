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
import lombok.Getter;

	@RestController
	@RequestMapping("/perfume")
	public class CadastroPessoaController {
		
		
		@GetMapping("/cadastra")
		public Perfume cadastroPerfume(@RequestParam(value = "nome") String nome,
										@RequestParam(value = "valor") BigDecimal valor,
										@RequestParam(value = "tipo") EnumTipoPerfume tipo) {
			Perfume perfume = new Perfume(nome, valor, tipo);
			armazenamento.perfumesCadastrados.add(perfume);
			return perfume;
		}
		
		@GetMapping("/lista")
		public List<Perfume> listar() {
			return armazenamento.perfumesCadastrados;
		}
		
		@GetMapping("/edita")
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
		
		@GetMapping("/remove")
		public List<Perfume> remover(@RequestParam(value = "id") Long id) {
			
			for(Perfume perfume : armazenamento.perfumesCadastrados) {
				if(id.equals(perfume.getID())) {
					armazenamento.perfumesCadastrados.remove(perfume);
					return armazenamento.perfumesCadastrados;
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


