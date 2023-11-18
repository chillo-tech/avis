package tech.chillo.avis.controleur;

import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tech.chillo.avis.entite.Utilisateur;
import tech.chillo.avis.service.UtilisateurService;

import java.util.List;

@AllArgsConstructor
@RequestMapping("utilisateur")
@RestController
public class UtilisateurControleur {
    UtilisateurService utilisateurService;

    @PreAuthorize("hasAuthority('ROLE_ADMINISTRATEUR')")
    @GetMapping
    public List<Utilisateur> liste() {
        return this.utilisateurService.liste();
    }
}
