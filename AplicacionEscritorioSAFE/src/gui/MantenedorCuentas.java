package gui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.IOException;
import java.io.StringWriter;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import service.ServicioComunicacionIOExceptionException;
import service.ServicioComunicacionStub;
import service.ServicioComunicacionStub.InsertEmpresa;
import service.ServicioComunicacionStub.ReadComunas;
import service.ServicioComunicacionStub.ReadProvincias;
import service.ServicioComunicacionStub.ReadRegiones;

import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import com.toedter.calendar.JDateChooser;

import entidades.ModuloGeneral.Comuna;
import entidades.ModuloGeneral.Empleado;
import entidades.ModuloGeneral.Empresa;
import entidades.ModuloGeneral.Provincia;
import entidades.ModuloGeneral.Region;
import entidades.ModuloGeneral.Rol;

import javax.swing.JRadioButton;
import javax.swing.SwingConstants;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JSeparator;

public class MantenedorCuentas extends JFrame {

	private JPanel contentPane;
	private JTextField txtRazonSocial;
	private JTextField txtDirEmpresa;
	private JTextField txtNombreCorto;
	private JTextField txtRubro;
	private JTextField txtRutEmpresa;
	private JTextField txtDVempresa;
	private JTextField txtNombreEmpleado;
	private JTextField txtApPaterno;
	private JTextField txtRutEmpleado;
	private JTextField txtDvEmpleado;
	private JTextField txtApMaterno;
	private JTextField txtFono;
	private JTextField txtEmail;
	private JTextField txtCelu;
	private JTextField txtDirEmpleado;
	private ButtonGroup bg = new ButtonGroup();
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MantenedorCuentas frame = new MantenedorCuentas();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MantenedorCuentas() {
		setTitle("Inicio Administrador");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 673, 694);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu mnAplicacin = new JMenu("Aplicaci\u00F3n");
		menuBar.add(mnAplicacin);

		JMenuItem mntmNuevoInicio = new JMenuItem("Nuevo inicio de sesi\u00F3n");
		mntmNuevoInicio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Login lgn = new Login();
				lgn.setVisible(true);
			}
		});

		JMenuItem mntmCerrarSesin = new JMenuItem("Cerrar sesi\u00F3n");
		mntmCerrarSesin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Login lgn = new Login();
				lgn.setVisible(true);
				dispose();
			}
		});
		mnAplicacin.add(mntmCerrarSesin);
		mnAplicacin.add(mntmNuevoInicio);

		JMenuItem mntmDupVentana = new JMenuItem("Duplicar ventana");
		mntmDupVentana.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MantenedorCuentas mantCta = new MantenedorCuentas();
				mantCta.setVisible(true);
			}
		});
		mnAplicacin.add(mntmDupVentana);

		JSeparator separator = new JSeparator();
		mnAplicacin.add(separator);

		JMenuItem mntmSalir = new JMenuItem("Salir de la aplicaci\u00F3n");
		mntmSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(JFrame.DISPOSE_ON_CLOSE);
			}
		});
		mnAplicacin.add(mntmSalir);

		JMenu mnAgregar = new JMenu("Agregar");
		menuBar.add(mnAgregar);

		contentPane = new JPanel();
		contentPane.setBackground(new Color(51, 153, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblAdmin = new JLabel("Inicio Administrador");
		lblAdmin.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblAdmin.setBounds(10, 34, 385, 14);
		contentPane.add(lblAdmin);

		JPanel pnlEmpresa = new JPanel();
		pnlEmpresa.setBounds(677, 88, 290, 337);
		contentPane.add(pnlEmpresa);
		pnlEmpresa.setLayout(null);

		JComboBox cbxRegEmpresa = new JComboBox();
		cbxRegEmpresa.setBounds(93, 182, 177, 20);
		pnlEmpresa.add(cbxRegEmpresa);

		JComboBox cbxProvEmpresa = new JComboBox();
		cbxProvEmpresa.setBounds(93, 213, 177, 20);
		pnlEmpresa.add(cbxProvEmpresa);

		JComboBox cbxComEmpresa = new JComboBox();
		cbxComEmpresa.setBounds(93, 244, 177, 20);
		pnlEmpresa.add(cbxComEmpresa);

		try {

			ServicioComunicacionStub proxy = new ServicioComunicacionStub();
			ArrayList<Region> regiones = new ArrayList<>();
			ReadRegiones readRegiones = new ReadRegiones();
			String regionesJson = proxy.readRegiones(readRegiones).get_return();
			regiones = new ObjectMapper().readValue(regionesJson, new TypeReference<List<Region>>() {
			});

			for (Region region : regiones) {
				cbxRegEmpresa.addItem(region);
			}
		} catch (Exception ex) {
			// mandar mensaje
			JOptionPane.showMessageDialog(null, "No se pudieron cargar las regiones");
		}

		JLabel lblDatosDelCliente = new JLabel("Datos de empresa");
		lblDatosDelCliente.setBounds(73, 11, 130, 14);
		pnlEmpresa.add(lblDatosDelCliente);

		JLabel lblNombre = new JLabel("Nombre corto");
		lblNombre.setBounds(10, 95, 102, 14);
		pnlEmpresa.add(lblNombre);

		JLabel lblRubro = new JLabel("Rubro");
		lblRubro.setBounds(10, 123, 86, 14);
		pnlEmpresa.add(lblRubro);

		txtNombreCorto = new JTextField();
		txtNombreCorto.setBounds(93, 92, 177, 20);
		pnlEmpresa.add(txtNombreCorto);
		txtNombreCorto.setColumns(10);

		txtRubro = new JTextField();
		txtRubro.setBounds(93, 120, 177, 20);
		pnlEmpresa.add(txtRubro);
		txtRubro.setColumns(10);

		JLabel lblRut = new JLabel("Rut");
		lblRut.setBounds(10, 39, 86, 14);
		pnlEmpresa.add(lblRut);

		txtRutEmpresa = new JTextField();
		txtRutEmpresa.setBounds(93, 36, 127, 20);
		pnlEmpresa.add(txtRutEmpresa);
		txtRutEmpresa.setColumns(10);

		txtDVempresa = new JTextField();
		txtDVempresa.setBounds(238, 36, 32, 20);
		pnlEmpresa.add(txtDVempresa);
		txtDVempresa.setColumns(10);

		JLabel label = new JLabel("-");
		label.setBounds(226, 39, 12, 14);
		pnlEmpresa.add(label);

		JLabel lblRazonSocial = new JLabel("Razon social");
		lblRazonSocial.setBounds(10, 67, 102, 14);
		pnlEmpresa.add(lblRazonSocial);

		txtRazonSocial = new JTextField();
		txtRazonSocial.setBounds(93, 64, 177, 20);
		pnlEmpresa.add(txtRazonSocial);
		txtRazonSocial.setColumns(10);

		JLabel lblDireccion = new JLabel("Direccion");
		lblDireccion.setBounds(10, 151, 123, 14);
		pnlEmpresa.add(lblDireccion);

		txtDirEmpresa = new JTextField();
		txtDirEmpresa.setBounds(93, 151, 177, 20);
		pnlEmpresa.add(txtDirEmpresa);
		txtDirEmpresa.setColumns(10);

		JLabel lblRegion = new JLabel("Regi\u00F3n");
		lblRegion.setBounds(10, 185, 102, 14);
		pnlEmpresa.add(lblRegion);

		JLabel lblProvincia = new JLabel("Provincia");
		lblProvincia.setBounds(10, 216, 86, 14);
		pnlEmpresa.add(lblProvincia);

		JLabel lblComuna = new JLabel("Comuna");
		lblComuna.setBounds(10, 247, 73, 14);
		pnlEmpresa.add(lblComuna);

		JButton btnCambiosEmpresa = new JButton("Guardar Cambios");
		btnCambiosEmpresa.setBounds(74, 287, 146, 23);
		pnlEmpresa.add(btnCambiosEmpresa);
		btnCambiosEmpresa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// if (txtPassword.getPassword() == txtConfirmarPass.getPassword()) {

				int rutEmpresa = Integer.parseInt(txtRutEmpresa.getText());
				String dvEmpresa = txtDVempresa.getText();
				String razonSocial = txtRazonSocial.getText();
				String nombreEmpresa = txtNombreCorto.getText();
				String dirEmpresa = txtDirEmpresa.getText();
				String rubro = txtRubro.getText();
				Comuna comu = (Comuna) cbxComEmpresa.getSelectedItem();
				int idComuna = comu.getId_comuna();

				try {
					ServicioComunicacionStub proxy = new ServicioComunicacionStub();

					StringWriter stringIns = new StringWriter();
					ObjectMapper objectMapper = new ObjectMapper();

					stringIns.toString();

					// if (idCuentaIns > 0) {

					Empresa emp = new Empresa();
					emp.setRut_empresa(rutEmpresa);
					emp.setDv_empresa(dvEmpresa);
					emp.setNombre_empresa(nombreEmpresa);
					emp.setRazon_social(razonSocial);
					emp.setDir_empresa(dirEmpresa);
					emp.setRubro(rubro);
					emp.setId_comuna(idComuna);

					StringWriter stringInsEmp = new StringWriter();
					objectMapper.writeValue(stringInsEmp, emp);
					String insJsonEmp = stringInsEmp.toString();
					InsertEmpresa insertEmpresa = new InsertEmpresa();
					insertEmpresa.setEmpresaJson(insJsonEmp);

					System.out.println("json insert empresa: " + insertEmpresa);
					int rutEmp = proxy.insertEmpresa(insertEmpresa).get_return();
					System.out.println("rut empresa ingresado: " + rutEmp);

					if (rutEmp > 0) {
						JOptionPane.showMessageDialog(null, "Se registro exitosamente la empresa");

					} else {
						JOptionPane.showMessageDialog(null, "Error al registrar la empresa.");
					}

					// }

				} catch (RemoteException e1) {
					e1.printStackTrace();
				} catch (ServicioComunicacionIOExceptionException e1) {
					e1.printStackTrace();
				} catch (JsonGenerationException e) {
					e.printStackTrace();
				} catch (JsonMappingException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
				// } else {
				// JOptionPane.showMessageDialog(null, "Contraseñas no coinciden.");
				// }
			}
		});

		cbxProvEmpresa.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				try {

					if (cbxProvEmpresa.getSelectedIndex() >= 0) {
						System.out.println("change de provincia: " + (Provincia) cbxProvEmpresa.getSelectedItem());
						cbxComEmpresa.removeAllItems();

						Provincia pro = (Provincia) cbxProvEmpresa.getSelectedItem();
						ServicioComunicacionStub proxy = new ServicioComunicacionStub();
						ArrayList<Comuna> comunas = new ArrayList<>();
						ReadComunas readCom = new ReadComunas();
						readCom.setIdProvincia(pro.getId_provincia());
						String comunasJson = proxy.readComunas(readCom).get_return();
						comunas = new ObjectMapper().readValue(comunasJson, new TypeReference<List<Comuna>>() {
						});
						for (Comuna comu : comunas) {
							cbxComEmpresa.addItem(comu);
						}
					}
				} catch (Exception ex) {
					// mandar mensaje
					JOptionPane.showMessageDialog(null, "No se pudo cargar lista de comunas.");
				}
			}
		});

		cbxRegEmpresa.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				try {

					if (cbxRegEmpresa.getSelectedIndex() >= 0) {
						System.out.println("change de region: " + cbxRegEmpresa.getSelectedIndex());
						cbxProvEmpresa.removeAllItems();

						Region reg = (Region) cbxRegEmpresa.getSelectedItem();
						ServicioComunicacionStub proxy = new ServicioComunicacionStub();
						ArrayList<Provincia> provincias = new ArrayList<>();
						ReadProvincias readprovincia = new ReadProvincias();
						readprovincia.setIdRegion(reg.getId_region());
						String provinciasJson = proxy.readProvincias(readprovincia).get_return();
						provincias = new ObjectMapper().readValue(provinciasJson, new TypeReference<List<Provincia>>() {
						});
						for (Provincia prov : provincias) {
							cbxProvEmpresa.addItem(prov);
						}
					}
				} catch (Exception ex) {
					// mandar mensaje

					JOptionPane.showMessageDialog(null, "No se pudo cargar lista de provincias.");

				}
			}
		});

		JPanel pnlCredenciales = new JPanel();
		pnlCredenciales.setBounds(21, 88, 299, 503);
		contentPane.add(pnlCredenciales);

		JLabel lblListado = new JLabel("Listado de cuentas");
		lblListado.setFont(new Font("Tahoma", Font.BOLD, 11));

		JLabel lblRolARegistrar = new JLabel("Rol a editar:");

		JComboBox cbxRol = new JComboBox();

		Rol rol1 = new Rol();
		rol1.setId_rol(3);
		rol1.setNombre_rol("Supervisor");
		rol1.setDescripcion("Recopila y emite informes de evaluación.");
		cbxRol.addItem(rol1);

		Rol rol2 = new Rol();
		rol2.setId_rol(4);
		rol2.setNombre_rol("Ingeniero");
		rol2.setDescripcion("Autoriza informes emitidos.");
		cbxRol.addItem(rol2);

		Rol rol3 = new Rol();
		rol3.setId_rol(9);
		rol3.setNombre_rol("Empresa");
		rol3.setDescripcion("Empresa registrada.");
		cbxRol.addItem(rol3);

		JPanel pnlEmpleado = new JPanel();
		pnlEmpleado.setLayout(null);
		pnlEmpleado.setBounds(345, 88, 290, 432);
		contentPane.add(pnlEmpleado);

		pnlEmpresa.setVisible(false);

		JComboBox cbxProvUser = new JComboBox();

		cbxProvUser.setBounds(76, 308, 189, 20);
		pnlEmpleado.add(cbxProvUser);

		JComboBox cbxRegUser = new JComboBox();
		cbxRegUser.setBounds(76, 277, 189, 20);
		pnlEmpleado.add(cbxRegUser);

		JLabel label_14 = new JLabel("Provincia");
		label_14.setBounds(10, 311, 63, 14);
		pnlEmpleado.add(label_14);

		JComboBox cbxComUser = new JComboBox();
		cbxComUser.setBounds(76, 339, 189, 20);
		pnlEmpleado.add(cbxComUser);
		try {

			ServicioComunicacionStub proxy = new ServicioComunicacionStub();
			ArrayList<Region> regiones = new ArrayList<>();
			ReadRegiones readRegiones = new ReadRegiones();
			String regionesJson = proxy.readRegiones(readRegiones).get_return();
			regiones = new ObjectMapper().readValue(regionesJson, new TypeReference<List<Region>>() {
			});

			for (Region region : regiones) {
				cbxRegUser.addItem(region);
			}
		} catch (Exception ex) {
			// mandar mensaje
			JOptionPane.showMessageDialog(null, "No se pudieron cargar las regiones");
		}

		cbxRegUser.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				try {

					if (cbxRegUser.getSelectedIndex() >= 0) {
						System.out.println("change de region: " + cbxRegUser.getSelectedIndex());
						cbxProvUser.removeAllItems();

						Region reg = (Region) cbxRegUser.getSelectedItem();
						ServicioComunicacionStub proxy = new ServicioComunicacionStub();
						ArrayList<Provincia> provincias = new ArrayList<>();
						ReadProvincias readprovincia = new ReadProvincias();
						readprovincia.setIdRegion(reg.getId_region());
						String provinciasJson = proxy.readProvincias(readprovincia).get_return();
						provincias = new ObjectMapper().readValue(provinciasJson, new TypeReference<List<Provincia>>() {
						});
						for (Provincia prov : provincias) {
							cbxProvUser.addItem(prov);
						}
					}
				} catch (Exception ex) {
					// mandar mensaje
					JOptionPane.showMessageDialog(null, "No se pudo cargar lista de provincias.");
				}
			}
		});

		cbxProvUser.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				try {

					if (cbxProvUser.getSelectedIndex() >= 0) {
						System.out.println("change de provincia: " + (Provincia) cbxProvUser.getSelectedItem());
						cbxComUser.removeAllItems();

						Provincia pro = (Provincia) cbxProvUser.getSelectedItem();
						ServicioComunicacionStub proxy = new ServicioComunicacionStub();
						ArrayList<Comuna> comunas = new ArrayList<>();
						ReadComunas readCom = new ReadComunas();
						readCom.setIdProvincia(pro.getId_provincia());
						String comunasJson = proxy.readComunas(readCom).get_return();
						comunas = new ObjectMapper().readValue(comunasJson, new TypeReference<List<Comuna>>() {
						});
						for (Comuna comu : comunas) {
							cbxComUser.addItem(comu);
						}
					}
				} catch (Exception ex) {
					// mandar mensaje
					JOptionPane.showMessageDialog(null, "No se pudo cargar lista de comunas.");
				}
			}
		});

		cbxRol.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				Rol rol = (Rol) cbxRol.getSelectedItem();

				switch (rol.getId_rol()) {

				case 3:
					pnlEmpleado.setVisible(true);
					pnlEmpresa.setVisible(false);
					break;
				case 4:
					pnlEmpleado.setVisible(true);
					pnlEmpresa.setVisible(false);
					break;
				case 9:
					pnlEmpleado.setVisible(false);
					pnlEmpresa.setVisible(true);
					pnlEmpresa.setBounds(345, 88, 290, 360);
					break;

				default:
					pnlEmpleado.setVisible(true);
					pnlEmpresa.setVisible(false);
					break;

				}
			}
		});

		JButton btnInicio = new JButton("Volver a menu");
		btnInicio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				EmpresaMenu empmenu = new EmpresaMenu();
				empmenu.setVisible(true);
				dispose();
			}
		});

		table = new JTable();
		table.setModel(new DefaultTableModel(
				new Object[][] { { null, null, null, null }, { null, null, null, null }, { null, null, null, null },
						{ null, null, null, null }, { null, null, null, null }, { null, null, null, null },
						{ null, null, null, null }, { null, null, null, null }, { null, null, null, null },
						{ null, null, null, null }, { null, null, null, null }, { null, null, null, null },
						{ null, null, null, null }, { null, null, null, null }, { null, null, null, null },
						{ null, null, null, null }, { null, null, null, null }, },
				new String[] { "New column", "New column", "New column", "New column" }));

		JButton btnEliminarCuenta = new JButton("Eliminar cuenta");

		JButton btnDeshabilitar = new JButton("Deshabilitar cuenta");

		GroupLayout gl_pnlCredenciales = new GroupLayout(pnlCredenciales);
		gl_pnlCredenciales.setHorizontalGroup(gl_pnlCredenciales.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlCredenciales.createSequentialGroup().addGap(80)
						.addGroup(gl_pnlCredenciales.createParallelGroup(Alignment.TRAILING, false)
								.addComponent(btnDeshabilitar, Alignment.LEADING, GroupLayout.DEFAULT_SIZE,
										GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(btnEliminarCuenta, Alignment.LEADING, GroupLayout.DEFAULT_SIZE,
										GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(btnInicio, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 146,
										Short.MAX_VALUE))
						.addContainerGap(84, Short.MAX_VALUE))
				.addGroup(Alignment.TRAILING, gl_pnlCredenciales.createSequentialGroup()
						.addGroup(gl_pnlCredenciales.createParallelGroup(Alignment.TRAILING)
								.addGroup(gl_pnlCredenciales.createSequentialGroup().addContainerGap().addComponent(
										table, GroupLayout.PREFERRED_SIZE, 259, GroupLayout.PREFERRED_SIZE))
								.addGroup(
										gl_pnlCredenciales.createSequentialGroup().addGap(20)
												.addComponent(lblRolARegistrar, GroupLayout.PREFERRED_SIZE, 79,
														GroupLayout.PREFERRED_SIZE)
												.addPreferredGap(ComponentPlacement.RELATED)
												.addGroup(gl_pnlCredenciales.createParallelGroup(Alignment.LEADING)
														.addComponent(lblListado, GroupLayout.PREFERRED_SIZE, 139,
																GroupLayout.PREFERRED_SIZE)
														.addComponent(cbxRol, 0, 174, Short.MAX_VALUE))))
						.addGap(23)));
		gl_pnlCredenciales.setVerticalGroup(gl_pnlCredenciales.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_pnlCredenciales.createSequentialGroup().addContainerGap()
						.addGroup(gl_pnlCredenciales.createParallelGroup(Alignment.TRAILING)
								.addGroup(gl_pnlCredenciales.createSequentialGroup().addComponent(lblListado).addGap(24)
										.addComponent(cbxRol, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
												GroupLayout.PREFERRED_SIZE))
								.addComponent(lblRolARegistrar))
						.addGap(18).addComponent(table, GroupLayout.PREFERRED_SIZE, 286, GroupLayout.PREFERRED_SIZE)
						.addGap(18).addComponent(btnDeshabilitar).addGap(13).addComponent(btnEliminarCuenta)
						.addPreferredGap(ComponentPlacement.UNRELATED).addComponent(btnInicio).addGap(19)));
		pnlCredenciales.setLayout(gl_pnlCredenciales);

		JLabel label_1 = new JLabel("Nombres");
		label_1.setBounds(10, 65, 89, 14);
		pnlEmpleado.add(label_1);

		JLabel label_2 = new JLabel("Apellido paterno");
		label_2.setBounds(10, 90, 104, 14);
		pnlEmpleado.add(label_2);

		JLabel label_3 = new JLabel("Fecha de nacimiento");
		label_3.setBounds(10, 146, 125, 14);
		pnlEmpleado.add(label_3);

		JDateChooser dcFchNacimiento = new JDateChooser();
		dcFchNacimiento.setBounds(133, 142, 132, 20);
		pnlEmpleado.add(dcFchNacimiento);

		txtNombreEmpleado = new JTextField();
		txtNombreEmpleado.setColumns(10);
		txtNombreEmpleado.setBounds(133, 64, 132, 20);
		pnlEmpleado.add(txtNombreEmpleado);

		txtApPaterno = new JTextField();
		txtApPaterno.setColumns(10);
		txtApPaterno.setBounds(133, 89, 132, 20);
		pnlEmpleado.add(txtApPaterno);

		JLabel label_5 = new JLabel("Rut");
		label_5.setBounds(10, 40, 72, 14);
		pnlEmpleado.add(label_5);

		txtRutEmpleado = new JTextField();
		txtRutEmpleado.setColumns(10);
		txtRutEmpleado.setBounds(133, 40, 86, 20);
		pnlEmpleado.add(txtRutEmpleado);

		JLabel label_6 = new JLabel("-");
		label_6.setBounds(224, 42, 13, 14);
		pnlEmpleado.add(label_6);

		txtDvEmpleado = new JTextField();
		txtDvEmpleado.setColumns(10);
		txtDvEmpleado.setBounds(234, 40, 31, 20);
		pnlEmpleado.add(txtDvEmpleado);

		JLabel label_7 = new JLabel("Apellido materno");
		label_7.setBounds(10, 115, 114, 14);
		pnlEmpleado.add(label_7);

		txtApMaterno = new JTextField();
		txtApMaterno.setColumns(10);
		txtApMaterno.setBounds(133, 114, 132, 20);
		pnlEmpleado.add(txtApMaterno);

		JLabel label_8 = new JLabel("Sexo");
		label_8.setBounds(10, 171, 72, 14);
		pnlEmpleado.add(label_8);

		JLabel label_9 = new JLabel("Tel\u00E9fono");
		label_9.setBounds(10, 199, 72, 14);
		pnlEmpleado.add(label_9);

		txtFono = new JTextField();
		txtFono.setHorizontalAlignment(SwingConstants.TRAILING);
		txtFono.setColumns(10);
		txtFono.setBounds(76, 196, 63, 20);
		pnlEmpleado.add(txtFono);

		JLabel label_10 = new JLabel("Email");
		label_10.setBounds(10, 224, 63, 14);
		pnlEmpleado.add(label_10);

		txtEmail = new JTextField();
		txtEmail.setColumns(10);
		txtEmail.setBounds(76, 223, 189, 20);
		pnlEmpleado.add(txtEmail);

		JLabel label_11 = new JLabel("Celular");
		label_11.setBounds(147, 199, 57, 14);
		pnlEmpleado.add(label_11);

		txtCelu = new JTextField();
		txtCelu.setHorizontalAlignment(SwingConstants.TRAILING);
		txtCelu.setColumns(10);
		txtCelu.setBounds(193, 196, 72, 20);
		pnlEmpleado.add(txtCelu);

		JLabel label_12 = new JLabel("Direcci\u00F3n");
		label_12.setBounds(10, 252, 72, 14);
		pnlEmpleado.add(label_12);

		txtDirEmpleado = new JTextField();
		txtDirEmpleado.setColumns(10);
		txtDirEmpleado.setBounds(76, 249, 189, 20);
		pnlEmpleado.add(txtDirEmpleado);

		JLabel label_13 = new JLabel("Regi\u00F3n");
		label_13.setBounds(10, 280, 63, 14);
		pnlEmpleado.add(label_13);

		JLabel label_15 = new JLabel("Comuna");
		label_15.setBounds(10, 342, 63, 14);
		pnlEmpleado.add(label_15);

		JLabel lblDatosDeUsuario = new JLabel("Datos de usuario");
		lblDatosDeUsuario.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblDatosDeUsuario.setHorizontalAlignment(SwingConstants.CENTER);
		lblDatosDeUsuario.setBounds(68, 11, 136, 14);
		pnlEmpleado.add(lblDatosDeUsuario);

		JButton btnGuarCambios = new JButton("Guardar Cambios");
		btnGuarCambios.setBounds(76, 386, 147, 23);
		pnlEmpleado.add(btnGuarCambios);

		JRadioButton rbtnFemenino = new JRadioButton("Femenino");
		rbtnFemenino.setBounds(183, 167, 82, 23);
		pnlEmpleado.add(rbtnFemenino);

		JRadioButton rbtnMasculino = new JRadioButton("Masculino");
		rbtnMasculino.setBounds(92, 167, 89, 23);
		pnlEmpleado.add(rbtnMasculino);

		bg.add(rbtnMasculino);
		bg.add(rbtnFemenino);

		btnGuarCambios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// if (txtPassword.getPassword() == txtConfirmarPass.getPassword()) {

				int rutEmpleado = Integer.parseInt(txtRutEmpleado.getText());
				String dvEmpleado = txtDvEmpleado.getText();
				String nomEmpleado = txtNombreEmpleado.getText();
				String apPat = txtApPaterno.getText();
				String apMat = txtApMaterno.getText();
				Date fchNac = dcFchNacimiento.getDate();
				txtRubro.getText();
				String sexo = ObtenerSexo();
				int fono = Integer.parseInt(txtFono.getText());
				int celu = Integer.parseInt(txtCelu.getText());
				String email = txtEmail.getText();
				String dirEmp = txtDirEmpleado.getText();

				Region reg = (Region) cbxRegUser.getSelectedItem();
				Provincia pro = (Provincia) cbxProvUser.getSelectedItem();
				Comuna comu = (Comuna) cbxComUser.getSelectedItem();
				int idReg = reg.getId_region();
				int idPro = pro.getId_provincia();
				int idCom = comu.getId_comuna();

				cbxRol.getSelectedItem();

				try {
					Empleado emp = new Empleado();
					emp.setRut(rutEmpleado);
					emp.setDv(dvEmpleado);
					emp.setNombres(nomEmpleado);
					emp.setAp_paterno(apPat);
					emp.setAp_materno(apMat);
					emp.setFch_nacimiento(fchNac);
					emp.setSexo(sexo);
					emp.setFono_fijo(fono);
					emp.setCelular(celu);
					emp.setCorreo(email);
					emp.setDireccion(dirEmp);
					emp.setId_region(idReg);
					emp.setId_provincia(idPro);
					emp.setId_comuna(idCom);

				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, "Error al agregar al empleado.");
				}

				/*
				 * try { ServicioComunicacionStub proxy = new ServicioComunicacionStub();
				 * 
				 * StringWriter stringIns = new StringWriter(); ObjectMapper objectMapper = new
				 * ObjectMapper(); objectMapper.writeValue(stringIns, cue);
				 * 
				 * String insJson = stringIns.toString();
				 * 
				 * InsertCuentaUsuario insertCuentaUsuario = new InsertCuentaUsuario();
				 * insertCuentaUsuario.setUsuarioJson(insJson);
				 * 
				 * int idCuentaIns; idCuentaIns =
				 * proxy.insertCuentaUsuario(insertCuentaUsuario).get_return(); if (idCuentaIns
				 * > 0) {
				 * 
				 * Empresa emp = new Empresa(); emp.setRut_empresa(rutEmpresa);
				 * emp.setDv_empresa(dvEmpresa); emp.setNombre_empresa(nombreEmpresa);
				 * emp.setRazon_social(razonSocial); emp.setDir_empresa(dirEmpresa);
				 * emp.setRubro(rubro); emp.setId_comuna(idComuna);
				 * emp.setId_cuenta_usuario(idCuentaIns);
				 * 
				 * StringWriter stringInsEmp = new StringWriter();
				 * objectMapper.writeValue(stringInsEmp, emp); String insJsonEmp =
				 * stringInsEmp.toString(); InsertEmpresa insertEmpresa = new InsertEmpresa();
				 * insertEmpresa.setEmpresaJson(insJsonEmp);
				 * 
				 * System.out.println("json insert empresa: " + insertEmpresa); int rutEmp =
				 * proxy.insertEmpresa(insertEmpresa).get_return();
				 * System.out.println("rut empresa ingresado: " + rutEmp);
				 * 
				 * if (rutEmp > 0) { JOptionPane.showMessageDialog(null,
				 * "Se registro exitosamente la empresa");
				 * 
				 * } else { JOptionPane.showMessageDialog(null, "Mori en el intento"); // Delete
				 * cuenta de usuario en caso de que no // registre la empresa }
				 * 
				 * }
				 * 
				 * } catch (RemoteException e1) { // TODO Auto-generated catch block
				 * e1.printStackTrace(); } catch (ServicioComunicacionIOExceptionException e1) {
				 * // TODO Auto-generated catch block e1.printStackTrace(); } catch
				 * (JsonGenerationException e) { // TODO Auto-generated catch block
				 * e.printStackTrace(); } catch (JsonMappingException e) { // TODO
				 * Auto-generated catch block e.printStackTrace(); } catch (IOException e) { //
				 * TODO Auto-generated catch block e.printStackTrace(); }
				 */

				// } else {
				// JOptionPane.showMessageDialog(null, "Contraseñas no coinciden.");
				// }
			}

			private String ObtenerSexo() {
				String sexo;
				if (rbtnMasculino.isSelected()) {
					sexo = "M";
				} else {
					sexo = "F";
				}
				return sexo;
			}
		});

	}
}
