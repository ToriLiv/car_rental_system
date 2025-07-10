package org.example.OBSERVER;

import org.example.INTERFACES.Observer;

import java.util.ArrayList;
import java.util.List;

/**
 * -------------------------------OBSERVER-------------------------------
 * Permite que un objeto notifique a otros objetos sobre eventos específicos.
 * -----------------------------------------------------------------------
 */
public class NotificadorReserva {
    private List<Observer> observers = new ArrayList<>();

    public void agregarObservador(Observer observer) {
        observers.add(observer);
    }

    public void eliminarObservador(Observer observer) {
        observers.remove(observer);
    }

    public void notificar(String mensaje) {
        for (Observer observer : observers) {
            observer.actualizar(mensaje);
        }
    }
}
