package custompage.auth.controller;

import custompage.auth.dto.*;
import custompage.auth.service.IAuthService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    private final IAuthService service;
    public AuthController(IAuthService service) { this.service = service; }

    @PostMapping("/register")
    public ResponseEntity<UsuarioDTO> registrar(@Validated @RequestBody UsuarioDTO dto) {
        return ResponseEntity.ok(service.registrarUsuario(dto));
    }

    @PostMapping("/login")
    public ResponseEntity<JwtResponseDTO> login(@Validated @RequestBody LoginRequestDTO dto) {
        return ResponseEntity.ok(service.login(dto));
    }
}