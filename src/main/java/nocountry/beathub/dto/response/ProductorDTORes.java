package nocountry.beathub.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductorDTORes {
    private Long id;
    private String name;
    private String lastname;
    private String username;
    private String email;
    private String descripcion;
}
