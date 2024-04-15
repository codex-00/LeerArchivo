package ar.com.unpaz.model;

import java.util.List;

public class Informe {
    private Cliente cliente;
    private int cantidadVentas;
    private double totalVentas;

    public Informe(Cliente cliente, int cantidadVentas, double totalVentas) {
        this.cliente = cliente;
        this.cantidadVentas = cantidadVentas;
        this.totalVentas = totalVentas;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public int getCantidadVentas() {
        return cantidadVentas;
    }

    public double getTotalVentas() {
        return totalVentas;
    }

    // Método para calcular el nombre del cliente, cantidad de ventas y total de ventas
    public static Informe generarInforme(Cliente cliente, List<Venta> ventas) {
        int cantidadVentas = 0;
        double totalVentas = 0.0;

        for (Venta venta : ventas) {
            if (venta.getIdCliente() == cliente.getId()) {
                cantidadVentas++;
                totalVentas += venta.getTotal();
            }
        }

        return new Informe(cliente, cantidadVentas, totalVentas);
    }

    @Override
    public String toString() {
        return "Cliente: " + cliente.getNombre() + " " + cliente.getApellido() +
               ", Cantidad de Ventas: " + cantidadVentas +
               ", Total de Ventas: $" + totalVentas;
    }
}
