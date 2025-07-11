package com.comanDaBack.comanDa.repository;

import com.comanDaBack.comanDa.entity.Menu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MenuRepository extends JpaRepository<Menu,Long> {
    boolean existsByNombreMenu(String nombreMenu);
    List<Menu> findByNombreMenuContainingIgnoreCase(String nombreMenu);
}
