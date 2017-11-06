package entidades.ModuloAtencionMedica;
//import javax.validation.constraints.Max;

//import javax.validation.constraints.NotNull;
//import javax.validation.constraints.Size;

import entidades.ModuloGeneral.CuentaUsuario;

public class Medico {
	// @NotNull @Size(max=10,message="Largo de rut excedido")
	private int rutMedico;
	// @NotNull @Max(1)
	private String dvMedico;
	// @NotNull @Size(max=30,message="Largo de nombre excedido")
	private String nombreMedico;
	// @NotNull @Size(max=20,message="Largo de apellido excedido")
	private String apPaternoMed;
	// @NotNull @Size(max=20,message="Largo de apellido excedido")
	private String apMaternoMed;
	// @NotNull @Size(max=50,message="Largo de especialidad excedido")
	private String especialidad;
	// @NotNull @Size(max=10,message="Largo de cuenta excedido")
	private CuentaUsuario idMedico;

	/**
	 * @return the dvMedico
	 */
	public String getDvMedico() {
		return dvMedico;
	}

	/**
	 * @param dvMedico
	 *            the dvMedico to set
	 */
	public void setDvMedico(String dvMedico) {
		this.dvMedico = dvMedico;
	}

	/**
	 * @return the rutMedico
	 */
	public int getRutMedico() {
		return rutMedico;
	}

	/**
	 * @param rutMedico
	 *            the rutMedico to set
	 */
	public void setRutMedico(int rutMedico) {
		this.rutMedico = rutMedico;
	}

	/**
	 * @return the nombreMedico
	 */
	public String getNombreMedico() {
		return nombreMedico;
	}

	/**
	 * @param nombreMedico
	 *            the nombreMedico to set
	 */
	public void setNombreMedico(String nombreMedico) {
		this.nombreMedico = nombreMedico;
	}

	/**
	 * @return the apPaternoMed
	 */
	public String getApPaternoMed() {
		return apPaternoMed;
	}

	/**
	 * @param apPaternoMed
	 *            the apPaternoMed to set
	 */
	public void setApPaternoMed(String apPaternoMed) {
		this.apPaternoMed = apPaternoMed;
	}

	/**
	 * @return the apMaternoMed
	 */
	public String getApMaternoMed() {
		return apMaternoMed;
	}

	/**
	 * @param apMaternoMed
	 *            the apMaternoMed to set
	 */
	public void setApMaternoMed(String apMaternoMed) {
		this.apMaternoMed = apMaternoMed;
	}

	/**
	 * @return the especialidad
	 */
	public String getEspecialidad() {
		return especialidad;
	}

	/**
	 * @param especialidad
	 *            the especialidad to set
	 */
	public void setEspecialidad(String especialidad) {
		this.especialidad = especialidad;
	}

	/**
	 * @return the cuentaMedico
	 */
	public CuentaUsuario getIdMedico() {
		return idMedico;
	}

	/**
	 * @param cuentaMedico
	 *            the cuentaMedico to set
	 */
	public void setIdMedico(CuentaUsuario idMedico) {
		this.idMedico = idMedico;
	}
}
