package com.comanDaBack.comanDa.repository;

import com.comanDaBack.comanDa.entity.Categoria;
import com.comanDaBack.comanDa.entity.TipoCategoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;


@Repository
public interface CategoriaRepository extends JpaRepository<Categoria , Long> {

        List<Categoria> findByTipoCategoria(TipoCategoria tipo);

        @Query("SELECT DISTINCT c FROM Categoria c LEFT JOIN FETCH c.ingredientes WHERE c.idCategoria = :idCategoria AND c.tipoCategoria = 'INGREDIENTE'")
        Optional<Categoria> findCategoriaIngredienteConIngredientePorId(@Param("idCategoria") Long idCategoria);

        @Query("SELECT DISTINCT c FROM Categoria c LEFT JOIN FETCH c.menus WHERE c.idCategoria = :idCategoria AND c.tipoCategoria = 'MENU'")
        Optional<Categoria> findCategoriaMenuConMenusPorId(@Param("idCategoria") Long idCategoria);

}
