package gui;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import entidades.ModuloGeneral.Empresa;
import service.ServicioComunicacionStub;
import service.ServicioComunicacionStub.ReadEmpresasAll;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JSeparator;
import javax.swing.JScrollPane;

public class ListadoEmpresasCap extends JFrame {

	private JPanel contentPane;
	public static JLabel lblNombreUsuario;
	public static JTable tblEmpresas;
	public JLabel lblRutEmp;
	public JScrollPane scrollPane = new JScrollPane();

	public static DefaultTableModel modelo = new DefaultTableModel() {
		public boolean isCellEditable(int fila, int columna) {
			return false;
		}
	};

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ListadoEmpresasCap frame = new ListadoEmpresasCap();
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
	public ListadoEmpresasCap() {
		setIconImage(utilidades.CambiarIcono.getIconImage());
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 886, 489);

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
				System.exit(DISPOSE_ON_CLOSE);
			}
		});
		mnAplicacin.add(mntmSalirDeLa);

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

		JMenu mnEditar = new JMenu("Editar");
		menuBar.add(mnEditar);

		JMenuItem mntmAdministradores = new JMenuItem("Administradores");
		mntmAdministradores.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AdminMantenedorCuentas adMant = new AdminMantenedorCuentas();
				adMant.setVisible(true);
				AdminMantenedorCuentas.lblNombreUsuario.setText(lblNombreUsuario.getText());
				dispose();
				AdminMantenedorCuentas.EditarAdmin();
			}
		});
		mnEditar.add(mntmAdministradores);

		JMenuItem mntmSupervisores = new JMenuItem("Supervisores");
		mntmSupervisores.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AdminMantenedorCuentas adMant = new AdminMantenedorCuentas();
				adMant.setVisible(true);
				AdminMantenedorCuentas.lblNombreUsuario.setText(lblNombreUsuario.getText());
				AdminMantenedorCuentas.EditarSupervisor();
				dispose();
			}
		});
		mnEditar.add(mntmSupervisores);

		JMenuItem mntmIngenieros = new JMenuItem("Ingenieros");
		mntmIngenieros.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AdminMantenedorCuentas adMant = new AdminMantenedorCuentas();
				adMant.setVisible(true);
				AdminMantenedorCuentas.lblNombreUsuario.setText(lblNombreUsuario.getText());
				AdminMantenedorCuentas.EditarIngeniero();
				dispose();
			}
		});
		mnEditar.add(mntmIngenieros);

		JMenuItem mntmEmpresas = new JMenuItem("Empresas");
		mntmEmpresas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AdminMantenedorCuentas adMant = new AdminMantenedorCuentas();
				adMant.setVisible(true);
				AdminMantenedorCuentas.lblNombreUsuario.setText(lblNombreUsuario.getText());
				AdminMantenedorCuentas.EditarEmpresa();
				dispose();
			}
		});
		mnEditar.add(mntmEmpresas);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(51, 153, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JPanel panel = new JPanel();

		JLabel label = new JLabel("Bienvenido");

		lblNombreUsuario = new JLabel("NombreUsuario");

		lblRutEmp = new JLabel("New label");
		lblRutEmp.setForeground(new Color(51, 153, 255));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup().addGap(19)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
										.addComponent(panel, GroupLayout.PREFERRED_SIZE, 825,
												GroupLayout.PREFERRED_SIZE)
										.addContainerGap())
								.addGroup(gl_contentPane.createSequentialGroup()
										.addComponent(label, GroupLayout.PREFERRED_SIZE, 62, GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(lblNombreUsuario, GroupLayout.PREFERRED_SIZE, 162,
												GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.RELATED, 447, Short.MAX_VALUE)
										.addComponent(lblRutEmp).addGap(215)))));
		gl_contentPane.setVerticalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addGroup(gl_contentPane
				.createSequentialGroup()
				.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup().addContainerGap().addComponent(lblRutEmp))
						.addGroup(gl_contentPane.createSequentialGroup().addGap(20)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE).addComponent(label)
										.addComponent(lblNombreUsuario))))
				.addGap(18).addComponent(panel, GroupLayout.PREFERRED_SIZE, 334, GroupLayout.PREFERRED_SIZE)
				.addContainerGap(34, Short.MAX_VALUE)));

		JLabel lblListadoDeEmpresas = new JLabel("Listado de empresas");
		lblListadoDeEmpresas.setFont(new Font("Tahoma", Font.BOLD, 12));

		JButton btnAgNuevaCap = new JButton("Agregar nueva capacitaci\u00F3n a empresa");
		btnAgNuevaCap.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int row = tblEmpresas.getSelectedRow();
				String rutEmpresa = tblEmpresas.getValueAt(row, 0).toString();
				RegistroCapacitacion.lblRutEmpr.setText(rutEmpresa);
				RegistroCapacitacion regCap = new RegistroCapacitacion();
				regCap.setVisible(true);
			}
		});

		JButton btnEditarCap = new JButton("Editar planes de capacitaci\u00F3n de empresa");
		btnEditarCap.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int row = tblEmpresas.getSelectedRow();
				String rutEmpresa = tblEmpresas.getValueAt(row, 0).toString();
				MantenedorPlanCapacitacion.lblRutEmpr.setText(rutEmpresa);
				MantenedorPlanCapacitacion mantCap = new MantenedorPlanCapacitacion();
				mantCap.setVisible(true);
			}
		});

		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
				gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup().addGap(33)
								.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
										.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 750,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(lblListadoDeEmpresas, GroupLayout.PREFERRED_SIZE, 221,
												GroupLayout.PREFERRED_SIZE))
								.addContainerGap(42, Short.MAX_VALUE))
						.addGroup(Alignment.TRAILING,
								gl_panel.createSequentialGroup().addGap(95).addComponent(btnAgNuevaCap)
										.addPreferredGap(ComponentPlacement.RELATED, 172, Short.MAX_VALUE)
										.addComponent(btnEditarCap).addGap(146)));
		gl_panel.setVerticalGroup(
				gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup().addContainerGap().addComponent(lblListadoDeEmpresas)
								.addGap(18)
								.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 235, GroupLayout.PREFERRED_SIZE)
								.addGap(18).addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
										.addComponent(btnEditarCap).addComponent(btnAgNuevaCap))
								.addContainerGap(14, Short.MAX_VALUE)));

		tblEmpresas = new JTable();
		LlenarTabla();
		scrollPane.setViewportView(tblEmpresas);
		panel.setLayout(gl_panel);
		contentPane.setLayout(gl_contentPane);
	}

	public static void LlenarTabla() {
		try {
			modelo.setRowCount(0);
			modelo.setColumnCount(0);

			ServicioComunicacionStub proxy = new ServicioComunicacionStub();
			ArrayList<Empresa> listaEmpresa = new ArrayList<>();
			ReadEmpresasAll readEmpresas = new ReadEmpresasAll();
			String empresasJson = proxy.readEmpresasAll(readEmpresas).get_return();
			listaEmpresa = new ObjectMapper().readValue(empresasJson, new TypeReference<List<Empresa>>() {
			});

			ArrayList<Object> columnas = new ArrayList<>();
			columnas.add("Rut empresa");
			columnas.add("Razon social");
			columnas.add("Empresa");
			columnas.add("Direccion");
			columnas.add("Rubro");

			for (Object col : columnas) {
				modelo.addColumn(col);
			}

			tblEmpresas.setModel(modelo);

			Object[] fila = new Object[modelo.getColumnCount()];
			for (int i = 0; i < listaEmpresa.size(); i++) {
				fila[0] = listaEmpresa.get(i).getRut_empresa();
				fila[1] = listaEmpresa.get(i).getRazon_social();
				fila[2] = listaEmpresa.get(i).getNombre_empresa();
				fila[3] = listaEmpresa.get(i).getDir_empresa();
				fila[4] = listaEmpresa.get(i).getRubro();
				modelo.addRow(fila);
			}

			tblEmpresas.setModel(modelo);

			for (int i = 0; i < tblEmpresas.getColumnCount(); i++) {
				utilidades.Ajustar.AnchoColumnas(tblEmpresas, i);
			}

		} catch (Exception ex) {
			JOptionPane.showMessageDialog(null, "No se pudo cargar lista de empresas.");
		}
	}
}
