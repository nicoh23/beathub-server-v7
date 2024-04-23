package nocountry.beathub.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Licencia {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long IdLic;


    @ManyToOne
    @JoinColumn(name = "pago_lic_id", referencedColumnName = "IdPago")
    private Pago miPago;

}
