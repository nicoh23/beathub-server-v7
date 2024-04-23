package nocountry.beathub.dto.request;


import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioLoginDTO {

    @NotNull(message = "No se permite un usuario vacio")
    @Size(min = 4, message = "Como mínimo debe tener 4 caracteres")
    private String username;

    @NotNull(message = "No se permite un password vacio")
    @Size(min = 4, message = "Como mínimo debe tener 4 caracteres")
    private String password;
}
