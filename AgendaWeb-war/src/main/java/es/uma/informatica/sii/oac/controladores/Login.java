/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package es.uma.informatica.sii.oac.controladores;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import es.uma.informatica.sii.agendaee.entidades.Alumno;
import es.uma.informatica.sii.agendaee.entidades.Ong;
import es.uma.informatica.sii.agendaee.entidades.Profesor;
import es.uma.informatica.sii.agendaee.entidades.Usuario;
import es.uma.informatica.sii.agendaee.entidades.Usuario.Rol;



@Named(value = "login")
@RequestScoped
public class Login {

   private String email;
   private String contrasenia;
   private List<Usuario> usuarios;
   private List<Alumno> alumnos;
   
   @Inject
   private ControlAutorizacion ctrl;

   /**
    * Creates a new instance of Login
    */
   public Login() {
       

   }

   public String getEmail() {
       return email;
   }

   public String getcontrasenia() {
       return contrasenia;
   }

   public void setEmail(String usuario) {
       this.email = usuario;
   }

   public void setcontrasenia(String contrasenia) {
       this.contrasenia = contrasenia;
   }

   public String autenticar() {
       // Implementar este método
       FacesContext ctx = FacesContext.getCurrentInstance();
       
       if(email == null) { //si no se introduce usuario
       	return "login.xhtml";
       }
       
       //creo un iterador para buscar en la lista y un comprobador
       boolean esta = false;
       Iterator i = usuarios.iterator(); //el metodo contains no puede usarse porque se introduce una clase Usuario
       //creamos un auxiliar para guardar el usuario encontrado si es que se encuentra
       Usuario act = null;
               
       //recorremos la lista y comprobamos si se encuentra el usuario
       while(i.hasNext() && !esta) {
       	act = (Usuario) i.next();
       	if(act.getEmail().equals(email)) {
       		esta = true;
       	}
       }
       
       //si el usuario esta en la lista, se comprueba que su contrasenia sea valida
       if(esta) {
       	if(act.getContrasenia().equals(contrasenia)) {
       		ctrl.setEmail(act);
       		return ctrl.home();
       		
       	}else {//si la contrasenia no es correcta, muestra error
       		ctx.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERROR. contrasenia equivocada", "ERROR. contrasenia equivocada"));
       	}
       }else {//si el usuario no esta en la lista, se muestra error
       	ctx.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Este usuario no existe", "Este usuario no existe"));
       }
       
       
       //ctx.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "", ""));
       return null;
   }
}
