package gui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.StringWriter;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import entidades.ModuloGeneral.CuentaUsuario;
import service.ServicioComunicacionStub;
import service.ServicioComunicacionStub.ValidarUsuario;
import utilidades.Constantes;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JSeparator;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField txtUsername;
	private JPasswordField txtPassword;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
				} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
						| UnsupportedLookAndFeelException e) {
					e.printStackTrace();
				}
				try {
					Login frame = new Login();
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
	public Login() {
		setIconImage(utilidades.CambiarIcono.getIconImage());
		setTitle("Iniciar Sesi\u00F3n");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 395, 300);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu mnAplicacin = new JMenu("Aplicaci\u00F3n");
		menuBar.add(mnAplicacin);

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
		contentPane = new JPanel();
		contentPane.setBackground(new Color(51, 153, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(23, 54, 328, 154);
		contentPane.add(panel);

		JLabel lblNombreDeUsuario = new JLabel("Nombre de usuario:");
		lblNombreDeUsuario.setFont(new Font("Tahoma", Font.PLAIN, 13));

		txtUsername = new JTextField();
		txtUsername.setColumns(10);

		JLabel lblContrasea = new JLabel("Contrase\u00F1a:");
		lblContrasea.setFont(new Font("Tahoma", Font.PLAIN, 13));

		txtPassword = new JPasswordField();

		JButton btnIngresar = new JButton("Ingresar");
		btnIngresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String username = txtUsername.getText();
				String password = new String(txtPassword.getPassword());

				try {

					ServicioComunicacionStub proxy = new ServicioComunicacionStub();

					ValidarUsuario vu = new ValidarUsuario();

					CuentaUsuario user = new CuentaUsuario();
					user.setUsername(username);
					user.setPassword(password);
					// user.setRol(rol);

					// String userJson = user.toJson();
					ObjectMapper objectMapper = new ObjectMapper();
					objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
					objectMapper.configure(SerializationFeature.INDENT_OUTPUT, true);

					StringWriter stringCta = new StringWriter();
					objectMapper.writeValue(stringCta, user);

					String userJson = stringCta.toString();

					vu.setUsuarioJson(userJson);
					String userRespuesta = proxy.validarUsuario(vu).get_return();

					if (userRespuesta != null) {
						user = objectMapper.readValue(userRespuesta, CuentaUsuario.class);

						if (user.getHabilitado() == Constantes.HABILITADO) {
							switch (user.getRol()) {
							case 1:
								// Administrador
								AdminRegistroCuenta reg = new AdminRegistroCuenta();
								reg.setVisible(true);
								reg.lblNombreUsuario.setText(txtUsername.getText());
								reg.AgregarEmpresa();
								dispose();
								break;
							case 3:
								// Supervisor
								MenuSupervisor sup = new MenuSupervisor();
								sup.setVisible(true);
								dispose();
								break;
							case 4:
								// Ingeniero
								// MenuPrevRiesgo ing = new MenuPrevRiesgo();
								// ing.setVisible(true);
								// dispose();
								break;
							case 9:
								// Empresa
								EmpresaMenu emp = new EmpresaMenu();
								emp.setVisible(true);

								dispose();
								break;
							default:
								JOptionPane.showMessageDialog(null, "Perfil inadecuado para esta aplicación.");
								break;
							}
						} else {
							JOptionPane.showMessageDialog(null, "Usuario inhabilitado.");
						}
					} else {
						JOptionPane.showMessageDialog(null, "Credenciales no válidas");
					}

					lblNombreDeUsuario.setText("Exito");

				} catch (Exception e) {

					e.printStackTrace();
				}
			}
		});

		JLabel lblIngresoDeCredenciales = new JLabel("Ingreso de Credenciales");
		lblIngresoDeCredenciales.setFont(new Font("Tahoma", Font.BOLD, 11));

		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(gl_panel.createParallelGroup(Alignment.TRAILING).addGroup(gl_panel
				.createSequentialGroup().addContainerGap()
				.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_panel.createSequentialGroup()
								.addGroup(gl_panel.createParallelGroup(Alignment.LEADING).addComponent(lblContrasea)
										.addComponent(lblNombreDeUsuario, GroupLayout.PREFERRED_SIZE, 144,
												GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
										.addComponent(txtPassword, GroupLayout.DEFAULT_SIZE, 126, Short.MAX_VALUE)
										.addComponent(txtUsername, GroupLayout.DEFAULT_SIZE, 126, Short.MAX_VALUE)
										.addComponent(btnIngresar))
								.addGap(25))
						.addGroup(gl_panel.createSequentialGroup().addComponent(lblIngresoDeCredenciales,
								GroupLayout.PREFERRED_SIZE, 152, GroupLayout.PREFERRED_SIZE).addGap(86)))));
		gl_panel.setVerticalGroup(gl_panel.createParallelGroup(Alignment.LEADING).addGroup(gl_panel
				.createSequentialGroup().addContainerGap()
				.addComponent(lblIngresoDeCredenciales, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
				.addGap(18)
				.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtUsername, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNombreDeUsuario, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE))
				.addPreferredGap(ComponentPlacement.RELATED)
				.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblContrasea, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtPassword, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE))
				.addGap(18).addComponent(btnIngresar).addContainerGap(58, Short.MAX_VALUE)));
		panel.setLayout(gl_panel);
	}
}
