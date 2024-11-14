package oo1;

import java.time.LocalDate;

public class CancelacionModerada implements PoliticaDeCancelacion {

    @Override
    public double devolverDinero(Reserva reserva) {
        if (reserva.getPeriodo().getFrom().isBefore(LocalDate.now().minusDays(7))) 
            return reserva.getPrecioTotal();
        else if (reserva.getPeriodo().getFrom().isBefore(LocalDate.now().minusDays(2)))
            return reserva.getPrecioTotal() * 0.5 ;
        else 
            return 0;
    }
}
