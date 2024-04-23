package nocountry.beathub.service;

import nocountry.beathub.dto.response.ProductorDTORes;
import nocountry.beathub.exception.*;
import nocountry.beathub.model.Beat;
import nocountry.beathub.model.Productor;
import nocountry.beathub.repository.IProductorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductorService implements IProductorService {

    @Autowired
    private IProductorRepository productorRepository;


    @Override
    public boolean registerProductor(Productor productor) throws ProductorExistException, HibernateOperationException {
        Beat beat = null;
        if (productorRepository.existsByUsername(productor.getName())) {
            throw new ProductorExistException("Ya se encuentra el cliente : " + productor.getName());
        }

        try {


            productorRepository.save(productor);
        } catch (Exception e) {
            throw new HibernateOperationException("Error interto: " + e.getMessage());
        }


        return true;
    }

    @Override
    public ProductorDTORes loginUser(String username, String password) throws UsernameNotFoundException, IncorrectPasswordException, HibernateOperationException {
        Optional<Productor> userOptional;
        try {
            userOptional = productorRepository.findByUsername(username);
        } catch (Exception e) {
            throw new HibernateOperationException("Error con hibertane: " + e.getMessage());
        }

        if (userOptional.isPresent()) {
            Productor user = userOptional.get();
            if (user.getPassword().equals(password)) {
                return new ProductorDTORes(
                        user.getId(),
                        user.getName(),
                        user.getLastname(),
                        user.getUsername(),
                        user.getEmail(),
                        user.getDescripcion()
                );
            } else {
                throw new IncorrectPasswordException("Contraseña incorrecta para el usuario: " + username);
            }
        } else {
            throw new UsernameNotFoundException("Usuario no encontrado: " + username);
        }
    }

    @Override
    public List<Productor> findAllProductores() {
        List<Productor> productores = productorRepository.findAll();
        return productores;
    }

    public Productor findProductorById(Long id) throws IdNotFoundException, HibernateOperationException {
        Optional<Productor> userOptional;
        try {
            userOptional = productorRepository.findById(id);
        } catch (Exception e) {
            throw new HibernateOperationException("Error con hibernate: " + e.getMessage());
        }

        if (userOptional.isPresent()) {
            Productor user = userOptional.get();
            return user;
        } else {
            throw new IdNotFoundException("Usuario no encontrado: " + id);
        }
    }

    @Override
    public boolean agregarBeat(Productor productor) throws HibernateOperationException {


        try {
            productorRepository.save(productor);
        } catch (Exception e) {
            throw new HibernateOperationException("Error interno: " + e.getMessage());
        }


        return true;

    }
}
