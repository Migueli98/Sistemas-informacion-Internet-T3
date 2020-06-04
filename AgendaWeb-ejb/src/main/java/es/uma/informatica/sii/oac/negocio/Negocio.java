
package es.uma.informatica.sii.oac.negocio;

import java.util.List;

import javax.ejb.Local;

import es.uma.informatica.sii.agendaee.entidades.Actividades;
import es.uma.informatica.sii.agendaee.entidades.Actividades.Estado;
import es.uma.informatica.sii.agendaee.entidades.Alumno;


import es.uma.informatica.sii.agendaee.entidades.Curriculum;
import es.uma.informatica.sii.agendaee.entidades.InformeActividades;
import es.uma.informatica.sii.agendaee.entidades.Inscripciones;
import es.uma.informatica.sii.agendaee.entidades.Ong;
import es.uma.informatica.sii.agendaee.entidades.Profesor;
import es.uma.informatica.sii.agendaee.entidades.Servicios;
import es.uma.informatica.sii.agendaee.entidades.Usuario;


@Local
public interface Negocio {
   // public void registrarUsuario(Usuario u, UriBuilder uriBuilder) throws AgendaException;
   
	public void inicializar();
	
	//Comprobar que el usuario logeado esta en la bd
	public void compruebaLogin(Usuario u) throws AprendizajeServicioException;
	public Usuario refrescarUsuario(Usuario u) throws AprendizajeServicioException;
	
	//Mostrar entidades
	public List<Actividades> allActividades();
	public List<Actividades> allActividadesEstado(Estado estado);
	public List<InformeActividades> allInformeActividades();
	public List<InformeActividades> allInformeActividadesProfesor(Profesor pro);
	public List<Inscripciones> allInscripciones(Usuario u);
	public List<Ong> allOng();
	public List<Usuario> allProfesor();
	public List<Servicios> allServicios();
	public List<Usuario> allUsuario();
	public List<Usuario> allUsuarioAP();
	public List<Inscripciones> allInscripciones();
	List<Actividades> allActividadesAlumno(Usuario u);

	
	//Aniadir elementos a las entidades
	public void addActividades(Actividades a);
	public void addInformeActividades(InformeActividades a);
	public void addInscripciones(Inscripciones a) throws AprendizajeServicioException;
	public void addServicios(Servicios a);
	public void addUsuario(Usuario a);
	public void addOng(Ong ongAd);
	
	//Eliminar elementos de las entidades
	public void deleteActividades(Actividades a) throws AprendizajeServicioException;
	public void deleteInscripciones(Inscripciones a);
	public void deleteOng(Ong a);
	public void deleteServicios(Servicios a);
	public void deleteUsuario(Usuario a);
	
	//Modificar elementos de las entidades
	public void updateActividades(Actividades a);
	public void updateAlumno(Alumno a) throws AprendizajeServicioException;
	public void updateCurriculum(Curriculum a);
	public void updateOng(Ong a);
	public void updateServicios(Servicios a);
	public void updateUsuario(Usuario a);
	public void updateInscripciones(Inscripciones a);
	public void updateInforme(InformeActividades informe);

	//Buscar por clave primaria en las entidades
	public Actividades findActividades(Long id) throws AprendizajeServicioException;
	public Alumno findAlumno(String id); 
	public Curriculum findCurriculum(Long id);
	public InformeActividades findInformeActividades(Actividades a, Usuario u);
	public Inscripciones findInscripciones(Long id);
	public Ong findOng(String id);
	public Profesor findProfesor(String id);
	public Servicios findServicios(Long id);
	public List<Servicios> findServiciosOng(Usuario ong);
	public Usuario findUsuario(String id);
	public InformeActividades findInformeActividadesId(Long id);

	


	
}

