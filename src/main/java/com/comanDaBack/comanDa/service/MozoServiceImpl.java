package com.comanDaBack.comanDa.service;


import com.comanDaBack.comanDa.dto.MozoDTO;
import com.comanDaBack.comanDa.dto.MozoRequestDTO;
import com.comanDaBack.comanDa.entity.Mozo;
import com.comanDaBack.comanDa.exception.custom.DuplicadoException;
import com.comanDaBack.comanDa.exception.custom.NotFoundException;
import com.comanDaBack.comanDa.mapper.MozoMapper;
import com.comanDaBack.comanDa.mapper.MozoRequestMapper;
import com.comanDaBack.comanDa.repository.MozoRepository;
import com.comanDaBack.comanDa.security.entity.Role;
import com.comanDaBack.comanDa.security.entity.RoleEnum;
import com.comanDaBack.comanDa.security.entity.Usuario;
import com.comanDaBack.comanDa.security.repository.RoleRepository;
import com.comanDaBack.comanDa.security.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MozoServiceImpl implements MozoService{
    private final MozoRepository mozoRepository;
    private final UserRepository usuarioRepository;
    private final PasswordEncoder passwordEncoder;
    private final MozoMapper mozoMapper;
    private final MozoRequestMapper mozoRequestMapper;
    private final RoleRepository roleRepository;

    @Override
    @Transactional
    public MozoDTO crearMozoConUsuario(MozoRequestDTO mozoRequestDTO) {
        // 1. Validar si el username ya existe
        validarUsername(mozoRequestDTO.getUsername());

        // 2. Mapear y preparar el Usuario
        Usuario usuario = mozoRequestMapper.toUsuario(mozoRequestDTO);
        usuario.setPassword(passwordEncoder.encode(mozoRequestDTO.getPassword()));

        // Buscar el rol MOZO
        Role rolMozo = roleRepository.findByRoleEnum(RoleEnum.MOZO)
                .orElseThrow(() -> new NotFoundException("Rol MOZO no encontrado"));
        usuario.setRole(rolMozo);
        Usuario usuarioGuardado = usuarioRepository.save(usuario);

        // 3. Mapear el Mozo y asignar el Usuario
        Mozo mozo = mozoRequestMapper.toMozo(mozoRequestDTO);
        mozo.setIdUsuario(usuarioGuardado);

        Mozo mozoGuardado = mozoRepository.save(mozo);

        // 4. Retornar el DTO final
        return mozoMapper.toDTO(mozoGuardado);
    }

    private void validarUsername(String username){
        // 1. Validar si el username ya existe
        if (usuarioRepository.existsByUsername(username)) {
            throw new DuplicadoException("El nombre de usuario ya está en uso");
        }
    }


}