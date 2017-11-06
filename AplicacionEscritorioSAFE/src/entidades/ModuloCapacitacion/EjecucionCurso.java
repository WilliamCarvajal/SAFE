package entidades.ModuloCapacitacion;

import java.util.Date;

//import javax.validation.constraints.NotNull;
//import javax.validation.constraints.Size;

public class EjecucionCurso {

	// @NotNull @Size(max=10,message="Largo de id excedido")
	private int idEjecucion;
	// @NotNull
	private Date fechaInicio;
	// @NotNull
	private Date fechaTermino;
	// @NotNull @Size(max=10,message="Largo de id excedido")
	private int idCurso;
	// @NotNull @Size(max=10,message="Largo de rut excedido")
	private int rutExpositor;

	/**
	 * @return the fechaInicio
	 */
	public Date getFechaInicio() {
		return fechaInicio;
	}

	/**
	 * @param fechaInicio
	 *            the fechaInicio to set
	 */
	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	/**
	 * @return the idEjecucion
	 */
	public int getIdEjecucion() {
		return idEjecucion;
	}

	/**
	 * @param idEjecucion
	 *            the idEjecucion to set
	 */
	public void setIdEjecucion(int idEjecucion) {
		this.idEjecucion = idEjecucion;
	}

	/**
	 * @return the fechaTermino
	 */
	public Date getFechaTermino() {
		return fechaTermino;
	}

	/**
	 * @param fechaTermino
	 *            the fechaTermino to set
	 */
	public void setFechaTermino(Date fechaTermino) {
		this.fechaTermino = fechaTermino;
	}

	/**
	 * @return the idCurso
	 */
	public int getIdCurso() {
		return idCurso;
	}

	/**
	 * @param idCurso
	 *            the idCurso to set
	 */
	public void setIdCurso(int idCurso) {
		this.idCurso = idCurso;
	}

	/**
	 * @return the rutExpositor
	 */
	public int getRutExpositor() {
		return rutExpositor;
	}

	/**
	 * @param rutExpositor
	 *            the rutExpositor to set
	 */
	public void setRutExpositor(int rutExpositor) {
		this.rutExpositor = rutExpositor;
	}
}
