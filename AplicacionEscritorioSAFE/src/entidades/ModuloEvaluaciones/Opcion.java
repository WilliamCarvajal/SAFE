package entidades.ModuloEvaluaciones;
//import javax.validation.constraints.Max;

//import javax.validation.constraints.NotNull;
//import javax.validation.constraints.Size;

public class Opcion {
	// @NotNull @Size(max=10,message="Largo de id excedido")
	private int idOpcion;
	// @NotNull @Max(1)
	private int numeroOpcion;
	// @NotNull @Size(max=1000,message="Largo excedido")
	private String opcion;
	// @NotNull @Size(max=10,message="Largo de id excedido")
	private int idPreguntaPersonas;

	/**
	 * @return the idOpcion
	 */
	public int getIdOpcion() {
		return idOpcion;
	}

	/**
	 * @param idOpcion
	 *            the idOpcion to set
	 */
	public void setIdOpcion(int idOpcion) {
		this.idOpcion = idOpcion;
	}

	/**
	 * @return the numeroOpcion
	 */
	public int getNumeroOpcion() {
		return numeroOpcion;
	}

	/**
	 * @param numeroOpcion
	 *            the numeroOpcion to set
	 */
	public void setNumeroOpcion(int numeroOpcion) {
		this.numeroOpcion = numeroOpcion;
	}

	/**
	 * @return the idPreguntaPersonas
	 */
	public int getIdPreguntaPersonas() {
		return idPreguntaPersonas;
	}

	/**
	 * @param idPreguntaPersonas
	 *            the idPreguntaPersonas to set
	 */
	public void setIdPreguntaPersonas(int idPreguntaPersonas) {
		this.idPreguntaPersonas = idPreguntaPersonas;
	}

	/**
	 * @return the opcion
	 */
	public String getOpcion() {
		return opcion;
	}

	/**
	 * @param opcion
	 *            the opcion to set
	 */
	public void setOpcion(String opcion) {
		this.opcion = opcion;
	}
}
