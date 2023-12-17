package tech.chillo.avis.controleur;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import tech.chillo.avis.entite.Avis;
import tech.chillo.avis.service.AvisService;

import java.util.List;

@AllArgsConstructor
@RequestMapping("avis")
@RestController
public class AvisControleur {
    private final AvisService avisService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public void creer(@RequestBody final Avis avis) {
        this.avisService.creer(avis);
    }

    @PreAuthorize("hasAuthority('ROLE_ADMINISTRATEUR')")
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Avis> liste() {
        return this.avisService.liste();
    }
}
