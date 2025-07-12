package org.example;

import org.example.ENTITIES.CAR.Auto;
import org.example.ENTITIES.Cliente;
import org.example.ENTITIES.Reserva;
import org.example.EXCEPTIONS.AutosNoDisponibles;
import org.example.EXCEPTIONS.ClienteDuplicado;
import org.example.EXCEPTIONS.ReservaNoValida;
import org.example.FACTORY.AutoFactory;
import org.example.INTERFACES.Observer;
import org.example.OBSERVER.NotificadorReserva;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class SistemaReservas {
    private  final List<Reserva> reservas;
    private  static SistemaReservas instance;
    private  final List<Cliente> clientes;
    private  final List<Auto> autos = new ArrayList<>();
    private  final NotificadorReserva notificador;

    public List<Auto> getAutos() {
        return autos;
    }

    public SistemaReservas() {
        this.reservas = new ArrayList<>();
        this.clientes = new ArrayList<>();
        this.notificador = new NotificadorReserva();
        inicializarAuto();
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
        autos.add(AutoFactory.crearAuto("10", "Mazda", "CX-80", "Rojo", "BCD444", "sedan", 118.0));

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

    public void crearReserva(Reserva reserva) throws ReservaNoValida {
        reservas.add(reserva);
        notificador.notificar("¡Su reserva ha sido confirmada!");
    }

    public void cancelarReserva(Reserva reserva) throws ReservaNoValida {
        //Lógica para cancelar una reserva
        if(reserva == null || !reservas.contains(reserva)) {
            throw new ReservaNoValida("La reserva no es válida o no existe.");
        }
        reserva.cancelarReserva();
        notificador.notificar("La reserva ha sido cancelada: " + reserva.getCliente().getNombre());
    }

    private Auto BuscarAutoDisponible(String tipo) throws AutosNoDisponibles {
        List<Auto> autosDisponibles = BuscarAutosDisponibles(tipo);
        if (autosDisponibles.isEmpty()) {
            throw new AutosNoDisponibles("No hay autos disponibles del tipo: " + tipo);
        }
        return autosDisponibles.get(0);
    }

    private List<Auto> BuscarAutosDisponibles(String tipo) {
        return autos.stream()
                .filter(auto -> auto.getTipo().equalsIgnoreCase(tipo) && auto.isDisponible())
                .collect(Collectors.toList());
    }

    public Cliente BuscarClientePorDui(String dui) {
        return clientes.stream()
                .filter(cliente -> cliente.getDui().equals(dui))
                .findFirst()
                .orElse(null);
    }

    public Cliente BuscarClientePorId(String id) {
        return clientes.stream()
                .filter(cliente -> cliente.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    public List<Auto> BuscarAutosPorTipo(String tipo) {
        return autos.stream()
                .filter(auto -> auto.getTipo().equalsIgnoreCase(tipo))
                .collect(Collectors.toList());
    }

    public List<Reserva> BuscarReservaPorCliente(String dui) {
        Cliente cliente = BuscarClientePorDui(dui);
        if (cliente == null) {
            return List.of();
        }
        return reservas.stream()
                .filter(reserva -> reserva.getCliente().getDui().equals(dui))
                .collect(Collectors.toList());
    }

    public void mostrarClientes() {
        if (clientes.isEmpty()) {
            System.out.println("No hay clientes registrados.");
            return;
        }
        System.out.println("Lista de Clientes:");
        for (Cliente cliente : clientes) {
            System.out.println(cliente);
        }
    }

    public void mostrarReservas() {
        if (reservas.isEmpty()) {
            System.out.println("No hay reservas registradas.");
            return;
        }
        System.out.println("Lista de Reservas:");
        for (Reserva reserva : reservas) {
            System.out.println(reserva);
        }
    }


    public void mostrarEstadoSistema() {
        System.out.println("========Estado del Sistema de Reservas==========");
        System.out.println("Total de Clientes: " + clientes.size());
        System.out.println("Total de Autos: " + autos.size());
        System.out.println("Total de Reservas: " + reservas.size());
        System.out.println("================================================");

    }

    public void mostrarAutosDisponibles() {
        List<Auto> autosDisponibles = autos.stream()
                .filter(Auto::isDisponible)
                .collect(Collectors.toList());
        if (autosDisponibles.isEmpty()) {
            System.out.println("No hay autos disponibles actualmente.");
            return;
        }
        System.out.println("=========Lista de Autos Disponibles===========");
        for (Auto auto : autosDisponibles) {
            System.out.println(auto);
        }
    }

    public Reserva buscarReservaPorId(String id) {
        return reservas.stream()
                .findFirst()
                .orElse(null);}
}
