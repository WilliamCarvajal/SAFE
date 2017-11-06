package entidades.ModuloCapacitacion;

public class Curso {

	private int id_curso;
	private String nombre_curso;
	private String lugar_curso;
	private int min_participantes;
	private int max_participantes;
	private String desc_curso;
	private String correo_info;
	private int id_plan_capacitacion;
	
	public int getId_curso() {
		return id_curso;
	}
	public void setId_curso(int id_curso) {
		this.id_curso = id_curso;
	}
	public String getNombre_curso() {
		return nombre_curso;
	}
	public void setNombre_curso(String nombre_curso) {
		this.nombre_curso = nombre_curso;
	}
	public String getLugar_curso() {
		return lugar_curso;
	}
	public void setLugar_curso(String lugar_curso) {
		this.lugar_curso = lugar_curso;
	}
	public int getMin_participantes() {
		return min_participantes;
	}
	public void setMin_participantes(int min_participantes) {
		this.min_participantes = min_participantes;
	}
	public int getMax_participantes() {
		return max_participantes;
	}
	public void setMax_participantes(int max_participantes) {
		this.max_participantes = max_participantes;
	}
	public String getDesc_curso() {
		return desc_curso;
	}
	public void setDesc_curso(String desc_curso) {
		this.desc_curso = desc_curso;
	}
	public String getCorreo_info() {
		return correo_info;
	}
	public void setCorreo_info(String correo_info) {
		this.correo_info = correo_info;
	}
	public int getId_plan_capacitacion() {
		return id_plan_capacitacion;
	}
	public void setId_plan_capacitacion(int id_plan_capacitacion) {
		this.id_plan_capacitacion = id_plan_capacitacion;
	}
	
}
