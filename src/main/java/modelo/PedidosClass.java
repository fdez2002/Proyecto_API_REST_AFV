package modelo;

import jakarta.persistence.*;

import java.sql.Date;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "Pedidos", schema = "TiendaInfo", catalog = "")
public class PedidosClass {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private int id;
    @Basic
    @Column(name = "cliente_nombre", nullable = false, length = 50)
    private String clienteNombre;
    @Basic
    @Column(name = "fecha", nullable = false)
    private Date fecha;
    @OneToMany(mappedBy = "pedidosByPedidoId")
    private Collection<ProductosPedidosClass> productosPedidosById;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getClienteNombre() {
        return clienteNombre;
    }

    public void setClienteNombre(String clienteNombre) {
        this.clienteNombre = clienteNombre;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PedidosClass that = (PedidosClass) o;
        return id == that.id && Objects.equals(clienteNombre, that.clienteNombre) && Objects.equals(fecha, that.fecha);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, clienteNombre, fecha);
    }

    public Collection<ProductosPedidosClass> getProductosPedidosById() {
        return productosPedidosById;
    }

    public void setProductosPedidosById(Collection<ProductosPedidosClass> productosPedidosById) {
        this.productosPedidosById = productosPedidosById;
    }
}
