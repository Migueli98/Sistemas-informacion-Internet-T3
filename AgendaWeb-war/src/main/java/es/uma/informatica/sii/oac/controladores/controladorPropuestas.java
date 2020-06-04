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

import es.uma.informatica.sii.agendaee.entidades.Actividades;
import es.uma.informatica.sii.agendaee.entidades.Inscripciones;
import es.uma.informatica.sii.agendaee.entidades.Ong;
import es.uma.informatica.sii.agendaee.entidades.Servicios;
import es.uma.informatica.sii.agendaee.entidades.Actividades.Estado;
import es.uma.informatica.sii.oac.negocio.AprendizajeServicioException;
import es.uma.informatica.sii.oac.negocio.Negocio;



@Named(value ="controladorPropuestas")
@RequestScoped
public class controladorPropuestas implements Serializable{
	private List<Actividades> actividades;
	private Actividades actividad;
	private List<Servicios> servicios;
	private Servicios servicio;
	private Long codigo;
	private String fechaI;
	private String fechaF;
	
	@Inject
	Negocio bd;
	
	public controladorPropuestas() throws ParseException{
		servicio = new Servicios();
		servicios = new ArrayList<Servicios>();
		actividad = new Actividades();
		fechaI = "dd/mm/yyyy";
		fechaF = "dd/mm/yyyy";
		actividades = new ArrayList<Actividades>();
	}

	public List<Actividades> getActividades(Ong ong) throws AprendizajeServicioException {
		
		List <Actividades> activ = new ArrayList<Actividades>();
		List<Servicios> serv = new ArrayList<Servicios>();
		Servicios ns = new Servicios();
		actividades = new ArrayList<Actividades>();
		serv = bd.findServiciosOng(ong);
		
		for(Servicios s : serv) {	
			activ = bd.allActividades();
			for(Actividades a : activ) {
				ns = bd.findServicios(a.getServicio().getCodigoServicio());
				if(ns.getCodigoServicio() == s.getCodigoServicio()) {
					actividades.add(a);
				}
			}
		}		
		return actividades;
	}
	
	public List<Actividades> getPropuestasActividades(){
		
		List<Actividades> ac = new ArrayList<Actividades>();
		List<Actividades> res = new ArrayList<Actividades>();
		ac = bd.allActividades();
		for(Actividades a : ac) {
			if (a.getEstado()==Estado.PENDIENTE) {
				res.add(a);
			}
		}

		return res;
	}
	
	public String aceptarPropuestaActividad(Long id) throws AprendizajeServicioException {
		
		Actividades a = new Actividades();
		a = bd.findActividades(id);
		a.setEstado(Estado.BUSCANDO_PARTICIPANTES);
		bd.updateActividades(a);
		
		return "propuestas.xhtml";
	}
	
	public String denegarPropuestaActividad(Long id) throws AprendizajeServicioException {
		Actividades a = new Actividades();
		a = bd.findActividades(id);
		a.setEstado(Estado.RECHAZADA);
		bd.updateActividades(a);
		
		return "propuestas.xhtml";
	}

	public void setActividades(ArrayList<Actividades> actividades) {
		this.actividades = actividades;
	}

	public Actividades getActividad() {
		return actividad;
	}

	public void setActividad(Actividades actividad) {
		this.actividad = actividad;
	}
	
	
	public List<Servicios> getServicios(Ong ong) {
		
		servicios = bd.findServiciosOng(ong);
		
		return servicios;
	}
	
	public List<Servicios> getAllServicios(){
		
		servicios = bd.allServicios();
		return servicios;
	}
	
	
	public void setServicios(ArrayList<Servicios> servicios) {
		this.servicios = servicios;
	}

	public Servicios getServicio() {
		return servicio;
	}

	public void setServicio(Servicios servicio) {
		this.servicio = servicio;
	}
	
	public String getFechaI() {
		return fechaI;
	}

	public void setFechaI(String fechaI) {
		this.fechaI = fechaI;
	}

	public String getFechaF() {
		return fechaF;
	}

	public void setFechaF(String fechaF) {
		this.fechaF = fechaF;
	}

	
	
	public String borrarServicio(Long id){
    
		List<Actividades> act = new ArrayList<Actividades>();
		act = bd.allActividades();
		
		for(Actividades a : act) {
			if(a.getServicio().getCodigoServicio() == id) {
				FacesMessage fm = new FacesMessage("No se puede borrar un servicio con actividades asignadas");
	            FacesContext.getCurrentInstance().addMessage("login:pass", fm);
	        	return "serviciosActivos.xhtml";
			}
		}
		
		bd.deleteServicios(bd.findServicios(id));
		
        return "serviciosActivos.xhtml";
    }
	
	//MODIFICAR
    public String modificarPropuestaActividad(){
        return "modificarPropuestaActividad.xhtml";
    }
    
    public String modificarServicio(Long id){
    	
    	servicio = bd.findServicios(id);
    	
        return "modificarServicio.xhtml";
    }
    //s
    //VER
    public String verPropuestaActividad(){
       return "verPropuestaActividad.xhtml";
     }
    
    public String verPropuestaServicio(){
        return "verPropuestaServicio.xhtml";
      }
    
    //GUARDAR
    public String guardarPropuestaActividad() {
    	return "propuesta.xhtml";
    }
    
    public String guardarPropuestaServicio() {
    	return "propuestas.xhtml";
    }
    
    //MODIFICAR
    public Actividades inicializarPropuestaActividad() throws ParseException{
    	
    	
    	actividad.setNombreActividad("");  	
    	actividad.setTipoActividad("");
    	actividad.setLugarRealizacion("");
    	actividad.setDescripcion("");
    	actividad.setEstado(Estado.PENDIENTE);
    	actividad.setServicio(servicio);
    	actividad.setIdiomas("");
    	actividad.setExperienciaLaboral("");
    	actividad.setDisponibilidad("");
    	
    	
    	
       return actividad;
    }
    
    public Servicios inicializarS(Ong ong) {
    	
    	servicio.setDescripcion("");
		servicio.setNombre("");
		servicio.setNumHoras(0);
		servicio.setTipoServicio("");
		servicio.setNumParticipantes(0);
		servicio.setZona("");
		servicio.setOng(ong);
    	
		return servicio;
    }
    
    
    
    public String crearPropuestaServicio(Ong email){
    	
    	bd.addServicios(servicio);
    	
        return "serviciosActivos.xhtml";
     }
    
    
    public String guardarServicio(Ong ong) throws AprendizajeServicioException {
    	servicio.setOng(ong);
    	bd.updateServicios(servicio);
    	
    	
    	return "serviciosActivos.xhtml";
    }
    
    public String crearPropuestaActividad(Long id) {
    	
    	servicio = bd.findServicios(id);
    	
    	return "crearPropuestaActividad.xhtml";
    }
    
    public String crearPropuestaActividad() throws ParseException, AprendizajeServicioException {
    
    	servicio = bd.findServicios(servicio.getCodigoServicio());
    	actividad.setServicio(servicio);
    	SimpleDateFormat dateformat1 = new SimpleDateFormat("dd/MM/yyyy");
    	actividad.setFechaInicioActividad(dateformat1.parse(fechaI));
    	actividad.setFechaFinActividad(dateformat1.parse(fechaF));
    	bd.addActividades(actividad);
    	return "propuestas.xhtml";
    }
    
    public String borrarActividad(Long a) throws AprendizajeServicioException{	
    	Actividades act = new Actividades();
    	act = bd.findActividades(a);
    	boolean puede = true;
    	
    	List<Inscripciones> inf= new ArrayList<Inscripciones>();
    	inf = bd.allInscripciones();
    	
    	for(Inscripciones i : inf) {
    		if(i.getActividad().getIdActividad() == act.getIdActividad()) {
    	        puede = false;
    		}
    	}

    	
		if(bd.findActividades(a).getEstado() == Estado.EN_CURSO || bd.findActividades(a).getEstado() == Estado.REALIZADA) { 	
			FacesMessage fm = new FacesMessage("No se puede eliminar una actividad en curso o terminada");
	        FacesContext.getCurrentInstance().addMessage("login:pass", fm);

		}else if(!puede){
			FacesMessage fm = new FacesMessage("No se puede eliminar una actividad con participantes inscritos");
	        FacesContext.getCurrentInstance().addMessage("login:pass", fm);
			
		}else {
			bd.deleteActividades(act);
		}
		
        return "propuestas.xhtml";
    }
  
    public String iniciarActividad(Long id) throws AprendizajeServicioException {
    	
    	Actividades a = new Actividades();
    	a = bd.findActividades(id);
    	
    	if(a.getEstado() == Estado.BUSCANDO_PARTICIPANTES || a.getEstado() == Estado.ACEPTADA) {
    		a.setEstado(Estado.EN_CURSO);
    		bd.updateActividades(a);
    	}else {
    		FacesMessage fm = new FacesMessage("No se puede inciar una actividad con este estado: "+ a.getEstado());
            FacesContext.getCurrentInstance().addMessage("login:pass", fm);

    	}

    	return "propuestas.xhtml";
    }
    
    public String terminarActividad(Long id) throws AprendizajeServicioException {
    	
    	Actividades a = new Actividades();
    	a = bd.findActividades(id);
    	
    	if(a.getEstado() == Estado.EN_CURSO) {
    		a.setEstado(Estado.REALIZADA);
    		bd.updateActividades(a);
    	}else {
    		FacesMessage fm = new FacesMessage("No se puede terminar una actividad con este estado: "+ a.getEstado());
            FacesContext.getCurrentInstance().addMessage("login:pass", fm);

    	}

    	return "propuestas.xhtml";
    }

}
