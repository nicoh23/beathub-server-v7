package nocountry.beathub.service;

import nocountry.beathub.exception.HibernateOperationException;
import nocountry.beathub.exception.IdNotFoundException;
import nocountry.beathub.model.Beat;
import nocountry.beathub.model.Productor;

import java.util.List;
import java.util.Optional;

public interface IBeatService {
    List<Beat> getAllBeats();

    Beat saveBeat(Beat newBeat);

    public Beat findBeatById(Long id) throws IdNotFoundException, HibernateOperationException;


    public List<Beat> getAllBeatsByIdProductor(Long id);

} 