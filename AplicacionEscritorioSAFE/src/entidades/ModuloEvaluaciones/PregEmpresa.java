package entidades.ModuloEvaluaciones;
//import javax.validation.constraints.NotNull;

//import javax.validation.constraints.Size;

public class PregEmpresa {

	// @NotNull @Size(max=10,message="Largo de id excedido")
	private int idRiesgo;
	// @NotNull @Size(max=500,message="Descripción demasiado larga")
	private String descripcionRiesgo;

	/**
	 * @return the idRiesgo
	 */
	public int getIdRiesgo() {
		return idRiesgo;
	}

	/**
	 * @param idRiesgo
	 *            the idRiesgo to set
	 */
	public void setIdRiesgo(int idRiesgo) {
		this.idRiesgo = idRiesgo;
	}

	/**
	 * @return the descripcionRiesgo
	 */
	public String getDescripcionRiesgo() {
		return descripcionRiesgo;
	}

	/**
	 * @param descripcionRiesgo
	 *            the descripcionRiesgo to set
	 */
	public void setDescripcionRiesgo(String descripcionRiesgo) {
		this.descripcionRiesgo = descripcionRiesgo;
	}
}
