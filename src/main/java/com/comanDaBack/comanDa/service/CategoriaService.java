package com.comanDaBack.comanDa.service;

import com.comanDaBack.comanDa.dto.CategoriaIngreResponseDTO;
import com.comanDaBack.comanDa.dto.CategoriaIngredienteDTO;
import com.comanDaBack.comanDa.dto.CategoriaMenuDTO;
import com.comanDaBack.comanDa.dto.CategoriaMenuResponseDTO;
import java.util.List;


public interface CategoriaService {
    CategoriaIngredienteDTO guardarCategoriaIngrediente(CategoriaIngredienteDTO categoriaIngredienteDTO);

    CategoriaMenuDTO guardarCategoriaMenu(CategoriaMenuDTO categoriaMenuDTO);

    List<CategoriaIngredienteDTO> listarCatIngCreadas();

    List<CategoriaMenuDTO> listarCatMenuCreadas();

    CategoriaIngreResponseDTO listarIngredienteConCategoria(Long idCategoria);

    CategoriaMenuResponseDTO listarMenuConCategoria(Long idCategoria);

}
