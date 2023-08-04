package tech.chillo.avis.repository;

import org.springframework.data.repository.CrudRepository;
import tech.chillo.avis.entite.Avis;

public interface AvisRepository extends CrudRepository<Avis, Integer> {
}
