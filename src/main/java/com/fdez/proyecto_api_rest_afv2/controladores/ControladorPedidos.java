package com.fdez.proyecto_api_rest_afv2.controladores;

import com.fdez.proyecto_api_rest_afv2.modelo.CategoriasClass;
import com.fdez.proyecto_api_rest_afv2.modelo.ICategoriasDAO;
import com.fdez.proyecto_api_rest_afv2.modelo.IPedidosDAO;
import com.fdez.proyecto_api_rest_afv2.modelo.PedidosClass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@RestController
@RequestMapping(value="/api-rest/pedidos")
public class ControladorPedidos {

    @Autowired
    private IPedidosDAO pedidosDAO;

    @GetMapping
    public List<PedidosClass> buscarPedidos(){return (List<PedidosClass>) pedidosDAO.findAll();}

    @GetMapping("/{id}")
    public ResponseEntity<PedidosClass> buscarPedidoPorId(
            @PathVariable(value = "id") int id
    ){
        Optional<PedidosClass> pedido = pedidosDAO.findById(id);

        if(pedido.isPresent()){
            return ResponseEntity.ok().body(pedido.get());
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public PedidosClass guardarPedido(
            @Validated @RequestBody PedidosClass pedido ){
        return pedidosDAO.save(pedido);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> borrarPedido(
            @PathVariable(value = "id") int id
    ){
        Optional<PedidosClass> pedido = pedidosDAO.findById(id);

        if (pedido.isPresent()){
            pedidosDAO.deleteById(id);
            return ResponseEntity.ok().body("Borrado");
        }else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<PedidosClass> editarPedidoPorId(
            @PathVariable(value = "id") int id,
            @Validated @RequestBody PedidosClass pedidoedit
    ){
        Optional<PedidosClass> categoria = pedidosDAO.findById(id);

        if(categoria.isPresent()){
            pedidosDAO.save(pedidoedit);
            return ResponseEntity.ok().body(pedidoedit);
        }else {
            return ResponseEntity.notFound().build();
        }
    }
}
