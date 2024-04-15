package ar.com.unpaz.repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ar.com.unpaz.model.Cliente;
import ar.com.unpaz.model.Venta;

public class InformeRepository {

    public void generarInforme(ClienteRepository clienteRepository, VentaRepository ventaRepository) {
        List<Cliente> clientes = clienteRepository.getAllClientes();
        List<Venta> ventas = ventaRepository.getAllVentas();

        // Map para almacenar el total de ventas por cliente
        Map<Integer, Double> ventasPorCliente = new HashMap<>();
        Map<Integer, String> nombreClienteMap = new HashMap<>();

        // Inicializar el mapa con nombres de cliente
        for (Cliente cliente : clientes) {
            nombreClienteMap.put(cliente.getId(), cliente.getNombre() + " " + cliente.getApellido());
            ventasPorCliente.put(cliente.getId(), 0.0); // Inicializar el total de ventas en 0 para cada cliente
        }

        // Calcular el total de ventas por cliente
        for (Venta venta : ventas) {
            int idCliente = venta.getIdCliente();
            double montoVenta = venta.getTotal();
            ventasPorCliente.put(idCliente, ventasPorCliente.get(idCliente) + montoVenta);
        }

        // Mostrar el informe
        System.out.println("Informe de Ventas por Cliente:");
        for (int idCliente : ventasPorCliente.keySet()) {
            String nombreCliente = nombreClienteMap.get(idCliente);
            double totalVentas = ventasPorCliente.get(idCliente);
            System.out.println("Cliente: " + nombreCliente + " - Cantidad de Ventas: " + contarVentasPorCliente(ventas, idCliente) + " - Total Ventas: $" + totalVentas);
        }
    }

    private int contarVentasPorCliente(List<Venta> ventas, int idCliente) {
        int count = 0;
        for (Venta venta : ventas) {
            if (venta.getIdCliente() == idCliente) {
                count++;
            }
        }
        return count;
    }
}
