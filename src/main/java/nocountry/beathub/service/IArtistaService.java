package nocountry.beathub.service;

import nocountry.beathub.dto.response.ArtistaDTORes;
import nocountry.beathub.exception.ArtistaExistException;
import nocountry.beathub.exception.HibernateOperationException;
import nocountry.beathub.exception.IncorrectPasswordException;
import nocountry.beathub.exception.UsernameNotFoundException;
import nocountry.beathub.model.Artista;

import java.util.List;

public interface IArtistaService {
    boolean registerArtista(Artista artista)throws ArtistaExistException,HibernateOperationException;

    ArtistaDTORes loginUser(String username, String password)throws UsernameNotFoundException, IncorrectPasswordException, HibernateOperationException;

    List<Artista> findAllArtistas();

    Artista findArtistaById(Long id) throws UsernameNotFoundException, HibernateOperationException;
}

