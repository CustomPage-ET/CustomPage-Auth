package custompage.auth.service;
import custompage.auth.dto.EmpresaDTO;

public interface IEmpresaService {
    EmpresaDTO guardar(EmpresaDTO dto);
    EmpresaDTO buscarPorId(Long id);
}