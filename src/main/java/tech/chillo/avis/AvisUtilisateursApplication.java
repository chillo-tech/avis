package tech.chillo.avis;

import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import tech.chillo.avis.entite.Role;
import tech.chillo.avis.entite.Utilisateur;
import tech.chillo.avis.repository.UtilisateurRepository;
import tech.chillo.avis.service.UtilisateurService;
@AllArgsConstructor
@SpringBootApplication
public class AvisUtilisateursApplication {
	private BCryptPasswordEncoder passwordEncoder;
UtilisateurRepository utilisateurRepository;
	public static void main(String[] args) {
		SpringApplication.run(AvisUtilisateursApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner() {

		String mdpCrypte = this.passwordEncoder.encode("admin");
		Utilisateur administrateur = Utilisateur.builder()
				.mdp(mdpCrypte)
				.email("admin@chillo.tech")
				.role(
					Role.builder().libelle(TypeDeRole.ADMINISTRATEUR).build()
				)
				.actif(true)
				.nom("admin")
				.build();

		return  args -> {
			this.utilisateurRepository.save(administrateur);
		};
	}

}
