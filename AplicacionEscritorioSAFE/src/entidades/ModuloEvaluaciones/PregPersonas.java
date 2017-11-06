package entidades.ModuloEvaluaciones;
//import javax.validation.constraints.NotNull;

//import javax.validation.constraints.Size;

public class PregPersonas {
	// @NotNull @Size(max=10,message="Largo de id excedido")
	private int idPregunta;
	// @NotNull @Size(max=500,message="Descripción de pregunta demasiado larga")
	private String pregunta;

	/**
	 * @return the idPregunta
	 */
	public int getIdPregunta() {
		return idPregunta;
	}

	/**
	 * @param idPregunta
	 *            the idPregunta to set
	 */
	public void setIdPregunta(int idPregunta) {
		this.idPregunta = idPregunta;
	}

	/**
	 * @return the pregunta
	 */
	public String getPregunta() {
		return pregunta;
	}

	/**
	 * @param pregunta
	 *            the pregunta to set
	 */
	public void setPregunta(String pregunta) {
		this.pregunta = pregunta;
	}
}
