package org.example.ENTITIES;
import org.example.INTERFACES.Servicio;
//-------------------------BASE-------------------------
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
    public double obtenerCosto() {
        return getPrecio();
    }

    @Override
    public String toString() {
        return "Servicio Base" ;
    }



}
