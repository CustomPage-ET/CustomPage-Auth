package custompage.auth.service;
import custompage.auth.dto.*;

public interface IAuthService {
    UsuarioDTO registrarUsuario(UsuarioDTO usuarioDTO);
    JwtResponseDTO login(LoginRequestDTO loginDTO);
}