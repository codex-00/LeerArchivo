package ar.com.unpaz.repository;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import ar.com.unpaz.model.Producto;

public class ProductoRepository {
    private static final String PRODUCTO_FILE_PATH = "Producto.txt";

    public List<Producto> getAllProductos() {
        List<Producto> productos = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(PRODUCTO_FILE_PATH))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                int id = Integer.parseInt(data[0]);
                String nombre = data[1];
                int cantidad = Integer.parseInt(data[2]);
                double precio = Double.parseDouble(data[3]);
                Producto producto = new Producto(id, nombre, cantidad, precio);
                productos.add(producto);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return productos;
    }
}
