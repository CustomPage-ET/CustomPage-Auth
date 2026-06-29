package custompage.auth.controller;

import custompage.auth.dto.EmpresaDTO;
import custompage.auth.service.IEmpresaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/empresas")
public class EmpresaController {
    private final IEmpresaService service;
    public EmpresaController(IEmpresaService service) { this.service = service; }

    @PostMapping
    public ResponseEntity<EmpresaDTO> crear(@RequestBody EmpresaDTO dto) { return ResponseEntity.ok(service.guardar(dto)); }

    @GetMapping("/{id}")
    public ResponseEntity<EmpresaDTO> obtener(@PathVariable Long id) { return ResponseEntity.ok(service.buscarPorId(id)); }
}