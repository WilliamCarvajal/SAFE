package gui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.HeadlessException;
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
import service.ServicioComunicacionStub.DeleteCuentaUsuario;
import service.ServicioComunicacionStub.DeleteEmpresa;
import service.ServicioComunicacionStub.ReadCuentaUsuarioByRol;
import service.ServicioComunicacionStub.ReadEmpresaByIdCuentaUsuario;
import service.ServicioComunicacionStub.UpdateEmpresa;
import utilidades.Constantes;

import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import com.toedter.calendar.JDateChooser;

import entidades.ModuloGeneral.Comuna;
import entidades.ModuloGeneral.CuentaUsuario;
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
import javax.swing.JScrollPane;

public class AdminMantenedorCuentas extends JFrame {

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
	public static JLabel lblNombreUsuario;
	private ButtonGroup bg = new ButtonGroup();
	public static JPanel pnlEmpresa;
	public static JPanel pnlEmpleado;
	public static JLabel lblRolARegistrar;
	public static JComboBox<Rol> cbxRol;
	public static Rol rol1;
	public static Rol rol2;
	public static Rol rol3;
	public static Rol rol4;
	public static JLabel lblMantenedor;
	public JScrollPane scrollPane = new JScrollPane();
	public int idCuenta;

	public static DefaultTableModel modelo = new DefaultTableModel() {
		public boolean isCellEditable(int fila, int columna) {
			return false;
		}
	};

	public static JTable tblCuentas;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminMantenedorCuentas frame = new AdminMantenedorCuentas();
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
	public AdminMantenedorCuentas() {
		setIconImage(utilidades.CambiarIcono.getIconImage());
		setTitle("Mantenedor de cuentas");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 687, 694);

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

		JMenuItem mntmAdministrador = new JMenuItem("Administrador");
		mntmAdministrador.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AdminRegistroCuenta adReg = new AdminRegistroCuenta();
				adReg.setVisible(true);
				AdminRegistroCuenta.lblNombreUsuario.setText(lblNombreUsuario.getText());
				dispose();
				AdminRegistroCuenta.AgregarAdmin();
			}
		});
		mnAgregar.add(mntmAdministrador);

		JMenuItem mntmSupervisor = new JMenuItem("Supervisor");
		mntmSupervisor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AdminRegistroCuenta adReg = new AdminRegistroCuenta();
				adReg.setVisible(true);
				AdminRegistroCuenta.lblNombreUsuario.setText(lblNombreUsuario.getText());
				dispose();
				AdminRegistroCuenta.AgregarSupervisor();
			}
		});
		mnAgregar.add(mntmSupervisor);

		JMenuItem mntmIngeniero = new JMenuItem("Ingeniero");
		mntmIngeniero.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AdminRegistroCuenta adReg = new AdminRegistroCuenta();
				adReg.setVisible(true);
				AdminRegistroCuenta.lblNombreUsuario.setText(lblNombreUsuario.getText());
				dispose();
				AdminRegistroCuenta.AgregarIngeniero();
			}
		});
		mnAgregar.add(mntmIngeniero);

		JMenuItem mntmEmpresa = new JMenuItem("Empresa");
		mntmEmpresa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AdminRegistroCuenta adReg = new AdminRegistroCuenta();
				adReg.setVisible(true);
				AdminRegistroCuenta.lblNombreUsuario.setText(lblNombreUsuario.getText());
				dispose();
				AdminRegistroCuenta.AgregarEmpresa();
			}
		});
		mnAgregar.add(mntmEmpresa);

		JMenuItem mntmCapacitacin = new JMenuItem("Capacitaci\u00F3n");
		mntmCapacitacin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListadoEmpresasCap empCap = new ListadoEmpresasCap();
				empCap.setVisible(true);
				ListadoEmpresasCap.lblNombreUsuario.setText(lblNombreUsuario.getText());
				dispose();
			}
		});
		mnAgregar.add(mntmCapacitacin);

		JMenu mnEditar = new JMenu("Editar");
		menuBar.add(mnEditar);

		JMenuItem mntmAdministradores = new JMenuItem("Administradores");
		mntmAdministradores.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EditarAdmin();
			}
		});
		mnEditar.add(mntmAdministradores);

		JMenuItem mntmSupervisores = new JMenuItem("Supervisores");
		mntmSupervisores.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EditarSupervisor();
			}
		});
		mnEditar.add(mntmSupervisores);

		JMenuItem mntmIngenieros = new JMenuItem("Ingenieros");
		mntmIngenieros.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EditarIngeniero();
			}
		});
		mnEditar.add(mntmIngenieros);

		JMenuItem mntmEmpresas = new JMenuItem("Empresas");
		mntmEmpresas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EditarEmpresa();
			}
		});
		mnEditar.add(mntmEmpresas);

		contentPane = new JPanel();
		contentPane.setBackground(new Color(51, 153, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		lblMantenedor = new JLabel("Mantenedor de cuentas");
		lblMantenedor.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblMantenedor.setBounds(21, 50, 385, 14);
		contentPane.add(lblMantenedor);

		pnlEmpresa = new JPanel();
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

		utilidades.ObtenerDireccion.ObtenerRegiones(cbxRegEmpresa, 0);

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

				Region reg = (Region) cbxRegEmpresa.getSelectedItem();
				int idRegion = reg.getId_region();

				Provincia pro = (Provincia) cbxProvEmpresa.getSelectedItem();
				int idProvincia = pro.getId_provincia();

				Comuna comu = (Comuna) cbxComEmpresa.getSelectedItem();
				int idComuna = comu.getId_comuna();

				try {
					ServicioComunicacionStub proxy = new ServicioComunicacionStub();
					ObjectMapper objectMapper = new ObjectMapper();

					Empresa emp = new Empresa();
					emp.setRut_empresa(rutEmpresa);
					emp.setDv_empresa(dvEmpresa);
					emp.setNombre_empresa(nombreEmpresa);
					emp.setRazon_social(razonSocial);
					emp.setDir_empresa(dirEmpresa);
					emp.setRubro(rubro);
					emp.setId_region(idRegion);
					emp.setId_provincia(idProvincia);
					emp.setId_comuna(idComuna);
					emp.setId_cuenta_usuario(idCuenta);

					StringWriter stringUpdEmpresa = new StringWriter();
					objectMapper.writeValue(stringUpdEmpresa, emp);
					String updEmpJson = stringUpdEmpresa.toString();
					UpdateEmpresa updEmpresa = new UpdateEmpresa();
					updEmpresa.setEmpresaJson(updEmpJson);

					int actualizado = proxy.updateEmpresa(updEmpresa).get_return();
					System.out.println("actualizado: " + actualizado);

					if (actualizado > 0) {
						JOptionPane.showMessageDialog(null, "Se actualizó exitosamente la empresa");
					} else {
						JOptionPane.showMessageDialog(null, "No se actualizó correctamente la empresa");
					}
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
				utilidades.ObtenerDireccion.ObtenerComunas(cbxComEmpresa, cbxProvEmpresa, 0);
			}
		});

		cbxRegEmpresa.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				utilidades.ObtenerDireccion.ObtenerProvincias(cbxProvEmpresa, cbxRegEmpresa, 0);
			}
		});

		JPanel pnlCredenciales = new JPanel();
		pnlCredenciales.setBounds(21, 88, 299, 522);
		contentPane.add(pnlCredenciales);

		JLabel lblListado = new JLabel("Listado de cuentas");
		lblListado.setFont(new Font("Tahoma", Font.BOLD, 11));

		lblRolARegistrar = new JLabel("Rol a editar:");

		cbxRol = new JComboBox<Rol>();

		rol1 = new Rol();
		rol1.setId_rol(1);
		rol1.setNombre_rol("Administrador");
		cbxRol.addItem(rol1);

		rol2 = new Rol();
		rol2.setId_rol(3);
		rol2.setNombre_rol("Supervisor");
		rol2.setDescripcion("Recopila y emite informes de evaluación.");
		cbxRol.addItem(rol2);

		rol3 = new Rol();
		rol3.setId_rol(4);
		rol3.setNombre_rol("Ingeniero");
		rol3.setDescripcion("Autoriza informes emitidos.");
		cbxRol.addItem(rol3);

		rol4 = new Rol();
		rol4.setId_rol(9);
		rol4.setNombre_rol("Empresa");
		rol4.setDescripcion("Empresa registrada.");
		cbxRol.addItem(rol4);

		pnlEmpleado = new JPanel();
		pnlEmpleado.setLayout(null);
		pnlEmpleado.setBounds(357, 88, 290, 432);
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
		utilidades.ObtenerDireccion.ObtenerRegiones(cbxRegUser, 0);

		cbxRegUser.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				utilidades.ObtenerDireccion.ObtenerProvincias(cbxProvUser, cbxRegUser, 0);
			}
		});

		cbxProvUser.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				utilidades.ObtenerDireccion.ObtenerComunas(cbxComUser, cbxProvUser, 0);
			}
		});

		JButton btnEliminarCuenta = new JButton("Eliminar cuenta");
		btnEliminarCuenta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					int row = tblCuentas.getSelectedRow();
					int idUsu = (Integer) tblCuentas.getValueAt(row, 0);
					ServicioComunicacionStub proxy = new ServicioComunicacionStub();

					if (cbxRol.getSelectedItem() == rol4) {
						int opcEmpresa = JOptionPane.showConfirmDialog(null, "Se eliminará la empresa \n ¿Está seguro?",
								"Confirmar", JOptionPane.YES_NO_OPTION);
						// 0 = Si, 1 = No

						if (opcEmpresa == 0) {

							Empresa empr = new Empresa();
							ReadEmpresaByIdCuentaUsuario readEmpresa = new ReadEmpresaByIdCuentaUsuario();
							readEmpresa.setIdCuentaUsuario(idUsu);
							String IdUsuJson = proxy.readEmpresaByIdCuentaUsuario(readEmpresa).get_return();
							empr = new ObjectMapper().readValue(IdUsuJson, Empresa.class);

							DeleteEmpresa delEmpresa = new DeleteEmpresa();
							delEmpresa.setRutEmpresa(empr.getRut_empresa());

							int eliminado = proxy.deleteEmpresa(delEmpresa).get_return();
							System.out.println(eliminado);

							if (eliminado > 0) {
								JOptionPane.showMessageDialog(null, "Se eliminó de forma correcta la empresa");

								DeleteCuentaUsuario deleteCuenta = new DeleteCuentaUsuario();
								deleteCuenta.setIdCuentaUsuario(idUsu);
								proxy.deleteCuentaUsuario(deleteCuenta);

								LlenarTabla(rol4.getId_rol());
							} else {
								JOptionPane.showMessageDialog(null, "No se eliminó la empresa");
							}
						}
					} else {
						/*
						 * int opcEmpleado = JOptionPane.showConfirmDialog(null,
						 * "Se eliminará el usuario \n ¿Está seguro?", "Confirmar",
						 * JOptionPane.YES_NO_OPTION); // 0 = Si, 1 = No
						 * 
						 * if (opcEmpleado == 0) { Empleado empl = new Empleado();
						 * ReadEmpresaByIdCuentaUsuario readEmpresa = new
						 * ReadEmpresaByIdCuentaUsuario(); readEmpresa.setIdCuentaUsuario(idUsu); String
						 * IdUsuJson = proxy.readEmpresaByIdCuentaUsuario(readEmpresa).get_return();
						 * empr = new ObjectMapper().readValue(IdUsuJson, Empresa.class);
						 * 
						 * DeleteEmpresa delEmpresa = new DeleteEmpresa();
						 * delEmpresa.setRutEmpresa(empr.getRut_empresa());
						 * 
						 * int eliminado = proxy.deleteEmpresa(delEmpresa).get_return();
						 * System.out.println(eliminado);
						 * 
						 * if (eliminado > 0) { JOptionPane.showMessageDialog(null,
						 * "Se eliminó de forma correcta el empleado");
						 * 
						 * DeleteCuentaUsuario deleteCuenta = new DeleteCuentaUsuario();
						 * deleteCuenta.setIdCuentaUsuario(idUsu);
						 * 
						 * LlenarTabla(rol4.getId_rol()); } else { JOptionPane.showMessageDialog(null,
						 * "No se eliminó el empleado"); } }
						 */
					}
					DeleteCuentaUsuario deleteCuenta = new DeleteCuentaUsuario();
					deleteCuenta.setIdCuentaUsuario(idUsu);
					LlenarTabla(rol4.getId_rol());
				} catch (HeadlessException | ServicioComunicacionIOExceptionException | IOException e1) {
					e1.printStackTrace();
				}
			}
		});

		JButton btnDeshabilitar = new JButton("Deshabilitar cuenta");

		JButton btnEditar = new JButton("Editar");
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					int row = tblCuentas.getSelectedRow();
					int idUsu = (Integer) tblCuentas.getValueAt(row, 0);

					ServicioComunicacionStub proxy = new ServicioComunicacionStub();
					if (cbxRol.getSelectedItem() == rol4) {

						Empresa empr = new Empresa();
						ReadEmpresaByIdCuentaUsuario readEmpresa = new ReadEmpresaByIdCuentaUsuario();
						readEmpresa.setIdCuentaUsuario(idUsu);
						String IdUsuJson = proxy.readEmpresaByIdCuentaUsuario(readEmpresa).get_return();
						empr = new ObjectMapper().readValue(IdUsuJson, Empresa.class);

						txtRutEmpresa.setText(Integer.toString(empr.getRut_empresa()));
						txtDVempresa.setText(empr.getDv_empresa());
						txtRazonSocial.setText(empr.getRazon_social());
						txtNombreCorto.setText(empr.getNombre_empresa());
						txtRubro.setText(empr.getRubro());
						txtDirEmpresa.setText(empr.getDir_empresa());

						idCuenta = idUsu;

						utilidades.ObtenerDireccion.ObtenerRegiones(cbxRegEmpresa, empr.getId_region());
						utilidades.ObtenerDireccion.ObtenerProvincias(cbxProvEmpresa, cbxRegEmpresa,
								empr.getId_provincia());
						utilidades.ObtenerDireccion.ObtenerComunas(cbxComEmpresa, cbxProvEmpresa, empr.getId_comuna());

					} else {

						/*
						 * Empleado empl = new Empleado(); ReadEmpresaByIdCuentaUsuario readEmpresa =
						 * new ReadEmpresaByIdCuentaUsuario(); readEmpresa.setIdCuentaUsuario(idUsu);
						 * String IdUsuJson =
						 * proxy.readEmpresaByIdCuentaUsuario(readEmpresa).get_return(); empr = new
						 * ObjectMapper().readValue(IdUsuJson, Empresa.class);
						 * 
						 * txtRutEmpresa.setText(Integer.toString(empr.getRut_empresa()));
						 * txtDVempresa.setText(empr.getDv_empresa());
						 * txtRazonSocial.setText(empr.getRazon_social());
						 * txtNombreCorto.setText(empr.getNombre_empresa());
						 * txtRubro.setText(empr.getRubro());
						 * txtDirEmpresa.setText(empr.getDir_empresa());
						 * 
						 * idCuenta = idUsu;
						 * 
						 * utilidades.ObtenerDireccion.ObtenerRegiones(cbxRegEmpresa,
						 * empr.getId_region());
						 * utilidades.ObtenerDireccion.ObtenerProvincias(cbxProvEmpresa, cbxRegEmpresa,
						 * empr.getId_provincia());
						 * utilidades.ObtenerDireccion.ObtenerComunas(cbxComEmpresa, cbxProvEmpresa,
						 * empr.getId_comuna());
						 */

					}
				} catch (ServicioComunicacionIOExceptionException | IOException e) {
					e.printStackTrace();
				}
			}
		});

		GroupLayout gl_pnlCredenciales = new GroupLayout(pnlCredenciales);
		gl_pnlCredenciales.setHorizontalGroup(gl_pnlCredenciales.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlCredenciales.createSequentialGroup().addGap(48)
						.addComponent(lblListado, GroupLayout.PREFERRED_SIZE, 139, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(112, Short.MAX_VALUE))
				.addGroup(gl_pnlCredenciales.createSequentialGroup().addGap(20)
						.addGroup(gl_pnlCredenciales.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_pnlCredenciales.createSequentialGroup()
										.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 252,
												GroupLayout.PREFERRED_SIZE)
										.addContainerGap())
								.addGroup(gl_pnlCredenciales.createSequentialGroup()
										.addComponent(lblRolARegistrar, GroupLayout.PREFERRED_SIZE, 79,
												GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(cbxRol, 0, 173, Short.MAX_VALUE).addGap(23))))
				.addGroup(gl_pnlCredenciales.createSequentialGroup().addGap(81)
						.addGroup(gl_pnlCredenciales.createParallelGroup(Alignment.TRAILING, false)
								.addComponent(btnEditar, Alignment.LEADING, GroupLayout.DEFAULT_SIZE,
										GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(btnEliminarCuenta, Alignment.LEADING, GroupLayout.DEFAULT_SIZE,
										GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(btnDeshabilitar, Alignment.LEADING, GroupLayout.DEFAULT_SIZE,
										GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
						.addContainerGap(93, Short.MAX_VALUE)));
		gl_pnlCredenciales.setVerticalGroup(gl_pnlCredenciales.createParallelGroup(Alignment.TRAILING).addGroup(
				gl_pnlCredenciales.createSequentialGroup().addContainerGap().addComponent(lblListado).addGap(24)
						.addGroup(gl_pnlCredenciales.createParallelGroup(Alignment.TRAILING)
								.addComponent(cbxRol, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(lblRolARegistrar))
						.addGap(18)
						.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 290, GroupLayout.PREFERRED_SIZE)
						.addGap(30).addComponent(btnEditar).addPreferredGap(ComponentPlacement.UNRELATED)
						.addComponent(btnDeshabilitar).addGap(13).addComponent(btnEliminarCuenta).addGap(22)));

		tblCuentas = new JTable();
		scrollPane.setViewportView(tblCuentas);
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

		JLabel label_4 = new JLabel("Bienvenido");
		label_4.setBounds(28, 11, 62, 14);
		contentPane.add(label_4);

		lblNombreUsuario = new JLabel("NombreUsuario");
		lblNombreUsuario.setBounds(100, 11, 162, 14);
		contentPane.add(lblNombreUsuario);

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
					new ServicioComunicacionStub();
					new ObjectMapper();

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
					emp.setRut_empresa(Constantes.RUT_SAFE);
					emp.setId_region(idReg);
					emp.setId_provincia(idPro);
					emp.setId_comuna(idCom);

				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, "Error al actualizar empresa");
				}
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

	public static void LlenarTabla(int idRol) {
		try {

			if (cbxRol.getSelectedIndex() >= 0) {

				modelo.setRowCount(0);
				modelo.setColumnCount(0);
				ServicioComunicacionStub proxy = new ServicioComunicacionStub();
				ArrayList<CuentaUsuario> listaCuentas = new ArrayList<>();
				ReadCuentaUsuarioByRol readCuentaRol = new ReadCuentaUsuarioByRol();
				readCuentaRol.setIdRol(idRol);
				String cuentasJson = proxy.readCuentaUsuarioByRol(readCuentaRol).get_return();
				listaCuentas = new ObjectMapper().readValue(cuentasJson, new TypeReference<List<CuentaUsuario>>() {
				});

				ArrayList<Object> columnas = new ArrayList<>();
				columnas.add("ID cuenta");
				columnas.add("Username");
				columnas.add("Habilitado");
				columnas.add("ID Rol");

				for (Object col : columnas) {
					modelo.addColumn(col);
				}

				tblCuentas.setModel(modelo);

				Object[] fila = new Object[modelo.getColumnCount()];
				for (int i = 0; i < listaCuentas.size(); i++) {
					fila[0] = listaCuentas.get(i).getId();
					fila[1] = listaCuentas.get(i).getUsername();
					fila[2] = listaCuentas.get(i).getHabilitado();
					fila[3] = listaCuentas.get(i).getRol();
					modelo.addRow(fila);
				}

				tblCuentas.setModel(modelo);

				for (int i = 0; i < tblCuentas.getColumnCount(); i++) {
					utilidades.Ajustar.AnchoColumnas(tblCuentas, i);
				}
			}
		} catch (Exception ex) {
			// mandar mensaje
			JOptionPane.showMessageDialog(null, "No se pudo cargar lista de cuentas.");
		}
	}

	public static void EditarAdmin() {
		cbxRol.setSelectedItem(rol1);
		cbxRol.setVisible(false);
		LlenarTabla(rol1.getId_rol());
		cbxRol.setVisible(false);
		lblRolARegistrar.setVisible(false);
		lblMantenedor.setText("Mantenedor de administradores");
		pnlEmpleado.setVisible(true);
		pnlEmpresa.setVisible(false);
		pnlEmpresa.setBounds(677, 88, 290, 360);
	}

	public static void EditarSupervisor() {
		cbxRol.setSelectedItem(rol2);
		cbxRol.setVisible(false);
		LlenarTabla(rol2.getId_rol());
		cbxRol.setVisible(false);
		lblRolARegistrar.setVisible(false);
		lblMantenedor.setText("Mantenedor de supervisores");
		pnlEmpleado.setVisible(true);
		pnlEmpresa.setVisible(false);
		pnlEmpresa.setBounds(677, 88, 290, 360);
	}

	public static void EditarIngeniero() {
		cbxRol.setSelectedItem(rol3);
		cbxRol.setVisible(false);
		LlenarTabla(rol3.getId_rol());
		cbxRol.setVisible(false);
		pnlEmpleado.setVisible(true);
		pnlEmpresa.setVisible(false);
		pnlEmpresa.setBounds(677, 88, 290, 360);
		lblRolARegistrar.setVisible(false);
		lblMantenedor.setText("Mantenedor de ingenieros");
	}

	public static void EditarEmpresa() {
		cbxRol.setSelectedItem(rol4);
		cbxRol.setVisible(false);
		LlenarTabla(rol4.getId_rol());
		cbxRol.setVisible(false);
		lblRolARegistrar.setVisible(false);
		lblMantenedor.setText("Mantenedor de empresas");
		pnlEmpleado.setVisible(false);
		pnlEmpresa.setVisible(true);
		pnlEmpresa.setBounds(345, 88, 290, 360);
	}
}
