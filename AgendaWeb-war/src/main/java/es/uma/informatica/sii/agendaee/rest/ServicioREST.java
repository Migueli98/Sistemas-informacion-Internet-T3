package es.uma.informatica.sii.agendaee.rest;

import java.util.Iterator;
import java.util.List;

import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.core.UriInfo;

import es.uma.informatica.sii.agendaee.entidades.Contacto;
import es.uma.informatica.sii.agendaee.entidades.Usuario;
import es.uma.informatica.sii.agendaee.negocio.AgendaException;
import es.uma.informatica.sii.agendaee.negocio.Negocio;

@Path("/agenda")
public class ServicioREST {
	
	@EJB
	private Negocio negocio;
	@Context
	private UriInfo uriInfo;
	
	@HeaderParam("User-auth")
	private String autorización;
	
	@Path("/contactos")
	@GET
	@Produces ({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public Response getContactos() {
		Usuario usuario = getUsuario();
		if (usuario == null) {
			return Response.status(Status.BAD_REQUEST).build();
		}
		
		try {
			usuario = negocio.refrescarUsuario(usuario);
			return Response.ok(usuario).build();
		} catch (AgendaException e){
			return Response.status(Status.UNAUTHORIZED).build();
		}
	}
	
	@Path("/contactos")
	@POST
	@Consumes ({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public Response aniadirContacto(Contacto contacto) {
		Usuario usuario = getUsuario();
		if (usuario == null) {
			return Response.status(Status.BAD_REQUEST).build();
		}
		try {
			contacto.setUsuario(usuario);
			negocio.insertar(contacto);
			
			return Response
					.created(uriInfo.getBaseUriBuilder().path("/agenda/contacto/" + contacto.getId().toString()).build())
					.build();
		} catch (AgendaException e) {
			return Response.status(Response.Status.UNAUTHORIZED).build();
		}
	}
	
	@GET
	@Path("/contacto/{id}")
	@Produces({ MediaType.TEXT_XML, MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	public Response getContacto(@PathParam(value="id") String id) {
		Usuario usuario = getUsuario();

		if (usuario == null) {
			return Response.status(Response.Status.BAD_REQUEST).build();
		}
		Long ID = Long.parseLong(id);
			Contacto c = buscarContacto(usuario,ID);
			if (c == null) {
				return Response.status(Response.Status.BAD_REQUEST).build();
			} else {
				return Response.ok(c).build();
			}
			

	}

	@PUT
	@Path("/contacto/{id}")
	@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.TEXT_XML })
	public Response putContacto(@PathParam(value="id") String id, Contacto c) {
		Usuario usuario = getUsuario();
		Long ID = Long.parseLong(id);

		if (usuario == null) {
			return Response.status(Response.Status.BAD_REQUEST).build();
		}

		try {
			Contacto c1 = buscarContacto(usuario, ID);
			if(c==null)return Response.status(Response.Status.BAD_REQUEST).build();
			c1.setNombre(c.getNombre());
			c1.setEmail(c.getEmail());
			c1.setTelefono(c.getTelefono());
			negocio.modificar(c1);
			return Response.ok().build();
		} catch (AgendaException e) {
			return Response.status(Response.Status.UNAUTHORIZED).build();
		}
	}

	@DELETE
	@Path("/contacto/{id}")
	public Response deleteContacto(@PathParam(value="id") String id) {

		Usuario usuario = getUsuario();
		Long ID = Long.parseLong(id);

		if (usuario == null) {
			return Response.status(Response.Status.BAD_REQUEST).build();
		}

		try {
			Contacto c1 = buscarContacto(usuario, ID);
			negocio.eliminarContacto(c1 );
			return Response.ok().build();

		} catch (AgendaException e) {
			return Response.status(Response.Status.UNAUTHORIZED).build();
		}
	}

	private Usuario getUsuario() {
		// TODO Auto-generated method stub
		Usuario u = null;
		if (autorización!=null) {
			String [] s = autorización.split(":");
			if (s.length>=2){
				String user = s[0];
				String pass = s[1];
				
				u = new Usuario();
				u.setCuenta(user);
				u.setContrasenia(pass);
			}
		}
		return u;
	}
	
	private Contacto buscarContacto(Usuario us, Long id) {
		//Usuario us = getUsuario();
		List<Contacto> lc = us.getContactos();
		Iterator<Contacto> it = lc.iterator();
		Boolean fin = false;
		Contacto c=null;
		while (!fin) {
			c=it.next();
			if (c.getId()==id) {
				fin=true;;
			}
		}
		return c;
	}

}
