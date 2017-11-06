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
import java.util.Date;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import service.ServicioComunicacionIOExceptionException;
import service.ServicioComunicacionStub;
import service.ServicioComunicacionStub.DeleteCuentaUsuario;
import service.ServicioComunicacionStub.InsertCuentaUsuario;
import service.ServicioComunicacionStub.InsertEmpleado;
import service.ServicioComunicacionStub.InsertEmpresa;
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
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JSeparator;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;

public class AdminRegistroCuenta extends JFrame {

	private JPanel contentPane;
	private JTextField txtRazonSocial;
	private JTextField txtDirEmpresa;
	private JTextField txtNombreCorto;
	private JTextField txtRubro;
	private JTextField txtRutEmpresa;
	private JTextField txtDVempresa;
	private JTextField txtUsername;
	private JPasswordField txtPassword;
	private JTextField txtNombreEmpleado;
	private JTextField txtApPaterno;
	private JTextField txtRutEmpleado;
	private JTextField txtDvEmpleado;
	private JTextField txtApMaterno;
	private JTextField txtFono;
	private JTextField txtEmail;
	private JTextField txtCelu;
	private JTextField txtDirEmpleado;
	private JPasswordField txtConfirmarPass;
	private ButtonGroup bg = new ButtonGroup();
	public static JLabel lblNombreUsuario;
	public static JComboBox cbxRol;
	public static JLabel lblRolARegistrar;
	public static JPanel pnlEmpresa;
	public static JPanel pnlEmpleado;
	public static Rol rol1;
	public static Rol rol2;
	public static Rol rol3;
	public static Rol rol4;
	public static JButton btnRegistrarUsuario;
	public static JLabel lblRegistro;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminRegistroCuenta frame = new AdminRegistroCuenta();
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
	public AdminRegistroCuenta() {
		setIconImage(utilidades.CambiarIcono.getIconImage());
		setTitle("Registro de cuentas");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 678, 615);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu mnAplicacin = new JMenu("Aplicaci\u00F3n");
		menuBar.add(mnAplicacin);

		JMenuItem mntmCerrarSesin = new JMenuItem("Cerrar sesi\u00F3n");
		mntmCerrarSesin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Login lgn = new Login();
				lgn.setVisible(true);
				dispose();
			}
		});
		mnAplicacin.add(mntmCerrarSesin);

		JMenuItem mntmNuevoInicioDe = new JMenuItem("Nuevo inicio de sesi\u00F3n");
		mntmNuevoInicioDe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Login lgn = new Login();
				lgn.setVisible(true);
			}
		});
		mnAplicacin.add(mntmNuevoInicioDe);

		JSeparator separator = new JSeparator();
		mnAplicacin.add(separator);

		JMenuItem mntmSalirDeLa = new JMenuItem("Salir de la aplicaci\u00F3n");
		mntmSalirDeLa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(JFrame.DISPOSE_ON_CLOSE);
			}
		});
		mnAplicacin.add(mntmSalirDeLa);

		JMenu mnAgregar = new JMenu("Agregar");
		menuBar.add(mnAgregar);

		JMenuItem mntmAdministrador = new JMenuItem("Administrador");
		mntmAdministrador.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AgregarAdmin();
			}
		});
		mnAgregar.add(mntmAdministrador);

		JMenuItem mntmEmpresa = new JMenuItem("Empresa");
		mntmEmpresa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AgregarEmpresa();
			}
		});

		JMenuItem mntmSupervisor = new JMenuItem("Supervisor");
		mntmSupervisor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AgregarSupervisor();
			}
		});
		mnAgregar.add(mntmSupervisor);

		JMenuItem mntmIngeniero = new JMenuItem("Ingeniero");
		mntmIngeniero.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AgregarIngeniero();
			}
		});
		mnAgregar.add(mntmIngeniero);
		mnAgregar.add(mntmEmpresa);

		JMenuItem mntmCapacitacin = new JMenuItem("Capacitaci\u00F3n");
		mntmCapacitacin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ListadoEmpresasCap empCap = new ListadoEmpresasCap();
				empCap.setVisible(true);
				empCap.lblNombreUsuario.setText(lblNombreUsuario.getText());
				dispose();
			}
		});
		mnAgregar.add(mntmCapacitacin);

		JMenu mnEditar = new JMenu("Editar");
		menuBar.add(mnEditar);

		JMenuItem mntmAdministradores = new JMenuItem("Administradores");
		mntmAdministradores.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AdminMantenedorCuentas adMant = new AdminMantenedorCuentas();
				adMant.setVisible(true);
				adMant.lblNombreUsuario.setText(lblNombreUsuario.getText());
				dispose();
				adMant.EditarAdmin();
			}
		});
		mnEditar.add(mntmAdministradores);

		JMenuItem mntmSupervisores = new JMenuItem("Supervisores");
		mntmSupervisores.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AdminMantenedorCuentas adMant = new AdminMantenedorCuentas();
				adMant.setVisible(true);
				adMant.lblNombreUsuario.setText(lblNombreUsuario.getText());
				dispose();
				adMant.EditarSupervisor();
			}
		});
		mnEditar.add(mntmSupervisores);

		JMenuItem mntmIngenieros = new JMenuItem("Ingenieros");
		mntmIngenieros.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AdminMantenedorCuentas adMant = new AdminMantenedorCuentas();
				adMant.setVisible(true);
				adMant.lblNombreUsuario.setText(lblNombreUsuario.getText());
				dispose();
				adMant.EditarIngeniero();
			}
		});
		mnEditar.add(mntmIngenieros);

		JMenuItem mntmEmpresas = new JMenuItem("Empresas");
		mntmEmpresas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AdminMantenedorCuentas adMant = new AdminMantenedorCuentas();
				adMant.setVisible(true);
				adMant.lblNombreUsuario.setText(lblNombreUsuario.getText());
				dispose();
				adMant.EditarEmpresa();
			}
		});
		mnEditar.add(mntmEmpresas);
		contentPane = new JPanel();
		contentPane.setName("");
		contentPane.setBackground(new Color(51, 153, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		lblRegistro = new JLabel("Registro de cuentas");
		lblRegistro.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblRegistro.setBounds(10, 51, 385, 14);
		contentPane.add(lblRegistro);

		pnlEmpresa = new JPanel();
		pnlEmpresa.setBounds(677, 88, 290, 360);
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

		utilidades.ObtenerDireccion.ObtenerRegiones(cbxRegEmpresa, 1);

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

		JButton btnRegistrarEmpresa = new JButton("Registrar Empresa");
		btnRegistrarEmpresa.setBounds(50, 299, 170, 23);
		pnlEmpresa.add(btnRegistrarEmpresa);
		btnRegistrarEmpresa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// if (txtPassword.getPassword() == txtConfirmarPass.getPassword()) {

				int rutEmpresa = Integer.parseInt(txtRutEmpresa.getText());
				String dvEmpresa = txtDVempresa.getText();
				String razonSocial = txtRazonSocial.getText();
				String nombreEmpresa = txtNombreCorto.getText();
				String dirEmpresa = txtDirEmpresa.getText();
				String rubro = txtRubro.getText();

				Region region = (Region) cbxRegEmpresa.getSelectedItem();
				Provincia prov = (Provincia) cbxProvEmpresa.getSelectedItem();
				Comuna comu = (Comuna) cbxComEmpresa.getSelectedItem();

				int idRegion = region.getId_region();
				int idProv = prov.getId_provincia();
				int idComuna = comu.getId_comuna();
				String user = txtUsername.getText();
				String pass = new String(txtPassword.getPassword());
				try {
					ServicioComunicacionStub proxy = new ServicioComunicacionStub();

					CuentaUsuario cue = new CuentaUsuario();

					cue.setUsername(user);
					cue.setPassword(pass);
					cue.setHabilitado(1);
					cue.setRol(9);

					StringWriter stringIns = new StringWriter();
					ObjectMapper objectMapper = new ObjectMapper();
					objectMapper.writeValue(stringIns, cue);

					String insJson = stringIns.toString();

					InsertCuentaUsuario insertCuentaUsuario = new InsertCuentaUsuario();
					insertCuentaUsuario.setUsuarioJson(insJson);

					int idCuentaIns;
					idCuentaIns = proxy.insertCuentaUsuario(insertCuentaUsuario).get_return();
					if (idCuentaIns > 0) {

						Empresa emp = new Empresa();
						emp.setRut_empresa(rutEmpresa);
						emp.setDv_empresa(dvEmpresa);
						emp.setNombre_empresa(nombreEmpresa);
						emp.setRazon_social(razonSocial);
						emp.setDir_empresa(dirEmpresa);
						emp.setRubro(rubro);
						emp.setId_region(idRegion);
						emp.setId_provincia(idProv);
						emp.setId_comuna(idComuna);
						emp.setId_cuenta_usuario(idCuentaIns);

						StringWriter stringInsEmp = new StringWriter();
						objectMapper.writeValue(stringInsEmp, emp);
						String insJsonEmp = stringInsEmp.toString();
						InsertEmpresa insertEmpresa = new InsertEmpresa();
						insertEmpresa.setEmpresaJson(insJsonEmp);

						int rutEmp = proxy.insertEmpresa(insertEmpresa).get_return();

						if (rutEmp > 0) {
							JOptionPane.showMessageDialog(null, "Se registro exitosamente la empresa");
						} else {
							JOptionPane.showMessageDialog(null, "Error al registrar la empresa");
							// Delete cuenta de usuario en caso de que no registre la empresa
							DeleteCuentaUsuario deleteCuenta = new DeleteCuentaUsuario();
							deleteCuenta.setIdCuentaUsuario(idCuentaIns);
						}

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

		cbxRegEmpresa.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				utilidades.ObtenerDireccion.ObtenerProvincias(cbxProvEmpresa, cbxRegEmpresa, 1);
			}
		});

		cbxProvEmpresa.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				utilidades.ObtenerDireccion.ObtenerComunas(cbxComEmpresa, cbxProvEmpresa, 1);
			}

		});

		JPanel pnlCredenciales = new JPanel();
		pnlCredenciales.setOpaque(false);
		pnlCredenciales.setBackground(Color.BLACK);
		pnlCredenciales.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"),
				"Definici\u00F3n de nombre de usuario y contrase\u00F1a", TitledBorder.LEADING, TitledBorder.TOP, null,
				Color.WHITE));
		pnlCredenciales.setName("");
		pnlCredenciales.setToolTipText("");
		pnlCredenciales.setBounds(10, 88, 310, 119);
		contentPane.add(pnlCredenciales);

		txtUsername = new JTextField();
		txtUsername.setColumns(10);

		txtPassword = new JPasswordField();

		JLabel lblNombreDeUsuario = new JLabel("Nombre de Usuario:");
		lblNombreDeUsuario.setForeground(new Color(255, 255, 255));

		JLabel lblContrasea = new JLabel("Contrase\u00F1a:");
		lblContrasea.setForeground(new Color(255, 255, 255));

		lblRolARegistrar = new JLabel("Rol a registrar:");

		cbxRol = new JComboBox();

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
		pnlEmpleado.setBounds(345, 88, 290, 421);
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
		utilidades.ObtenerDireccion.ObtenerRegiones(cbxRegUser, 1);

		cbxRegUser.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				utilidades.ObtenerDireccion.ObtenerProvincias(cbxProvUser, cbxRegUser, 1);
			}
		});

		cbxProvUser.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				utilidades.ObtenerDireccion.ObtenerComunas(cbxComUser, cbxProvUser, 1);
			}
		});

		JLabel lblConfirmeContrasea = new JLabel("Confirme contrase\u00F1a:");
		lblConfirmeContrasea.setForeground(new Color(255, 255, 255));

		txtConfirmarPass = new JPasswordField();

		GroupLayout gl_pnlCredenciales = new GroupLayout(pnlCredenciales);
		gl_pnlCredenciales.setHorizontalGroup(gl_pnlCredenciales.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlCredenciales.createSequentialGroup().addContainerGap().addGroup(gl_pnlCredenciales
						.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_pnlCredenciales.createSequentialGroup().addComponent(lblRolARegistrar).addGap(63)
								.addComponent(cbxRol, 0, 129, Short.MAX_VALUE))
						.addGroup(gl_pnlCredenciales.createSequentialGroup()
								.addGroup(gl_pnlCredenciales.createParallelGroup(Alignment.LEADING)
										.addComponent(lblConfirmeContrasea, GroupLayout.PREFERRED_SIZE, 131,
												GroupLayout.PREFERRED_SIZE)
										.addGroup(gl_pnlCredenciales.createParallelGroup(Alignment.TRAILING, false)
												.addComponent(lblContrasea, Alignment.LEADING, GroupLayout.DEFAULT_SIZE,
														GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
												.addComponent(lblNombreDeUsuario, Alignment.LEADING)))
								.addPreferredGap(ComponentPlacement.RELATED)
								.addGroup(gl_pnlCredenciales.createParallelGroup(Alignment.LEADING)
										.addComponent(txtConfirmarPass, GroupLayout.DEFAULT_SIZE, 129, Short.MAX_VALUE)
										.addComponent(txtPassword, 106, 129, Short.MAX_VALUE)
										.addComponent(txtUsername, GroupLayout.DEFAULT_SIZE, 129, Short.MAX_VALUE))))
						.addGap(24)));
		gl_pnlCredenciales.setVerticalGroup(gl_pnlCredenciales.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_pnlCredenciales.createSequentialGroup().addContainerGap()
						.addGroup(gl_pnlCredenciales.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNombreDeUsuario).addComponent(txtUsername, GroupLayout.PREFERRED_SIZE,
										GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(gl_pnlCredenciales.createParallelGroup(Alignment.BASELINE).addComponent(lblContrasea)
								.addComponent(txtPassword, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(gl_pnlCredenciales.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblConfirmeContrasea)
								.addComponent(txtConfirmarPass, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE))
						.addGap(50)
						.addGroup(gl_pnlCredenciales.createParallelGroup(Alignment.TRAILING).addComponent(cbxRol,
								GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblRolARegistrar))));
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

		btnRegistrarUsuario = new JButton("Registrar usuario");
		btnRegistrarUsuario.setBounds(53, 387, 184, 23);
		pnlEmpleado.add(btnRegistrarUsuario);

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
		lblNombreUsuario.setBounds(90, 11, 162, 14);
		contentPane.add(lblNombreUsuario);

		btnRegistrarUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// if (txtPassword.getPassword() == txtConfirmarPass.getPassword()) {

				int rutEmpleado = Integer.parseInt(txtRutEmpleado.getText());
				String dvEmpleado = txtDvEmpleado.getText();
				String nomEmpleado = txtNombreEmpleado.getText();
				String apPat = txtApPaterno.getText();
				String apMat = txtApMaterno.getText();
				Date fchNac = dcFchNacimiento.getDate();
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

				String user = txtUsername.getText();
				String pass = new String(txtPassword.getPassword());

				Rol rl = (Rol) cbxRol.getSelectedItem();

				try {
					ServicioComunicacionStub proxy = new ServicioComunicacionStub();

					CuentaUsuario cue = new CuentaUsuario();

					cue.setUsername(user);
					cue.setPassword(pass);
					cue.setHabilitado(1);
					cue.setRol(rl.getId_rol());

					StringWriter stringIns = new StringWriter();
					ObjectMapper objectMapper = new ObjectMapper();
					objectMapper.writeValue(stringIns, cue);

					String insJson = stringIns.toString();

					InsertCuentaUsuario insertCuentaUsuario = new InsertCuentaUsuario();
					insertCuentaUsuario.setUsuarioJson(insJson);

					int idCuentaIns;
					idCuentaIns = proxy.insertCuentaUsuario(insertCuentaUsuario).get_return();
					if (idCuentaIns > 0) {
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
						emp.setId_cuenta(idCuentaIns);

						StringWriter stringInsEmp = new StringWriter();
						objectMapper.writeValue(stringInsEmp, emp);
						String insJsonEmp = stringInsEmp.toString();
						InsertEmpleado insertEmpleado = new InsertEmpleado();
						insertEmpleado.setEmpleadoJson(insJsonEmp);

						int rutEmp = proxy.insertEmpleado(insertEmpleado).get_return();

						if (rutEmp > 0) {
							JOptionPane.showMessageDialog(null, "Se registró exitosamente el empleado");

						} else {
							JOptionPane.showMessageDialog(null, "Error al registrar al empleado");
							// Delete cuenta de usuario en caso de que no
							// registre la empresa
							DeleteCuentaUsuario deleteCuenta = new DeleteCuentaUsuario();
							deleteCuenta.setIdCuentaUsuario(idCuentaIns);
						}
					}

				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, "Error al agregar al empleado.");
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

	public static void AgregarAdmin() {
		cbxRol.setSelectedItem(rol1);
		cbxRol.setVisible(false);
		lblRolARegistrar.setVisible(false);
		pnlEmpleado.setVisible(true);
		btnRegistrarUsuario.setText("Registrar Administrador");
		lblRegistro.setText("Registro de administrador");
		pnlEmpresa.setVisible(false);
		pnlEmpresa.setBounds(677, 88, 290, 360);
	}

	public static void AgregarSupervisor() {
		cbxRol.setSelectedItem(rol2);
		cbxRol.setVisible(false);
		lblRolARegistrar.setVisible(false);
		pnlEmpleado.setVisible(true);
		btnRegistrarUsuario.setText("Registrar Supervisor");
		lblRegistro.setText("Registro de supervisor");
		pnlEmpresa.setVisible(false);
		pnlEmpresa.setBounds(677, 88, 290, 360);
	}

	public static void AgregarIngeniero() {
		cbxRol.setSelectedItem(rol3);
		cbxRol.setVisible(false);
		pnlEmpleado.setVisible(true);
		btnRegistrarUsuario.setText("Registrar Ingeniero");
		lblRegistro.setText("Registro de Ingeniero");
		pnlEmpresa.setVisible(false);
		pnlEmpresa.setBounds(677, 88, 290, 360);
		lblRolARegistrar.setVisible(false);
	}

	public static void AgregarEmpresa() {
		cbxRol.setSelectedItem(rol4);
		cbxRol.setVisible(false);
		lblRolARegistrar.setVisible(false);
		lblRegistro.setText("Registro de empresa");
		pnlEmpleado.setVisible(false);
		pnlEmpresa.setVisible(true);
		pnlEmpresa.setBounds(345, 88, 290, 360);
	}
}
