package org.example.ENTITIES.CAR;

//hereda de la clase Auto
public class Sedan extends  Auto {

    public Sedan(String id, String marca, String modelo, String color, String matricula, double precioPorDia) {
        super(id, marca, modelo, color, matricula, "Sedan", precioPorDia);
    }

    @Override
    public String getDescripcion() {
        return "Auto Sedan";
    }
}
