package ar.com.unpaz.repository;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import ar.com.unpaz.model.Venta;

public class VentaRepository {
    private static final String VENTA_FILE_PATH = "Venta.txt";

    public List<Venta> getAllVentas() {
        List<Venta> ventas = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(VENTA_FILE_PATH))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                int id = Integer.parseInt(data[0]);
                LocalDate fecha = LocalDate.parse(data[1]);
                int idCliente = Integer.parseInt(data[2]);
                double total = Double.parseDouble(data[3]);
                Venta venta = new Venta(id, fecha, idCliente, total);
                ventas.add(venta);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return ventas;
    }
}
