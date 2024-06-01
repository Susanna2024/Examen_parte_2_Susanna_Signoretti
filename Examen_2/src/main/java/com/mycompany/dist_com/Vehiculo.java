package com.mycompany.dist_com;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "Vehiculos")
public class Vehiculo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "tipo", nullable = false)
    private String tipo;

    @Column(name = "marca", nullable = false)
    private String marca;

    @Column(name = "potencia", nullable = false)
    private int potencia;

    @Column(name = "fecha_de_compra", nullable = false)
    private LocalDate fechaDeCompra;

    // Costruttore vuoto
    public Vehiculo() {
    }

    // Costruttore con parametri
    public Vehiculo(String tipo, String marca, int potencia, LocalDate fechaDeCompra) {
        this.tipo = tipo;
        this.marca = marca;
        this.potencia = potencia;
        this.fechaDeCompra = fechaDeCompra;
    }

    // Metodi getter e setter
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public int getPotencia() {
        return potencia;
    }

    public void setPotencia(int potencia) {
        this.potencia = potencia;
    }

    public LocalDate getFechaDeCompra() {
        return fechaDeCompra;
    }

    public void setFechaDeCompra(LocalDate fechaDeCompra) {
        this.fechaDeCompra = fechaDeCompra;
    }

    // Override del metodo toString per rappresentare l'oggetto come stringa
    @Override
    public String toString() {
        return "Vehiculo{" +
                "id=" + id +
                ", tipo='" + tipo + '\'' +
                ", marca='" + marca + '\'' +
                ", potencia=" + potencia +
                ", fechaDeCompra=" + fechaDeCompra +
                '}';
    }
}
