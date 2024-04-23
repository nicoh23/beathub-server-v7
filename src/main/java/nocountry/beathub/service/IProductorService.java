package nocountry.beathub.service;

import nocountry.beathub.dto.response.ProductorDTORes;
import nocountry.beathub.exception.*;
import nocountry.beathub.model.Productor;

import java.util.List;

public interface IProductorService {

    boolean registerProductor(Productor productor)throws ProductorExistException, HibernateOperationException;

    ProductorDTORes loginUser(String username, String password)throws UsernameNotFoundException, IncorrectPasswordException, HibernateOperationException;

    public List<Productor> findAllProductores();


    Productor findProductorById(Long id) throws IdNotFoundException, HibernateOperationException;

    boolean agregarBeat(Productor productor)throws  HibernateOperationException;


}
