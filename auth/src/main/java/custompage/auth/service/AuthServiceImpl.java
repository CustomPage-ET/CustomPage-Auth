package custompage.auth.service;

import custompage.auth.config.JwtProvider;
import custompage.auth.dto.*;
import custompage.auth.model.Usuario;
import custompage.auth.repository.UsuarioRepository;
import custompage.auth.service.IAuthService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements IAuthService {

    private final UsuarioRepository usuarioRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtProvider jwtProvider;

    public AuthServiceImpl(UsuarioRepository usuarioRepository, PasswordEncoder passwordEncoder, JwtProvider jwtProvider) {
        this.usuarioRepository = usuarioRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtProvider = jwtProvider;
    }

    @Override
    public UsuarioDTO registrarUsuario(UsuarioDTO dto) {
        if(usuarioRepository.findByUsername(dto.getUsername()).isPresent()) {
            throw new RuntimeException("El nombre de usuario ya existe");
        }

        Usuario usuario = Usuario.builder()
                .username(dto.getUsername())
                .email(dto.getEmail())
                .password(passwordEncoder.encode(dto.getPassword()))
                .rol(dto.getRol().toUpperCase())
                .build();

        Usuario guardado = usuarioRepository.save(usuario);
        dto.setIdUsuario(guardado.getIdUsuario());
        dto.setPassword("******");
        return dto;
    }

    @Override
    public JwtResponseDTO login(LoginRequestDTO dto) {
        Usuario usuario = usuarioRepository.findByUsernameOrEmail(dto.getUsernameOrEmail(), dto.getUsernameOrEmail())
                .orElseThrow(() -> new RuntimeException("Credenciales inválidas"));

        if (!passwordEncoder.matches(dto.getPassword(), usuario.getPassword())) {
            throw new RuntimeException("Credenciales inválidas");
        }

        String token = jwtProvider.generateToken(usuario);

        return JwtResponseDTO.builder()
                .token(token)
                .username(usuario.getUsername())
                .rol(usuario.getRol())
                .build();
    }
}