/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package es.uma.informatica.sii.oac.controladores;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import es.uma.informatica.sii.agendaee.entidades.Alumno;
import es.uma.informatica.sii.agendaee.entidades.Usuario;
import es.uma.informatica.sii.oac.negocio.AprendizajeServicioException;
import es.uma.informatica.sii.oac.negocio.ContraseniaInvalidaException;
import es.uma.informatica.sii.oac.negocio.CuentaInexistenteException;
import es.uma.informatica.sii.oac.negocio.Negocio;



@Named(value = "login")
@RequestScoped
public class Login {

   
   @Inject
   private ControlAutorizacion ctrl;
   
   @Inject 
   private Negocio bd;
     
   private Usuario email;


   /**
    * Creates a new instance of Login
    */
   public Login() {
	   email = new Usuario();
   }

	public String autenticar() {
		try {

			bd.compruebaLogin(email);
			ctrl.setEmail(bd.refrescarUsuario(email));
			return "inicio.xhtml";

		} catch (CuentaInexistenteException e) {
			FacesMessage fm = new FacesMessage("La cuenta no existe");
			FacesContext.getCurrentInstance().addMessage("login:user", fm);
		} catch (ContraseniaInvalidaException e) {
			FacesMessage fm = new FacesMessage("La contraseña no es correcta");
			FacesContext.getCurrentInstance().addMessage("login:pass", fm);
		} catch (AprendizajeServicioException e) {
			FacesMessage fm = new FacesMessage("Error: " + e);
			FacesContext.getCurrentInstance().addMessage(null, fm);
		}
		return null;
	}

	public Usuario getEmail() {
		return email;
	}

	public void setEmail(Usuario email) {
		this.email = email;
	}
	
}

