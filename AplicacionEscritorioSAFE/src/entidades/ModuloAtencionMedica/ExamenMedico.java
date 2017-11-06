package entidades.ModuloAtencionMedica;

import java.util.Date;

//import javax.validation.constraints.NotNull;
//import javax.validation.constraints.Size;

public class ExamenMedico {

	// @NotNull @Size(max=10,message="Largo de 10 caracteres excedido")
	private int idExamen;
	// @NotNull
	private Date fechaExamen;
	// @NotNull @Size(max=30,message="Largo de 30 caracteres excedido")
	private String tipoExamen;
	// @NotNull @Size(max=10,message="Largo de 10 caracteres excedido")
	private int idFichaMedica;

	/**
	 * @return the idExamen
	 */
	public int getIdExamen() {
		return idExamen;
	}

	/**
	 * @param idExamen
	 *            the idExamen to set
	 */
	public void setIdExamen(int idExamen) {
		this.idExamen = idExamen;
	}

	/**
	 * @return the fechaExamen
	 */
	public Date getFechaExamen() {
		return fechaExamen;
	}

	/**
	 * @param fechaExamen
	 *            the fechaExamen to set
	 */
	public void setFechaExamen(Date fechaExamen) {
		this.fechaExamen = fechaExamen;
	}

	/**
	 * @return the tipoExamen
	 */
	public String getTipoExamen() {
		return tipoExamen;
	}

	/**
	 * @param tipoExamen
	 *            the tipoExamen to set
	 */
	public void setTipoExamen(String tipoExamen) {
		this.tipoExamen = tipoExamen;
	}

	/**
	 * @return the idFichaMedica
	 */
	public int getIdFichaMedica() {
		return idFichaMedica;
	}

	/**
	 * @param idFichaMedica
	 *            the idFichaMedica to set
	 */
	public void setIdFichaMedica(int idFichaMedica) {
		this.idFichaMedica = idFichaMedica;
	}
}
