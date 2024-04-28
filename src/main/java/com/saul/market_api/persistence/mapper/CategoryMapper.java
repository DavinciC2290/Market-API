package com.saul.market_api.persistence.mapper;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import com.saul.market_api.domain.Category;
import com.saul.market_api.persistence.entity.Categoria;


//Interfaz para realizar el Data Mapper (Traducir o convertir de persistencia a dominio)
@Mapper(componentModel = "spring")
public interface CategoryMapper {

    @Mappings(
        {
            @Mapping(source = "idCategoria", target = "categoryId"),
            @Mapping(source ="descripcion", target = "category" ),
            @Mapping(source ="estado" , target = "active")
        }
    )
    Category toCategory(Categoria categoria); //Convierte un objeto Categoria a Category

    @InheritInverseConfiguration //Notación que sirve para ya no agregar el "@Mappings con los atributos a convertir y tome el de arriba"
    @Mapping(target = "productos", ignore = true) //Le indicamos que ignore el atributo que no mapeamos en el "@mappings"
    Categoria toCategoria(Category category); //Convierte un objeto Category a Categoria




    
}
