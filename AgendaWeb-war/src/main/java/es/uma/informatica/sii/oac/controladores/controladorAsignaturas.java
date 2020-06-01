package es.uma.informatica.sii.oac.controladores;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import es.uma.informatica.sii.agendaee.entidades.Asignaturas;
import es.uma.informatica.sii.agendaee.entidades.Actividades.Estado;
import es.uma.informatica.sii.oac.negocio.AprendizajeServicioException;
import es.uma.informatica.sii.oac.negocio.Negocio;

@Named(value = "controladorAsignaturas")
@RequestScoped
public class controladorAsignaturas implements Serializable {

	private ArrayList<Asignaturas> asignaturas;
	private Asignaturas asignatura;

	@Inject
	Negocio bd;
	
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
	
	public String asignaturas() {
		return "asignaturas.xhtml";
	}
	
	public List<Asignaturas> Allasignaturas() {
		return bd.allAsignaturas();
	}

	
	public String crearNuevaAsignatura() {
		asignatura = new Asignaturas();
		
		return "crearAsignatura.xhtml";
	}
	
	public String crearAsignatura() {
		bd.addAsignaturas(asignatura);
    	
		return "crearAsignatura.xhtml";
	}
	
	public String borrarAsignatura(Long id) throws AprendizajeServicioException {
		
		bd.deleteAsignaturas(bd.findAsignaturas(id));
		
		return "asignaturas.xhtml";
		
		
	}
}
