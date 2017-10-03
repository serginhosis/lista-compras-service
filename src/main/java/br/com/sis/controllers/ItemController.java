package br.com.sis.controllers;

import java.net.URI;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.sis.entities.Item;
import br.com.sis.services.ItemService;
import io.swagger.annotations.ApiOperation;

@RestController
public class ItemController {

	@Autowired
	private ItemService itemService;

	@GetMapping("/item/lista")
	@ApiOperation(value = "Lista todos os items")
	public ResponseEntity<List<Item>> getAll() {
		return new ResponseEntity<List<Item>>(itemService.getAll(), HttpStatus.OK);
	}
	
/*	@GetMapping("/item/{id}")
	public ResponseEntity<Item> getItemById(@PathVariable long id)
	{
		return new ResponseEntity<Item>(itemService.findById(id),HttpStatus.OK);
	}
	*/

	@PostMapping(value="/item", consumes = "application/json")
	public ResponseEntity<String> salvar(@RequestBody Item item,HttpHeaders responseHeaders)
	{
		itemService.salvar(item);
		URI location = ServletUriComponentsBuilder
				.fromCurrentRequest().path("/{id}")
				.buildAndExpand(item.getId()).toUri();
		
		   responseHeaders.setLocation(location);
		   responseHeaders.set("MyResponseHeader", "MyValue");
		   return new ResponseEntity<String>("Item salvo com sucesso", responseHeaders, HttpStatus.CREATED);
	}
	
	
	@PostMapping(value = "/item/adicionar", consumes = "application/json")	
	public ResponseEntity<String> adicionaJson(@RequestBody Item item, HttpHeaders responseHeaders) {
		URI location = ServletUriComponentsBuilder
				.fromCurrentRequest().path("/{id}")
				.buildAndExpand(itemService.salvar(item).getId()).toUri();
		/*responseHeaders.setLocation(location);*/
		return new ResponseEntity<String>("Item Salvo com sucesso",HttpStatus.CREATED);

	}

}
