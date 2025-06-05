package ar.edu.unlp.info.oo2.biblioteca;

import java.util.ArrayList;
import java.util.List;

public class Biblioteca {
	private List<Socio> socios;
	private Target exporter;

	public Biblioteca() {
		socios = new ArrayList<>();
		exporter= new JSONAdapter(); 
	}

	public void agregarSocio(Socio socio) {
		socios.add(socio);
	}

	/**
	 * Retorna la representación JSON de la colección de socios.
	 */
	public String exportarSocios() {
		return exporter.exportar(socios);
	}

	public Target getExporter() {
		return exporter;
	}

	public void setExporter(Target exporter) {
		this.exporter = exporter;
	}
}
