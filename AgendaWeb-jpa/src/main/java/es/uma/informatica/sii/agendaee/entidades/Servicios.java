package es.uma.informatica.sii.agendaee.entidades;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;


/**
 * Entity implementation class for Entity: Servicios
 *
 */
@Entity

@NamedQueries({
    @NamedQuery(name="findServiciosOng",query="select s from Servicios s where s.ong= :ong"),
    @NamedQuery(name="findServiciosId",query="select s from Servicios s where s.codigoServicio= :id"),
    @NamedQuery(name="findAllServicios",query="select s from Servicios s")
	})
public class Servicios implements Serializable {
	
	@Id @GeneratedValue
	private Long codigoServicio;
	//@Column(nullable = false)
	private String tipoServicio;
	//@Column(nullable = false)
	private String nombre;
	private String descripcion;
	private Integer numParticipantes;
	//@Column(nullable = false)
	private Integer numHoras;
	//@Column(nullable = false)
	private String zona;
	
	@ManyToOne
	@JoinColumn(name = "ong")
	private Ong ong;
	
	@OneToMany(mappedBy="servicio")
	private List<Actividades> actividades;
	

	
	private static final long serialVersionUID = 1L;

	public Servicios() {
		super();
	}   
	
	public Servicios(Long id, String tipo, String n, String des, Integer num, String z) {
		codigoServicio = id;
		tipoServicio = tipo;
		nombre = n;
		descripcion = des;
		numHoras = num;
		zona = z;
	}
	
	public Long getCodigoServicio() {
		return this.codigoServicio;
	}

	public void setCodigoServicio(Long codigoServicio) {
		this.codigoServicio = codigoServicio;
	}   
	public String getTipoServicio() {
		return this.tipoServicio;
	}

	public void setTipoServicio(String tipoServicio) {
		this.tipoServicio = tipoServicio;
	}   
	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}   
	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}   
	public Integer getNumParticipantes() {
		return this.numParticipantes;
	}

	public void setNumParticipantes(Integer numParticipantes) {
		this.numParticipantes = numParticipantes;
	}   
	public Integer getNumHoras() {
		return this.numHoras;
	}

	public void setNumHoras(Integer numHoras) {
		this.numHoras = numHoras;
	}   
	public String getZona() {
		return this.zona;
	}

	public void setZona(String zona) {
		this.zona = zona;
	}
	public Ong getOng() {
		return ong;
	}
	public void setOng(Ong ong) {
		this.ong = ong;
	}

	public List<Actividades> getActividades() {
		return actividades;
	}

	public void setActividades(List<Actividades> actividades) {
		this.actividades = actividades;
	}

	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigoServicio == null) ? 0 : codigoServicio.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Servicios other = (Servicios) obj;
		if (codigoServicio == null) {
			if (other.codigoServicio != null)
				return false;
		} else if (!codigoServicio.equals(other.codigoServicio))
			return false;
		return true;
	}

	
	
	
   
}
