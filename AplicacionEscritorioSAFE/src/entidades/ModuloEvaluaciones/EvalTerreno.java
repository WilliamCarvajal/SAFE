package entidades.ModuloEvaluaciones;

import java.util.Date;

//import javax.validation.constraints.NotNull;
//import javax.validation.constraints.Size;

public class EvalTerreno {

	// @NotNull @Size(max=10,message="Largo de 10 caracteres excedido")
	private int idEvaluacion;
	// @NotNull
	private Date fechaEvaluacion;
	// @NotNull @Size(max=10,message="Largo de 10 caracteres excedido")
	private int detalleIdEvaluacion;

	/**
	 * @return the idEvaluacion
	 */
	public int getIdEvaluacion() {
		return idEvaluacion;
	}

	/**
	 * @param idEvaluacion
	 *            the idEvaluacion to set
	 */
	public void setIdEvaluacion(int idEvaluacion) {
		this.idEvaluacion = idEvaluacion;
	}

	/**
	 * @return the fechaEvaluacion
	 */
	public Date getFechaEvaluacion() {
		return fechaEvaluacion;
	}

	/**
	 * @param fechaEvaluacion
	 *            the fechaEvaluacion to set
	 */
	public void setFechaEvaluacion(Date fechaEvaluacion) {
		this.fechaEvaluacion = fechaEvaluacion;
	}

	/**
	 * @return the detalleIdEvaluacion
	 */
	public int getDetalleIdEvaluacion() {
		return detalleIdEvaluacion;
	}

	/**
	 * @param detalleIdEvaluacion
	 *            the detalleIdEvaluacion to set
	 */
	public void setDetalleIdEvaluacion(int detalleIdEvaluacion) {
		this.detalleIdEvaluacion = detalleIdEvaluacion;
	}
}
