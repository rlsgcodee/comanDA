package com.comanDaBack.comanDa.service;


import com.comanDaBack.comanDa.dto.AdministradorDTO;
import com.comanDaBack.comanDa.dto.AdministradorRequestDTO;
import com.comanDaBack.comanDa.entity.Administrador;
import com.comanDaBack.comanDa.exception.custom.DuplicadoException;
import com.comanDaBack.comanDa.exception.custom.NotFoundException;
import com.comanDaBack.comanDa.mapper.AdministradorMapper;
import com.comanDaBack.comanDa.mapper.AdministradorRequestMapper;
import com.comanDaBack.comanDa.repository.AdministradorRepository;
import com.comanDaBack.comanDa.security.entity.Role;
import com.comanDaBack.comanDa.security.entity.RoleEnum;
import com.comanDaBack.comanDa.security.entity.Usuario;
import com.comanDaBack.comanDa.security.repository.RoleRepository;
import com.comanDaBack.comanDa.security.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class AdministradorServiceImpl implements AdministradorService {
    private final AdministradorRepository administradorRepository;
    private final UserRepository usuarioRepository;
    private final PasswordEncoder passwordEncoder;
    private final AdministradorMapper administradorMapper;
    private final AdministradorRequestMapper administradorRequestMapper;
    private final RoleRepository roleRepository;


    @Override
    @Transactional
    public AdministradorDTO crearAdministrador(AdministradorRequestDTO dto) {
        if (administradorRepository.count() > 0) {
            throw new IllegalStateException("Ya existe un administrador en el sistema");
        }

        validarUsername(dto.getUsername());

        Usuario usuario = administradorRequestMapper.toUsuario(dto);
        usuario.setPassword(passwordEncoder.encode(dto.getPassword()));

        Role rolAdmin = roleRepository.findByRoleEnum(RoleEnum.ADMIN)
                .orElseThrow(() -> new NotFoundException("Rol ADMIN no encontrado"));
        usuario.setRole(rolAdmin);

        Usuario usuarioGuardado = usuarioRepository.save(usuario);

        Administrador administrador = administradorRequestMapper.toAdministrador(dto);
        administrador.setIdUsuario(usuarioGuardado);
        administrador.setFechaAlta(LocalDateTime.now());

        Administrador administradorGuardado = administradorRepository.save(administrador);
        return administradorMapper.toDTO(administradorGuardado);
    }


    private void validarUsername(String username){
        // 1. Validar si el username ya existe
        if (usuarioRepository.existsByUsername(username)) {
            throw new DuplicadoException("El nombre de usuario ya está en uso");
        }
    }
    public boolean existeAdministrador() {
        return administradorRepository.count() > 0;
    }

}
