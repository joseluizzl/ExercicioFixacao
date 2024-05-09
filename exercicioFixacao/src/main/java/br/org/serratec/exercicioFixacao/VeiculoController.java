package br.org.serratec.exercicioFixacao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/veiculos")
public class VeiculoController {
	List<Veiculo> veiculos = new ArrayList<>();
	int id = 0;
	
	
	@GetMapping
	public List<Veiculo> listarTodosVeiculos() {
		return veiculos;
	}
	
	@PostMapping
	public Veiculo adicionarVeiculo(@RequestBody Veiculo veiculo) {
		veiculo.setId(++id);
		veiculos.add(veiculo);
		return veiculo;
	}
	
	private int obterIndice(int id) {
		   for(int i = 0; i < veiculos.size(); i++) {
	           if(veiculos.get(i).getId() == id) {
	        	   	return i;
	           }
	       }
		   
		   return -1;
	   }
	
	@GetMapping("/{id}")
	public Veiculo buscarVeiculoPorId(@PathVariable int id) {
		int indice = obterIndice(id);
		
		if(indice != -1) {
			return veiculos.get(indice);
		}
		
		return null;
		
	}
	
	@PutMapping("/{id}")
	public Veiculo atualizarVeiculo(@PathVariable int id, @RequestBody Veiculo veiculoatualizado) {
		int indice = obterIndice(id);
		
		if(indice != -1) {
			veiculoatualizado.setId(id);
             veiculos.set(indice, veiculoatualizado);
          	return veiculoatualizado;
		}
		
		return null;
	}
	
	@DeleteMapping("/{id}")
	 public void removerVeiculo(@PathVariable int id) {
		   int indice = obterIndice(id);
		   
		   if(indice != -1) {
			   veiculos.remove(indice);
		   }
	   }

}
