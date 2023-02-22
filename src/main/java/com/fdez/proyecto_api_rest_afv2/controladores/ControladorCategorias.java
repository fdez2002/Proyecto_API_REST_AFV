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
@RequestMapping(value = "/api-rest/categorias")
public class ControladorCategorias {
    @Autowired
    private ICategoriasDAO categoriasDAO;

    @GetMapping
    public List<CategoriasClass> buscarCategoria(){return (List<CategoriasClass>) categoriasDAO.findAll();}

    @GetMapping("/{id}")
    public ResponseEntity<CategoriasClass> buscarCategoriaPorId(
            @PathVariable(value = "id") int id
    ){
        Optional<CategoriasClass> categoria = categoriasDAO.findById(id);

        if(categoria.isPresent()){
            return ResponseEntity.ok().body(categoria.get());
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public CategoriasClass guardarCategoria(
            @Validated @RequestBody CategoriasClass categoria ){
        return categoriasDAO.save(categoria);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> borrarEmpleado(
            @PathVariable(value = "id") int id
    ){
        Optional<CategoriasClass> categoria = categoriasDAO.findById(id);

        if (categoria.isPresent()){
            categoriasDAO.deleteById(id);
            return ResponseEntity.ok().body("Borrado");
        }else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<CategoriasClass> editarCategoriaPorId(
            @PathVariable(value = "id") int id,
            @Validated @RequestBody CategoriasClass categoriaedit
    ){
        Optional<CategoriasClass> categoria = categoriasDAO.findById(id);

        if(categoria.isPresent()){
            categoriasDAO.save(categoriaedit);
            return ResponseEntity.ok().body(categoriaedit);
        }else {
            return ResponseEntity.notFound().build();
        }
    }
}
