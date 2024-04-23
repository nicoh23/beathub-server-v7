package nocountry.beathub.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
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
public class Beat {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long idBeat;
    @NotBlank
    private String nombre;
    @NotBlank
    private String url;
    @NotNull
    @Column(name = "tiempo_bpm")
    private Integer tiempoBpm;
    @NotBlank
    private String tonalidad;
    @NotBlank
    private String genero;
    private String mood;
    private Boolean featured;
    @NotNull
    private Double precio;

    private Boolean comprado = false;

    @OneToOne
    private Licencia miLicencia;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="idproductor")
    private Productor productor;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<EstructuraBeat> estructurasBeat;


}
