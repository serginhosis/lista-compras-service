package br.com.sis.domain.services;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.sis.core.annotation.VersionHandling;
import br.com.sis.core.exception.ApplicationException;
import br.com.sis.domain.dtos.ItemDTO;
import br.com.sis.domain.entities.Item;
import br.com.sis.domain.entities.ListaCompras;
import br.com.sis.domain.repositories.ItemRepository;
import br.com.sis.domain.repositories.ListaComprasRepository;

@Service
public class ItemService {

	@Autowired
	private ItemRepository itemRepository;	
	
	@Autowired
	private ListaComprasRepository listaComprasRepository;
	
	public Item salvar(ItemDTO dto)
	{				
		Item item = new Item();
		BeanUtils.copyProperties(dto, item);
		
		ListaCompras lista = listaComprasRepository.findOne(dto.getIdLista());
		item.setListaCompras(lista);
		
		return itemRepository.save(item);		
	}
	
	public List<Item> getAll(Long idLista)
	{
		return itemRepository.findByIdListaCompras(idLista);
	}

	public ItemDTO findById(long itemId) {
		Item item = itemRepository.findOne(itemId);
		ItemDTO dto = new ItemDTO();
		BeanUtils.copyProperties(item, dto);
		dto.setIdLista(item.getListaCompras().getId());
		
		return dto;
	}

	@VersionHandling(description="Blablabla")
	public void modificaStatusCompra(long itemId, boolean statusCompra,Integer version) {
		Item item = itemRepository.findOne(itemId);		
		item.setFoiComprado(statusCompra);
		if(item.getVersion()==version)		
		{
			itemRepository.save(item);
		}else
		{
			throw new ApplicationException("Este item já foi alterado, por favor recarregue-o novamente para edita-lo");
		}
	}
	
	public void modificaNomeItem(long itemId, String nomeItem,Integer version) {
		Item item = itemRepository.findOne(itemId);
		item.setNome(nomeItem);
		if(item.getVersion()==version)		
		{
			itemRepository.save(item);
		}else
		{
			throw new ApplicationException("Este item já foi alterado, por favor recarregue-o novamente para edita-lo");
		}
	}

	public void delete(long id) {	
		itemRepository.delete(id);
	}
}
