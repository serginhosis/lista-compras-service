package br.com.sis.domain.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.sis.core.exception.ApplicationException;
import br.com.sis.domain.entities.ListaCompras;
import br.com.sis.domain.repositories.ListaComprasRepository;

@Service
public class ListaComprasService {

	@Autowired
	private ListaComprasRepository listaComprasRepository;
	
	public ListaCompras salvar(ListaCompras listaCompras)
	{	
		listaCompras.getItens().forEach(item-> item.setListaCompras(listaCompras));
		return listaComprasRepository.save(listaCompras);			
	}
	
	public List<ListaCompras> getAll()
	{
		return listaComprasRepository.findAll();
	}
	

	public ListaCompras findById(long listaComprasId) {
		return listaComprasRepository.findOne(listaComprasId);		
	}

	public void modificaNomeListaCompras(long listaComprasId, String nomeListaCompras,Integer version) {
		ListaCompras listaCompras = findById(listaComprasId);
		listaCompras.setNome(nomeListaCompras);
		if(listaCompras.getVersion()==version)		
		{
			listaComprasRepository.save(listaCompras);
		}else
		{
			throw new ApplicationException("Esta Lista de compras já foi alterada, por favor carregue-a novamente para edita-la");
		}
	}

	public void delete(long idLista) {
		listaComprasRepository.delete(idLista);
	}
}
