package es.uma.informatica.sii.oac.controladores;

import java.io.Serializable;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Iterator;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import es.uma.informatica.sii.agendaee.entidades.Actividades;
import es.uma.informatica.sii.agendaee.entidades.InformeActividades;



@Named(value ="controladorValoraciones")
@RequestScoped
public class controladorValoraciones implements Serializable{
	private Actividades actividad;
	private ArrayList<Actividades> actividades;
	private InformeActividades informe;
	private ArrayList<InformeActividades> informes;
	private ArrayList<InformeActividades> informesValorados;
	

	public controladorValoraciones() throws ParseException{
		
	}


	public Actividades getActividad() {
		return actividad;
	}


	public void setActividad(Actividades actividad) {
		this.actividad = actividad;
	}


	public ArrayList<Actividades> getActividades() {
		return actividades;
	}


	public void setActividades(ArrayList<Actividades> actividades) {
		this.actividades = actividades;
	}


	public InformeActividades getInforme() {
		return informe;
	}


	public void setInforme(InformeActividades informe) {
		this.informe = informe;
	}


	public ArrayList<InformeActividades> getInformes() {
		return informes;
	}


	public void setInformes(ArrayList<InformeActividades> informes) {
		this.informes = informes;
	}
	
	
	
	public ArrayList<InformeActividades> getInformesValorados() {
		return informesValorados;
	}


	public void setInformesValorados(ArrayList<InformeActividades> informesValorados) {
		this.informesValorados = informesValorados;
	}


	public String verValoracion(Long id) {
    	Iterator<InformeActividades> i = informes.iterator();
    	informesValorados = new ArrayList<>();
        while (i.hasNext()) {
            informe = i.next();
            if (informe.getAct().getIdActividad()==id) {
                informesValorados.add(informe);
            }
        }
        return "verValoracionActividad.xhtml";
    }
	
	
	
}
