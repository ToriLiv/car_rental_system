package org.example.ENTITIES.CAR;

//hereda de la clase Auto
public class Pickup extends Auto {

    public Pickup(String id, String marca, String modelo, String color, String matricula, double precioPorDia) {
        super(id, marca, modelo, color, matricula, "Pickup", precioPorDia);
    }

    @Override
    public String getDescripcion() {
        return "Auto Pickup";
    }
}
