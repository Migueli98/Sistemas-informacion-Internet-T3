package es.uma.informatica.sii.oac.vista;

import java.io.Serializable;
import java.text.ParseException;
import java.util.ArrayList;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import es.uma.informatica.sii.agendaee.entidades.Asignaturas;

@Named(value = "controladorAsignaturas")
@SessionScoped
public class controladorAsignaturas implements Serializable {

	private ArrayList<Asignaturas> asignaturas;
	private Asignaturas asignatura;

	public controladorAsignaturas() throws ParseException {
		asignaturas = new ArrayList<>();

	
	}

	public ArrayList<Asignaturas> getAsignaturas() {
		return asignaturas;
	}

	public void setAsignaturas(ArrayList<Asignaturas> asignaturas) {
		this.asignaturas = asignaturas;
	}

	public Asignaturas getAsignatura() {
		return asignatura;
	}

	public void setAsignatura(Asignaturas asignatura) {
		this.asignatura = asignatura;
	}

	public String borrarAsignatura(int id) {
		boolean encontrado = false;
		int cont = 0;
		while (!encontrado) {
			Asignaturas ac = asignaturas.get(cont);
			if (ac.getCodigoAsignatura() == (id)) {
				asignaturas.remove(cont);
				encontrado = true;
			}
			cont++;
		}
		return "asignaturas.xhtml";
	}

	public String asignaturas() {
		return "asignaturas.xhtml";
	}

	public String crearAsignatura() {
		return "crearAsignatura.xhtml";
	}

}
