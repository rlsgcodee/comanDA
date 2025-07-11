package com.comanDaBack.comanDa.service;

import com.comanDaBack.comanDa.dto.MovimientoStockRequestDTO;
import com.comanDaBack.comanDa.dto.MovimientoStockResponseDTO;
import com.comanDaBack.comanDa.entity.Ingrediente;
import com.comanDaBack.comanDa.entity.MovimientoStock;
import com.comanDaBack.comanDa.entity.TipoMovimiento;
import com.comanDaBack.comanDa.exception.custom.NotFoundException;
import com.comanDaBack.comanDa.mapper.MovimientoResponseMapper;
import com.comanDaBack.comanDa.mapper.MovimientoStockMapper;
import com.comanDaBack.comanDa.repository.IngredienteRepository;
import com.comanDaBack.comanDa.repository.MovimientoStockRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor

public class MovimientoStockImpl implements MovimientoStockService {
    private final MovimientoStockRepository movimientoStockRepository;
    private final MovimientoStockMapper movimientoStockMapper;
    private final MovimientoResponseMapper movimientoResponseMapper;
    private final IngredienteRepository ingredienteRepository;

    @Override
    public MovimientoStockResponseDTO guardarMovimientoStock(MovimientoStockRequestDTO movimientoStockRequestDTO) {
        MovimientoStock movimientoStock = movimientoStockMapper.toEntity(movimientoStockRequestDTO);

        Ingrediente ingrediente = ingredienteRepository.findById(movimientoStockRequestDTO.getIdIngrediente()).orElseThrow(() -> new NotFoundException("No se encontro el ingrediente"));

        movimientoStock.setIngrediente(ingrediente);

        int cantidad = movimientoStock.getCantidad();
        if (movimientoStock.getTipoMovimiento()  == TipoMovimiento.ENTRADA){
            ingrediente.setStockActual(ingrediente.getStockActual() + cantidad);
        } else if (movimientoStock.getTipoMovimiento() == TipoMovimiento.SALIDA) {
           int nuevoStock = ingrediente.getStockActual() - cantidad;
           if (nuevoStock < 0){
               throw new IllegalArgumentException("Stock insuficiente para realizar la salida");
           }
           ingrediente.setStockActual(nuevoStock);
        }
        movimientoStock.setFechaMovimiento(LocalDateTime.now());
        movimientoStockRepository.save(movimientoStock);
        ingredienteRepository.save(ingrediente);

        return movimientoResponseMapper.toDTO(movimientoStock);
    }

    @Override
    public List<MovimientoStockResponseDTO> listarMovimientos() {
        List<MovimientoStock> movimientoStocks = movimientoStockRepository.findAll();
        return movimientoStocks.stream().map(movimientoResponseMapper::toDTO).toList();
    }
}
