package custompage.auth.controller;

import custompage.auth.dto.ClienteDTO;
import custompage.auth.service.IClienteService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/clientes")
public class ClienteController {
    private final IClienteService service;
    public ClienteController(IClienteService service) { this.service = service; }

    @PostMapping
    public ResponseEntity<ClienteDTO> crear(@RequestBody ClienteDTO dto) { return ResponseEntity.ok(service.guardar(dto)); }

    @GetMapping("/{id}")
    public ResponseEntity<ClienteDTO> obtener(@PathVariable Long id) { return ResponseEntity.ok(service.buscarPorId(id)); }
}