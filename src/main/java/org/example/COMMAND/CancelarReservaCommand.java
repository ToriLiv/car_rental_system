package org.example.COMMAND;

import org.example.ENTITIES.Reserva;
import org.example.INTERFACES.ReservaCommand;
import org.example.SistemaReservas;

/*=================================COMMAND============================================
 * Clase que representa el comando para cancelar una reserva en el sistema de reservas.
 * Implementa la interfaz ReservaCommand.
 * ===================================================================================
 */
public class CancelarReservaCommand implements ReservaCommand {
    private SistemaReservas sistema;
    private Reserva reserva;

    public CancelarReservaCommand(SistemaReservas sistema, Reserva reserva) {
        this.sistema = sistema;
        this.reserva = reserva;
    }

    @Override
    public void ejecutar() {
        sistema.cancelarReserva(reserva);
    }
}
