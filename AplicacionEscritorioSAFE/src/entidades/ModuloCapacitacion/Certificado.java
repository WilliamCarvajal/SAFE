package entidades.ModuloCapacitacion;

import java.util.Date;
//import javax.validation.constraints.Max;
//import javax.validation.constraints.NotNull;
//import javax.validation.constraints.Size;

public class Certificado {
	// @NotNull @Size(max=10,message="id de certificado debe de ser de hasta 10
	// caracteres")
	private int idCertificado;
	// @NotNull
	private Date fechaEntrega;
	// @NotNull @Size(max=100,message="Largo excedido")
	private String descripcion;
	// @NotNull @Max(10)
	private Alumno alumnorut;
	// @NotNull @Size(max=10,message="id de curso debe de ser de hasta 10
	// caracteres")
	private int idEjecCurso;

	/**
	 * @return the idCertificado
	 */
	public int getIdCertificado() {
		return idCertificado;
	}

	/**
	 * @param idCertificado
	 *            the idCertificado to set
	 */
	public void setIdCertificado(int idCertificado) {
		this.idCertificado = idCertificado;
	}

	/**
	 * @return the fechaEntrega
	 */
	public Date getFechaEntrega() {
		return fechaEntrega;
	}

	/**
	 * @param fechaEntrega
	 *            the fechaEntrega to set
	 */
	public void setFechaEntrega(Date fechaEntrega) {
		this.fechaEntrega = fechaEntrega;
	}

	/**
	 * @return the descripcion
	 */
	public String getDescripcion() {
		return descripcion;
	}

	/**
	 * @param descripcion
	 *            the descripcion to set
	 */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	/**
	 * @return the alumnorut
	 */
	public Alumno getAlumnorut() {
		return alumnorut;
	}

	/**
	 * @param alumnorut
	 *            the alumnorut to set
	 */
	public void setAlumnorut(Alumno alumnorut) {
		this.alumnorut = alumnorut;
	}

	/**
	 * @return the idEjecCurso
	 */
	/**
	 * @return the idEjecCurso
	 */
	public int getIdEjecCurso() {
		return idEjecCurso;
	}

	/**
	 * @param idEjecCurso
	 *            the idEjecCurso to set
	 */
	public void setIdEjecCurso(int idEjecCurso) {
		this.idEjecCurso = idEjecCurso;
	}

}
/**
 * @param idEjecCurso
 *            the idEjecCurso to set
 */
