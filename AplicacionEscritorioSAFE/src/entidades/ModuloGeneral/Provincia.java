package entidades.ModuloGeneral;

public class Provincia {

	private int id_provincia;
	private int id_region;
	private String nom_provincia;
	private int cant_comunas;

	public int getId_provincia() {
		return id_provincia;
	}

	public void setId_provincia(int id_provincia) {
		this.id_provincia = id_provincia;
	}

	public int getId_region() {
		return id_region;
	}

	public void setId_region(int id_region) {
		this.id_region = id_region;
	}

	public String getNom_provincia() {
		return nom_provincia;
	}

	public void setNom_provincia(String nom_provincia) {
		this.nom_provincia = nom_provincia;
	}

	public int getCant_comunas() {
		return cant_comunas;
	}

	public void setCant_comunas(int cat_comunas) {
		this.cant_comunas = cat_comunas;
	}

	@Override
	public String toString() {
		return nom_provincia;
	}
}
