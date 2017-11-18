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

import br.com.sis.domain.dtos.ItemDTO;
import br.com.sis.domain.entities.Item;
import br.com.sis.domain.services.ItemService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value="Itens")
@RestController
public class ItemController {

	@Autowired
	private ItemService itemService;

	@GetMapping("/item/lista-compras/{idLista}")
	@ApiOperation(value = "Retorna todos os itens de uma lista de compras", produces = MediaType.APPLICATION_JSON_VALUE)	
	public ResponseEntity<List<Item>> getAll(@PathVariable long idLista) {
		return new ResponseEntity<List<Item>>(itemService.getAll(idLista), HttpStatus.OK);
	}
	
	@GetMapping(value="/item/{id}")
	@ApiOperation(value = "Retorna um item pelo seu id", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ItemDTO> getItemById(@PathVariable long id)
	{
		return new ResponseEntity<ItemDTO>(itemService.findById(id),HttpStatus.OK);
	}

	@PostMapping(value="/item")
	@ApiOperation(value = "Registra um item",consumes=MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> salvar(@RequestBody ItemDTO item,UriComponentsBuilder uriBuilder)
	{			   	   
	   UriComponents uriComponents = uriBuilder.path("/item/{id}").buildAndExpand(itemService.salvar(item).getId());
	   return ResponseEntity.created(uriComponents.toUri()).build();
	}
	
	@PutMapping(value="/item/editar-compra/{id}/{statusCompra}/{version}")
	@ApiOperation(value = "Modifica o status de compra de um item", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> modificaStatusCompra(@PathVariable long id, @PathVariable boolean statusCompra,@PathVariable Integer version) 
	{			   	 
	   itemService.modificaStatusCompra(id,statusCompra,version);
	   return ResponseEntity.ok().build();
	}
	
	@PutMapping(value="/item/editar-nome/{id}/{nomeItem}/{version}")
	@ApiOperation(value = "Modifica o nome de um item", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> modificaNomeItem(@PathVariable long id, @PathVariable String nomeItem,@PathVariable Integer version) 
	{			   	 
	   itemService.modificaNomeItem(id, nomeItem,version);
	   return ResponseEntity.ok().build();
	}
	
	@DeleteMapping(value="/item/delete/{idItem}")
	@ApiOperation(value = "Remove um item")
	public ResponseEntity<?> deletaItem(@PathVariable long idItem) 
	{			   	 
	   itemService.delete(idItem);
	   return ResponseEntity.ok().build();
	}
	

}
