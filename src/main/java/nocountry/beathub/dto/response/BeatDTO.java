package nocountry.beathub.dto.response;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class BeatDTO {
    private Long idBeat;
    private String nombre;
    private String url;
    private Double precio;
}
