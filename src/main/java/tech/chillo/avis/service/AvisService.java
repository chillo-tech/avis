package tech.chillo.avis.service;

import lombok.AllArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import tech.chillo.avis.entite.Avis;
import tech.chillo.avis.entite.Utilisateur;
import tech.chillo.avis.repository.AvisRepository;

import java.util.List;

@AllArgsConstructor
@Service
public class AvisService {

    private final AvisRepository avisRepository;

    public void creer(final Avis avis) {
        final Utilisateur utilisateur = (Utilisateur) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        avis.setUtilisateur(utilisateur);
        this.avisRepository.save(avis);
    }

    public List<Avis> liste() {
        return this.avisRepository.findAll();
    }
}
