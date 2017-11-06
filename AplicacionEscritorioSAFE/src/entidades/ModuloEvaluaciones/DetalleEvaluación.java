package entidades.ModuloEvaluaciones;
//import javax.validation.constraints.NotNull;

//import javax.validation.constraints.Size;

public class DetalleEvaluaci�n {

	// @NotNull @Size(max=10,message="Largo excedido(10)")
	private int idDetalle;
	// @NotNull
	private int autorizado;
	// @NotNull
	private int revisado;
	// @NotNull @Size(max=500,message="Largo de descripci�n excedido (500
	// caracteres)")
	private String observaci�n;
	// @NotNull @Size(max=10,message="Largo excedido(10)")
	private int rutEmpleado;
	// @NotNull @Size(max=10,message="Largo excedido(10)")
	private int idEvaluacionTerreno;

	public int getIdDetalle() {
		return idDetalle;
	}

	public void setIdDetalle(int idDetalle) {
		this.idDetalle = idDetalle;
	}

	public int isAutorizado() {
		return autorizado;
	}

	public void setAutorizado(int autorizado) {
		this.autorizado = autorizado;
	}

	public int isRevisado() {
		return revisado;
	}

	public void setRevisado(int revisado) {
		this.revisado = revisado;
	}

	public String getObservaci�n() {
		return observaci�n;
	}

	public void setObservaci�n(String observaci�n) {
		this.observaci�n = observaci�n;
	}

	public int getRutEmpleado() {
		return rutEmpleado;
	}

	public void setRutEmpleado(int rutEmpleado) {
		this.rutEmpleado = rutEmpleado;
	}
	
	public int getIdEvaluacionTerreno() {
		return idEvaluacionTerreno;
	}

	public void setIdEvaluacionTerreno(int idEvaluacionTerreno) {
		this.idEvaluacionTerreno = idEvaluacionTerreno;
	}

}
