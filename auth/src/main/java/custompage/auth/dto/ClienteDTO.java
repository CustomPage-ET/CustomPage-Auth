package custompage.auth.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ClienteDTO {
    private Long idCliente;
    @NotBlank(message = "El RUT del cliente es obligatorio")
    private String rutCliente;
    @NotBlank(message = "El nombre es obligatorio")
    private String nombre;
    private String telefono;
    @NotBlank(message = "La dirección de envío es obligatoria")
    private String direccionEnvio;
}