package entidades.ModuloCapacitacion;

import java.sql.Date;

//import java.util.Date;
//import javax.validation.constraints.Max;
//import javax.validation.constraints.NotNull;

public class AsisCapacitacion {

	// @NotNull
	private Date fecha_actual;
	// @NotNull
	private boolean asiste;
	// @NotNull @Max(10)
	private Alumno rutAlumno;
	// @NotNull @Max(10)
	private int idEjecucionCurso;

	/**
	 * @return the fecha_actual
	 */
	public Date getFecha_actual() {
		return fecha_actual;
	}

	/**
	 * @param fecha_actual
	 *            the fecha_actual to set
	 */
	public void setFecha_actual(Date fecha_actual) {
		this.fecha_actual = fecha_actual;
	}

	/**
	 * @return the asiste
	 */
	public boolean isAsiste() {
		return asiste;
	}

	/**
	 * @param asiste
	 *            the asiste to set
	 */
	public void setAsiste(boolean asiste) {
		this.asiste = asiste;
	}

	/**
	 * @return the rutAlumno
	 */
	public Alumno getRutAlumno() {
		return rutAlumno;
	}

	/**
	 * @param rutAlumno
	 *            the rutAlumno to set
	 */
	public void setRutAlumno(Alumno rutAlumno) {
		this.rutAlumno = rutAlumno;
	}

	/**
	 * @return the idEjecucionCurso
	 */
	public int getIdEjecucionCurso() {
		return idEjecucionCurso;
	}

	/**
	 * @param idEjecucionCurso
	 *            the idEjecucionCurso to set
	 */
	public void setIdEjecucionCurso(int idEjecucionCurso) {
		this.idEjecucionCurso = idEjecucionCurso;
	}
}
