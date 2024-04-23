package nocountry.beathub.controller;

import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import nocountry.beathub.dto.request.UsuarioLoginDTO;
import nocountry.beathub.dto.response.ArtistaDTORes;
import nocountry.beathub.exception.ArtistaExistException;
import nocountry.beathub.exception.HibernateOperationException;
import nocountry.beathub.exception.IncorrectPasswordException;
import nocountry.beathub.exception.UsernameNotFoundException;
import nocountry.beathub.model.Artista;
import nocountry.beathub.service.IArtistaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/artista")
public class ArtistaController {


    @Autowired
    private IArtistaService artistaService;

    @Operation(
            summary = "Registra un artista",
            description = ""
    )
    @PostMapping("/register")
    public ResponseEntity<Object> registerArtista(@RequestBody @Valid Artista artista) {
        try {
            boolean estadoRegistro = artistaService.registerArtista(artista);
            if (estadoRegistro) {
                return ResponseEntity.ok().body("{\"message\": \"Usuario registrado exitosamente.\"}");
            }
        } catch (ArtistaExistException e) {
            return ResponseEntity.badRequest().body("{\"error\": \"El nombre de usuario ya fue registrado.\"}");
        } catch (HibernateOperationException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("{\"error\": \"Error interno del servidor al intentar registrar el usuario.\"}");
        }

        // Si el estado de registro es falso (algo inesperado ocurrió)
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("{\"error\": \"Error desconocido al intentar registrar el usuario.\"}");
    }

    @Operation(
            summary = "Autentica un artista",
            description = ""
    )
    @PostMapping("/login")
    public ResponseEntity<Object> loginUser(@RequestBody @Valid UsuarioLoginDTO usuarioLogin) {
        try {
            ArtistaDTORes authenticated = artistaService.loginUser(usuarioLogin.getUsername(), usuarioLogin.getPassword());
            if (authenticated != null) {
                return ResponseEntity.ok().body(authenticated);
            } else {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("{\"error\": \"Nombre de usuario o contraseña incorrectos\"}");
            }
        } catch (UsernameNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\": \"Nombre de usuario no encontrado\"}");
        } catch (IncorrectPasswordException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("{\"error\": \"Contraseña incorrecta\"}");
        } catch (HibernateOperationException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("{\"error\": \"Error interno del servidor\"}");
        }
    }

    @Operation(
            summary = "Obtiene todos los artistas",
            description = ""
    )
    @GetMapping("/artistas")
    public ResponseEntity<List<Artista>> findAllArtistas() {
        List<Artista> artistas = artistaService.findAllArtistas();
        return new ResponseEntity<>(artistas, HttpStatus.OK);
    }

    @Operation(
            summary = "Obtiene un artista por su ID",
            description = "Obtiene un artista especifico almacenado la base de datos"
    )
    @GetMapping("/{id}")
    public ResponseEntity<Object> findArtistaById(@PathVariable Long id) {
        try {
            Artista artista = artistaService.findArtistaById(id);
            return ResponseEntity.ok().body(artista);
        } catch (UsernameNotFoundException e) {
              return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\": \"Artista no encontrado\"}");


        } catch (HibernateOperationException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("{\"error\": \"Error interno del servidor\"}");
        }
    }


//    @Operation(
//            summary = "Trae un artista",
//            description = "Busca un artista por id"
//    )
//    @GetMapping("/{userId}")
//    public String getUser(@PathVariable Long artista){
//        return "Prueba";
//    }
}
