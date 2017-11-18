package br.com.sis.domain.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.sis.domain.entities.ListaCompras;
import br.com.sis.domain.services.ListaComprasService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value="ListaCompras")
@RestController
public class ListaComprasController {

	@Autowired
	private ListaComprasService listaComprasService;

	@GetMapping("/lista-compras/listar-todas")
	@ApiOperation(value = "Retorna uma lista com todas as lista de compras", produces = MediaType.APPLICATION_JSON_VALUE)	
	public ResponseEntity<List<ListaCompras>> getAll() {
		return new ResponseEntity<List<ListaCompras>>(listaComprasService.getAll(), HttpStatus.OK);
	}
	
	@GetMapping(value="/lista-compras/{id}")
	@ApiOperation(value = "Retorna uma lista de compras pelo seu id", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ListaCompras> getItemById(@PathVariable long id)
	{
		return new ResponseEntity<ListaCompras>(listaComprasService.findById(id),HttpStatus.OK);
	}

	@PostMapping(value="/lista-compras")
	@ApiOperation(value = "Registra uma lista de compras",consumes=MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> salvar(@RequestBody ListaCompras lista,UriComponentsBuilder uriBuilder)
	{			   	   
	   UriComponents uriComponents = uriBuilder.path("/lista-compras/{id}").buildAndExpand(listaComprasService.salvar(lista).getId());
	   return ResponseEntity.created(uriComponents.toUri()).build();
	}
	
	@PutMapping(value="/lista-compras/editar-nome/id/{id}/nome/{nomeLista}/versao/{version}")
	@ApiOperation(value = "Modifica o nome de uma lista de compras", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> modificaNomeItem(@PathVariable long id, @PathVariable String nomeLista,@PathVariable Integer version) 
	{			   	 
	   listaComprasService.modificaNomeListaCompras(id, nomeLista,version);
	   return ResponseEntity.ok().build();
	}
	
	@DeleteMapping(value="/lista-compras/delete/{idLista}")
	@ApiOperation(value = "Remove uma lista")
	public ResponseEntity<?> deletaItem(@PathVariable long idLista) 
	{			   	 
	   listaComprasService.delete(idLista);
	   return ResponseEntity.ok().build();
	}
	
	

}
