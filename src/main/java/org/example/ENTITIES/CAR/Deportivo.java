package org.example.ENTITIES.CAR;

//herencia de la clase Auto
public class Deportivo extends Auto{

    public Deportivo(String id, String marca, String modelo, String color, String matricula, double precioPorDia) {
        super(id, marca, modelo, color, matricula, "Deportivo", precioPorDia);
    }

    @Override
    public String getDescripcion() {
        return "Auto Deportivo";
    }
}
