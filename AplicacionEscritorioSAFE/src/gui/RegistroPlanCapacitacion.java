package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.fasterxml.jackson.databind.ObjectMapper;

import entidades.ModuloCapacitacion.PlanCapacitacion;
import service.ServicioComunicacionStub;
import service.ServicioComunicacionStub.InsertPlanCapacitacion;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.StringWriter;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JSeparator;

public class RegistroPlanCapacitacion extends JFrame {

	private JPanel contentPane;
	private JLabel lblTitulo;
	private JLabel lblNombrePlanDe;
	private JTextField txtNombrepPlan;
	private JLabel lblNewLabel;
	private JTextField txtAnio;
	private JMenuBar menuBar;
	private JMenu mnAplicacin;
	private JMenuItem mntmNuevoInicioDe;
	private JMenuItem mntmCerrarSesin;
	private JMenuItem mntmDuplicarPantalla;
	private JMenuItem mntmSalirDea;
	private JSeparator separator;
	private JLabel lblRegistroDeCapacitaciones;
	private JMenu mnEditar;
	private JMenuItem mntmPlanDeCapacitacin;
	private JMenuItem mntmCapacitaciones;
	private JLabel label_7;
	public static JLabel lblNombreUsuario;
	public static JLabel lblEmpRut = new JLabel("New label");;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegistroPlanCapacitacion frame = new RegistroPlanCapacitacion();
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
	public RegistroPlanCapacitacion() {
		setIconImage(utilidades.CambiarIcono.getIconImage());
		setTitle("Registro de capacitaciones");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 343, 405);

		menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		mnAplicacin = new JMenu("Aplicaci\u00F3n");
		menuBar.add(mnAplicacin);

		mntmCerrarSesin = new JMenuItem("Cerrar sesi\u00F3n");
		mntmCerrarSesin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Login lgn = new Login();
				lgn.setVisible(true);
				dispose();
			}
		});
		mnAplicacin.add(mntmCerrarSesin);

		mntmNuevoInicioDe = new JMenuItem("Nuevo inicio de sesi\u00F3n");
		mntmNuevoInicioDe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Login lgn = new Login();
				lgn.setVisible(true);
			}
		});
		mnAplicacin.add(mntmNuevoInicioDe);

		mntmDuplicarPantalla = new JMenuItem("Duplicar ventana");
		mntmDuplicarPantalla.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RegistroPlanCapacitacion mnPlan = new RegistroPlanCapacitacion();
				mnPlan.setVisible(true);
			}
		});
		mnAplicacin.add(mntmDuplicarPantalla);

		separator = new JSeparator();
		mnAplicacin.add(separator);

		mntmSalirDea = new JMenuItem("Salir de la aplicaci\u00F3n");
		mntmSalirDea.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(JFrame.DISPOSE_ON_CLOSE);
			}
		});
		mnAplicacin.add(mntmSalirDea);

		mnEditar = new JMenu("Editar");
		menuBar.add(mnEditar);

		mntmPlanDeCapacitacin = new JMenuItem("Planes de capacitaci\u00F3n");
		mntmPlanDeCapacitacin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				MantenedorPlanCapacitacion mPlan = new MantenedorPlanCapacitacion();
				mPlan.setVisible(true);
				dispose();
			}
		});
		mnEditar.add(mntmPlanDeCapacitacin);

		mntmCapacitaciones = new JMenuItem("Capacitaciones");
		mntmCapacitaciones.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MantenedorCapacitacion mCap = new MantenedorCapacitacion();
				mCap.setVisible(true);
				dispose();
			}
		});
		mnEditar.add(mntmCapacitaciones);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(51, 153, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JPanel pnlPlanCap = new JPanel();

		lblRegistroDeCapacitaciones = new JLabel("Registro de planes de capacitaci\u00F3n");
		lblRegistroDeCapacitaciones.setFont(new Font("Tahoma", Font.BOLD, 12));

		label_7 = new JLabel("Bienvenido");

		lblNombreUsuario = new JLabel("NombreUsuario");

		lblEmpRut.setForeground(new Color(51, 153, 255));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addGroup(gl_contentPane
				.createSequentialGroup().addGap(22)
				.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(lblRegistroDeCapacitaciones, GroupLayout.DEFAULT_SIZE, 258, Short.MAX_VALUE)
						.addGroup(gl_contentPane.createSequentialGroup()
								.addComponent(label_7, GroupLayout.PREFERRED_SIZE, 62, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(lblNombreUsuario, GroupLayout.PREFERRED_SIZE, 162,
										GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED).addComponent(lblEmpRut)))
				.addGap(13))
				.addGroup(gl_contentPane.createSequentialGroup().addGap(37)
						.addComponent(pnlPlanCap, GroupLayout.PREFERRED_SIZE, 248, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(32, Short.MAX_VALUE)));
		gl_contentPane.setVerticalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup().addGap(17)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE).addComponent(label_7)
								.addComponent(lblNombreUsuario).addComponent(lblEmpRut))
						.addGap(18).addComponent(lblRegistroDeCapacitaciones).addGap(18)
						.addComponent(pnlPlanCap, GroupLayout.PREFERRED_SIZE, 236, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(18, Short.MAX_VALUE)));

		lblTitulo = new JLabel("Datos de plan de capacitaci\u00F3n");
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 11));

		lblNombrePlanDe = new JLabel("Nombre plan de capacitaci\u00F3n");

		txtNombrepPlan = new JTextField();
		txtNombrepPlan.setColumns(10);

		lblNewLabel = new JLabel("A\u00F1o de aplicaci\u00F3n del plan");

		txtAnio = new JTextField();
		txtAnio.setColumns(10);

		JButton btnAgregarPlan = new JButton("Agregar plan");
		btnAgregarPlan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					String nomPlan = txtNombrepPlan.getText();
					int anio = Integer.parseInt(txtAnio.getText());
					int rut = Integer.parseInt(lblEmpRut.getText());

					ServicioComunicacionStub proxy = new ServicioComunicacionStub();

					PlanCapacitacion plan = new PlanCapacitacion();
					plan.setNombre_plan(nomPlan);
					plan.setAnio(anio);
					plan.setRut_empresa(rut);

					StringWriter stringInsPlan = new StringWriter();
					ObjectMapper objectMapper = new ObjectMapper();
					objectMapper.writeValue(stringInsPlan, plan);
					String insJsonPlan = stringInsPlan.toString();
					InsertPlanCapacitacion insertPlan = new InsertPlanCapacitacion();
					insertPlan.setPlanJson(insJsonPlan);

					int idPlan = proxy.insertPlanCapacitacion(insertPlan).get_return();

					if (idPlan > 0) {
						JOptionPane.showMessageDialog(null, "Se registró exitosamente el plan de capacitación");
						dispose();
					} else {
						JOptionPane.showMessageDialog(null, "No se registró el plan de capacitación");
						dispose();
					}

				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, "Error al agregar el plan de capacitación.");
					dispose();
				}
				RegistroCapacitacion.lblRutEmpr.setText(lblEmpRut.getText());
				RegistroCapacitacion regCap = new RegistroCapacitacion();
				regCap.setVisible(true);
			}
		});
		GroupLayout gl_pnlPlanCap = new GroupLayout(pnlPlanCap);
		gl_pnlPlanCap.setHorizontalGroup(gl_pnlPlanCap.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlPlanCap.createSequentialGroup().addGap(19)
						.addGroup(gl_pnlPlanCap.createParallelGroup(Alignment.LEADING)
								.addComponent(lblTitulo, GroupLayout.DEFAULT_SIZE, 198, Short.MAX_VALUE)
								.addComponent(lblNombrePlanDe).addComponent(lblNewLabel))
						.addGap(22))
				.addGroup(
						gl_pnlPlanCap.createSequentialGroup().addGap(23)
								.addComponent(btnAgregarPlan, GroupLayout.PREFERRED_SIZE, 181,
										GroupLayout.PREFERRED_SIZE)
								.addContainerGap(35, Short.MAX_VALUE))
				.addGroup(Alignment.TRAILING,
						gl_pnlPlanCap.createSequentialGroup().addContainerGap()
								.addGroup(gl_pnlPlanCap.createParallelGroup(Alignment.TRAILING)
										.addComponent(txtAnio, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 198,
												Short.MAX_VALUE)
										.addComponent(txtNombrepPlan, GroupLayout.DEFAULT_SIZE, 198, Short.MAX_VALUE))
								.addGap(31)));
		gl_pnlPlanCap.setVerticalGroup(gl_pnlPlanCap.createParallelGroup(Alignment.LEADING).addGroup(gl_pnlPlanCap
				.createSequentialGroup().addContainerGap().addComponent(lblTitulo).addGap(18)
				.addComponent(lblNombrePlanDe).addPreferredGap(ComponentPlacement.RELATED)
				.addComponent(txtNombrepPlan, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
						GroupLayout.PREFERRED_SIZE)
				.addGap(11).addComponent(lblNewLabel).addPreferredGap(ComponentPlacement.RELATED)
				.addComponent(txtAnio, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
				.addGap(34).addComponent(btnAgregarPlan).addContainerGap(84, Short.MAX_VALUE)));
		pnlPlanCap.setLayout(gl_pnlPlanCap);
		contentPane.setLayout(gl_contentPane);
	}
}
