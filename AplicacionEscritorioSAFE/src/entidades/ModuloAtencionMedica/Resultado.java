package entidades.ModuloAtencionMedica;
//import javax.validation.constraints.NotNull;

//import javax.validation.constraints.Size;

public class Resultado {
	// @NotNull @Size(max=10,message="Largo de id excedido")
	private int idResultado;
	// @NotNull
	private double resultado;
	// @NotNull @Size(max=10,message="Largo de id excedido")
	private ExamenMedico idExamMedRes;
	// @NotNull @Size(max=10,message="Largo de id excedido")
	private Parametro idParamResultado;

	/**
	 * @return the idResultado
	 */
	public int getIdResultado() {
		return idResultado;
	}

	/**
	 * @param idResultado
	 *            the idResultado to set
	 */
	public void setIdResultado(int idResultado) {
		this.idResultado = idResultado;
	}

	/**
	 * @return the resultado
	 */
	public double getResultado() {
		return resultado;
	}

	/**
	 * @param resultado
	 *            the resultado to set
	 */
	public void setResultado(double resultado) {
		this.resultado = resultado;
	}

	/**
	 * @return the idExamMedRes
	 */
	public ExamenMedico getIdExamMedRes() {
		return idExamMedRes;
	}

	/**
	 * @param idExamMedRes
	 *            the idExamMedRes to set
	 */
	public void setIdExamMedRes(ExamenMedico idExamMedRes) {
		this.idExamMedRes = idExamMedRes;
	}

	/**
	 * @return the idParamResultado
	 */
	public Parametro getIdParamResultado() {
		return idParamResultado;
	}

	/**
	 * @param idParamResultado
	 *            the idParamResultado to set
	 */
	public void setIdParamResultado(Parametro idParamResultado) {
		this.idParamResultado = idParamResultado;
	}
}
