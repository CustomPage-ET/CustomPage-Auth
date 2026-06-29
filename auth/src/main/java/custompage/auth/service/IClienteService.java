package custompage.auth.service;
import custompage.auth.dto.ClienteDTO;

public interface IClienteService {
    ClienteDTO guardar(ClienteDTO dto);
    ClienteDTO buscarPorId(Long id);
}