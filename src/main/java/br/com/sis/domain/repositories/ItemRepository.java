package br.com.sis.domain.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.sis.domain.entities.Item;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {

	@Query("select i from Item i join i.listaCompras l where (l.id = :idLista)")
	List<Item> findByIdListaCompras(@Param("idLista") Long idLista);
}
