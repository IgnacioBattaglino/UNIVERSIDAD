package oo1;
public class CancelacionFlexible implements PoliticaDeCancelacion {

    @Override
    public double devolverDinero(Reserva reserva) {
        return reserva.getPrecioTotal();
    }
}
