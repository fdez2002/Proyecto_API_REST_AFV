package com.fdez.proyecto_api_rest_afv2.controladores;

import com.fdez.proyecto_api_rest_afv2.modelo.CategoriasClass;
import com.fdez.proyecto_api_rest_afv2.modelo.ICategoriasDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/api-rest/categorias")//mapea la solicitud HTTP
public class ControladorCategorias {
    @Autowired
    private ICategoriasDAO categoriasDAO;

    /**
     * Nos devuelve todas las categorias
     * @return
     */
    @GetMapping
    public List<CategoriasClass> buscarCategoria(){return (List<CategoriasClass>) categoriasDAO.findAll();}

    /**
     * Nos devuelve la categoria que le pasamos con un id
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public ResponseEntity<CategoriasClass> buscarCategoriaPorId(
            @PathVariable(value = "id") int id
    ){
        //busca la categoria
        Optional<CategoriasClass> categoria = categoriasDAO.findById(id);

        if(categoria.isPresent()){
            //si exite la mostrara
            return ResponseEntity.ok().body(categoria.get());
        }else{
            //si no la ha encontrado devolvera el codigo de estado 404
            return ResponseEntity.notFound().build();
        }
    }

    /**
     * Guardamos una nueva categoria, al aumnetar automaticamente el id por la base de datos,
     * no sera necesario comprobar si ese id existe
     * @param categoria
     * @return
     */
    @PostMapping
    public CategoriasClass guardarCategoria(
            @Validated @RequestBody CategoriasClass categoria ){
        //guarda la nueva categoria en la base de datos
        return categoriasDAO.save(categoria);
    }

    /**
     * Eliminamos una categoria pasada por el id
     * @param id
     * @return
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<?> borrarCategoria(
            @PathVariable(value = "id") int id
    ){
        //buscamos la categoria en la base de datos
        Optional<CategoriasClass> categoria = categoriasDAO.findById(id);

        if (categoria.isPresent()){
            //si exite la eliminara mostrando el texto de "Borrado"
            categoriasDAO.deleteById(id);
            return ResponseEntity.ok().body("Borrado");
        }else {
            return ResponseEntity.notFound().build();
        }
    }

    /**
     * Eitamos la categoria que le pasemos por el id
     * @param id
     * @param categoriaedit
     * @return
     */
    @PutMapping("/{id}")
    public ResponseEntity<CategoriasClass> editarCategoriaPorId(
            @PathVariable(value = "id") int id,
            @Validated @RequestBody CategoriasClass categoriaedit
    ){
        //buscamos el id
        Optional<CategoriasClass> categoria = categoriasDAO.findById(id);

        if(categoria.isPresent()){
            //si existe lo editara con los nuevos valores
            categoriasDAO.save(categoriaedit);
            return ResponseEntity.ok().body(categoriaedit);
        }else {
            //muestra el codigo de error 404
            return ResponseEntity.notFound().build();
        }
    }
}
