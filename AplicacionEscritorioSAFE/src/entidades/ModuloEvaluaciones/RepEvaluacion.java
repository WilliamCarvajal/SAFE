package entidades.ModuloEvaluaciones;

import java.util.Date;

import entidades.ModuloGeneral.Empresa;

//import javax.validation.constraints.NotNull;
//import javax.validation.constraints.Size;

public class RepEvaluacion {

	// @NotNull @Size(max=10,message="Largo de id excedido")
	private int idResultado;
	// @NotNull
	private Date anioEvaluacion;
	// @NotNull @Size(max=100,message="Descripción demasiado larga")
	private String resultado;
	// @NotNull @Size(max=10,message="Largo de rut excedido")
	private Empresa rutEmpresaEval;

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
	 * @return the anioEvaluacion
	 */
	public Date getAnioEvaluacion() {
		return anioEvaluacion;
	}

	/**
	 * @param anioEvaluacion
	 *            the anioEvaluacion to set
	 */
	public void setAnioEvaluacion(Date anioEvaluacion) {
		this.anioEvaluacion = anioEvaluacion;
	}

	/**
	 * @return the resultado
	 */
	public String getResultado() {
		return resultado;
	}

	/**
	 * @param resultado
	 *            the resultado to set
	 */
	public void setResultado(String resultado) {
		this.resultado = resultado;
	}

	/**
	 * @return the rutEmpresaEval
	 */
	public Empresa getRutEmpresaEval() {
		return rutEmpresaEval;
	}

	/**
	 * @param rutEmpresaEval
	 *            the rutEmpresaEval to set
	 */
	public void setRutEmpresaEval(Empresa rutEmpresaEval) {
		this.rutEmpresaEval = rutEmpresaEval;
	}
}
