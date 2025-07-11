package org.example;

import org.example.ENTITIES.CAR.Auto;
import org.example.ENTITIES.Cliente;
import org.example.ENTITIES.Reserva;
import org.example.EXCEPTIONS.ClienteDuplicado;
import org.example.FACTORY.AutoFactory;
import org.example.INTERFACES.Observer;
import org.example.OBSERVER.NotificadorReserva;

import java.util.List;

public class SistemaReservas {
    private  List<Reserva> reservas;
    private static SistemaReservas instance;
    private  List<Cliente> clientes;
    private  List<Auto> autos;
    private  NotificadorReserva notificador;


    private SistemaReservas() {
        inicializarAuto();

        this.reservas = new java.util.ArrayList<>();
        this.clientes = new java.util.ArrayList<>();
        this.notificador = new NotificadorReserva();
    }

    private void inicializarAuto() {
        autos.add(AutoFactory.crearAuto("1", "Ferrari", "488 GTB", "Rojo", "ABC123", "deportivo", 500.0));
        autos.add(AutoFactory.crearAuto("2", "Lamborghini", "Huracan", "Amarillo", "DEF456", "deportivo", 550.0));
        autos.add(AutoFactory.crearAuto("3", "Toyota", "Yaris", "Blanco", "GHI789", "economico", 80.0));
        autos.add(AutoFactory.crearAuto("4", "Hyundai", "Accent", "Gris", "JKL321", "economico", 75.0));
        autos.add(AutoFactory.crearAuto("5", "Chevrolet", "Spark", "Azul", "MNO654", "economico", 70.0));
        autos.add(AutoFactory.crearAuto("6", "Ford", "F-150", "Negro", "PQR987", "pickup", 150.0));
        autos.add(AutoFactory.crearAuto("7", "Chevrolet", "Silverado", "Blanco", "STU111", "pickup", 160.0));
        autos.add(AutoFactory.crearAuto("8", "Honda", "Accord", "Gris", "VWX222", "sedan", 120.0));
        autos.add(AutoFactory.crearAuto("9", "Toyota", "Camry", "Negro", "YZA333", "sedan", 125.0));
        autos.add(AutoFactory.crearAuto("10", "Mazda", "6", "Rojo", "BCD444", "sedan", 118.0));

    }


    public static SistemaReservas getInstance(){
        if(instance == null){
            instance = new SistemaReservas();
        }
        return instance;
    }

    public void registrarCliente(Cliente cliente) throws ClienteDuplicado {
        for (Cliente c : clientes) {
            if (c.getDui().equals(cliente.getDui())) {
                throw new ClienteDuplicado("El cliente con DNI " + cliente.getDui() + " ya está registrado.");
            }
        }
        clientes.add(cliente);
        notificador.agregarObservador(cliente);
        System.out.println("Cliente registrado: " + cliente.getNombre());
    }

    public void crearReserva(Reserva reserva) {
        reservas.add(reserva);
        System.out.println("Reserva creada para el cliente: " + reserva.getCliente().getNombre());
    }

    public void cancelarReserva(Reserva reserva) {
        //Lógica para cancelar una reserva
        System.out.println("Reserva cancelada: " + reserva);
    }

    public List<Reserva> getReservas() {
        return reservas;
    }
}
