package org.example.ENTITIES;

import org.example.INTERFACES.Servicio;

public class ServicioBase implements Servicio {


    @Override
    public String getDescripcion() {
        return "Servicio Base de alquiler de vehiculo";
    }

    @Override
    public double getPrecio() {
        return 0;
    }

    @Override
    public String toString() {
        return "Servicio Base" ;
    }
}
