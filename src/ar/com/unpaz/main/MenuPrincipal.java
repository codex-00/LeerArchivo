package ar.com.unpaz.main;

import java.util.List;
import java.util.Scanner;

import ar.com.unpaz.model.Cliente;
import ar.com.unpaz.repository.ClienteRepository;
import ar.com.unpaz.model.Venta;
import ar.com.unpaz.repository.VentaRepository;
import ar.com.unpaz.model.Detalle;
import ar.com.unpaz.repository.DetalleRepository;
import ar.com.unpaz.model.Producto;
import ar.com.unpaz.repository.ProductoRepository;
import ar.com.unpaz.repository.InformeRepository;

public class MenuPrincipal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ClienteRepository clienteRepository = new ClienteRepository();
        VentaRepository ventaRepository = new VentaRepository();
        DetalleRepository detalleRepository = new DetalleRepository();
        ProductoRepository productoRepository = new ProductoRepository();
        InformeRepository informeRepository = new InformeRepository();
        
        while (true) {
            System.out.println("MENÚ:");
            System.out.println("1. LEER ARCHIVO CLIENTE");
            System.out.println("2. LEER ARCHIVO VENTA");
            System.out.println("3. LEER ARCHIVO DETALLE");
            System.out.println("4. LEER ARCHIVO PRODUCTO");
            System.out.println("5. LEER COMPLETO");
            System.out.println("6. MOSTRAR INFORMES");
            System.out.println("0. SALIR");
            System.out.print("INGRESE UNA OPCIÓN: ");

            int opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 0:
                    System.out.println("SALIENDO...");
                    scanner.close();
                    System.exit(0);
                case 1:
                    List<Cliente> clientes = clienteRepository.getAllClientes();
                    System.out.println("Listado de clientes:");
                    for (Cliente cliente : clientes) {
                        System.out.println(cliente.getId() + ": " + cliente.getNombre() + " " + cliente.getApellido() + " - Teléfono: " + cliente.getTelefono());
                    }
                    break;
                case 2:
                	List<Venta> ventas = ventaRepository.getAllVentas();
                    System.out.println("Listado de ventas:");
                    for (Venta venta : ventas) {
                        System.out.println("ID: " + venta.getId() +
                                ", Fecha: " + venta.getFecha() +
                                ", ID Cliente: " + venta.getIdCliente() +
                                ", Total: " + venta.getTotal());
                    }
                    break;
                case 3:
                	List<Detalle> detalles = detalleRepository.getAllDetalles();
                    System.out.println("Listado de detalles:");
                    for (Detalle detalle : detalles) {
                        System.out.println("ID: " + detalle.getId() +
                                ", ID Venta: " + detalle.getIdVenta() +
                                ", ID Producto: " + detalle.getIdProducto() +
                                ", Cantidad: " + detalle.getCantidad() +
                                ", Precio Unitario: " + detalle.getPrecioUnitario());
                    }
                    break;
                case 4:
                	List<Producto> productos = productoRepository.getAllProductos();
                    System.out.println("Listado de productos:");
                    for (Producto producto : productos) {
                        System.out.println(producto.getId() + ": " + producto.getNombre() + " - Cantidad: " + producto.getCantidad() + " - Precio: $" + producto.getPrecio());
                    }
                    break;
                case 5:
                	 System.out.println("Listado completo:");

                     // Clientes
                     System.out.println("\nClientes:");
                     List<Cliente> allClientes = clienteRepository.getAllClientes();
                     for (Cliente cliente : allClientes) {
                         System.out.println(cliente.getId() + ": " + cliente.getNombre() + " " + cliente.getApellido() + " - Teléfono: " + cliente.getTelefono());
                     }

                     // Ventas
                     System.out.println("\nVentas:");
                     List<Venta> allVentas = ventaRepository.getAllVentas();
                     for (Venta venta : allVentas) {
                         System.out.println("ID: " + venta.getId() + ", Fecha: " + venta.getFecha() + ", ID Cliente: " + venta.getIdCliente() + ", Total: $" + venta.getTotal());
                     }

                     // Detalles
                     System.out.println("\nDetalles:");
                     List<Detalle> allDetalles = detalleRepository.getAllDetalles();
                     for (Detalle detalle : allDetalles) {
                         System.out.println("ID Venta: " + detalle.getIdVenta() + ", ID Producto: " + detalle.getIdProducto() + ", Cantidad: " + detalle.getCantidad() + ", Precio Unitario: $" + detalle.getPrecioUnitario());
                     }

                     // Productos
                     System.out.println("\nProductos:");
                     List<Producto> allProductos = productoRepository.getAllProductos();
                     for (Producto producto : allProductos) {
                         System.out.println("ID: " + producto.getId() + ", Nombre: " + producto.getNombre() + ", Cantidad: " + producto.getCantidad() + ", Precio: $" + producto.getPrecio());
                     }
                    break;
                case 6:
                    informeRepository.generarInforme(clienteRepository, ventaRepository);
                    break;
                default:
                    System.out.println("OPCIÓN INVÁLIDA. INTENTE DE NUEVO.");
            }
        }
    }
}
