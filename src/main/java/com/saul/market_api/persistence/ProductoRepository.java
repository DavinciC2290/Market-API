package com.saul.market_api.persistence;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.saul.market_api.domain.Product;
import com.saul.market_api.domain.repository.ProductRepository;
import com.saul.market_api.persistence.crud.ProductoCrudRepository;
import com.saul.market_api.persistence.entity.Producto;
import com.saul.market_api.persistence.mapper.ProductMapper;

@Repository
public class ProductoRepository implements ProductRepository {

     //Esta notación nos ayuda a que Spring inicialize el objeto o lo instancie. 
    @Autowired//**Solo se puede con componentes pertenecientes a Spring o al framework. */
    private ProductoCrudRepository productoCrudRepository;

    @Autowired
    private ProductMapper mapper;

    @Override
    public List<Product> getAll() {
        List<Producto> productos = (List<Producto>)productoCrudRepository.findAll();
        return mapper.toProducts(productos);
    }

    @Override
    public Optional<List<Product>> getByCategory(int categoryId) {
        List<Producto> productos = productoCrudRepository.findByIdCategoriaOrderByNombreAsc(categoryId);
        return Optional.of(mapper.toProducts(productos));
  
    }

    @Override
    public Optional<List<Product>> getScarceProducts(int quantity) {
        Optional<List<Producto>> productos = productoCrudRepository.findByCantidadStockLessThanAndEstado(quantity, true);
        return productos.map(prods -> mapper.toProducts(prods));
    }

    @Override
    public Optional<Product> getProduct(int productId) {
        return productoCrudRepository.findById(productId).map(producto -> mapper.toProduct(producto));
    }

    @Override
    public Product save(Product product) {
        Producto producto = mapper.toProducto(product);
        return mapper.toProduct(productoCrudRepository.save(producto));
    
    }

    @Override
    public void delete(int productId) {
        productoCrudRepository.deleteById(productId);
    }


    //MÉTODO findAll() HEREDADO DE LA INTERFAZ CRUD REPOSITORY
    /*public List<Producto> getAll(){
        return (List<Producto>) productoCrudRepository.findAll();
    }*/

    //QUERY METHOD
    /*public List<Producto> getByCategoria(int idCategoria){
        return productoCrudRepository.findByIdCategoriaOrderByNombreAsc(idCategoria);
    }*/

    //QUERY METHOD
    /*public Optional<List<Producto>> getEscasos(int cantidad){
        return productoCrudRepository.findByCantidadStockLessThanAndEstado(cantidad, true);
        }*/

}
