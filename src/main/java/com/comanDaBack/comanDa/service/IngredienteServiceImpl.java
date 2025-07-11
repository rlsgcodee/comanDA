package com.comanDaBack.comanDa.service;


import com.comanDaBack.comanDa.dto.IngredienteRequestDTO;
import com.comanDaBack.comanDa.dto.IngredienteResponseDTO;
import com.comanDaBack.comanDa.entity.Categoria;
import com.comanDaBack.comanDa.entity.Ingrediente;
import com.comanDaBack.comanDa.entity.Menu;
import com.comanDaBack.comanDa.exception.custom.DuplicadoException;
import com.comanDaBack.comanDa.exception.custom.NotFoundException;
import com.comanDaBack.comanDa.mapper.IngredienteRequestMapper;
import com.comanDaBack.comanDa.mapper.IngredienteResponseMapper;
import com.comanDaBack.comanDa.repository.CategoriaRepository;
import com.comanDaBack.comanDa.repository.IngredienteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class IngredienteServiceImpl implements IngredienteService {
    private final IngredienteRepository ingredienteRepository;
    private final IngredienteRequestMapper ingredienteRequestMapper;
    private final IngredienteResponseMapper ingredienteResponseMapper;
    private final CategoriaRepository categoriaRepository;

    @Override
    public List<IngredienteResponseDTO> listarIngredientes() {
        List<Ingrediente> ingredientes = ingredienteRepository.findAll();
        return ingredientes.stream().map(ingredienteResponseMapper::toDTO).toList();
    }


    @Override
    public IngredienteResponseDTO guardarIngrediente(IngredienteRequestDTO ingredienteRequestDTO) {

        Categoria categoria = categoriaRepository.findById(ingredienteRequestDTO.getIdCategoria())
                .orElseThrow(() -> new NotFoundException("No se encontró la categoría"));

        validarIngrediente(ingredienteRequestDTO.getNombreIngrediente());
        Ingrediente ingrediente = ingredienteRequestMapper.toIngrediente(ingredienteRequestDTO);


        ingrediente.setCategoria(categoria);
        ingrediente.setUltimaActualizacion(LocalDateTime.now());

        Ingrediente nuevoIngrediente = ingredienteRepository.save(ingrediente);

        return ingredienteResponseMapper.toDTO(nuevoIngrediente);
    }

    @Override
    public IngredienteResponseDTO modificarIngrediente(Long idIngrediente, IngredienteRequestDTO ingredienteRequestDTO) {
        Categoria categoria = categoriaRepository.findById(ingredienteRequestDTO.getIdCategoria()).orElseThrow(() -> new NotFoundException("No se encontró la categoria"));
        validarIngrediente(ingredienteRequestDTO.getNombreIngrediente());
        Ingrediente ingrediente = ingredienteRepository.findById(idIngrediente).orElseThrow(() -> new NotFoundException("No se encontró el ingrediente"));

        ingredienteRequestMapper.updateIngredienteFromDTO(ingredienteRequestDTO , ingrediente);
        ingrediente.setCategoria(categoria);
        ingrediente.setUltimaActualizacion(LocalDateTime.now());
        Ingrediente ingredienteActualizado = ingredienteRepository.save(ingrediente);
    return ingredienteResponseMapper.toDTO(ingredienteActualizado);
    }


    @Override
    public List<IngredienteResponseDTO> findByNombreIngrediente(String nombreIngrediente) {
       List<Ingrediente> ingredientes = ingredienteRepository.findByNombreIngredienteContainingIgnoreCase(nombreIngrediente);

        return ingredientes.stream().map(ingredienteResponseMapper::toDTO).toList();
    }
//lo puedo mejorar
    @Override
    public void eliminarIngrediente(Long idIngrediente) {
      ingredienteRepository.deleteById(idIngrediente);
    }


    //*******
    private void validarIngrediente(String nombreIngrediente){
        if (ingredienteRepository.existsByNombreIngrediente(nombreIngrediente)){
            throw new DuplicadoException("El nombre del ingrediente ya existe");
        }
    }

}
