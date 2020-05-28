package es.uma.informatica.sii.oac.controladores;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import es.uma.informatica.sii.agendaee.entidades.Actividades;
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
	
	@Inject
	Negocio bd;
	
	public controladorPropuestas() throws ParseException{
		servicio = new Servicios();
		servicios = new ArrayList<Servicios>();
		actividad = new Actividades();
		
	}

	public List<Actividades> getActividades() {
		return actividades;
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

	public void setServicios(ArrayList<Servicios> servicios) {
		this.servicios = servicios;
	}

	public Servicios getServicio() {
		return servicio;
	}

	public void setServicio(Servicios servicio) {
		this.servicio = servicio;
	}
	
	//BORRAR
	public String borrarPropuestaActividad(int id){
    	boolean encontrado =  false;
    	int cont = 0;
    	while(!encontrado) {
    		Actividades ac = actividades.get(cont);
    		if(ac.getIdActividad() == (id)) {
    			actividades.remove(cont);
    			encontrado = true;
    		}
    		cont++;
    	}
        return "propuestas.xhtml";
    }
	
	public String borrarServicio(Long id){
    	
		
		bd.deleteServicios(bd.findServicios(id));
    	
        return "serviciosActivos.xhtml";
    }
    
	
	
	
	//MODIFICAR
    public String modificarPropuestaActividad(){
        return "modificarPropuestaActividad.xhtml";
    }
    
    public String modificarServicio(Long id){
    	
    	codigo = id;
    	servicio = bd.findServicios(codigo);
    	
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
    public String inicializarPropuestaActividad() throws ParseException{
    	
    	
    	actividad.setNombreActividad("");
    	
    	actividad.setTipoActividad("HOLA");
    	SimpleDateFormat dateformat1 = new SimpleDateFormat("dd/MM/yyyy");
    	actividad.setFechaInicioActividad(dateformat1.parse("01/01/2001"));
    	actividad.setFechaFinActividad(dateformat1.parse("02/01/2001"));
    	actividad.setLugarRealizacion("");
    	actividad.setDescripcion("");
    	actividad.setEstado(Estado.PENDIENTE);
    	actividad.setServicio(servicio);
    	
    	
    	
       return "crearPropuestaActividad.xhtml";
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
    	/*Servicios s = new Servicios();
    	s.setOng(email);
    	s.setDescripcion(servicio.getDescripcion());
    	s.setTipoServicio(servicio.getTipoServicio());
    	s.setNombre(servicio.getNombre());
    	s.setNumHoras(servicio.getNumHoras());
    	s.setZona(servicio.getZona());
*/
    	//servicio.setOng(email);
    	bd.addServicios(servicio);
    	
        return "serviciosActivos.xhtml";
     }
    
    
    public String guardarServicio(Ong ong) throws AprendizajeServicioException {
    	
    	//servicio = bd.findServicios(codigo);
    	//servicio = bd.findServicios(servicio.getCodigoServicio());
    	//if(servicio==null) throw new AprendizajeServicioException("servicio es null");
    	//if (servicio!=null) throw new AprendizajeServicioException(""+servicio.getCodigoServicio());
    	servicio.setOng(ong);
    	bd.updateServicios(servicio);
    	
    	
    	return "serviciosActivos.xhtml";
    }
    
}
