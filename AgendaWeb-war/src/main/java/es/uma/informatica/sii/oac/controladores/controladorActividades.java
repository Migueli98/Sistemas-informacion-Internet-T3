package es.uma.informatica.sii.oac.controladores;



import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import es.uma.informatica.sii.agendaee.entidades.Actividades;
import es.uma.informatica.sii.agendaee.entidades.Actividades.Estado;
import es.uma.informatica.sii.agendaee.entidades.Inscripciones.estadoInscripcion;
import es.uma.informatica.sii.agendaee.entidades.Alumno;

import es.uma.informatica.sii.agendaee.entidades.Curriculum;
import es.uma.informatica.sii.agendaee.entidades.InformeActividades;
import es.uma.informatica.sii.agendaee.entidades.Inscripciones;
import es.uma.informatica.sii.agendaee.entidades.Ong;
import es.uma.informatica.sii.agendaee.entidades.Profesor;
import es.uma.informatica.sii.agendaee.entidades.Servicios;
import es.uma.informatica.sii.agendaee.entidades.Usuario;
import es.uma.informatica.sii.agendaee.entidades.Usuario.Rol;
import es.uma.informatica.sii.oac.negocio.AprendizajeServicioException;
import es.uma.informatica.sii.oac.negocio.Negocio;






@Named(value ="controladorActividades")
@RequestScoped
public class controladorActividades implements Serializable {
	
	private ArrayList<Actividades> actividades;
	private Actividades actividad;
	private ArrayList<InformeActividades> informes;
	private InformeActividades informe;
	private List<Inscripciones> inscripciones;
	private List<Inscripciones> ins;
	private Actividades inscripcion;
	private ArrayList<Actividades> supervisiones;
	private Actividades supervision;
	private ArrayList<Usuario> usuarios;
	private Usuario usuario;
	
	private ArrayList<Usuario> usuariosActividad;
	private ArrayList<Actividades> evaluacionActividades;
	private ArrayList<Usuario> profesores;
	private Curriculum curriculum;
	private Usuario a;
	
	   @Inject 
	   private Negocio bd;
	    
	   
	   
	    public controladorActividades() throws ParseException {
	    	actividades = new ArrayList<Actividades>();
            informe = new InformeActividades();
            curriculum= new Curriculum();
            a = new Usuario();
	    }
	    
	    public String getNombreApellido(Profesor p) {
	    	return p.getNombre().concat(p.getApellido());
	    }
	    

	   



		public ArrayList<Usuario> getUsuarios() {
			return usuarios;
		}



		public void setUsuarios(ArrayList<Usuario> usuarios) {
			this.usuarios = usuarios;
		}



		public Usuario getUsuario() {
			return usuario;
		}



		public void setUsuario(Usuario usuario) {
			this.usuario = usuario;
		}



		public List<Inscripciones> getInscripciones(Ong ong) {
			
			List <Inscripciones> inscrip = new ArrayList<>();
			List<Inscripciones> resultado = new ArrayList<>();
			
			List <Actividades> activ = new ArrayList<Actividades>();
			List<Servicios> serv = new ArrayList<Servicios>();
			Servicios ns = new Servicios();
			List<Actividades> activ2 = new ArrayList<Actividades>();
			serv = bd.findServiciosOng(ong);
			
			for(Servicios s : serv) {	
				activ = bd.allActividades();
				for(Actividades a : activ) {
					ns = bd.findServicios(a.getServicio().getCodigoServicio());
					if(ns.getCodigoServicio() == s.getCodigoServicio()) {
						if(a.getEstado() == Estado.BUSCANDO_PARTICIPANTES) {
							activ2.add(a);
						}
					}
				}
			}
			
			inscrip = bd.allInscripciones();
			
			for(Inscripciones i : inscrip) {				
				for(Actividades a : activ2) {
					if(a.getIdActividad() == i.getActividad().getIdActividad()) {
						resultado.add(i);	
					}
				}
			}
			
			return resultado;
		}

		


		public void setSupervisiones(ArrayList<Actividades> supervisiones) {
			this.supervisiones = supervisiones;
		}



		public Actividades getSupervision() {
			return supervision;
		}



		public void setSupervision(Actividades supervision) {
			this.supervision = supervision;
		}



		public List<Actividades> getInscripciones(Usuario u) throws AprendizajeServicioException {
			ins = new ArrayList<Inscripciones>();
			ins = bd.allInscripciones(u);
			List<Actividades> acti = new ArrayList<Actividades>();
			List<Actividades> acts = new ArrayList<Actividades>();
			acts = bd.allActividades();
			
			for (Actividades a : acts) {
				for (Inscripciones i : ins) {
					if(a.getIdActividad() ==i.getActividad().getIdActividad()) {
						if(a.getEstado() == Estado.BUSCANDO_PARTICIPANTES) {
							acti.add(a);
						}
					}
				}
			}
			
			return acti;
		}


		public void setInscripciones(List<Inscripciones> inscripciones) {
			this.inscripciones = inscripciones;
		}



		public Actividades getInscripcion() {
			return inscripcion;
		}


		public void setInscripcion(Actividades inscripcion) {
			this.inscripcion = inscripcion;
		}

	    
	    public ArrayList<InformeActividades> getInformes() {
			return informes;
		}

		public void setInformes(ArrayList<InformeActividades> informes) {
			this.informes = informes;
		}

		public String igual (Long i, Long a) {
			if (i == a) {
				return "si";
			}
			return "no";
		}
		

		public String getInforme(Actividades a, Usuario u) {			
			informe = bd.findInformeActividades(a, u);
			
			return "verInformeActividad.xhtml";
		}

		public void setInforme(InformeActividades informe) {
			this.informe = informe;
		}

		public String borrarActividad(int id){
	    	
	        return "inscripcionActividad.xhtml";
	    }
	    
		public String cancelarInscripcion(int id, Usuario u){
			ins = new ArrayList<Inscripciones>();
			ins = bd.allInscripciones(u);
			List<Actividades> acts = new ArrayList<Actividades>();
			acts = bd.allActividades();
			
			
			for (Actividades a : acts) {
				for (Inscripciones i : ins) {
					if((a.getIdActividad() ==i.getActividad().getIdActividad()) && (a.getIdActividad()== id)) {
						bd.deleteInscripciones(i);
						
					}
				}
				
			}

	        return "inscripcionActividad.xhtml";
	    }
		
		public String aceptarSolicitud(Long id) {
			
			
			Inscripciones i = new Inscripciones();
			i = bd.findInscripciones(id);
			
			if(i.getEstado() == estadoInscripcion.ACEPTADO) {
				FacesMessage fm = new FacesMessage("No se aceptar 2 veces al mismo alumno a la misma asignatura");
	            FacesContext.getCurrentInstance().addMessage("login:pass", fm);
			}else {
				i.setEstado(estadoInscripcion.ACEPTADO);
				
				bd.updateInscripciones(i);
				
				if(i.getUsuario().getRol() == Rol.ALUMNO) {
					InformeActividades in = new InformeActividades(); 
					in.setActividades(i.getActividad());
					in.setAlumno((Alumno) i.getUsuario());
					in.setInformeONG("");
					in.setInformeProfesor("");
					in.setValoracionAlumno("");
					in.setEstado(InformeActividades.Estado.EN_CURSO);
					bd.addInformeActividades(in);
				}
			}
			
			
			return "supervisionActividad.xhtml";
		}
		
		
	    public String modificarActividad(){
	        return "ModificarActividades.xhtml";
	    }
	 
	    
	 
	    public String verActividades(){
	       return "verActividades.xhtml";
	     }
	    
	    public String guardarValoracion(Long id) throws AprendizajeServicioException {
	    	InformeActividades i = bd.findInformeActividadesId(id);
	    	i.setValoracionAlumno(informe.getValoracionAlumno());
	    	
	    	bd.updateInforme(i);
	    	
	    	return "MisActividades.xhtml";
	    }
	     
	    public String crearActividad(){
	       return "crearActividad.xhtml";
	    }

	    public Actividades getActividad() {
	        return actividad;
	    }

	    public void setActividad(Actividades actividad) {
	        this.actividad = actividad;
	    }
	    
	    public String verInformeActividad(Long id) {
	    	Iterator<InformeActividades> i = informes.iterator();
            Boolean encontrado = false;
            while (i.hasNext() && !encontrado) {
                informe = i.next();
                if (informe.getActividades().getIdActividad()==id) {
                    encontrado = true;
                }
            }
            return "verInformeActividad.xhtml";
	    }
	    
	    public String valorarActividad() {
	    	return "valorarActividad.xhtml";
	    }
	    
	    public String inscripcionActividad() {
	    	return "inscripcionActividad.xhtml";
	    }
	    
	    public String supervisionActividad() {
	    	return "supervisionActividad.xhtml";
	    }
	    
	    public String evaluarParticipante() {
	    	return "evaluarParticipante.xhtml";
	    }

		public ArrayList<Usuario> getUsuariosActividad() {
			return usuariosActividad;
		}

		public Curriculum getCurriculum() {
			return curriculum;
		}

		public void setCurriculum(Curriculum curriculum) {
			this.curriculum = curriculum;
		}

		public void setUsuariosActividad(ArrayList<Usuario> usuariosActividad) {
			this.usuariosActividad = usuariosActividad;
		}

		public ArrayList<Actividades> getEvaluacionActividades() {
			return evaluacionActividades;
		}

		public void setEvaluacionActividades(ArrayList<Actividades> evaluacionActividades) {
			this.evaluacionActividades = evaluacionActividades;
		}

		public ArrayList<Usuario> getProfesores() {
			return profesores;
		}

		public void setProfesores(ArrayList<Usuario> profesores) {
			this.profesores = profesores;
		}

		public List<Actividades> getActividades(Usuario u) {
			actividades = new ArrayList<Actividades>();
			List<Actividades> a1 = new ArrayList<Actividades>();
			a1 = bd.allActividadesEstado(Actividades.Estado.EN_CURSO);
			List<Actividades> a2 = new ArrayList<Actividades>();
			a2 = bd.allActividadesEstado(Actividades.Estado.REALIZADA);
			a1.addAll(a2);
			List<Inscripciones> in = new ArrayList<Inscripciones>();
			in = bd.allInscripciones(u);
			List<Actividades> acti = new ArrayList<Actividades>();
			
			
			for(Actividades a : a1) {
				for(Inscripciones i : in ) {
					if(a.getIdActividad() == i.getActividad().getIdActividad()) {
						actividades.add(a);
					}
				}
			}
			
			
			return actividades;
		}

		
		public void setActividades(ArrayList<Actividades> actividades) {
			this.actividades = actividades;
		}

		public ArrayList<Actividades> getActividades() {
			return actividades;
		}

		public InformeActividades getInforme() {
			return informe;
		}
		
		public String verCurriculum(String email){
			
			a = bd.findUsuario(email);
			
			if(a.getRol() == Rol.PASPDI) {
				FacesMessage fm = new FacesMessage("Este usuario es un profesor. Los profesores no tienen CV");
	            FacesContext.getCurrentInstance().addMessage("login:pass", fm);
			}else {
				curriculum = ((Alumno) a).getCv();
				return "Curriculum.xhtml";
			}
			
			return "supervisionActividad.xhtml";
		}
		
	    
}
