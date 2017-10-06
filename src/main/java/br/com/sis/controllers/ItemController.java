package br.com.sis.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.sis.entities.Item;
import br.com.sis.services.ItemService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@Api(value="Itens")
public class ItemController {

	@Autowired
	private ItemService itemService;

	@GetMapping("/item/lista")
	@ApiOperation(value = "Retorna uma lista com todos os itens", produces = MediaType.APPLICATION_JSON_VALUE)	
	public ResponseEntity<List<Item>> getAll() {
		return new ResponseEntity<List<Item>>(itemService.getAll(), HttpStatus.OK);
	}
	
	@GetMapping(value="/item/{id}")
	@ApiOperation(value = "Retorna um item pelo seu id", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Item> getItemById(@PathVariable long id)
	{
		return new ResponseEntity<Item>(itemService.findById(id),HttpStatus.OK);
	}

	@PostMapping(value="/item")
	@ApiOperation(value = "Registra um item",consumes=MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> salvar(@RequestBody Item item,UriComponentsBuilder uriBuilder)
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
	
	@PutMapping(value="/item/editar-nome/{id}/{nomeItem}")
	@ApiOperation(value = "Modifica o nome de um item", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> modificaNomeItem(@PathVariable long id, @PathVariable String nomeItem) 
	{			   	 
	   itemService.modificaNomeItem(id, nomeItem);
	   return ResponseEntity.ok().build();
	}
	
	
	
	

}
