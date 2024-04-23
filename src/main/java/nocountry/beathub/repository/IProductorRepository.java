package nocountry.beathub.repository;

import nocountry.beathub.model.Artista;
import nocountry.beathub.model.Productor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IProductorRepository extends JpaRepository<Productor,Long> {

    Optional<Productor> findByUsername(String username);
    boolean existsByUsername(String username);
}
