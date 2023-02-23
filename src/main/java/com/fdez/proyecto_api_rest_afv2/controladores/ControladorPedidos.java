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
@RequestMapping(value="/api-rest/pedidos")//mapea la solicitud HTTP
public class ControladorPedidos {

    @Autowired
    private IPedidosDAO pedidosDAO;

    /**
     * Nos devuelve todos los pedidos
     * @return
     */
    @GetMapping
    public List<PedidosClass> buscarPedidos(){return (List<PedidosClass>) pedidosDAO.findAll();}

    /**
     * Nos devuelve el pedido que le pasamos con un id
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public ResponseEntity<PedidosClass> buscarPedidoPorId(
            @PathVariable(value = "id") int id
    ){
        //busca la categoria
        Optional<PedidosClass> pedido = pedidosDAO.findById(id);

        if(pedido.isPresent()){
            //si exite la mostrara
            return ResponseEntity.ok().body(pedido.get());
        }else{
            //si no la ha encontrado devolvera el codigo de estado 404
            return ResponseEntity.notFound().build();
        }
    }

    /**
     * Guardamos un nuevo pedido, al aumnetar automaticamente el id por la base de datos,
     * no sera necesario comprobar si ese id existe
     * @param pedido
     * @return
     */
    @PostMapping
    public PedidosClass guardarPedido(
            @Validated @RequestBody PedidosClass pedido ){
        //guarda el pedido en la base de datos
        return pedidosDAO.save(pedido);
    }

    /**
     * Eliminamos el pedido pasada por el id
     * @param id
     * @return
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<?> borrarPedido(
            @PathVariable(value = "id") int id
    ){
        //buscamos el pedido en la base de datos
        Optional<PedidosClass> pedido = pedidosDAO.findById(id);

        if (pedido.isPresent()){
            //si exite la eliminara mostrando el texto de "Borrado"
            pedidosDAO.deleteById(id);
            return ResponseEntity.ok().body("Borrado");
        }else {
            return ResponseEntity.notFound().build();
        }
    }

    /**
     * Eitamos el pedido que le pasemos por el id
     * @param id
     * @param pedidoedit
     * @return
     */
    @PutMapping("/{id}")
    public ResponseEntity<PedidosClass> editarPedidoPorId(
            @PathVariable(value = "id") int id,
            @Validated @RequestBody PedidosClass pedidoedit
    ){
        //buscamos el id
        Optional<PedidosClass> categoria = pedidosDAO.findById(id);

        if(categoria.isPresent()){
            //si existe lo editara con los nuevos valores
            pedidosDAO.save(pedidoedit);
            return ResponseEntity.ok().body(pedidoedit);
        }else {
            //muestra el codigo de error 404
            return ResponseEntity.notFound().build();
        }
    }
}
