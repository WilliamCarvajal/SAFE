package entidades.ModuloGeneral;

public class Empresa {

	private int rut_empresa;
	private String dv_empresa;
	private String razon_social;
	private String nombre_empresa;
	private String dir_empresa;
	private String rubro;
	private int id_comuna;
	private int id_provincia;
	private int id_region;
	private int id_cuenta_usuario;

	public int getRut_empresa() {
		return rut_empresa;
	}

	public void setRut_empresa(int rut_empresa) {
		this.rut_empresa = rut_empresa;
	}

	public String getDv_empresa() {
		return dv_empresa;
	}

	public void setDv_empresa(String dv_empresa) {
		this.dv_empresa = dv_empresa;
	}

	public String getRazon_social() {
		return razon_social;
	}

	public void setRazon_social(String razon_social) {
		this.razon_social = razon_social;
	}

	public String getNombre_empresa() {
		return nombre_empresa;
	}

	public void setNombre_empresa(String nombre_empresa) {
		this.nombre_empresa = nombre_empresa;
	}

	public String getDir_empresa() {
		return dir_empresa;
	}

	public void setDir_empresa(String dir_empresa) {
		this.dir_empresa = dir_empresa;
	}

	public String getRubro() {
		return rubro;
	}

	public void setRubro(String rubro) {
		this.rubro = rubro;
	}

	public int getId_comuna() {
		return id_comuna;
	}

	public void setId_comuna(int id_comuna) {
		this.id_comuna = id_comuna;
	}

	public int getId_cuenta_usuario() {
		return id_cuenta_usuario;
	}

	public void setId_cuenta_usuario(int id_cuenta_usuario) {
		this.id_cuenta_usuario = id_cuenta_usuario;
	}

	public int getId_region() {
		return id_region;
	}

	public void setId_region(int id_region) {
		this.id_region = id_region;
	}

	public int getId_provincia() {
		return id_provincia;
	}

	public void setId_provincia(int id_provincia) {
		this.id_provincia = id_provincia;
	}
}
