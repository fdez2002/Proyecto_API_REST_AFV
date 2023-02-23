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
@RequestMapping(value = "/api-rest/productos")//mapea la solicitud HTTP
public class ControladorProductos {
    @Autowired
    private IProductosDAO productosDAO;

    /**
     * Busca y muestra todos los productos
     * @return
     */
    @GetMapping
    public List<ProductosClass> buscarProducto(){return (List<ProductosClass>) productosDAO.findAll();}

    /**
     * Nos devuelve el producto que le pasamos con un id
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public ResponseEntity<ProductosClass> buscarproductoPorId(
            @PathVariable(value = "id") int id
    ){
        //busca el producto
        Optional<ProductosClass> categoria = productosDAO.findById(id);

        if(categoria.isPresent()){
            //si exite lo mostrara
            return ResponseEntity.ok().body(categoria.get());
        }else{
            //si no la ha encontrado devolvera el codigo de estado 404
            return ResponseEntity.notFound().build();
        }
    }

    /**
     * Guardamos un nuevo producto, al aumnetar automaticamente el id por la base de datos,
     * no sera necesario comprobar si ese id existe.
     * Aqui se hace la comprobacion de la existencia del id de la categoria
     * @param producto
     * @return
     */
    @PostMapping
    public ResponseEntity<?> guardarProducto(
            @Validated @RequestBody ProductosClass producto ){
        //buscamos la existencia del id de la categoria
        if(productosDAO.findById(producto.getCategoriaId()).isPresent()){
            //si existe lo guardará
            return ResponseEntity.ok(productosDAO.save(producto));
        }else {
            //si no mostrara un mensaje de que no existe el id de la categoria
            return ResponseEntity.badRequest().body("El id de la categoria no existe");
        }
        //return productosDAO.save(producto);
    }

    /**
     * Borramnos un producto
     * @param id
     * @return
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<?> borrarProducto(
            @PathVariable(value = "id") int id
    ){
        //buscamos el producto en la base de datos
        Optional<ProductosClass> categoria = productosDAO.findById(id);

        if (categoria.isPresent()){
            //si existe lo mostrará
            productosDAO.deleteById(id);
            return ResponseEntity.ok().body("Borrado");
        }else {
            //si no existe mostrará el error
            return ResponseEntity.notFound().build();
        }
    }

    /**
     * Eitamos el producto que le pasemos por el id
     * @param id
     * @param productoedit
     * @return
     */
    @PutMapping("/{id}")
    public ResponseEntity<ProductosClass> editarProductoPorId(
            @PathVariable(value = "id") int id,
            @Validated @RequestBody ProductosClass productoedit
    ){
        //buiscamos el id
        Optional<ProductosClass> categoria = productosDAO.findById(id);

        if(categoria.isPresent()){
            //si lo encuentra aplicara los cambios
            productosDAO.save(productoedit);
            return ResponseEntity.ok().body(productoedit);
        }else {
            return ResponseEntity.notFound().build();
        }
    }
}
