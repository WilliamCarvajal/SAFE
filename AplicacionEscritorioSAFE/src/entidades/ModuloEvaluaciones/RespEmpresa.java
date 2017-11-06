package entidades.ModuloEvaluaciones;
//import javax.validation.constraints.NotNull;

//import javax.validation.constraints.Size;

import entidades.ModuloGeneral.Empresa;

public class RespEmpresa {

	// @NotNull @Size(max=10,message="Largo de id excedido")
	private int idRespuesta;
	// @NotNull
	private int probabilidad;
	// @NotNull
	private int severidad;
	// @NotNull @Size(max=50,message="Descripción muy larga")
	private String valorRiesgo;
	// @NotNull @Size(max=50,message="Descripción de prioridad muy larga")
	private String prioridad;
	// @NotNull @Size(max=1000,message="Descripción muy larga")
	private String medidaPrevencion;
	// @NotNull @Size(max=10,message="Largo de id excedido")
	private PregEmpresa idRiesgoResp;
	// @NotNull @Size(max=10,message="Largo de rut excedido")
	private Empresa empresaRutResp;
	// @NotNull @Size(max=10,message="Largo de id excedido")
	private EvalTerreno idEvalResp;

	/**
	 * @return the idRespuesta
	 */
	public int getIdRespuesta() {
		return idRespuesta;
	}

	/**
	 * @param idRespuesta
	 *            the idRespuesta to set
	 */
	public void setIdRespuesta(int idRespuesta) {
		this.idRespuesta = idRespuesta;
	}

	/**
	 * @return the probabilidad
	 */
	public int getProbabilidad() {
		return probabilidad;
	}

	/**
	 * @param probabilidad
	 *            the probabilidad to set
	 */
	public void setProbabilidad(int probabilidad) {
		this.probabilidad = probabilidad;
	}

	/**
	 * @return the severidad
	 */
	public int getSeveridad() {
		return severidad;
	}

	/**
	 * @param severidad
	 *            the severidad to set
	 */
	public void setSeveridad(int severidad) {
		this.severidad = severidad;
	}

	/**
	 * @return the valorRiesgo
	 */
	public String getValorRiesgo() {
		return valorRiesgo;
	}

	/**
	 * @param valorRiesgo
	 *            the valorRiesgo to set
	 */
	public void setValorRiesgo(String valorRiesgo) {
		this.valorRiesgo = valorRiesgo;
	}

	/**
	 * @return the prioridad
	 */
	public String getPrioridad() {
		return prioridad;
	}

	/**
	 * @param prioridad
	 *            the prioridad to set
	 */
	public void setPrioridad(String prioridad) {
		this.prioridad = prioridad;
	}

	/**
	 * @return the medidaPrevencion
	 */
	public String getMedidaPrevencion() {
		return medidaPrevencion;
	}

	/**
	 * @param medidaPrevencion
	 *            the medidaPrevencion to set
	 */
	public void setMedidaPrevencion(String medidaPrevencion) {
		this.medidaPrevencion = medidaPrevencion;
	}

	/**
	 * @return the idRiesgoResp
	 */
	public PregEmpresa getIdRiesgoResp() {
		return idRiesgoResp;
	}

	/**
	 * @param idRiesgoResp
	 *            the idRiesgoResp to set
	 */
	public void setIdRiesgoResp(PregEmpresa idRiesgoResp) {
		this.idRiesgoResp = idRiesgoResp;
	}

	/**
	 * @return the empresaRutResp
	 */
	public Empresa getEmpresaRutResp() {
		return empresaRutResp;
	}

	/**
	 * @param empresaRutResp
	 *            the empresaRutResp to set
	 */
	public void setEmpresaRutResp(Empresa empresaRutResp) {
		this.empresaRutResp = empresaRutResp;
	}

	/**
	 * @return the idEvalResp
	 */
	public EvalTerreno getIdEvalResp() {
		return idEvalResp;
	}

	/**
	 * @param idEvalResp
	 *            the idEvalResp to set
	 */
	public void setIdEvalResp(EvalTerreno idEvalResp) {
		this.idEvalResp = idEvalResp;
	}
}
