package br.com.sis.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.sis.entities.Item;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {
	
	@Modifying
	@Transactional
	@Query("update Item i set i.foiComprado = ?2 where i.id = ?1")
	void modificaStatusCompra(long itemId,boolean foiComprado,Integer version);

	
	@Modifying
	@Transactional
	@Query("update Item i set i.nome = ?2 where i.id = ?1 and i.version=?3")
	void modificaNomeItem(long itemId,String nomeItem,Integer version);
}
