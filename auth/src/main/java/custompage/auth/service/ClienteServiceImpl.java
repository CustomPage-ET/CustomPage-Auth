package custompage.auth.service;

import custompage.auth.dto.ClienteDTO;
import custompage.auth.exception.ResourceNotFoundException;
import custompage.auth.model.Cliente;
import custompage.auth.repository.ClienteRepository;
import custompage.auth.service.IClienteService;
import org.springframework.stereotype.Service;

@Service
public class ClienteServiceImpl implements IClienteService {
    private final ClienteRepository repo;
    public ClienteServiceImpl(ClienteRepository repo) { this.repo = repo; }

    @Override
    public ClienteDTO guardar(ClienteDTO dto) {
        Cliente c = Cliente.builder().rutCliente(dto.getRutCliente()).nombre(dto.getNombre()).telefono(dto.getTelefono()).direccionEnvio(dto.getDireccionEnvio()).build();
        c = repo.save(c);
        dto.setIdCliente(c.getIdCliente());
        return dto;
    }

    @Override
    public ClienteDTO buscarPorId(Long id) {
        Cliente c = repo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Cliente no encontrado"));
        return ClienteDTO.builder().idCliente(c.getIdCliente()).rutCliente(c.getRutCliente()).nombre(c.getNombre()).telefono(c.getTelefono()).direccionEnvio(c.getDireccionEnvio()).build();
    }
}