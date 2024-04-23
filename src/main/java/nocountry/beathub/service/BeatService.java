package nocountry.beathub.service;

import lombok.RequiredArgsConstructor;
import nocountry.beathub.exception.HibernateOperationException;
import nocountry.beathub.exception.IdNotFoundException;
import nocountry.beathub.exception.UsernameNotFoundException;
import nocountry.beathub.model.Beat;
import nocountry.beathub.model.Productor;
import nocountry.beathub.repository.IBeatRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@RequiredArgsConstructor
@Service
public class BeatService implements IBeatService{

    private final IBeatRepository iBeatRepository;
    
    @Override
    public List<Beat> getAllBeats() {
        return iBeatRepository.findAll();
    }

    @Override
    public Beat saveBeat(Beat newBeat) {
        return iBeatRepository.save(newBeat);
    }

    @Override
    public Beat findBeatById(Long id) throws IdNotFoundException, HibernateOperationException{

        Optional<Beat> beatOptional;
        try {
            beatOptional = iBeatRepository.findById(id) ;
        } catch (Exception e) {
            throw new HibernateOperationException("Error con hibernate: " + e.getMessage());
        }

        if (beatOptional.isPresent()) {
            Beat beat =  beatOptional.get();
            return beat;
        } else {
            throw new IdNotFoundException("Beat no encontrado: " + id);
        }
    }

    @Override
    public List<Beat> getAllBeatsByIdProductor(Long id) {

        return iBeatRepository.findByProductorId(id);

    }



}
