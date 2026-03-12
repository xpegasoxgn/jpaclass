package com.clasejava.demo_jpa.dto;

public class ProductoVentaDTO {
    private String producto;
    private Double totalVentas;

    // Constructor
    public ProductoVentaDTO(String producto, Double totalVentas) {
        this.producto = producto;
        this.totalVentas = totalVentas;
    }

    public String getProducto() {
        return producto;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }

    public Double getTotalVentas() {
        return totalVentas;
    }

    public void setTotalVentas(Double totalVentas) {
        this.totalVentas = totalVentas;
    }
}
