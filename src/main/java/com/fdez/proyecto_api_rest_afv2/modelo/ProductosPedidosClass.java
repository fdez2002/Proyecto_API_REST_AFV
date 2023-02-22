package com.fdez.proyecto_api_rest_afv2.modelo;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "Productos_Pedidos", schema = "TiendaInfo", catalog = "")
@IdClass(ProductosPedidosClassPK.class)
public class ProductosPedidosClass {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "producto_id", nullable = false)
    private int productoId;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "pedido_id", nullable = false, updatable = false, insertable = false)
    private int pedidoId;
    @Basic
    @Column(name = "cantidad", nullable = true)
    private Integer cantidad;
    @ManyToOne
    @JoinColumn(name = "producto_id", referencedColumnName = "id", nullable = false, updatable = false, insertable = false)
    @JsonBackReference
    private ProductosClass productosByProductoId;
    @ManyToOne
    @JoinColumn(name = "pedido_id", referencedColumnName = "id", nullable = false, updatable = false, insertable = false)
    @JsonBackReference
    private PedidosClass pedidosByPedidoId;

    public int getProductoId() {
        return productoId;
    }

    public void setProductoId(int productoId) {
        this.productoId = productoId;
    }

    public int getPedidoId() {
        return pedidoId;
    }

    public void setPedidoId(int pedidoId) {
        this.pedidoId = pedidoId;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductosPedidosClass that = (ProductosPedidosClass) o;
        return productoId == that.productoId && pedidoId == that.pedidoId && Objects.equals(cantidad, that.cantidad);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productoId, pedidoId, cantidad);
    }

    public ProductosClass getProductosByProductoId() {
        return productosByProductoId;
    }

    public void setProductosByProductoId(ProductosClass productosByProductoId) {
        this.productosByProductoId = productosByProductoId;
    }

    public PedidosClass getPedidosByPedidoId() {
        return pedidosByPedidoId;
    }

    public void setPedidosByPedidoId(PedidosClass pedidosByPedidoId) {
        this.pedidosByPedidoId = pedidosByPedidoId;
    }
}
