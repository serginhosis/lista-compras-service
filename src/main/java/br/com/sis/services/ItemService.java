package br.com.sis.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.sis.entities.Item;
import br.com.sis.repositories.ItemRepository;

@Service
public class ItemService {

	@Autowired
	private ItemRepository itemRepository;
	
	public Item salvar(Item item)
	{
		return itemRepository.save(item);		
	}
	
	public List<Item> getAll()
	{
		return itemRepository.findAll();
	}

	public Item findById(long itemId) {
		return itemRepository.findOne(itemId);		
	}
}
