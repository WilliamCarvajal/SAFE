package entidades.ModuloCapacitacion;
//import javax.validation.constraints.Max;

//import javax.validation.constraints.NotNull;

//import javax.validation.constraints.Size;

public class Alumno {

	// @NotNull @Size(min=1,max=10, message="Rut debe tener 10 caracteres")
	private int rut;
	// @NotNull @Size(min=1,max=1,message="Digito verificado debe ser de un
	// caracter")
	private String dv;
	// @NotNull @Size(max=30,message="Largo de nombre excedido")
	private String nombre;
	// @NotNull @Size(max=20,message="Largo de apellido excedido")
	private String appaterno;
	// @NotNull @Size(max=20,message="Largo de apellido excedido")
	private String apmaterno;
	// @NotNull @Max(10)
	private int idCuentaUsuario;

	/**
	 * @return the rut
	 */
	public int getRut() {
		return rut;
	}

	/**
	 * @param rut
	 *            the rut to set
	 */
	public void setRut(int rut) {
		this.rut = rut;
	}

	/**
	 * @return the dv
	 */
	public String getDv() {
		return dv;
	}

	/**
	 * @param dv
	 *            the dv to set
	 */
	public void setDv(String dv) {
		this.dv = dv;
	}

	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @param nombre
	 *            the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * @return the appaterno
	 */
	public String getAppaterno() {
		return appaterno;
	}

	/**
	 * @param appaterno
	 *            the appaterno to set
	 */
	public void setAppaterno(String appaterno) {
		this.appaterno = appaterno;
	}

	/**
	 * @return the apmaterno
	 */
	public String getApmaterno() {
		return apmaterno;
	}

	/**
	 * @param apmaterno
	 *            the apmaterno to set
	 */
	public void setApmaterno(String apmaterno) {
		this.apmaterno = apmaterno;
	}

	/**
	 * @return the idCuentaUsuario
	 */
	public int getIdCuentaUsuario() {
		return idCuentaUsuario;
	}

	/**
	 * @param idCuentaUsuario
	 *            the idCuentaUsuario to set
	 */
	public void setIdCuentaUsuario(int idCuentaUsuario) {
		this.idCuentaUsuario = idCuentaUsuario;
	}

	public String RutCompleto() {
		return rut + "-" + dv;
	}

}
