package entidades.ModuloAtencionMedica;
//import javax.validation.constraints.NotNull;

//import javax.validation.constraints.Size;

public class Parametro {
	// @NotNull @Size(max=10,message="Largo de id excedido")
	private int idParametro;
	// @NotNull @Size(max=30,message="Largo de parámetro excedido")
	private String parametro;
	// @NotNull @Size(max=10,message="Descripción de unidad de medida muy largo")
	private String unidadMedida;
	// @NotNull
	private double refInicial;
	// @NotNull
	private double refFinal;

	/**
	 * @return the idParametro
	 */
	public int getIdParametro() {
		return idParametro;
	}

	/**
	 * @param idParametro
	 *            the idParametro to set
	 */
	public void setIdParametro(int idParametro) {
		this.idParametro = idParametro;
	}

	/**
	 * @return the parametro
	 */
	public String getParametro() {
		return parametro;
	}

	/**
	 * @param parametro
	 *            the parametro to set
	 */
	public void setParametro(String parametro) {
		this.parametro = parametro;
	}

	/**
	 * @return the unidadMedida
	 */
	public String getUnidadMedida() {
		return unidadMedida;
	}

	/**
	 * @param unidadMedida
	 *            the unidadMedida to set
	 */
	public void setUnidadMedida(String unidadMedida) {
		this.unidadMedida = unidadMedida;
	}

	/**
	 * @return the refFinal
	 */
	public double getRefFinal() {
		return refFinal;
	}

	/**
	 * @param refFinal
	 *            the refFinal to set
	 */
	public void setRefFinal(double refFinal) {
		this.refFinal = refFinal;
	}

	/**
	 * @return the refInicial
	 */
	public double getRefInicial() {
		return refInicial;
	}

	/**
	 * @param refInicial
	 *            the refInicial to set
	 */
	public void setRefInicial(double refInicial) {
		this.refInicial = refInicial;
	}
}
