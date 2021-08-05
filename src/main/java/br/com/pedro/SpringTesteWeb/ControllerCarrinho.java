package br.com.pedro.SpringTesteWeb;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

	@RestController
	@RequestMapping("/carrinho")
	public class ControllerCarrinho {
		
		@GetMapping("/addproduto")
		public Compra addPerfume(@RequestParam Long id,
								 @RequestParam Integer qtd) {
			
			for(Perfume perfume : armazenamento.perfumesCadastrados)
				if(id.equals(perfume.getID())) {
					Compra compra = new Compra(perfume, qtd);
					armazenamento.carrinho.add(compra);
					return compra;
				}
			return null;
		}
		
		@GetMapping("/listar")
		public List<Compra> listar() {
			return armazenamento.carrinho;
		}
	
		
		
		
		
		
		
}
