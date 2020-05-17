
package es.uma.informatica.sii.oac.negocio;

import java.util.List;

import javax.ejb.Local;

import es.uma.informatica.sii.agendaee.entidades.Actividades;
import es.uma.informatica.sii.agendaee.entidades.Alumno;
import es.uma.informatica.sii.agendaee.entidades.Asignaturas;
import es.uma.informatica.sii.agendaee.entidades.Centro;
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
   
	//Comprobar que el usuario logeado esta en la bd
	public void compruebaLogin(Usuario u) throws AprendizajeServicioException;
	public Usuario refrescarUsuario(Usuario u) throws AprendizajeServicioException;
	
	//Mostrar entidades
	public List<Actividades> allActividades();
	public List<Alumno> allAlumno();
	public List<Asignaturas> allAsignaturas();
	public List<Centro> allCentro();
	public List<Curriculum> allCurriculum();
	public List<InformeActividades> allInformeActividades();
	public List<Inscripciones> allInscripciones();
	public List<Ong> allOng();
	public List<Profesor> allProfesor();
	public List<Servicios> allServicios();
	public List<Usuario> allUsuario();
	
	//Añadir elementos a las entidades
	public void addActividades(Actividades a);
	public void addAlumno(Alumno a);
	public void addAsignaturas(Asignaturas a);
	public void addCentro(Centro a);
	public void addCurriculum(Curriculum a);
	public void addInformeActividades(InformeActividades a);
	public void addInscripciones(Inscripciones a);
	public void addOng(Ong a);
	public void addProfesor(Profesor a);
	public void addServicios(Servicios a);
	public void addUsuario(Usuario a);
	
	//Eliminar elementos de las entidades
	public void deleteActividades(Actividades a);
	public void deleteAlumno(Alumno a);
	public void deleteAsignaturas(Asignaturas a);
	public void deleteCentro(Centro a);
	public void deleteCurriculum(Curriculum a);
	public void deleteInformeActividades(InformeActividades a);
	public void deleteInscripciones(Inscripciones a);
	public void deleteOng(Ong a);
	public void deleteProfesor(Profesor a);
	public void deleteServicios(Servicios a);
	public void deleteUsuario(Usuario a);
	
	//Modificar elementos de las entidades
	public void updateActividades(Actividades a);
	public void updateAlumno(Alumno a);
	public void updateAsignaturas(Asignaturas a);
	public void updateCentro(Centro a);
	public void updateCurriculum(Curriculum a);
	//public void updateInformeActividades(InformeActividades a);
	//public void updateInscripciones(Inscripciones a);
	public void updateOng(Ong a);
	public void updateProfesor(Profesor a);
	public void updateServicios(Servicios a);
	public void updateUsuario(Usuario a);

	//Buscar por clave primaria en las entidades
	public Actividades findActividades(Long id);
	public Alumno findAlumno(String id); //¿Debe existir métodos para las entidades que extienden Usuario o vale con los del usuario?
	public Asignaturas findAsignaturas(Long id);
	public Centro findCentro(Long id);
	public Curriculum findCurriculum(Long id);
	public InformeActividades findInformeActividades(Long id);
	public Inscripciones findInscripciones(Long id);
	public Ong findOng(String id);
	public Profesor findProfesor(String id);
	public Servicios findServicios(Long id);
	public Usuario findUsuario(String id);
	
	
	
	

}

