package com.comanDaBack.comanDa.service;

import com.comanDaBack.comanDa.dto.CategoriaIngreResponseDTO;
import com.comanDaBack.comanDa.dto.CategoriaIngredienteDTO;
import com.comanDaBack.comanDa.dto.CategoriaMenuDTO;
import com.comanDaBack.comanDa.dto.CategoriaMenuResponseDTO;
import com.comanDaBack.comanDa.entity.Categoria;
import com.comanDaBack.comanDa.entity.TipoCategoria;
import com.comanDaBack.comanDa.exception.custom.NotFoundException;
import com.comanDaBack.comanDa.mapper.CategoriaIngredienteMapper;
import com.comanDaBack.comanDa.mapper.CategoriaIngredienteResponseMapper;
import com.comanDaBack.comanDa.mapper.CategoriaMenuMapper;
import com.comanDaBack.comanDa.mapper.CategoriaMenuResponseMapper;
import com.comanDaBack.comanDa.repository.CategoriaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
@RequiredArgsConstructor
public class CategoriaServiceImpl implements CategoriaService{
    private final CategoriaRepository categoriaRepository;
    private final CategoriaIngredienteMapper categoriaIngredienteMapper;
    private final CategoriaMenuMapper categoriaMenuMapper;
    private final CategoriaMenuResponseMapper categoriaMenuResponseMapper;
    private final CategoriaIngredienteResponseMapper categoriaIngredienteResponseMapper;

    @Override
    public CategoriaIngredienteDTO guardarCategoriaIngrediente(CategoriaIngredienteDTO categoriaIngredienteDTO) {
        Categoria categoriaIngrediente = categoriaIngredienteMapper.toEntity(categoriaIngredienteDTO);
        categoriaIngrediente.setTipoCategoria(TipoCategoria.INGREDIENTE);
        Categoria nuevaCategoriaIngrediente = categoriaRepository.save(categoriaIngrediente);
        return categoriaIngredienteMapper.toDTO(nuevaCategoriaIngrediente);
    }

    @Override
    public CategoriaMenuDTO guardarCategoriaMenu(CategoriaMenuDTO categoriaMenuDTO) {
        Categoria categoriaMenu = categoriaMenuMapper.toEntity(categoriaMenuDTO);
        categoriaMenu.setTipoCategoria(TipoCategoria.MENU);
        Categoria nuevaCategoriaMenu = categoriaRepository.save(categoriaMenu);
        return categoriaMenuMapper.toDTO(nuevaCategoriaMenu);
    }

    @Override
    public List<CategoriaIngredienteDTO> listarCatIngCreadas() {
        List<Categoria> categorias = categoriaRepository.findByTipoCategoria(TipoCategoria.INGREDIENTE);
        return categorias.stream().map(categoriaIngredienteMapper::toDTO).toList();
    }

    @Override
    public List<CategoriaMenuDTO> listarCatMenuCreadas() {
        List<Categoria> categorias = categoriaRepository.findByTipoCategoria(TipoCategoria.INGREDIENTE);
        return categorias.stream().map(categoriaMenuMapper::toDTO).toList();
    }

    @Override
    public CategoriaIngreResponseDTO listarIngredienteConCategoria(Long idCategoria) {
        Categoria categoria = categoriaRepository.findCategoriaIngredienteConIngredientePorId(idCategoria).orElseThrow(() -> new NotFoundException("Categoria no encontrada"));
        return categoriaIngredienteResponseMapper.toDTO(categoria);
    }

    @Override
    public CategoriaMenuResponseDTO listarMenuConCategoria(Long idCategoria){
        Categoria categoria = categoriaRepository.findCategoriaMenuConMenusPorId(idCategoria).orElseThrow(() -> new NotFoundException("Categoria no encontrada"));
        return categoriaMenuResponseMapper.toDTO(categoria);
    }


}
