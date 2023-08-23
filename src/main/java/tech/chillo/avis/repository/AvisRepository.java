package tech.chillo.avis.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import tech.chillo.avis.entite.Avis;

public interface AvisRepository extends JpaRepository<Avis, Integer> {
}
