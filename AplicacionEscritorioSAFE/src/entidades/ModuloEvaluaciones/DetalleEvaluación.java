package entidades.ModuloEvaluaciones;
//import javax.validation.constraints.NotNull;

//import javax.validation.constraints.Size;

public class DetalleEvaluación {

	// @NotNull @Size(max=10,message="Largo excedido(10)")
	private int idDetalle;
	// @NotNull
	private int autorizado;
	// @NotNull
	private int revisado;
	// @NotNull @Size(max=500,message="Largo de descripción excedido (500
	// caracteres)")
	private String observación;
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

	public String getObservación() {
		return observación;
	}

	public void setObservación(String observación) {
		this.observación = observación;
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
