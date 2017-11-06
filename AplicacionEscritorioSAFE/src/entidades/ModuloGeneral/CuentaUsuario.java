package entidades.ModuloGeneral;
//import javax.validation.constraints.NotNull;

//import javax.validation.constraints.Size;

public class CuentaUsuario {
	private int id;
	private String username;
	private String password;
	private int habilitado;
	private int rol;

	public CuentaUsuario() {
	}

	public CuentaUsuario(String xml) {
		//
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getRol() {
		return rol;
	}

	public void setRol(int rol) {
		this.rol = rol;
	}

	public int getHabilitado() {
		return habilitado;
	}

	public void setHabilitado(int habilitado) {
		this.habilitado = habilitado;
	}
}
