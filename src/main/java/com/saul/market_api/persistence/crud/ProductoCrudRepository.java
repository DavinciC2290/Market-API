package com.saul.market_api.persistence.crud;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.saul.market_api.persistence.entity.Producto;

public interface ProductoCrudRepository extends CrudRepository<Producto, Integer> {

    //QUERYS METHODS
    List<Producto> findByIdCategoriaOrderByNombreAsc(int idCategoria);
    Optional<List<Producto>> findByCantidadStockLessThanAndEstado(int cantidadStock, boolean estado);
    
}
