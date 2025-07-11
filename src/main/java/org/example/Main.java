package org.example;

import org.example.ADAPTER.AutoDisponibleAdapter;
import org.example.DECORATOR.ServicioDecorator;
import org.example.ENTITIES.CAR.Auto;
import org.example.ENTITIES.Cliente;
import org.example.ENTITIES.Reserva;
import org.example.EXCEPTIONS.ClienteDuplicado;
import org.example.FACADE.ReservaFacade;
import org.example.FACTORY.MetodoPagoFactory;
import org.example.INTERFACES.AutoInfoDisponible;
import org.example.INTERFACES.MetodoPago;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static SistemaReservas sistemaReserva = SistemaReservas.getInstance();
    ReservaFacade reservaFacade = new ReservaFacade();
    AutoDisponibleAdapter autoDisponibleAdapter = new AutoDisponibleAdapter(sistemaReserva.getAutos());

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do{
            menu();
            System.out.print("Seleccione una opción:");
            opcion = scanner.nextInt();
            scanner.nextLine();
            if(opcion < 0 || opcion > 10) {
                System.out.println("Opción no válida. Por favor, intente de nuevo.");
            } else {
                switch (opcion) {
                    case 1:
                        registrarCliente(scanner);
                        break;
                    case 2:
                        buscarCliente(scanner);
                        break;
                    case 3:
                        sistemaReserva.mostrarClientes();
                        break;
                    case 4:
                        sistemaReserva.mostrarAutosDisponibles();
                        break;
                    case 5:
                        System.out.println("Saliendo del programa...");
                        break;
                    case 0:
                        System.out.println("Saliendo del sistema de reservas...");
                        break;
                    default:
                        System.out.println("Opción no válida. Por favor, intente de nuevo.");
                        break;
                }
            }


        }while(opcion != 0);



    }

    private static void menu() {
        System.out.println("\n");
        System.out.println("┌─────────────────────────────────────┐");
        System.out.println("│           BOOKING SYSTEM            │");
        System.out.println("├─────────────────────────────────────┤");
        System.out.println("│ 1-> Registrar cliente               │");
        System.out.println("│ 2-> Buscar cliente                  │");
        System.out.println("│ 3-> Mostrar clientes                │");
        System.out.println("│ 4-> Autos disponibles               │");
        System.out.println("│ 5-> Buscar autos disponibles        │");
        System.out.println("│ 6-> Crear reserva                   │");
        System.out.println("│ 7-> Cancelar reserva                │");
        System.out.println("│ 8-> Mostrar reservas                │");
        System.out.println("│ 9-> Buscar reserva                  │");
        System.out.println("│ 10->Estado del sistema              │");
        System.out.println("│ 0-> Salir                           │");
        System.out.println("└─────────────────────────────────────┘");
    }

    //======================METODO CLIENTE==========================
    public static void registrarCliente(Scanner scanner){
        System.out.print("Ingrese el ID del cliente: ");
        String id = scanner.nextLine();
        if (id.isEmpty()) {
            System.out.println("El ID no puede estar vacío.");
            return;
        }
        if(sistemaReserva.BuscarClientePorId(id) != null) {
            System.out.println("El cliente con ID " + id + " ya está registrado.");
            return;
        }
        System.out.print("Ingrese el nombre del cliente: ");
        String nombre = scanner.nextLine();
        System.out.print("Ingrese el email del cliente: ");
        String email = scanner.nextLine();
        System.out.print("Ingrese el DUI del cliente: ");
        String dui = scanner.nextLine();
        Cliente cliente = new Cliente(id, nombre, email, dui);
        try {
            sistemaReserva.registrarCliente(cliente);
            System.out.println("\nCliente registrado exitosamente.");
        } catch (ClienteDuplicado e) {
            System.err.println(e.getMessage());
        }
    }

    public static void buscarCliente(Scanner scanner){
        System.out.print("Ingrese ID del cliente a buscar: ");
        String id = scanner.nextLine();
        Cliente cliente = sistemaReserva.BuscarClientePorId(id);
        if (cliente != null) {
            System.out.println("Cliente encontrado: \n" + cliente);
        } else {
            System.out.println("Cliente no encontrado.");
        }
    }

    //======================METODO RESERVA==========================
    public void crearReserva(Scanner scanner) {
        System.out.print("Ingrese el ID del cliente: ");
        String idCliente = scanner.nextLine();
        if (idCliente.isEmpty()) {
            System.out.println("El ID del cliente no puede estar vacío.");
            return;
        }
        Cliente cliente = sistemaReserva.BuscarClientePorId(idCliente);
        if (cliente == null) {
            System.out.println("Cliente no encontrado.");
            return;
        }
        //============================================================
        List<Auto> todosLosAutos = SistemaReservas.getInstance().getAutos();
        AutoInfoDisponible adapter = new AutoDisponibleAdapter(todosLosAutos);
        List<Auto> disponibles = adapter.obtenerAutosDisponibles();

        if (disponibles.isEmpty()) {
            System.out.println("No hay autos disponibles actualmente.");
            return;
        }

        System.out.println("\n=====================Autos disponibles===============");
        for (int i = 0; i < disponibles.size(); i++) {
            System.out.println((i + 1) + ". " + disponibles.get(i).getModelo());
        }

        System.out.print("Seleccione el número del auto que desea reservar: ");
        int opcionAuto = scanner.nextInt();
        scanner.nextLine();
        if (opcionAuto < 1 || opcionAuto > disponibles.size()) {
            System.out.println("Opción no válida. Por favor, intente de nuevo.");
            return;
        }
        Auto autoSeleccionado = disponibles.get(opcionAuto - 1);
        //============================================================
        System.out.print("Ingrese la cantidad de días para la reserva: ");
        int cantidadDias = scanner.nextInt();
        scanner.nextLine();
        if (cantidadDias <= 0) {
            System.out.println("La cantidad de días debe ser mayor a cero.");
            return;
        }

        //============================================================
        System.out.print("Seleccione el método de pago: ");
        System.out.println("1. tarjeta de credito");
        System.out.println("2. paypal");
        String tipoPago = scanner.nextLine();
        scanner.nextLine();
        MetodoPago metodoPago = MetodoPagoFactory.obtenerMetodoPago(tipoPago);

        if (metodoPago == null) {
            System.out.println("Método de pago no válido. Por favor, intente de nuevo.");
            return;
        }

        //============================================================
        System.out.print("¿Desea agregar servicios adicionales? (si/no): ");
        String respuesta = scanner.nextLine();
        List<ServicioDecorator> serviciosAdicionales = new ArrayList<>();
        String tipoServicio = "";
        if (respuesta.equalsIgnoreCase("si")) {
            System.out.println("Seleccione los servicios adicionales:");
            System.out.println("1. GPS");
            System.out.println("2. Seguro");
            System.out.println("3. GPS y Seguro");
            tipoServicio = scanner.nextLine();
            if(tipoServicio.isEmpty()) {
                System.out.println("El tipo de servicio no puede estar vacío. No se agregará ningún servicio.");
                tipoServicio = "";
            }
            if(tipoServicio.equals("1")) {
                tipoServicio = "gps";
            } else if(tipoServicio.equals("2")) {
                tipoServicio = "seguro";
            } else if(tipoServicio.equals("3")) {
                tipoServicio = "gps y seguro";
            } else if(tipoServicio.equals("4")) {
                tipoServicio = "todo incluido";
            } else {
                System.out.println("Tipo de servicio no reconocido. No se agregará ningún servicio.");
                tipoServicio = "";
            }
        }
        Reserva reserva = reservaFacade.realizarReserva(
                cliente,
                autoSeleccionado,
                serviciosAdicionales,
                metodoPago,
                cantidadDias
        );
        System.out.println("\nReserva registrada exitosamente.");
        }


    }

