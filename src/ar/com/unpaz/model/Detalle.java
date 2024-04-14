package ar.com.unpaz.model;

public class Detalle {
    private int id;
    private int idVenta;
    private int idProducto;
    private int cantidad;
    private double precioUnitario;

    public Detalle(int id, int idVenta, int idProducto, int cantidad, double precioUnitario) {
        this.id = id;
        this.idVenta = idVenta;
        this.idProducto = idProducto;
        this.cantidad = cantidad;
        this.precioUnitario = precioUnitario;
    }

    // Getters
    public int getId() {
        return id;
    }

    public int getIdVenta() {
        return idVenta;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public double getPrecioUnitario() {
        return precioUnitario;
    }
}
