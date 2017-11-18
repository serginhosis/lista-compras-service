package br.com.sis.domain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.sis.domain.entities.ListaCompras;

@Repository
public interface ListaComprasRepository extends JpaRepository<ListaCompras, Long> {

}
