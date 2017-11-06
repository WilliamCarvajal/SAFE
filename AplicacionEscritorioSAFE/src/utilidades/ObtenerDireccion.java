package utilidades;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import entidades.ModuloGeneral.Comuna;
import entidades.ModuloGeneral.Provincia;
import entidades.ModuloGeneral.Region;
import service.ServicioComunicacionStub;
import service.ServicioComunicacionStub.ReadComunas;
import service.ServicioComunicacionStub.ReadProvincias;
import service.ServicioComunicacionStub.ReadRegiones;

public class ObtenerDireccion {
	public static void ObtenerRegiones(JComboBox cbxRegiones, int idRegion) {
		try {
			cbxRegiones.removeAllItems();

			ServicioComunicacionStub proxy = new ServicioComunicacionStub();
			ArrayList<Region> regiones = new ArrayList<>();
			ReadRegiones readRegiones = new ReadRegiones();
			String regionesJson = proxy.readRegiones(readRegiones).get_return();
			regiones = new ObjectMapper().readValue(regionesJson, new TypeReference<List<Region>>() {
			});

			for (Region region : regiones) {
				cbxRegiones.addItem(region);
				if (region.getId_region()==idRegion) {
					cbxRegiones.setSelectedItem(region);
				}
			}
		} catch (Exception ex) {
			// mandar mensaje
			JOptionPane.showMessageDialog(null, "No se pudieron cargar las regiones");
		}
	}

	public static void ObtenerProvincias(JComboBox cbxProvincias, JComboBox cbxRegiones, int idProvincia) {
		try {
			cbxProvincias.removeAllItems();

			if (cbxRegiones.getSelectedIndex() >= 0) {
				cbxProvincias.removeAllItems();

				Region reg = (Region) cbxRegiones.getSelectedItem();
				ServicioComunicacionStub proxy = new ServicioComunicacionStub();
				ArrayList<Provincia> provincias = new ArrayList<>();
				ReadProvincias readprovincia = new ReadProvincias();
				readprovincia.setIdRegion(reg.getId_region());
				String provinciasJson = proxy.readProvincias(readprovincia).get_return();
				provincias = new ObjectMapper().readValue(provinciasJson, new TypeReference<List<Provincia>>() {
				});
				for (Provincia prov : provincias) {
					cbxProvincias.addItem(prov);
					if (prov.getId_provincia()==idProvincia) {
						cbxProvincias.setSelectedItem(prov);
					}
				}
			}
		} catch (Exception ex) {
			JOptionPane.showMessageDialog(null, "No se pudo cargar lista de provincias.");
		}
	}

	public static void ObtenerComunas(JComboBox cbxComunas, JComboBox cbxProvincias, int idComuna) {
		try {
			cbxComunas.removeAllItems();

			if (cbxProvincias.getSelectedIndex() >= 0) {
				cbxComunas.removeAllItems();

				Provincia pro = (Provincia) cbxProvincias.getSelectedItem();
				ServicioComunicacionStub proxy = new ServicioComunicacionStub();
				ArrayList<Comuna> comunas = new ArrayList<>();
				ReadComunas readCom = new ReadComunas();
				readCom.setIdProvincia(pro.getId_provincia());
				String comunasJson = proxy.readComunas(readCom).get_return();
				comunas = new ObjectMapper().readValue(comunasJson, new TypeReference<List<Comuna>>() {
				});
				for (Comuna comu : comunas) {
					cbxComunas.addItem(comu);
					if (comu.getId_comuna()==idComuna) {
						cbxComunas.setSelectedItem(comu);
					}
				}
			}
		} catch (Exception ex) {
			JOptionPane.showMessageDialog(null, "No se pudo cargar lista de comunas.");
		}
	}
}
