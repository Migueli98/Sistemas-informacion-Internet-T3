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

		// CURRICULUMNS
		Curriculum c1 = new Curriculum();
		c1.setExperienciaLaboral("Camarero, bandeja, Ayudante de cocina");
		c1.setIdiomas("Frances, Aleman, Ingles");
		c1.setDisponibilidad("Lunes por la maniana y viernes por la tarde");
		
		
		em.persist(c1);
		
		Curriculum c2 = new Curriculum();
		c2.setExperienciaLaboral("Pintor, Carpintero, Albanil");
		c2.setIdiomas("Ingles, Frances");
		c2.setDisponibilidad("Fin de semana");
		
		
		em.persist(c2);
		
		// ALUMNOS
		Alumno al1 = new Alumno();
		al1.setEmail("alu1@uma.es");
		al1.setContrasenia("q");
		al1.setRol(Rol.ALUMNO);
		al1.setNombre("Christian");
		al1.setApellido("Martos");
		al1.setCreditos(160);
		al1.setHorasLibre(10);
		al1.setCv(c1);
		em.persist(al1);
		Alumno al2 = new Alumno();
		al2.setEmail("alu2@uma.es");
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
		ong1.setEmail("ong1@xmail.com");
		ong1.setContrasenia("q");
		ong1.setRol(Rol.ONG);
		ong1.setCiudad("Murcia");
		ong1.setPais("España");
		ong1.setPaginaWeb("www.miemtrasmenosmirasmenosves.com");
		ong1.setNombreONG("Caritas");
		em.persist(ong1);
		
		//ADMIN
		Usuario us = new Usuario();
		us.setEmail("admin@uma.es");
		us.setContrasenia("q");
		us.setRol(Rol.ADMIN);
		//us.setNombre("Francisco");
		//us.setApellido("Chicano");
		em.persist(us);

		//PROFESOR
		Profesor p1 = new Profesor();
		p1.setEmail("pro1@uma.es");
		p1.setContrasenia("q");
		p1.setRol(Rol.PASPDI);
		p1.setNombre("Enrique");
		p1.setApellido("Soler");
		p1.setDepartamento("Bases de Datos");
		em.persist(p1);
		
		Profesor p2 = new Profesor();
		p2.setEmail("pro2@uma.es");
		p2.setContrasenia("q");
		p2.setRol(Rol.PASPDI);
		p2.setNombre("Carlos");
		p2.setApellido("Rossi");
		p2.setDepartamento("Sistemas de Informacion");
		em.persist(p2);
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
		Query q = em.createNamedQuery("findAllActividadesAlumno").setParameter("user",u);
		List<Actividades> act = q.getResultList();
		return act;
	}

	@Override
	public List<InformeActividades> allInformeActividades() {
		Query q = em.createNamedQuery("findAllInformeActividades");
		List<InformeActividades> infact = q.getResultList();
		return infact;
	}
	
	public List<InformeActividades> allInformeActividadesProfesor(Profesor pro){
		Query q = em.createNamedQuery("findAllInformeActividadesProfesor").setParameter("p", pro);
		List<InformeActividades> infact = q.getResultList();
		return infact;
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
		
		Query q = em.createNamedQuery("findAllOng");
		List<Ong> ins=q.getResultList();
		return ins;
	}

	@Override
	public List<Usuario> allProfesor() {
		Query q = em.createNamedQuery("findAllProfesor").setParameter("rol", Rol.PASPDI);
		List<Usuario> pro = q.getResultList();
		return pro;
	}

	@Override
	public List<Servicios> allServicios() {
		Query q = em.createNamedQuery("findAllServicios");
		List<Servicios> s = q.getResultList();
		return s;
	}

	@Override
	public List<Usuario> allUsuario() {
		Query q = em.createNamedQuery("findAllUsuarios");
		List<Usuario> usu = q.getResultList();
		return usu;
		
	}
	
	@Override
	public List<Usuario> allUsuarioAP() {
		Query q = em.createNamedQuery("findAllUsuariosAP").setParameter("rol1", Rol.ALUMNO).setParameter("rol2", Rol.PASPDI);
		List<Usuario> usu = q.getResultList();
		return usu;
		
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
	public void addOng(Ong ongAd) {
		// TODO Auto-generated method stub
		em.persist(ongAd);
	}
	@Override
	public void addInformeActividades(InformeActividades a) {
		// TODO Auto-generated method stub
		em.persist(a);
		
	}

	@Override
	public void addInscripciones(Inscripciones a) throws AprendizajeServicioException{
		// TODO Auto-generated method stub
		
		Query q = em.createNamedQuery("findInscripcionesUserAct").setParameter("user", a.getUsuario()).setParameter("actividad", a.getActividad());
		List<Inscripciones> ins=q.getResultList();
		if(ins.isEmpty()) {
			em.persist(a);
		} else {
			throw new AprendizajeServicioException();
		}
		
		
	}

	@Override
	public void addServicios(Servicios a) {
		em.persist(a);	
	}

	@Override
	public void addUsuario(Usuario a) {
		// TODO Auto-generated method stub
		em.persist(a);
	}

	@Override
	public void deleteActividades(Actividades a) throws AprendizajeServicioException{
		// TODO Auto-generated method stub	
		em.remove(em.contains(a) ? a : em.merge(a));
	}


	@Override
	public void deleteInscripciones(Inscripciones a) {
		// TODO Auto-generated method stub
		em.remove(em.contains(a) ? a : em.merge(a));
	}

	@Override
	public void deleteOng(Ong a) {
		// TODO Auto-generated method stub
		em.remove(em.contains(a) ? a : em.merge(a));
	}

	@Override
	public void deleteServicios(Servicios a) {
		// TODO Auto-generated method stub
		em.remove(em.contains(a) ? a : em.merge(a));
	}

	@Override
	public void deleteUsuario(Usuario a) {
		// TODO Auto-generated method stub
		em.remove(em.contains(a) ? a : em.merge(a));
		
	}

	@Override
	public void updateActividades(Actividades a) {
		// TODO Auto-generated method stub
		em.merge(a);
	}

	@Override
	public void updateAlumno(Alumno a) throws AprendizajeServicioException {
		// TODO Auto-generated method stub
		em.merge(a);
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
	public void updateInscripciones(Inscripciones a) {
		em.merge(a);
	}
	
	@Override
	public void updateInforme(InformeActividades informe) {
		em.merge(informe);
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
		Query q = em.createNamedQuery("findInscripcionesId").setParameter("id", id);
		List<Inscripciones> ins = q.getResultList();
		
		return ins.get(0);
		
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
	
	public List<Servicios> findServiciosOng(Usuario ong) {
		
		Query q = em.createNamedQuery("findServiciosOng").setParameter("ong", ong);
		List<Servicios> ser = q.getResultList();
		
		return ser;
		
	}

	@Override
	public Usuario findUsuario(String id) {
		Query q = em.createNamedQuery("findUsuarioId").setParameter("id", id);
		List<Usuario> usu = q.getResultList();
		return usu.get(0);
	}
	

	@Override
	public InformeActividades findInformeActividadesId(Long id) {
		Query q = em.createNamedQuery("findInformeId").setParameter("id", id);
		List<InformeActividades> inf = q.getResultList();
		return inf.get(0);
	}

}
