package entidades.ModuloAtencionMedica;
//import javax.validation.constraints.NotNull;

//import javax.validation.constraints.Size;

import entidades.ModuloGeneral.Empleado;

public class FichaMedica {

	// @NotNull @Size(max=10,message="Largo de 10 caracteres excedido")
	private int idFicha;
	// @NotNull @Size(max=50,message="Descripción de alergia demasiado largo")
	private String alergia;
	// @NotNull @Size(max=12,message="largo de teléfono excedido")
	private int telefonoEmergencia;
	// @NotNull @Size(max=10,message="Largo de 10 caracteres excedido")
	private Empleado rutEmpleadoFicha;
	// @NotNull @Size(max=10,message="Largo de 10 caracteres excedido")
	private int idEnfermedad;

	/**
	 * @return the idFicha
	 */
	public int getIdFicha() {
		return idFicha;
	}

	/**
	 * @param idFicha
	 *            the idFicha to set
	 */
	public void setIdFicha(int idFicha) {
		this.idFicha = idFicha;
	}

	/**
	 * @return the alergia
	 */
	public String getAlergia() {
		return alergia;
	}

	/**
	 * @param alergia
	 *            the alergia to set
	 */
	public void setAlergia(String alergia) {
		this.alergia = alergia;
	}

	/**
	 * @return the telefonoEmergencia
	 */
	public int getTelefonoEmergencia() {
		return telefonoEmergencia;
	}

	/**
	 * @param telefonoEmergencia
	 *            the telefonoEmergencia to set
	 */
	public void setTelefonoEmergencia(int telefonoEmergencia) {
		this.telefonoEmergencia = telefonoEmergencia;
	}

	/**
	 * @return the rutEmpleadoFicha
	 */
	public Empleado getRutEmpleadoFicha() {
		return rutEmpleadoFicha;
	}

	/**
	 * @param rutEmpleadoFicha
	 *            the rutEmpleadoFicha to set
	 */
	public void setRutEmpleadoFicha(Empleado rutEmpleadoFicha) {
		this.rutEmpleadoFicha = rutEmpleadoFicha;
	}

	/**
	 * @return the idEnfermedad
	 */
	public int getIdEnfermedad() {
		return idEnfermedad;
	}

	/**
	 * @param idEnfermedad
	 *            the idEnfermedad to set
	 */
	public void setIdEnfermedad(int idEnfermedad) {
		this.idEnfermedad = idEnfermedad;
	}
}
