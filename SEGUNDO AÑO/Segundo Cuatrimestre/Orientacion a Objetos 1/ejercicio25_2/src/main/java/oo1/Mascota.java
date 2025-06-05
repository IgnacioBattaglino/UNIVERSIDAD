package oo1;

import java.time.LocalDate;
import java.util.ArrayList;

import javax.swing.tree.VariableHeightLayoutCache;

public class Mascota {
    private String nombre;
    private LocalDate fechaNacimiento;
    private String especie;
    private ArrayList<Servicio> servicios;

    public double getRecaudacionFecha (LocalDate fecha){
        return servicios.stream()
        .filter(s -> s.getFecha().equals(fecha))
        .mapToDouble(s -> s.calcularCosto())
        .sum();
    }

    public Consulta altaConsulta (Medico medico){
        Consulta con = new Consulta (this, medico, LocalDate.now());
        this.servicios.add(con);
        return con;
    }

    public Mascota (String nombre, LocalDate fechaNac, String especie) {
        this.nombre=nombre;
        this.fechaNacimiento=fechaNac;
        this.especie=especie;
        this.servicios= new ArrayList<>();
    }

    public Vacunacion altaVacunacion (Medico medico, String vacuna, double costo){
        Vacunacion vac = new Vacunacion (this,medico,LocalDate.now(), vacuna,costo);
        this.servicios.add(vac);
        return vac;
    }

    public Guarderia altaGuarderia (int cantDias){
        Guarderia gua = new Guarderia (this, LocalDate.now(), cantDias);
        this.servicios.add(gua);
        return gua;
    }

    public boolean tiene5oMasServicios(){
        return this.servicios.size()>=5;
    }
 
}
