package org.example;
import org.example.ADAPTER.AutoDisponibleAdapter;
import org.example.DECORATOR.ServicioDecorator;
import org.example.ENTITIES.CAR.Auto;
import org.example.ENTITIES.Cliente;
import org.example.ENTITIES.Reserva;
import org.example.ENTITIES.ServicioBase;
import org.example.EXCEPTIONS.ClienteDuplicado;
import org.example.EXCEPTIONS.ReservaNoValida;
import org.example.FACADE.ReservaFacade;
import org.example.FACTORY.MetodoPagoFactory;
import org.example.FACTORY.ServicioFactory;
import org.example.INTERFACES.AutoInfoDisponible;
import org.example.INTERFACES.MetodoPago;
import org.example.INTERFACES.Servicio;
import java.util.List;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    //======================SINGLETON==========================
    static SistemaReservas sistemaReserva = SistemaReservas.getInstance();
    //======================FACADE=============================
    ReservaFacade reservaFacade = new ReservaFacade();
    //======================ADAPTER============================
    AutoDisponibleAdapter autoDisponibleAdapter = new AutoDisponibleAdapter(sistemaReserva.getAutos());

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcion;
        do{
            menu();
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine();
            if(opcion < 0 || opcion > 10) {
                System.out.println("Opción no válida. Por favor, intente de nuevo.");
            }
            else {
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
                        buscarAutosDisponibles(scanner);
                        break;
                    case 6:
                        crearReserva(scanner);
                        break;
                    case 7:
                        cancelarReserva(scanner);
                        break;
                    case 8:
                        sistemaReserva.mostrarReservas();
                        break;
                    case 9:
                        buscarReserva(scanner);
                        break;
                    case 10:
                        sistemaReserva.mostrarEstadoSistema();
                        break;
                    case 0:
                        System.out.println("Saliendo del sistema de reservas...");
                        scanner.close();
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
        System.out.println("│         CAR RENTAL SYSTEM           │");
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
        if (nombre.isEmpty()) {
            System.out.println("El nombre no puede estar vacío.");
            return;
        }
        String email = scanner.nextLine();
        if (email.isEmpty()) {
            System.out.println("El email no puede estar vacío.");
            return;
        }
        System.out.print("Ingrese el DUI del cliente: ");
        String dui = scanner.nextLine();
        if (dui.isEmpty()) {
            System.out.println("El DUI no puede estar vacío.");
            return;
        }
        System.out.print("Ingrese el telefono del cliente: ");
        String telefono = scanner.nextLine();
        if (telefono.isEmpty()) {
            System.out.println("El teléfono no puede estar vacío.");
            return;
        }
        Cliente cliente = new Cliente(id, nombre, email, dui, telefono);
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
        if (id.isEmpty()) {
            System.out.println("El ID no puede estar vacío.");
            return;
        }
        Cliente cliente = sistemaReserva.BuscarClientePorId(id);
        if (cliente != null) {
            System.out.println("Cliente encontrado: \n" + cliente);
        } else {
            System.out.println("Cliente no encontrado.");
        }
    }

    //======================METODO AUTOS==========================
    public static void buscarAutosDisponibles(Scanner scanner) {
        System.out.println("deportivo, economico, sedan o pickup");
        System.out.print("Ingrese el tipo de auto que desea buscar: ");
        String tipo = scanner.nextLine();
        if (tipo.isEmpty()) {
            System.out.println("El tipo de auto no puede estar vacío.");
            return;
        }
        List<Auto> autosDisponibles = sistemaReserva.BuscarAutosPorTipo(tipo);
        if (autosDisponibles.isEmpty()) {
            System.out.println("No hay autos disponibles del tipo: " + tipo);
        } else {
            System.out.println("Autos disponibles del tipo " + tipo + ":");
            for (Auto auto : autosDisponibles) {
                System.out.println(auto);
            }
        }
    }

    //======================METODO RESERVA==========================
    public static void crearReserva(Scanner scanner) {
        ReservaFacade reservaFacade = new ReservaFacade();
        System.out.print("Ingrese el ID de la reserva: ");
        String idReserva = scanner.nextLine();
        if (idReserva.isEmpty()) {
            System.out.println("El ID de la reserva no puede estar vacío.");
            return;
        }
        if (sistemaReserva.buscarReservaPorId(idReserva) != null) {
            System.out.println("Ya existe una reserva con el ID " + idReserva);
            return;
        }
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
            System.out.println((i + 1) + ". " + disponibles.get(i).getModelo() + "-> Precio por día: $" + disponibles.get(i).getPrecioPorDia());
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
        if (cantidadDias <= 0) {
            System.out.println("La cantidad de días debe ser mayor a cero.");
            return;
        }
        //============================================================
        scanner.nextLine();
        System.out.print("Seleccione el método de pago: ");
        System.out.println("\n1. tarjeta de credito");
        System.out.println("2. paypal");
        System.out.print("Seleccione tipo de pago: ");
        String tipoPago = scanner.nextLine();
        if (tipoPago.isEmpty()) {
            System.out.println("El tipo de pago no puede estar vacío.");
            return;
        }
        MetodoPago metodoPago = MetodoPagoFactory.obtenerMetodoPago(tipoPago);

        //============================================================
        Servicio servicioFinal = new ServicioBase();
        System.out.print("¿Desea agregar servicios adicionales? (si/no): ");
        String respuesta = scanner.nextLine();

        if (respuesta.equalsIgnoreCase("si")) {
            System.out.println("Seleccione los servicios adicionales:");
            System.out.println("1. GPS");
            System.out.println("2. Seguro");
            System.out.println("3. GPS y Seguro");
            System.out.print("Ingrese opción: ");
            String tipoServicio = scanner.nextLine();
            if (tipoServicio.isEmpty()) {
                System.out.println("El tipo de servicio no puede estar vacío.");
                return;
            }
            servicioFinal = ServicioFactory.crearServicio(tipoServicio, new ServicioBase());

        }
        Reserva reserva = reservaFacade.realizarReserva(
                idReserva,
                cliente,
                autoSeleccionado,
                servicioFinal instanceof ServicioDecorator
                        ? (ServicioDecorator) servicioFinal
                        : new ServicioDecorator(servicioFinal, 0),
                metodoPago,
                cantidadDias
        );
        System.out.println("\nReserva registrada exitosamente.");
    }

    public static void cancelarReserva(Scanner scanner) {
        System.out.print("Ingrese el ID de la reserva a cancelar: ");
        String idReserva = scanner.nextLine();
        if (idReserva.isEmpty()) {
            System.out.println("El ID de la reserva no puede estar vacío.");
            return;
        }
        Reserva reserva = sistemaReserva.buscarReservaPorId(idReserva);
        if (reserva == null) {
            System.out.println("Reserva no encontrada.");
            return;
        }
        try {
            sistemaReserva.cancelarReserva(reserva);
            System.out.println("Reserva cancelada exitosamente.");
        } catch (ReservaNoValida e) {
            System.err.println(e.getMessage());
        }


    }

    public static void buscarReserva(Scanner scanner) {
        System.out.print("Ingrese el ID de la reserva a buscar: ");
        String idReserva = scanner.nextLine();
        if (idReserva.isEmpty()) {
            System.out.println("El ID de la reserva no puede estar vacío.");
            return;
        }
        Reserva reserva = sistemaReserva.buscarReservaPorId(idReserva);
        if (reserva != null) {
            System.out.println("Reserva encontrada: \n" + reserva);
        } else {
            System.out.println("Reserva no encontrada.");
        }
    }

}

