package org.example.ENTITIES.CAR;

public abstract class Auto {
    private String id;
    private String marca;
    private String modelo;
    private String color;
    private String matricula;
    private String tipo;
    private double precioPorDia;
    private boolean disponible;

    public Auto(String id, String marca, String modelo, String color, String matricula, String tipo, double precioPorDia) {
        this.id = id;
        this.marca = marca;
        this.modelo = modelo;
        this.color = color;
        this.matricula = matricula;
        this.tipo = tipo;
        this.precioPorDia = precioPorDia;
        this.disponible = true; //se encuentra disponible por defecto
    }

    //metodo abstracto que debe ser implementado por las subclases
    public abstract String getDescripcion();

    //=================Getters y Setters========================
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public double getPrecioPorDia() {
        return precioPorDia;
    }

    public void setPrecioPorDia(double precioPorDia) {
        this.precioPorDia = precioPorDia;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    //==============Metodo para obtener la descripcion del auto=====================
    @Override
    public String toString() {
        return "-------DESCIPCION DEL AUTO---------" + "\nId: " + id + "\nMarca: " + marca + "\nModelo: " + modelo + "\nColor: " + color +
                "\nMatricula: " + matricula + "\nTipo: " + tipo + "\nPrecio por dia: $" + precioPorDia +
                "\nDisponible: " + (disponible ? "Si" : "No");
    }
}
