package com.clasejava.demo_jpa.dto;

public class VentaClienteDTO {
    private String cliente;
    private Double totalCompras;

    // Constructor
    public VentaClienteDTO(String cliente, Double totalCompras) {
        this.cliente = cliente;
        this.totalCompras = totalCompras;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public Double getTotalCompras() {
        return totalCompras;
    }

    public void setTotalCompras(Double totalCompras) {
        this.totalCompras = totalCompras;
    }
        
}
