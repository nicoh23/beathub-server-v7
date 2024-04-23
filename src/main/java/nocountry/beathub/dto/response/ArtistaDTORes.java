package nocountry.beathub.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import nocountry.beathub.model.Licencia;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ArtistaDTORes {
    private Long id;
    private String name;
    private String lastname;
    private String username;
    private String email;
    private String generoMusical;
    private Integer experiencia;
    private List<Licencia> misLicencias;
}
