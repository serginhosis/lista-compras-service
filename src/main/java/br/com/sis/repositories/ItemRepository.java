package br.com.sis.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.sis.entities.Item;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {

}
