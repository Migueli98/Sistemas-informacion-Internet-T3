/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package es.uma.informatica.sii.oac.controladores;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import es.uma.informatica.sii.agendaee.entidades.Alumno;
import es.uma.informatica.sii.agendaee.entidades.Usuario;
import es.uma.informatica.sii.oac.negocio.Negocio;



@Named(value = "controlAutorizacion")
@SessionScoped
public class ControlAutorizacion implements Serializable {

   private Usuario email;
   private Alumno alumno;

   
   @Inject 
   private Negocio bd;
   
   public void setEmail(Usuario usuario) {
       this.email = usuario;

   }

   public Usuario getEmail() {
       return email;
   }
   
   public void setAlumno(Alumno al) {
       alumno = al;
   }

   public Alumno getAlumno() {
       return alumno;
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
   	/*
	   if(getEmail()==null){
           return "login.xhtml";
       }
       
      
       if(getEmail().getRol().equals(getEmail().getRol().ALUMNO)){
           return "inicio.xhtml";
       }
       
       if(getEmail().getRol().equals(getEmail().getRol().PASPDI)){
           return "inicio.xhtml";
       }
       
       if(getEmail().getRol().equals(getEmail().getRol().ONG)){
           return "inicio.xhtml";
       }
       
       if(getEmail().getRol().equals(getEmail().getRol().ADMIN)){
           return "inicio.xhtml";
       }
       return null;*/
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
   public ControlAutorizacion() {
	 
   }
   
   public String MisActividades(){
       return "MisActividades.xhtml";
   }
   
   public String miPerfil() {
		return "miPerfil.xhtml";
   }
   
   public String proyectosAdPP() {
	   return "ProyectosAdPasPdi.xhtml";
   }
   
   public String verUsuarios() {
	   return "verUsuariosAd.xhtml";
   }
   
   public String verOngs() {
	   return "verOngsAd.xhtml";
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
   
   public String asignaturas() {
	   return "asignaturas.xhtml";
   }
   
   public String asignarProfesores() {
	   return "asignarProfesores.xhtml";
   }
   
   
}
