package com.fdez.proyecto_api_rest_afv2.controladores;

import com.fdez.proyecto_api_rest_afv2.modelo.CategoriasClass;
import com.fdez.proyecto_api_rest_afv2.modelo.ICategoriasDAO;
import com.fdez.proyecto_api_rest_afv2.modelo.IProductosDAO;
import com.fdez.proyecto_api_rest_afv2.modelo.ProductosClass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/api-rest/productos")
public class ControladorProductos {
    @Autowired
    private IProductosDAO productosDAO;

    @GetMapping
    public List<ProductosClass> buscarProducto(){return (List<ProductosClass>) productosDAO.findAll();}

    @GetMapping("/{id}")
    public ResponseEntity<ProductosClass> buscarproductoPorId(
            @PathVariable(value = "id") int id
    ){
        Optional<ProductosClass> categoria = productosDAO.findById(id);

        if(categoria.isPresent()){
            return ResponseEntity.ok().body(categoria.get());
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<?> guardarProducto(
            @Validated @RequestBody ProductosClass producto ){

        if(productosDAO.findById(producto.getCategoriaId()).isPresent()){
            return ResponseEntity.ok(productosDAO.save(producto));
        }else {
            return ResponseEntity.badRequest().body("El id de la categoria no existe");
        }
        //return productosDAO.save(producto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> borrarProducto(
            @PathVariable(value = "id") int id
    ){
        Optional<ProductosClass> categoria = productosDAO.findById(id);

        if (categoria.isPresent()){
            productosDAO.deleteById(id);
            return ResponseEntity.ok().body("Borrado");
        }else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductosClass> editarProductoPorId(
            @PathVariable(value = "id") int id,
            @Validated @RequestBody ProductosClass productoedit
    ){
        Optional<ProductosClass> categoria = productosDAO.findById(id);

        if(categoria.isPresent()){
            productosDAO.save(productoedit);
            return ResponseEntity.ok().body(productoedit);
        }else {
            return ResponseEntity.notFound().build();
        }
    }
}
