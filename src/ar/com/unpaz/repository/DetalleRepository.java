package ar.com.unpaz.repository;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import ar.com.unpaz.model.Detalle;

public class DetalleRepository {
    private static final String DETALLE_FILE_PATH = "detalle.txt";

    public List<Detalle> getAllDetalles() {
        List<Detalle> detalles = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(DETALLE_FILE_PATH))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                int id = Integer.parseInt(data[0]);
                int idVenta = Integer.parseInt(data[1]);
                int idProducto = Integer.parseInt(data[2]);
                int cantidad = Integer.parseInt(data[3]);
                double precioUnitario = Double.parseDouble(data[4]);
                Detalle detalle = new Detalle(id, idVenta, idProducto, cantidad, precioUnitario);
                detalles.add(detalle);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return detalles;
    }
}
