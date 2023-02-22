package com.fdez.proyecto_api_rest_afv2.modelo;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "Productos", schema = "TiendaInfo", catalog = "")
public class ProductosClass {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private int id;
    @Basic
    @Column(name = "nombre", nullable = false, length = 50)
    private String nombre;
    @Basic
    @Column(name = "descripcion", nullable = true, length = -1)
    private String descripcion;
    @Basic
    @Column(name = "precio", nullable = true, precision = 2)
    private BigDecimal precio;
    @Basic
    @Column(name = "categoria_id", nullable = true)
    private Integer categoriaId;
    @ManyToOne
    @JoinColumn(name = "categoria_id", referencedColumnName = "id", updatable = false, insertable=false)
    @JsonIgnore
    private CategoriasClass categoriasByCategoriaId;
    @OneToMany(mappedBy = "productosByProductoId")
    @JsonIgnore
    private Collection<ProductosPedidosClass> productosPedidosById;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public BigDecimal getPrecio() {
        return precio;
    }

    public void setPrecio(BigDecimal precio) {
        this.precio = precio;
    }

    public Integer getCategoriaId() {
        return categoriaId;
    }

    public void setCategoriaId(Integer categoriaId) {
        this.categoriaId = categoriaId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductosClass that = (ProductosClass) o;
        return id == that.id && Objects.equals(nombre, that.nombre) && Objects.equals(descripcion, that.descripcion) && Objects.equals(precio, that.precio) && Objects.equals(categoriaId, that.categoriaId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nombre, descripcion, precio, categoriaId);
    }

    public CategoriasClass getCategoriasByCategoriaId() {
        return categoriasByCategoriaId;
    }

    public void setCategoriasByCategoriaId(CategoriasClass categoriasByCategoriaId) {
        this.categoriasByCategoriaId = categoriasByCategoriaId;
    }

    public Collection<ProductosPedidosClass> getProductosPedidosById() {
        return productosPedidosById;
    }

    public void setProductosPedidosById(Collection<ProductosPedidosClass> productosPedidosById) {
        this.productosPedidosById = productosPedidosById;
    }
}
