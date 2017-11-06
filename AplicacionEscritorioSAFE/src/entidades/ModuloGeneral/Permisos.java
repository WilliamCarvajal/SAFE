package entidades.ModuloGeneral;
//import javax.validation.constraints.NotNull;

//import javax.validation.constraints.Size;

public class Permisos {

	// @NotNull @Size(max=10, message="Largo de id excedido")
	private int idPermiso;
	// @NotNull @Size(max=20, message="Descripción de permiso muy larga")
	private String permiso;
	// @NotNull
	private boolean habilitado;
	// @NotNull @Size(max=10, message="Largo de id excedido")
	private int idRol;

	/**
	 * @return the idPermiso
	 */
	public int getIdPermiso() {
		return idPermiso;
	}

	/**
	 * @param idPermiso
	 *            the idPermiso to set
	 */
	public void setIdPermiso(int idPermiso) {
		this.idPermiso = idPermiso;
	}

	/**
	 * @return the permiso
	 */
	public String getPermiso() {
		return permiso;
	}

	/**
	 * @param permiso
	 *            the permiso to set
	 */
	public void setPermiso(String permiso) {
		this.permiso = permiso;
	}

	/**
	 * @return the idRol
	 */
	public int getIdRol() {
		return idRol;
	}

	/**
	 * @param idRol
	 *            the idRol to set
	 */
	public void setIdRol(int idRol) {
		this.idRol = idRol;
	}

	/**
	 * @return the habilitado
	 */
	public boolean isHabilitado() {
		return habilitado;
	}

	/**
	 * @param habilitado
	 *            the habilitado to set
	 */
	public void setHabilitado(boolean habilitado) {
		this.habilitado = habilitado;
	}

}
