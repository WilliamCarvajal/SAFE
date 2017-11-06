package entidades.ModuloGeneral;

public class Comuna {

	private int id_comuna;
	private int id_provincia;
	private String nom_comuna;

	public int getId_comuna() {
		return id_comuna;
	}

	public void setId_comuna(int id_comuna) {
		this.id_comuna = id_comuna;
	}

	public int getId_provincia() {
		return id_provincia;
	}

	public void setId_provincia(int id_provincia) {
		this.id_provincia = id_provincia;
	}

	public String getNom_comuna() {
		return nom_comuna;
	}

	public void setNom_comuna(String nom_comuna) {
		this.nom_comuna = nom_comuna;
	}

	@Override
	public String toString() {
		return nom_comuna;
	}

}
