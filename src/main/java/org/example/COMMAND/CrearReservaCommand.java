package org.example.COMMAND;

import org.example.ENTITIES.Reserva;
import org.example.INTERFACES.ReservaCommand;
import org.example.SistemaReservas;

public class CrearReservaCommand implements ReservaCommand {
    private SistemaReservas sistema;
    private Reserva reserva;

    public CrearReservaCommand(SistemaReservas sistema, Reserva reserva) {
        this.sistema = sistema;
        this.reserva = reserva;
    }


    @Override
    public void ejecutar() {
        sistema.crearReserva(reserva);
    }
}
