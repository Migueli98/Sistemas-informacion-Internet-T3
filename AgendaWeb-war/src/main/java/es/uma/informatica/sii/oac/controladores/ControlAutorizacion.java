/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package es.uma.informatica.sii.oac.controladores;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import es.uma.informatica.sii.agendaee.entidades.Actividades;
import es.uma.informatica.sii.agendaee.entidades.Alumno;
import es.uma.informatica.sii.agendaee.entidades.Ong;
import es.uma.informatica.sii.agendaee.entidades.Usuario;
import es.uma.informatica.sii.agendaee.entidades.Usuario.Rol;
import es.uma.informatica.sii.oac.negocio.AprendizajeServicioException;
import es.uma.informatica.sii.oac.negocio.Negocio;



@Named(value = "controlAutorizacion")
@SessionScoped
public class ControlAutorizacion implements Serializable {


   @Inject 
   private Negocio bd;
   
   private Usuario email;
   private Alumno alumno;
   private Ong ong;
   private Ong ongAd;
   private List<Ong> ongs;
   
   public ControlAutorizacion() {
		ong = new Ong();
		ongAd = new Ong();
		ongs = new ArrayList<Ong>();
   }
   
   public void setEmail(Usuario usuario) {
       this.email = usuario;
   }

   public Usuario getEmail() {
       return this.email;
   }
   
   
   
   public Ong getOngAd() {
	return ongAd;
}

   public void setOngAd(Ong ongAd) {
	this.ongAd = ongAd;
   }

   public void setAlumno(Alumno al) {
       alumno = al;
   }

   public Alumno getAlumno() {
       return alumno;
   }
   public Ong getOng() {
		return ong;
   }
	
   public void setOng(Ong ong) {
		this.ong = ong;
   }

public String home() {
	   String cad = "login.xhtml";
	   
   	if(email.getRol().equals(Usuario.Rol.ADMIN)) {
   		cad = "inicio.xhtml";
   	
   	}else if(email.getRol().equals(Usuario.Rol.ALUMNO)) {
   		cad = "inicio.xhtml";
   		
   	}else if(email.getRol().equals(Usuario.Rol.ONG)) {
   		cad = "inicio.xhtml";
   		
   	}else if(email.getRol().equals(Usuario.Rol.PASPDI)) {
   		cad = "inicio.xhtml";
   		
   	}
   	
   	return cad;
   }
   
  
	
	public String bd() {
		
		bd.inicializar();
		return "login.xhtml";
	}
   
   public String logout()
   {
       // Destruye la sesión (y con ello, el ámbito de este bean)
       FacesContext ctx = FacesContext.getCurrentInstance();
       ctx.getExternalContext().invalidateSession();
       email = null;
       return "login.xhtml";
   }

   /**
    * Creates a new instance of ControlAutorizacion
    */
   
   
   public String MisActividades(){
       return "MisActividades.xhtml";
   }
   
   public String miPerfil() {
	   return "miPerfil.xhtml";
   }
   
   public boolean isInicializadaBd() throws AprendizajeServicioException {
	   
	   List<Usuario> usu = bd.allUsuario();
	   
	   return usu.isEmpty();
   }
   
   public String modificarPerfilAlumno() throws AprendizajeServicioException {
	   	alumno = (Alumno) email;
	   	
		bd.updateAlumno(bd.findAlumno(alumno.getEmail()));
		bd.refrescarUsuario(alumno);
		
	   //bd.updateAlumno();
	
	   return "miPerfil.xhtml";
   }
   
   public String modificarPerfilOng() throws AprendizajeServicioException {
	   	ong = (Ong) email;
	   	
		bd.updateOng(bd.findOng(ong.getEmail()));
		bd.refrescarUsuario(ong);
		
	
	   return "miPerfil.xhtml";
  }
   
   public String modificarOngAd(String ong) throws AprendizajeServicioException {
	 
	   ongAd = bd.findOng(ong);
	   

	   return "modificarOngAd.xhtml";
 }
   
   public String guardarModificacionOng (String ong) throws AprendizajeServicioException {

	   bd.updateOng(ongAd);
	   
	   return "verOngsAd.xhtml";
   }
   
   public String borrarOng(String ong) {
	   
	   bd.deleteOng(bd.findOng(ong));
	   
	   return "verOngsAd.xhtml";
   }
   
   public List<Ong> verOngsAd(){
	   
	   ongs = bd.allOng();
	   return ongs;
   }
   
   public String verOngs() {
	   return "verOngsAd.xhtml";
   }
   
   public String modificarUsuario() throws AprendizajeServicioException {
	   
	   bd.updateUsuario(email);
	   bd.refrescarUsuario(email);
	   return "miPerfil.xhtml";
   }
   
   public Ong inicializarOng() {
	   ongAd.setEmail("");
	   ongAd.setRol(Rol.ONG);
	   ongAd.setNombreONG("");
	   ongAd.setContrasenia("");
	   ongAd.setDireccion("");
	   ongAd.setTelefono("999999999");
	   ongAd.setCiudad("");
	   ongAd.setPais("");
	   ongAd.setPaginaWeb("");

	   return ongAd;
   }
   

   public String crearOng() {
	   return "crearOngAd.xhtml";
   }
   
   public String persistOng() {
	   
	   bd.addOng(ongAd);
	   
	   return "verOngsAd.xhtml";
   }
   
   public String proyectosAdPP() {
	   return "ProyectosAdPasPdi.xhtml";
   }
   
   public String verUsuarios() {
	   return "verUsuariosAd.xhtml";
   }
   

   
   public String verBuscarActividades() {
	   return "buscarActividades.xhtml";
   }
   
   public String propuestasOng() {
	   return "propuestas.xhtml";
   }
   
   public String serviciosActivos() {
	   return "serviciosActivos.xhtml";
   }
   
   public String inscripcionActividad() {
	   return "inscripcionActividad.xhtml";
   }
   
   public String supervisionActividad() {
	   return "supervisionActividad.xhtml";
   }
   
   public String evaluarParticipante() {
	   return "evaluacionActividades.xhtml";
   }
   
   public String valoraciones() {
	   return "valoraciones.xhtml";
   }

   public String asignarProfesores() {
	   return "asignarProfesores.xhtml";
   }
   
   
}
