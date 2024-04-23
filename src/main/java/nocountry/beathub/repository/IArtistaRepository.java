package nocountry.beathub.repository;

import nocountry.beathub.model.Artista;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IArtistaRepository extends JpaRepository<Artista, Long> {
    Optional<Artista> findByUsername(String username);
    boolean existsByUsername(String username);
}