/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.uma.informatica.sii.oac.negocio;

import java.util.List;
import java.util.logging.Logger;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

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
import es.uma.informatica.sii.agendaee.entidades.Usuario.Rol;


@Stateless
public class NegocioImpl implements Negocio {

    private static final int TAM_CADENA_VALIDACION = 20;
    private static final Logger LOGGER = Logger.getLogger(NegocioImpl.class.getCanonicalName());

    @PersistenceContext(unitName = "OAC-EntidadesPU")
    private EntityManager em;

    
    

	@Override
	public void inicializar() {
		// TODO Auto-generated method stub
		Usuario us = new Usuario();
		us.setEmail("admin");
		us.setContrasenia("q");
		us.setRol(Rol.ADMIN);
		em.persist(us);
	}


	@Override
    public void compruebaLogin(Usuario u)  throws AprendizajeServicioException {
    	/*Usuario uu = em.find(Usuario.class, u.getEmail());
    	if (uu == null) {
    		throw new CuentaInexistenteException();
    	} else if (!u.getContrasenia().equals(uu.getContrasenia())) {
    		throw new ContraseniaInvalidaException();
    	} */
		Query q = em.createNamedQuery("buscarUsuario").setParameter("email", u.getEmail());
        List<Usuario> l = q.getResultList();
        try {
        	l.get(0);
        } catch (IndexOutOfBoundsException e){
        	throw new CuentaInexistenteException();
        }
        

        if (!l.get(0).getContrasenia().equals(u.getContrasenia())) {
            throw new ContraseniaInvalidaException();
        }
    }


    @Override
    public Usuario refrescarUsuario(Usuario u)  throws AprendizajeServicioException {
    	/*compruebaLogin(u);
    	Usuario uu = em.find(Usuario.class, u.getEmail());
    	em.refresh(uu);
        return uu;*/
    	compruebaLogin(u);
        Query q = em.createNamedQuery("buscarUsuario").setParameter("email", u.getEmail());
        List<Usuario> l = q.getResultList();
        em.refresh(l.get(0));
        return l.get(0);
    }
    

	@Override
	public List<Actividades> allActividades() {
		// TODO Auto-generated method stub
		return null;
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
	public List<Inscripciones> allInscripciones() {
		// TODO Auto-generated method stub
		return null;
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

	@Override
	public void addActividades(Actividades a) {
		// TODO Auto-generated method stub
		
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
	public void addInscripciones(Inscripciones a) {
		// TODO Auto-generated method stub
		
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
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addUsuario(Usuario a) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteActividades(Actividades a) {
		// TODO Auto-generated method stub
		
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
	public void updateAlumno(Alumno a) {
		// TODO Auto-generated method stub
		
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
		
	}

	@Override
	public void updateOng(Ong a) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateProfesor(Profesor a) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateServicios(Servicios a) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateUsuario(Usuario a) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Actividades findActividades(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Alumno findAlumno(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Asignaturas findAsignaturas(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Centro findCentro(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Curriculum findCurriculum(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public InformeActividades findInformeActividades(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Inscripciones findInscripciones(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Ong findOng(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Profesor findProfesor(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Servicios findServicios(Long id) {
		// TODO Auto-generated method stub
		return null;
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
