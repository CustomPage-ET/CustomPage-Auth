package custompage.auth.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EmpresaDTO {
    private Long idEmpresa;
    @NotBlank(message = "El RUT de la empresa es obligatorio")
    private String rutEmpresa;
    @NotBlank(message = "La razón social es obligatoria")
    private String razonSocial;
    @NotBlank(message = "La dirección es obligatoria")
    private String direccion;
}