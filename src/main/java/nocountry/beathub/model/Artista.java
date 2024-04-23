package nocountry.beathub.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Artista extends Usuario {


    private String generoMusical;
    private Integer experiencia;

    @OneToMany
    private List<Licencia> misLicencias;

}
