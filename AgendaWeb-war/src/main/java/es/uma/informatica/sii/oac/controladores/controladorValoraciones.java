package es.uma.informatica.sii.oac.controladores;

import java.io.Serializable;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import es.uma.informatica.sii.agendaee.entidades.Actividades;
import es.uma.informatica.sii.agendaee.entidades.InformeActividades;
import es.uma.informatica.sii.agendaee.entidades.Ong;
import es.uma.informatica.sii.agendaee.entidades.Servicios;
import es.uma.informatica.sii.agendaee.entidades.Usuario;
import es.uma.informatica.sii.oac.negocio.Negocio;



@Named(value ="controladorValoraciones")
@RequestScoped
public class controladorValoraciones implements Serializable{
	private Actividades actividad;
	private List<Actividades> actividades;
	private InformeActividades informe;
	private List<InformeActividades> informes;
	private List<InformeActividades> informesValorados;
	
	@Inject 
	Negocio bd;
	
	public controladorValoraciones() throws ParseException{
		informes = new ArrayList<InformeActividades>();
	}


	public Actividades getActividad() {
		return actividad;
	}


	public void setActividad(Actividades actividad) {
		this.actividad = actividad;
	}


	public List<Actividades> getActividades() {
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


	public List<InformeActividades> getInformes() {
		return informes;
	}


	public void setInformes(ArrayList<InformeActividades> informes) {
		this.informes = informes;
	}
	
	
	
	public List<InformeActividades> getInformesValorados() {
		return informesValorados;
	}


	public void setInformesValorados(ArrayList<InformeActividades> informesValorados) {
		this.informesValorados = informesValorados;
	}
	
	public List<InformeActividades> valoraciones(Usuario u) {
		List<Actividades> act = bd.allActividades();
		List<Servicios> ser = bd.findServiciosOng(u);
		List<Actividades> act2 = new ArrayList<Actividades>();
		List<InformeActividades> inf = bd.allInformeActividades();
		List<InformeActividades> infdefinitivo = new ArrayList<InformeActividades>();
		for(Servicios s : ser) {
			for(Actividades a : act) {
				if(a.getServicio().getCodigoServicio() == s.getCodigoServicio()) {
					act2.add(a);
				}
			}
		}
		
		for(InformeActividades i : inf) {
			for(Actividades a : act2) {
				if(i.getActividades().getIdActividad() == a.getIdActividad()) {
					infdefinitivo .add(i);
				}
			}
		}
				
		return infdefinitivo ;
	}
	
	/**
	 * POR TERMINAR :)
	 * @param infact
	 * @return
	 */
	public String valorar(InformeActividades infact) {
		InformeActividades i = bd.findInformeActividadesId(infact.getIdInforme());
		i.setInformeONG(infact.getInformeONG());
		
		bd.updateInforme(i);
		
		return "valoraciones.xhtml";
	}
	
}
