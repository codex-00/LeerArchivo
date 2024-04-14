package ar.com.unpaz.model;

import java.time.LocalDate;

public class Venta {
    private int id;
    private LocalDate fecha;
    private int idCliente;
    private double total;

    public Venta(int id, LocalDate fecha, int idCliente, double total) {
        this.id = id;
        this.fecha = fecha;
        this.idCliente = idCliente;
        this.total = total;
    }

    public int getId() {
        return id;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public int getIdCliente() {
        return idCliente;
    }

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}
}
