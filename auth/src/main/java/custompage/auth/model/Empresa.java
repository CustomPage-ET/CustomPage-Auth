package custompage.auth.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "empresas")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Empresa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEmpresa;

    @Column(nullable = false, unique = true, length = 15)
    private String rutEmpresa;

    @Column(nullable = false, length = 150)
    private String razonSocial;

    @Column(nullable = false, length = 200)
    private String direccion;
}