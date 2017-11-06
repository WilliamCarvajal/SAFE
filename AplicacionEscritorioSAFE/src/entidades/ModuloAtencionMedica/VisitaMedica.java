package entidades.ModuloAtencionMedica;

import java.util.Date;

import entidades.ModuloGeneral.Empleado;

//import javax.validation.constraints.NotNull;
//import javax.validation.constraints.Size;

public class VisitaMedica {

	// @NotNull @Size(max=10,message="Largo de id excedido")
	private int idVisitaMed;
	// @NotNull
	private Date fechaHora;
	// @NotNull @Size(max=10,message="Largo de rut excedido")
	private Empleado rutEmpleadoVis;
	// @NotNull @Size(max=10,message="Largo de rut excedido")
	private Medico rutMedicoVis;

	/**
	 * @return the idVisitaMed
	 */
	public int getIdVisitaMed() {
		return idVisitaMed;
	}

	/**
	 * @param idVisitaMed
	 *            the idVisitaMed to set
	 */
	public void setIdVisitaMed(int idVisitaMed) {
		this.idVisitaMed = idVisitaMed;
	}

	/**
	 * @return the fechaHora
	 */
	public Date getFechaHora() {
		return fechaHora;
	}

	/**
	 * @param fechaHora
	 *            the fechaHora to set
	 */
	public void setFechaHora(Date fechaHora) {
		this.fechaHora = fechaHora;
	}

	/**
	 * @return the rutEmpleadoVis
	 */
	public Empleado getRutEmpleadoVis() {
		return rutEmpleadoVis;
	}

	/**
	 * @param rutEmpleadoVis
	 *            the rutEmpleadoVis to set
	 */
	public void setRutEmpleadoVis(Empleado rutEmpleadoVis) {
		this.rutEmpleadoVis = rutEmpleadoVis;
	}

	/**
	 * @return the rutMedicoVis
	 */
	public Medico getRutMedicoVis() {
		return rutMedicoVis;
	}

	/**
	 * @param rutMedicoVis
	 *            the rutMedicoVis to set
	 */
	public void setRutMedicoVis(Medico rutMedicoVis) {
		this.rutMedicoVis = rutMedicoVis;
	}

}
