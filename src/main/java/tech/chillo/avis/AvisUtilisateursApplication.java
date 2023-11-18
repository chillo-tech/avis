package tech.chillo.avis;

import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;
import tech.chillo.avis.entite.Role;
import tech.chillo.avis.entite.Utilisateur;
import tech.chillo.avis.enums.TypeDeRole;
import tech.chillo.avis.repository.UtilisateurRepository;

@AllArgsConstructor
@SpringBootApplication
public class AvisUtilisateursApplication implements CommandLineRunner {
	UtilisateurRepository utilisateurRepository;
	PasswordEncoder passwordEncoder;


	public static void main(String[] args) {
		SpringApplication.run(AvisUtilisateursApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Utilisateur admin = Utilisateur.builder()
				.actif(true)
				.nom("admin")
				.mdp(passwordEncoder.encode("admin"))
				.email("achille.mbougueng@chillo.tech")
				.role(
						Role.builder()
								.libelle(TypeDeRole.ADMINISTRATEUR)
								.build()
				)
				.build();
		admin = this.utilisateurRepository.findByEmail("achille.mbougueng@chillo.tech")
				.orElse(admin);
		this.utilisateurRepository.save(admin);
		Utilisateur manager = Utilisateur.builder()
				.actif(true)
				.nom("manager")
				.mdp(passwordEncoder.encode("manager"))
				.email("manager@chillo.tech")
				.role(
						Role.builder()
								.libelle(TypeDeRole.MANAGER)
								.build()
				)
				.build();
		manager = this.utilisateurRepository.findByEmail("manager@chillo.tech")
				.orElse(manager);
		this.utilisateurRepository.save(manager);
	}
}
