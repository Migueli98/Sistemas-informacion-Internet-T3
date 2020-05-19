package es.uma.informatica.sii.agendaee.entidades;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import es.uma.informatica.sii.agendaee.entidades.Usuario.Rol;


public class OAC_EntidadesPU {

	
	public static void main(String[] args) {
		
		 Usuario admin = new Usuario("admin","p", Rol.ADMIN);
    	 EntityManagerFactory emf = Persistence.createEntityManagerFactory("OAC_EntidadesPU");
		 EntityManager em = emf.createEntityManager();
		 EntityTransaction et = em.getTransaction();
		 et.begin();
		 em.persist(admin);
		 et.commit();
		 em.close();
		 emf.close();
	}
	
	
}
