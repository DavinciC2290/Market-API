package com.saul.market_api.persistence.mapper;

import java.util.List;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import com.saul.market_api.domain.Product;
import com.saul.market_api.persistence.entity.Producto;


//Como tenemos un atributo de tipo objeto, se le agrega al @Mapper "CategoryMapper"
@Mapper(componentModel = "spring", uses = {CategoryMapper.class})
public interface ProductMapper {

    @Mappings({
        @Mapping(source ="idProducto" , target = "productId"),
        @Mapping(source ="nombre" , target = "name"),
        @Mapping(source ="idCategoria" , target = "categoryId"),
        @Mapping(source ="precioVenta" , target = "price"),
        @Mapping(source ="cantidadStock" , target = "stock"),
        @Mapping(source ="estado" , target = "active"),
        @Mapping(source ="categoria" , target = "category"),
    })
    Product toProduct(Producto producto);
    List<Product> toProducts(List<Producto> productos);

    @InheritInverseConfiguration
    @Mapping(target="codigoBarras", ignore = true)
    Producto toProducto(Product product);
   
}
