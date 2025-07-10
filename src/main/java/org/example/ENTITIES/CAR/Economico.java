package org.example.ENTITIES.CAR;

public class Economico extends  Auto{

    public Economico(String id, String marca, String modelo, String color, String matricula, double precioPorDia) {
        super(id, marca, modelo, color, matricula, "Economico", precioPorDia);
    }

    @Override
    public String getDescripcion() {
        return "Auto Economico";
    }
}
