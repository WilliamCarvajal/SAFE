package entidades.ModuloCapacitacion;
//import javax.validation.constraints.Max;

//import javax.validation.constraints.NotNull;
//import javax.validation.constraints.Size;

import entidades.ModuloGeneral.CuentaUsuario;

public class Expositor {

	// @NotNull @Size(max=10,message="largo de rut excedido, no mas de 10
	// caracteres")
	private int rutExpositor;
	// @NotNull @Max(1)
	private String dvExpositor;
	// @NotNull @Size(max=20,message="largo de nombre excedido, no mas de 10
	// caracteres")
	private String nombreExpositor;
	// @NotNull @Size(max=20,message="largo de apellido excedido, no mas de 10
	// caracteres")
	private String apPaternoExp;
	// @NotNull @Size(max=20,message="largo de apellido excedido, no mas de 10
	// caracteres")
	private String apMaternoExp;
	// @NotNull @Size(max=10,message="largo de nombre de cuenta excedido, no mas de
	// 10 caracteres")
	private CuentaUsuario cuentaExpositor;

	/**
	 * @return the rutExpositor
	 */
	public int getRutExpositor() {
		return rutExpositor;
	}

	/**
	 * @param rutExpositor
	 *            the rutExpositor to set
	 */
	public void setRutExpositor(int rutExpositor) {
		this.rutExpositor = rutExpositor;
	}

	/**
	 * @return the dvExpositor
	 */
	public String getDvExpositor() {
		return dvExpositor;
	}

	/**
	 * @param dvExpositor
	 *            the dvExpositor to set
	 */
	public void setDvExpositor(String dvExpositor) {
		this.dvExpositor = dvExpositor;
	}

	/**
	 * @return the nombreExpositor
	 */
	public String getNombreExpositor() {
		return nombreExpositor;
	}

	/**
	 * @param nombreExpositor
	 *            the nombreExpositor to set
	 */
	public void setNombreExpositor(String nombreExpositor) {
		this.nombreExpositor = nombreExpositor;
	}

	/**
	 * @return the apMaternoExp
	 */
	public String getApMaternoExp() {
		return apMaternoExp;
	}

	/**
	 * @param apMaternoExp
	 *            the apMaternoExp to set
	 */
	public void setApMaternoExp(String apMaternoExp) {
		this.apMaternoExp = apMaternoExp;
	}

	/**
	 * @return the apPaternoExp
	 */
	public String getApPaternoExp() {
		return apPaternoExp;
	}

	/**
	 * @param apPaternoExp
	 *            the apPaternoExp to set
	 */
	public void setApPaternoExp(String apPaternoExp) {
		this.apPaternoExp = apPaternoExp;
	}

	/**
	 * @return the cuentaExpositor
	 */
	public CuentaUsuario getCuentaExpositor() {
		return cuentaExpositor;
	}

	/**
	 * @param cuentaExpositor
	 *            the cuentaExpositor to set
	 */
	public void setCuentaExpositor(CuentaUsuario cuentaExpositor) {
		this.cuentaExpositor = cuentaExpositor;
	}

}
