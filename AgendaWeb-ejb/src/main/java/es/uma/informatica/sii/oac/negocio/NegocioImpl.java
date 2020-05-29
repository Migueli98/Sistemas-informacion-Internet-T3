/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.uma.informatica.sii.oac.negocio;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import es.uma.informatica.sii.agendaee.entidades.Actividades;
import es.uma.informatica.sii.agendaee.entidades.Actividades.Estado;
import es.uma.informatica.sii.agendaee.entidades.Alumno;
import es.uma.informatica.sii.agendaee.entidades.Asignaturas;
import es.uma.informatica.sii.agendaee.entidades.Centro;
import es.uma.informatica.sii.agendaee.entidades.Curriculum;


import es.uma.informatica.sii.agendaee.entidades.InformeActividades;
import es.uma.informatica.sii.agendaee.entidades.Inscripciones;
import es.uma.informatica.sii.agendaee.entidades.Inscripciones.estadoInscripcion;
import es.uma.informatica.sii.agendaee.entidades.Ong;
import es.uma.informatica.sii.agendaee.entidades.Profesor;
import es.uma.informatica.sii.agendaee.entidades.Servicios;
import es.uma.informatica.sii.agendaee.entidades.Usuario;
import es.uma.informatica.sii.agendaee.entidades.Usuario.Rol;


@Stateless
public class NegocioImpl implements Negocio {

    private static final int TAM_CADENA_VALIDACION = 20;
    private static final Logger LOGGER = Logger.getLogger(NegocioImpl.class.getCanonicalName());

    @PersistenceContext(unitName = "OAC-EntidadesPU")
    private EntityManager em;

 
	@Override
	public void inicializar() {
		
		//CENTRO
		Centro cen1 = new Centro();
		cen1.setNombreCentro("Facultad de Informatica");
		em.persist(cen1);
		
		
		//ASIGNATURA
		Asignaturas as1 = new Asignaturas();
		as1.setCentro(cen1);
		as1.setCreditos(6);
		as1.setNombreAsignatura("Introduccion a Bases de Datos");
		em.persist(as1);
		
		Asignaturas as2 = new Asignaturas();
		as2.setCentro(cen1);
		as2.setCreditos(6);
		as2.setNombreAsignatura("Analisis y Diseño de Algoritmos");
		em.persist(as2);
		
		// CURRICULUMNS
		Curriculum c1 = new Curriculum();
		c1.setExperienciaLaboral("Camarero, bandeja, Ayudante de cocina");
		c1.setIdiomas("Frances, Aleman, Ingles");
		c1.setDisponibilidad("Lunes por la ma�ana y viernes por la tarde");
		List<Asignaturas> asig1 = new ArrayList<>();
		asig1.add(as1);
		c1.setCompuestoDe(asig1);
		em.persist(c1);
		
		Curriculum c2 = new Curriculum();
		c2.setExperienciaLaboral("Pintor, Carpintero, Alba�il");
		c2.setIdiomas("Ingles, Frances");
		c2.setDisponibilidad("Fin de semana");
		List<Asignaturas> asig2 = new ArrayList<>();
		asig2.add(as1);
		asig2.add(as2);
		c2.setCompuestoDe(asig2);
		em.persist(c2);
		
		// ALUMNOS
		Alumno al1 = new Alumno();
		al1.setEmail("alu1");
		al1.setContrasenia("q");
		al1.setRol(Rol.ALUMNO);
		al1.setNombre("Christian");
		al1.setApellido("Martos");
		al1.setCreditos(160);
		al1.setHorasLibre(10);
		al1.setCv(c1);
		em.persist(al1);
		Alumno al2 = new Alumno();
		al2.setEmail("alu2");
		al2.setContrasenia("q");
		al2.setRol(Rol.ALUMNO);
		al2.setNombre("Miguel");
		al2.setApellido("Valadez");
		al2.setCreditos(110);
		al2.setHorasLibre(5);
		al2.setCv(c2);
		em.persist(al2);
		
		//ONG
		Ong ong1 = new Ong();
		ong1.setEmail("ong1");
		ong1.setContrasenia("q");
		ong1.setRol(Rol.ONG);
		ong1.setCiudad("Murcia");
		ong1.setPais("España");
		ong1.setPaginaWeb("www.miemtrasmenosmirasmenosves.com");
		ong1.setNombreONG("Caritas");
		em.persist(ong1);
		
		//ADMIN
		Usuario us = new Usuario();
		us.setEmail("admin");
		us.setContrasenia("q");
		us.setRol(Rol.ADMIN);
		//us.setNombre("Francisco");
		//us.setApellido("Chicano");
		em.persist(us);

		//PROFESOR
		Profesor p1 = new Profesor();
		p1.setEmail("pro1");
		p1.setContrasenia("q");
		p1.setRol(Rol.PASPDI);
		p1.setNombre("Enrique");
		p1.setApellido("Soler");
		p1.setDepartamento("Bases de Datos");
		p1.addAsignatura(as1);
		em.persist(p1);
	}

	@Override
    public void compruebaLogin(Usuario u)  throws AprendizajeServicioException {
		
		Usuario user = em.find(Usuario.class, u.getEmail());
        if(user==null){
            throw new CuentaInexistenteException();
        }else if(!user.getContrasenia().equals(u.getContrasenia())){
            throw new ContraseniaInvalidaException();
        }
    }


    @Override
    public Usuario refrescarUsuario(Usuario u)  throws AprendizajeServicioException {
    	
    	compruebaLogin(u);
        Usuario user = em.find(Usuario.class, u.getEmail());
        
        return user;
    }
    

	@Override
	public List<Actividades> allActividadesEstado(Actividades.Estado estado) {
		// TODO Auto-generated method stub
		Query q = em.createNamedQuery("findActividadesEstado").setParameter("est",estado);
		List<Actividades> act=q.getResultList();
		return act;
	}
	
	
	@Override
	public List<Actividades> allActividades() {
		// TODO Auto-generated method stub
		Query q = em.createNamedQuery("findAllActividades");
		List<Actividades> act = q.getResultList();
		return act;
	}
	
	@Override
	public List<Actividades> allActividadesAlumno(Usuario u) {
		// TODO Auto-generated method stub
		Query q = em.createNamedQuery("findAllActividadesAlumno").setParameter("user",u);;
		List<Actividades> act = q.getResultList();
		return act;
	}
	
	

	@Override
	public List<Alumno> allAlumno() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Asignaturas> allAsignaturas() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Centro> allCentro() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Curriculum> allCurriculum() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<InformeActividades> allInformeActividades() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Inscripciones> allInscripciones(Usuario u) {
		// TODO Auto-generated method stub
		Query q = em.createNamedQuery("findInscripciones").setParameter("user",u);
		List<Inscripciones> ins=q.getResultList();
		return ins;
		
	}

	@Override
	public List<Ong> allOng() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Profesor> allProfesor() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Servicios> allServicios() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Usuario> allUsuario() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public List<Inscripciones> allInscripciones(){
		Query q = em.createNamedQuery("findAllInscripciones");
		List<Inscripciones> ins=q.getResultList();
		return ins;
	}

	@Override
	public void addActividades(Actividades a) {
		// TODO Auto-generated method stub
		em.persist(a);
	}

	@Override
	public void addAlumno(Alumno a) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addAsignaturas(Asignaturas a) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addCentro(Centro a) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addCurriculum(Curriculum a) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addInformeActividades(InformeActividades a) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addInscripciones(Inscripciones a) throws AprendizajeServicioException{
		// TODO Auto-generated method stub
		
		Query q = em.createNamedQuery("findInscripcionesUserAct").setParameter("user", a.getUsuario()).setParameter("actividad", a.getActividad());
		List<Inscripciones> ins=q.getResultList();
		em.persist(a);
		
	}

	@Override
	public void addOng(Ong a) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addProfesor(Profesor a) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addServicios(Servicios a) {
		em.persist(a);	
	}

	@Override
	public void addUsuario(Usuario a) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteActividades(Actividades a) throws AprendizajeServicioException{
		// TODO Auto-generated method stub	
		em.remove(em.contains(a) ? a : em.merge(a));
	}

	@Override
	public void deleteAlumno(Alumno a) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAsignaturas(Asignaturas a) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteCentro(Centro a) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteCurriculum(Curriculum a) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteInformeActividades(InformeActividades a) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteInscripciones(Inscripciones a) {
		// TODO Auto-generated method stub
		em.remove(em.contains(a) ? a : em.merge(a));
	}

	@Override
	public void deleteOng(Ong a) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteProfesor(Profesor a) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteServicios(Servicios a) {
		// TODO Auto-generated method stub
		em.remove(em.contains(a) ? a : em.merge(a));
	}

	@Override
	public void deleteUsuario(Usuario a) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateActividades(Actividades a) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateAlumno(Alumno a) throws AprendizajeServicioException {
		// TODO Auto-generated method stub
		em.merge(a);
	}

	@Override
	public void updateAsignaturas(Asignaturas a) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateCentro(Centro a) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateCurriculum(Curriculum a) {
		// TODO Auto-generated method stub
		em.merge(a);
		
	}

	@Override
	public void updateOng(Ong a) {
		// TODO Auto-generated method stub
		em.merge(a);
	}

	@Override
	public void updateProfesor(Profesor a) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateServicios(Servicios a) {
		// TODO Auto-generated method stub
		em.merge(a);
	}

	@Override
	public void updateUsuario(Usuario a) {
		// TODO Auto-generated method stub
		em.merge(a);
	}

	@Override
	public Actividades findActividades(Long id) throws AprendizajeServicioException{
		// TODO Auto-generated method stub
		Query q = em.createNamedQuery("findActividades").setParameter("id", id);
		List<Actividades> act = q.getResultList();
		return act.get(0);
	}

	@Override
	public Alumno findAlumno(String email) {
		// TODO Auto-generated method stub
		Alumno a = em.find(Alumno.class, email);
		return a;
	}

	@Override
	public Asignaturas findAsignaturas(Long id) {
		// TODO Auto-generated method stub
		Query q = em.createNamedQuery("findAsignatura").setParameter("id", id);
		List<Asignaturas> asig = q.getResultList();

		return asig.get(0);
		
	}

	@Override
	public Centro findCentro(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Curriculum findCurriculum(Long id) {
		// TODO Auto-generated method stub
		Query q = em.createNamedQuery("findCurriculum").setParameter("id", id);
		List<Curriculum> cu = q.getResultList();
		return cu.get(0);
		
	}

	@Override
	public InformeActividades findInformeActividades(Actividades a, Usuario u) {
		// TODO Auto-generated method stub
		Query q = em.createNamedQuery("findInforme").setParameter("a", a).setParameter("u", u);
		List<InformeActividades> informes = q.getResultList();
		
		return informes.get(0);
	}

	@Override
	public Inscripciones findInscripciones(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Ong findOng(String email) {
		// TODO Auto-generated method stub
		Ong a = em.find(Ong.class, email);
		return a;
	}

	@Override
	public Profesor findProfesor(String email) {
		// TODO Auto-generated method stub
		Profesor p = em.find(Profesor.class, email);
		return p;
		
	}

	@Override
	public Servicios findServicios(Long id) {
		// TODO Auto-generated method stub
		Query q = em.createNamedQuery("findServiciosId").setParameter("id", id);
		List<Servicios> ser = q.getResultList();
		
		return ser.get(0);
	}
	
	public List<Servicios> findServiciosOng(Ong ong) {
		
		Query q = em.createNamedQuery("findServiciosOng").setParameter("ong", ong);
		List<Servicios> ser = q.getResultList();
		
		return ser;
		
	}

	@Override
	public Usuario findUsuario(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	

    
    
    
    
    
/*    @Override
    public void registrarUsuario(Usuario u, UriBuilder uriBuilder) throws AgendaException {
        Usuario user = em.find(Usuario.class, u.getCuenta());
        if (user != null) {
            // El usuario ya existe
            throw new CuentaRepetidaException();
        }

        u.setCadenaValidacion(generarCadenaAleatoria());
        em.persist(u);

        URI uriValidacion = uriBuilder.build(u.getCuenta(), u.getCadenaValidacion());

        LOGGER.info(uriValidacion.toString());
    }

    private String generarCadenaAleatoria() {
        Random rnd = new Random(System.currentTimeMillis());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < TAM_CADENA_VALIDACION; i++) {
            int v = rnd.nextInt(62);
            if (v < 26) {
                sb.append((char) ('a' + v));
            } else if (v < 52) {
                sb.append((char) ('A' + v - 26));
            } else {
                sb.append((char) ('0' + v - 52));
            }
        }

        return sb.toString();

    }

    @Override
    public void validarCuenta(String cuenta, String validacion) throws AgendaException {
        Usuario u = em.find(Usuario.class, cuenta);
        if (u == null) {
            throw new CuentaInexistenteException();
        }

        if (u.getCadenaValidacion() == null) {
            // la cuenta ya está activa
            return;
        }

        if (!u.getCadenaValidacion().equals(validacion)) {
            throw new ValidacionIncorrectaException();
        }
        // else
        // Eliminamos la cadena de validación, indicando que ya está activa la cuenta
        u.setCadenaValidacion(null);
    }

    /*
     * Este método debe comprobar que el nombre de usuario y contraseña que
     * recibe en el objeto u pertenecen a un usuario que existe en la BBDD y que
     * está validado (un usuario está validado cuando su cadena de validación es
     * nula).
     * 
     * Puede lanzar las excepciones CuentaInexistenteException, CuentaInactivaException
     * y ContraseniaInvalidaException
     *
     * @param u
     * @return
     
   
    @Override
    public void compruebaLogin(Usuario u)  throws AgendaException {
        // TODO
    	Usuario uu = em.find(Usuario.class, u.getCuenta());
    	if (uu == null) {
    		throw new CuentaInexistenteException();
    	} else if (!u.getContrasenia().equals(uu.getContrasenia())) {
    		throw new ContraseniaInvalidaException();
    	} else if (u.getCadenaValidacion() != null) {
    		throw new CuentaInactivaException();
    	}
    	
    }

    /**
     * Este método debe comprobar que el usuario que se le pasa como parámetro
     * es un usuario existente y con contraseña correcta (ya que estamos en la capa
     * de negocio con un Session Bean de tipo @Stateless, debemos comprobar
     * todos los accesos a la capa de nogocio). En caso negativo debe devolver 
     * la excepción que corresponda,
     * en caso afirmativo debe devolver una entidad usuario tal con la información
     * existe ahora mismo en la BBDD.
     * @param u
     * @return 
     
    @Override
    public Usuario refrescarUsuario(Usuario u)  throws AgendaException {
        // TODO
    	compruebaLogin(u);
    	Usuario uu = em.find(Usuario.class, u.getCuenta());
    	em.refresh(uu);
        return uu;

    }

    /**
     * Este método debe actualizar el contacto correspondiente en la BBDD con
     * la información contenida en el objeto que se le pasa como argumento.
     * Antes de eso, debe comprobar que el usuario a quien pertenece el contacto existe y 
     * tiene una contraseña correcta (en caso contrario debe devolver la excepción que
     * corresponda.
     * @param c
     * @return 
     
    @Override
    public void modificar(Contacto c)  throws AgendaException {
        // TODO
    	compruebaLogin(c.getUsuario());
        em.merge(c);
    }

    /** Este método debe insertar un contacto en la BBDD. Antes debe comprobar que
     * el usuario del contacto existe y tiene contraseña correcta (en caso contrario
     * debe lanzar la excepción correspodiente).
     * @param c
     * @return 
     
    
    @Override
    public void insertar(Contacto c)  throws AgendaException {
        // TODO
    	compruebaLogin(c.getUsuario());
        em.persist(c);
    }

    /**
     * Este método debe eliminar el contacto que se le pasa como argumento.
     * Antes debe comprobar que el usuario a quien pertenece el contacto existe
     * y tiene contraseña válida (en caso contrario debe lanzar la excepción
     * correspondiente).
     * @param c
     * @return 
     
    @Override
    public void eliminarContacto(Contacto c)  throws AgendaException {
        // TODO
    	compruebaLogin(c.getUsuario());
        em.remove(em.merge(c));
    }
*/
}
