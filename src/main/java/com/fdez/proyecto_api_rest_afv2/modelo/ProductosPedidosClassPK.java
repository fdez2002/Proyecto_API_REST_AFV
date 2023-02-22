package com.fdez.proyecto_api_rest_afv2.modelo;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.io.Serializable;
import java.util.Objects;

public class ProductosPedidosClassPK implements Serializable {
    @Column(name = "producto_id", nullable = false)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int productoId;
    @Column(name = "pedido_id", nullable = false)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int pedidoId;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductosPedidosClassPK that = (ProductosPedidosClassPK) o;
        return productoId == that.productoId && pedidoId == that.pedidoId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(productoId, pedidoId);
    }
}
