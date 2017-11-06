package entidades.ModuloCapacitacion;

public class PlanCapacitacion {

	private int id_plan;
	private String nombre_plan; 
	private int anio;
	private int rut_empresa;
	
	public int getId_plan() {
		return id_plan;
	}
	public void setId_plan(int id_plan) {
		this.id_plan = id_plan;
	}
	public String getNombre_plan() {
		return nombre_plan;
	}
	public void setNombre_plan(String nombre_plan) {
		this.nombre_plan = nombre_plan;
	}
	public int getAnio() {
		return anio;
	}
	public void setAnio(int anio) {
		this.anio = anio;
	}
	public int getRut_empresa() {
		return rut_empresa;
	}
	public void setRut_empresa(int rut_empresa) {
		this.rut_empresa = rut_empresa;
	}
}
