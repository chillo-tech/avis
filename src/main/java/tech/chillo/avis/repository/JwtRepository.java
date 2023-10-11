package tech.chillo.avis.repository;

import org.springframework.data.repository.CrudRepository;
import tech.chillo.avis.entite.Jwt;

import java.util.Optional;

public interface JwtRepository extends CrudRepository<Jwt, Integer> {
    Optional<Jwt> findByValeurAndDesactiveAndExpire(String valeur, boolean desactive, boolean expire);
}
