package gui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import service.ServicioComunicacionStub;
import service.ServicioComunicacionStub.ReadComunas;
import service.ServicioComunicacionStub.ReadProvincias;
import service.ServicioComunicacionStub.ReadRegiones;
import utilidades.Constantes;

import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import com.toedter.calendar.JDateChooser;

import entidades.ModuloGeneral.Comuna;
import entidades.ModuloGeneral.CuentaUsuario;
import entidades.ModuloGeneral.Empleado;
import entidades.ModuloGeneral.Provincia;
import entidades.ModuloGeneral.Region;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;

public class EmpresaRegistroCuenta extends JFrame {

	private JPanel contentPane;
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

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EmpresaRegistroCuenta frame = new EmpresaRegistroCuenta();
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
	public EmpresaRegistroCuenta() {
		setTitle("Registro de cuentas");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 678, 568);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(51, 153, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblCrearNuevaEmpresa = new JLabel("Registro de cuentas");
		lblCrearNuevaEmpresa.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblCrearNuevaEmpresa.setBounds(10, 34, 385, 14);
		contentPane.add(lblCrearNuevaEmpresa);

		JPanel pnlCredenciales = new JPanel();
		pnlCredenciales.setBounds(10, 88, 310, 180);
		contentPane.add(pnlCredenciales);

		txtUsername = new JTextField();
		txtUsername.setColumns(10);

		txtPassword = new JPasswordField();

		JLabel lblNombreDeUsuario = new JLabel("Nombre de Usuario:");

		JLabel lblContrasea = new JLabel("Contrase\u00F1a:");

		JLabel lblDefinicinDeNombre = new JLabel("Definici\u00F3n de nombre de usuario y contrase\u00F1a");
		lblDefinicinDeNombre.setFont(new Font("Tahoma", Font.BOLD, 11));

		JPanel pnlEmpleado = new JPanel();
		pnlEmpleado.setLayout(null);
		pnlEmpleado.setBounds(348, 75, 290, 421);
		contentPane.add(pnlEmpleado);

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

		JLabel lblConfirmeContrasea = new JLabel("Confirme contrase\u00F1a:");

		txtConfirmarPass = new JPasswordField();

		GroupLayout gl_pnlCredenciales = new GroupLayout(pnlCredenciales);
		gl_pnlCredenciales.setHorizontalGroup(gl_pnlCredenciales.createParallelGroup(Alignment.LEADING).addGroup(
				Alignment.TRAILING,
				gl_pnlCredenciales.createSequentialGroup().addContainerGap().addGroup(gl_pnlCredenciales
						.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblDefinicinDeNombre, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 276,
								Short.MAX_VALUE)
						.addGroup(gl_pnlCredenciales.createSequentialGroup().addGroup(gl_pnlCredenciales
								.createParallelGroup(Alignment.LEADING)
								.addComponent(lblConfirmeContrasea, GroupLayout.PREFERRED_SIZE, 131,
										GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_pnlCredenciales.createParallelGroup(Alignment.TRAILING, false)
										.addComponent(lblContrasea, Alignment.LEADING, GroupLayout.DEFAULT_SIZE,
												GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(lblNombreDeUsuario, Alignment.LEADING, GroupLayout.DEFAULT_SIZE,
												GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
								.addPreferredGap(ComponentPlacement.RELATED)
								.addGroup(gl_pnlCredenciales.createParallelGroup(Alignment.LEADING)
										.addComponent(txtConfirmarPass, GroupLayout.DEFAULT_SIZE, 141, Short.MAX_VALUE)
										.addComponent(txtPassword, 106, 141, Short.MAX_VALUE)
										.addComponent(txtUsername, GroupLayout.DEFAULT_SIZE, 141, Short.MAX_VALUE))))
						.addGap(24)));
		gl_pnlCredenciales.setVerticalGroup(gl_pnlCredenciales.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_pnlCredenciales.createSequentialGroup().addContainerGap()
						.addComponent(lblDefinicinDeNombre).addGap(18)
						.addGroup(gl_pnlCredenciales.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNombreDeUsuario).addComponent(txtUsername, GroupLayout.PREFERRED_SIZE,
										GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(gl_pnlCredenciales.createParallelGroup(Alignment.BASELINE).addComponent(lblContrasea)
								.addComponent(txtPassword, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(gl_pnlCredenciales.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblConfirmeContrasea).addComponent(txtConfirmarPass,
										GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE))
						.addGap(18).addGroup(gl_pnlCredenciales.createParallelGroup(Alignment.TRAILING)).addGap(71)));
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

		JButton btnRegistrarUsuario = new JButton("Registrar usuario");
		btnRegistrarUsuario.setBounds(23, 387, 151, 23);
		pnlEmpleado.add(btnRegistrarUsuario);

		JRadioButton rbtnFemenino = new JRadioButton("Femenino");
		rbtnFemenino.setBounds(183, 167, 82, 23);
		pnlEmpleado.add(rbtnFemenino);

		JRadioButton rbtnMasculino = new JRadioButton("Masculino");
		rbtnMasculino.setBounds(92, 167, 89, 23);
		pnlEmpleado.add(rbtnMasculino);

		bg.add(rbtnMasculino);
		bg.add(rbtnFemenino);

		JButton btnCerrar = new JButton("Cerrar");
		btnCerrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnCerrar.setBounds(191, 387, 89, 23);
		pnlEmpleado.add(btnCerrar);

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
					// emp.setRut_empresa();
					emp.setId_region(idReg);
					emp.setId_provincia(idPro);
					emp.setId_comuna(idCom);

					CuentaUsuario cue = new CuentaUsuario();

					cue.setUsername(user);
					cue.setPassword(pass);
					cue.setHabilitado(1);
					cue.setRol(Constantes.ROL_TRABAJADOR);

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
