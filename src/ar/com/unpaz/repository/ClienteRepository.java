package ar.com.unpaz.repository;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import ar.com.unpaz.model.Cliente;

public class ClienteRepository {
    private static final String CLIENTE_FILE_PATH = "cliente.txt";

    public List<Cliente> getAllClientes() {
        List<Cliente> clientes = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(CLIENTE_FILE_PATH))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                int id = Integer.parseInt(data[0]);
                String nombre = data[1];
                String apellido = data[2];
                String telefono = data[3];
                Cliente cliente = new Cliente(id, nombre, apellido, telefono);
                clientes.add(cliente);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return clientes;
    }
}
