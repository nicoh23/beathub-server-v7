package nocountry.beathub.service;

import nocountry.beathub.dto.response.ArtistaDTORes;
import nocountry.beathub.exception.ArtistaExistException;
import nocountry.beathub.exception.HibernateOperationException;
import nocountry.beathub.exception.IncorrectPasswordException;
import nocountry.beathub.exception.UsernameNotFoundException;
import nocountry.beathub.model.Artista;
import nocountry.beathub.repository.IArtistaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ArtistaService implements IArtistaService {
    private final IArtistaRepository artistaRepository;

    public ArtistaService(IArtistaRepository artistaRepository) {
        this.artistaRepository = artistaRepository;
    }

    public boolean registerArtista(Artista artista)throws ArtistaExistException,HibernateOperationException{
        if (artistaRepository.existsByUsername(artista.getName())) {
            throw new ArtistaExistException("Ya se encuentra el cliente : " + artista.getName());
        }

        try {
            artistaRepository.save(artista);
        } catch (Exception e) {
            throw new HibernateOperationException("Error interto: " + e.getMessage());
        }


        return true;
    }

    public ArtistaDTORes loginUser(String username, String password) throws UsernameNotFoundException, IncorrectPasswordException ,HibernateOperationException{
        Optional<Artista> userOptional;
        try {
           userOptional = artistaRepository.findByUsername(username);
        } catch (Exception e) {
            throw new HibernateOperationException("Error con hibertane: " + e.getMessage());
        }

        if (userOptional.isPresent()) {
            Artista user = userOptional.get();
            if (user.getPassword().equals(password)) {
                return new ArtistaDTORes(
                        user.getId(),
                        user.getName(),
                        user.getLastname(),
                        user.getUsername(),
                        user.getEmail(),
                        user.getGeneroMusical(),
                        user.getExperiencia(),
                        user.getMisLicencias()
                );
            } else {
                throw new IncorrectPasswordException("Contraseña incorrecta para el usuario: " + username);
            }
        } else {
            throw new UsernameNotFoundException("Usuario no encontrado: " + username);
        }
    }

    public List<Artista> findAllArtistas() {
        List<Artista> artistas = artistaRepository.findAll();
        return artistas;
    }

    public Artista findArtistaById(Long id) throws UsernameNotFoundException, HibernateOperationException {
        Optional<Artista> userOptional;
        try {
            userOptional = artistaRepository.findById(id);
        } catch (Exception e) {
            throw new HibernateOperationException("Error con hibernate: " + e.getMessage());
        }

        if (userOptional.isPresent()) {
            Artista user = userOptional.get();
            return user;
        } else {
            throw new UsernameNotFoundException("Usuario no encontrado: " + id);
        }
    }
}
