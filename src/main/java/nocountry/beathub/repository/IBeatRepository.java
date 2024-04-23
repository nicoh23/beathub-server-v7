package nocountry.beathub.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import nocountry.beathub.model.Beat;

import java.util.List;

public interface IBeatRepository  extends JpaRepository<Beat, Long>  {

    List<Beat> findByProductorId(Long productorId);
    
}
