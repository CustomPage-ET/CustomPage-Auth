package custompage.auth.service;

import custompage.auth.dto.EmpresaDTO;
import custompage.auth.exception.ResourceNotFoundException;
import custompage.auth.model.Empresa;
import custompage.auth.repository.EmpresaRepository;
import custompage.auth.service.IEmpresaService;
import org.springframework.stereotype.Service;

@Service
public class EmpresaServiceImpl implements IEmpresaService {
    private final EmpresaRepository repo;
    public EmpresaServiceImpl(EmpresaRepository repo) { this.repo = repo; }

    @Override
    public EmpresaDTO guardar(EmpresaDTO dto) {
        Empresa e = Empresa.builder().rutEmpresa(dto.getRutEmpresa()).razonSocial(dto.getRazonSocial()).direccion(dto.getDireccion()).build();
        e = repo.save(e);
        dto.setIdEmpresa(e.getIdEmpresa());
        return dto;
    }

    @Override
    public EmpresaDTO buscarPorId(Long id) {
        Empresa e = repo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Empresa no encontrada"));
        return EmpresaDTO.builder().idEmpresa(e.getIdEmpresa()).rutEmpresa(e.getRutEmpresa()).razonSocial(e.getRazonSocial()).direccion(e.getDireccion()).build();
    }
}