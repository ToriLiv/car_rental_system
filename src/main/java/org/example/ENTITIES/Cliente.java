package org.example.ENTITIES;

import org.example.INTERFACES.Observer;

public class Cliente implements Observer {
    private String id;
    private String dui;
    private String nombre;
    private String email;

    public Cliente(String id, String nombre, String email, String dui) {
        this.id = id;
        this.dui = dui;
        this.nombre = nombre;
        this.email = email;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDui() {
        return dui;
    }

    public void setDui(String dui) {
        this.dui = dui;
    }

    @Override
    public void actualizar(String mensaje) {
        System.out.println("Notificación para " + nombre + ": " + mensaje);
    }
}
