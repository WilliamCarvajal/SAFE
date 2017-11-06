package entidades.ModuloGeneral;

public class Region {
	private int id_region;
	private String nom_region;
	private String nro_romano;
	private int cant_provincias;
	private int cant_comunas;

	public int getId_region() {
		return id_region;
	}

	public void setId_region(int id_region) {
		this.id_region = id_region;
	}

	public String getNom_region() {
		return nom_region;
	}

	public void setNom_region(String nom_region) {
		this.nom_region = nom_region;
	}

	public String getNro_romano() {
		return nro_romano;
	}

	public void setNro_romano(String nro_romano) {
		this.nro_romano = nro_romano;
	}

	public int getCant_provincias() {
		return cant_provincias;
	}

	public void setCant_provincias(int cant_provincias) {
		this.cant_provincias = cant_provincias;
	}

	public int getCant_comunas() {
		return cant_comunas;
	}

	public void setCant_comunas(int cant_comunas) {
		this.cant_comunas = cant_comunas;
	}

	@Override
	public String toString() {
		return nro_romano + " " + nom_region;
	}

}
