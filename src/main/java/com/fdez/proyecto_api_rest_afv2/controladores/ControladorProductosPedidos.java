package com.fdez.proyecto_api_rest_afv2.controladores;

import com.fdez.proyecto_api_rest_afv2.modelo.IProductosDAO;
import com.fdez.proyecto_api_rest_afv2.modelo.IProductosPedidosDAO;
import com.fdez.proyecto_api_rest_afv2.modelo.ProductosClass;
import com.fdez.proyecto_api_rest_afv2.modelo.ProductosPedidosClass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@RestController
@RequestMapping(value="/api-rest/productosPedidos")
public class ControladorProductosPedidos {
    @Autowired
    private IProductosPedidosDAO propeDAO;

    @GetMapping
    public List<ProductosPedidosClass> buscarprope(){return (List<ProductosPedidosClass>) propeDAO.findAll();}

    @GetMapping("/{producto_id}")
    public ResponseEntity<ProductosPedidosClass> buscarproductoPedido_productoId(
            @PathVariable(value = "producto_id") int producto_id
    ){
        Optional<ProductosPedidosClass> prope = propeDAO.findById(producto_id);

        if(prope.isPresent()){
            return ResponseEntity.ok().body(prope.get());
        }else{
            return ResponseEntity.notFound().build();
        }
    }
    @GetMapping("/{pedido_id}")
    public ResponseEntity<ProductosPedidosClass> buscarproductoPedido_pedidoId(
            @PathVariable(value = "pedido_id") int pedido_id
    ){
        Optional<ProductosPedidosClass> prope = propeDAO.findById(pedido_id);

        if(prope.isPresent()){
            return ResponseEntity.ok().body(prope.get());
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ProductosPedidosClass guardarProducto(
            @Validated @RequestBody ProductosPedidosClass productoPed ){
        return propeDAO.save(productoPed);
    }

    @DeleteMapping("/{producto_id}")
    public ResponseEntity<?> borrarProductoPe_producto_Id(
            @PathVariable(value = "producto_id") int producto_id
    ){
        Optional<ProductosPedidosClass> produPe = propeDAO.findById(producto_id);

        if (produPe.isPresent()){
            propeDAO.deleteById(producto_id);
            return ResponseEntity.ok().body("Borrado");
        }else {
            return ResponseEntity.notFound().build();
        }
    }
    @DeleteMapping("/{pedido_id}")
    public ResponseEntity<?> borrarProductoPe_pedido_Id(
            @PathVariable(value = "pedido_id") int pedido_id
    ){
        Optional<ProductosPedidosClass> produPe = propeDAO.findById(pedido_id);

        if (produPe.isPresent()){
            propeDAO.deleteById(pedido_id);
            return ResponseEntity.ok().body("Borrado");
        }else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{pedido_id}")
    public ResponseEntity<ProductosPedidosClass> editarProductoPorId(
            @PathVariable(value = "pedido_id") int pedido_id,
            @Validated @RequestBody ProductosPedidosClass productoPedidoedit
    ){
        Optional<ProductosPedidosClass> categoria = propeDAO.findById(pedido_id);

        if(categoria.isPresent()){
            propeDAO.save(productoPedidoedit);
            return ResponseEntity.ok().body(productoPedidoedit);
        }else {
            return ResponseEntity.notFound().build();
        }
    }
}
