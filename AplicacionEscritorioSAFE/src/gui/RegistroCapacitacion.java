package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import entidades.ModuloCapacitacion.Curso;
import entidades.ModuloCapacitacion.PlanCapacitacion;
import service.ServicioComunicacionStub;
import service.ServicioComunicacionStub.InsertCurso;
import service.ServicioComunicacionStub.ReadPlanByRutEmpresa;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTable;

public class RegistroCapacitacion extends JFrame {

	private JPanel contentPane;
	private JPanel pnlCurso;
	private JLabel label_1;
	private JLabel label_2;
	private JTextField txtNomCurso;
	private JLabel label_3;
	private JTextField txtLugarCurso;
	private JLabel label_4;
	private JTextField txtCantMin;
	private JLabel label_5;
	private JTextField txtCantMax;
	private JLabel label_6;
	private JLabel lblDireccinEmailPara;
	private JTextField txtEmail;
	private JButton btnAgregarCurso;
	private JScrollPane scrollPane;
	private JTextArea txtDesCurso;
	private JLabel lblRegistroDeCapacitaciones;
	private JLabel label_7;
	public static JLabel lblNombreUsuario;
	public static JTable tblPlanes;
	public int rutEmpresa = 1;
	public static JLabel lblRutEmpr = new JLabel("lblRutEmpr");
	public JScrollPane scpPlanes = new JScrollPane();

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
					RegistroCapacitacion frame = new RegistroCapacitacion();
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
	public RegistroCapacitacion() {
		setIconImage(utilidades.CambiarIcono.getIconImage());
		setTitle("Registro de capacitaciones");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 812, 615);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(51, 153, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		pnlCurso = new JPanel();

		lblRegistroDeCapacitaciones = new JLabel("Registro de capacitaciones");
		lblRegistroDeCapacitaciones.setFont(new Font("Tahoma", Font.BOLD, 12));

		label_7 = new JLabel("Bienvenido");

		lblNombreUsuario = new JLabel("NombreUsuario");

		JPanel pnlPlanes = new JPanel();

		JLabel label = new JLabel("Listado de planes de capacitaci\u00F3n");
		label.setFont(new Font("Tahoma", Font.BOLD, 12));

		JButton btnEliminarPlan = new JButton("Eliminar plan");
		btnEliminarPlan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

			}
		});

		JButton btnAgregarNuevoPlan = new JButton("Agregar nuevo plan");
		btnAgregarNuevoPlan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				RegistroPlanCapacitacion.lblEmpRut.setText(lblRutEmpr.getText());
				RegistroPlanCapacitacion regPlan = new RegistroPlanCapacitacion();
				regPlan.setVisible(true);
				dispose();
			}
		});

		scpPlanes = new JScrollPane();
		GroupLayout gl_pnlPlanes = new GroupLayout(pnlPlanes);
		gl_pnlPlanes.setHorizontalGroup(gl_pnlPlanes.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_pnlPlanes.createSequentialGroup().addGap(138)
						.addGroup(gl_pnlPlanes.createParallelGroup(Alignment.TRAILING)
								.addComponent(btnEliminarPlan, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 140,
										Short.MAX_VALUE)
								.addComponent(btnAgregarNuevoPlan, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 140,
										Short.MAX_VALUE))
						.addGap(142))
				.addGroup(Alignment.LEADING,
						gl_pnlPlanes.createSequentialGroup().addGap(28)
								.addGroup(gl_pnlPlanes.createParallelGroup(Alignment.LEADING)
										.addComponent(scpPlanes, GroupLayout.PREFERRED_SIZE, 362,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(label))
								.addContainerGap(30, Short.MAX_VALUE)));
		gl_pnlPlanes.setVerticalGroup(gl_pnlPlanes.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlPlanes.createSequentialGroup().addContainerGap().addComponent(label).addGap(18)
						.addComponent(scpPlanes, GroupLayout.PREFERRED_SIZE, 191, GroupLayout.PREFERRED_SIZE).addGap(15)
						.addComponent(btnAgregarNuevoPlan).addGap(18).addComponent(btnEliminarPlan)
						.addContainerGap(27, Short.MAX_VALUE)));

		tblPlanes = new JTable();
		int rut = Integer.parseInt(lblRutEmpr.getText());
		LlenarTabla(rut);
		scpPlanes.setViewportView(tblPlanes);
		pnlPlanes.setLayout(gl_pnlPlanes);

		lblRutEmpr.setForeground(new Color(51, 153, 255));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addGroup(gl_contentPane
				.createSequentialGroup().addGap(31)
				.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPane.createSequentialGroup()
								.addComponent(pnlPlanes, GroupLayout.PREFERRED_SIZE, 420, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED, 371, Short.MAX_VALUE)
								.addComponent(pnlCurso, GroupLayout.PREFERRED_SIZE, 266, GroupLayout.PREFERRED_SIZE)
								.addGap(30))
						.addGroup(gl_contentPane.createSequentialGroup().addGroup(gl_contentPane
								.createParallelGroup(Alignment.TRAILING)
								.addGroup(gl_contentPane.createSequentialGroup()
										.addComponent(label_7, GroupLayout.PREFERRED_SIZE, 62,
												GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.RELATED).addComponent(lblNombreUsuario,
												GroupLayout.PREFERRED_SIZE, 162, GroupLayout.PREFERRED_SIZE))
								.addComponent(lblRegistroDeCapacitaciones, GroupLayout.PREFERRED_SIZE, 228,
										GroupLayout.PREFERRED_SIZE))
								.addContainerGap(525, Short.MAX_VALUE))))
				.addGroup(gl_contentPane.createSequentialGroup().addGap(297).addComponent(lblRutEmpr)
						.addContainerGap(770, Short.MAX_VALUE)));
		gl_contentPane.setVerticalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup().addContainerGap(17, Short.MAX_VALUE)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
								.addGroup(gl_contentPane.createSequentialGroup()
										.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
												.addComponent(label_7).addComponent(lblNombreUsuario))
										.addGap(18).addComponent(lblRegistroDeCapacitaciones).addGap(18))
								.addGroup(gl_contentPane.createSequentialGroup().addComponent(lblRutEmpr).addGap(33)))
						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(pnlCurso, GroupLayout.DEFAULT_SIZE, 474, Short.MAX_VALUE)
								.addComponent(pnlPlanes, GroupLayout.PREFERRED_SIZE, 341, GroupLayout.PREFERRED_SIZE))
						.addContainerGap()));

		label_1 = new JLabel("Datos de capacitaciones");
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setFont(new Font("Tahoma", Font.BOLD, 11));

		label_2 = new JLabel("Nombre del curso");

		txtNomCurso = new JTextField();
		txtNomCurso.setColumns(10);

		label_3 = new JLabel("Lugar de ejecuci\u00F3n");

		txtLugarCurso = new JTextField();
		txtLugarCurso.setColumns(10);

		label_4 = new JLabel("Cantidad m\u00EDnima de participantes");

		txtCantMin = new JTextField();
		txtCantMin.setColumns(10);

		label_5 = new JLabel("Cantidad m\u00E1xima de participantes");

		txtCantMax = new JTextField();
		txtCantMax.setColumns(10);

		label_6 = new JLabel("Descripci\u00F3n del curso");

		lblDireccinEmailPara = new JLabel("Direcci\u00F3n E-Mail para m\u00E1s informaci\u00F3n");

		txtEmail = new JTextField();
		txtEmail.setColumns(10);

		btnAgregarCurso = new JButton("Agregar curso");
		btnAgregarCurso.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nomCurso = txtNomCurso.getText();
				String lugCurso = txtLugarCurso.getText();
				int minPart = Integer.parseInt(txtCantMin.getText());
				int maxPart = Integer.parseInt(txtCantMax.getText());
				String desCurso = txtDesCurso.getText();
				String info = txtEmail.getText();

				int row = tblPlanes.getSelectedRow();
				int idPlan = (int) tblPlanes.getValueAt(row, 0);

				try {
					ServicioComunicacionStub proxy = new ServicioComunicacionStub();
					Curso cur = new Curso();

					cur.setNombre_curso(nomCurso);
					cur.setLugar_curso(lugCurso);
					cur.setMin_participantes(minPart);
					cur.setMax_participantes(maxPart);
					cur.setDesc_curso(desCurso);
					cur.setCorreo_info(info);
					cur.setId_plan_capacitacion(idPlan);

					StringWriter stringInsCurso = new StringWriter();
					ObjectMapper objectMapper = new ObjectMapper();
					objectMapper.writeValue(stringInsCurso, cur);
					String insJsonCurso = stringInsCurso.toString();
					InsertCurso insertCurso = new InsertCurso();
					insertCurso.setCursoJson(insJsonCurso);

					int idCurso = proxy.insertCurso(insertCurso).get_return();

					if (idCurso > 0) {
						JOptionPane.showMessageDialog(null, "Se registro exitosamente la capacitación");

					} else {
						JOptionPane.showMessageDialog(null, "Error al registrar la capacitación");
					}

				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, "Error al agregar la capacitación.");
				}
			}
		});

		scrollPane = new JScrollPane();
		GroupLayout gl_pnlCurso = new GroupLayout(pnlCurso);
		gl_pnlCurso.setHorizontalGroup(gl_pnlCurso.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlCurso.createSequentialGroup().addGap(56)
						.addComponent(label_1, GroupLayout.PREFERRED_SIZE, 149, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(61, Short.MAX_VALUE))
				.addGroup(gl_pnlCurso.createSequentialGroup().addGap(75).addComponent(btnAgregarCurso)
						.addContainerGap(90, Short.MAX_VALUE))
				.addGroup(gl_pnlCurso.createSequentialGroup().addGap(21)
						.addGroup(gl_pnlCurso.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_pnlCurso.createSequentialGroup().addComponent(label_4).addContainerGap())
								.addGroup(gl_pnlCurso.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_pnlCurso.createSequentialGroup()
												.addComponent(label_6, GroupLayout.PREFERRED_SIZE, 197,
														GroupLayout.PREFERRED_SIZE)
												.addContainerGap())
										.addGroup(gl_pnlCurso
												.createParallelGroup(Alignment.LEADING).addGroup(gl_pnlCurso
														.createSequentialGroup().addGroup(gl_pnlCurso
																.createParallelGroup(Alignment.TRAILING)
																.addGroup(gl_pnlCurso.createSequentialGroup()
																		.addComponent(label_3,
																				GroupLayout.PREFERRED_SIZE, 119,
																				GroupLayout.PREFERRED_SIZE)
																		.addPreferredGap(ComponentPlacement.RELATED,
																				321, Short.MAX_VALUE))
																.addComponent(
																		label_5, GroupLayout.DEFAULT_SIZE, 440,
																		Short.MAX_VALUE)
																.addGroup(gl_pnlCurso.createSequentialGroup()
																		.addGroup(gl_pnlCurso
																				.createParallelGroup(Alignment.TRAILING)
																				.addComponent(txtCantMax,
																						Alignment.LEADING,
																						GroupLayout.DEFAULT_SIZE, 218,
																						Short.MAX_VALUE)
																				.addComponent(scrollPane,
																						GroupLayout.DEFAULT_SIZE, 218,
																						Short.MAX_VALUE))
																		.addGap(222)))
														.addGap(247))
												.addGroup(gl_pnlCurso.createSequentialGroup().addComponent(label_2,
														GroupLayout.PREFERRED_SIZE, 115, GroupLayout.PREFERRED_SIZE)
														.addGap(572))
												.addGroup(gl_pnlCurso.createSequentialGroup()
														.addGroup(gl_pnlCurso
																.createParallelGroup(Alignment.TRAILING, false)
																.addComponent(txtLugarCurso, Alignment.LEADING)
																.addComponent(txtNomCurso, Alignment.LEADING,
																		GroupLayout.DEFAULT_SIZE, 215, Short.MAX_VALUE)
																.addComponent(txtCantMin, Alignment.LEADING))
														.addContainerGap()))
										.addGroup(gl_pnlCurso.createSequentialGroup()
												.addGroup(gl_pnlCurso.createParallelGroup(Alignment.TRAILING, false)
														.addComponent(lblDireccinEmailPara, Alignment.LEADING,
																GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
																Short.MAX_VALUE)
														.addComponent(txtEmail, Alignment.LEADING,
																GroupLayout.DEFAULT_SIZE, 217, Short.MAX_VALUE))
												.addContainerGap())))));
		gl_pnlCurso.setVerticalGroup(gl_pnlCurso.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlCurso.createSequentialGroup().addContainerGap().addComponent(label_1).addGap(18)
						.addComponent(label_2).addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(txtNomCurso, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.UNRELATED).addComponent(label_3)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(txtLugarCurso, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.UNRELATED).addComponent(label_4)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(txtCantMin, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.UNRELATED).addComponent(label_5)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(txtCantMax, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.UNRELATED).addComponent(label_6)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 63, GroupLayout.PREFERRED_SIZE).addGap(19)
						.addComponent(lblDireccinEmailPara).addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(txtEmail, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addGap(18).addComponent(btnAgregarCurso)
						.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));

		txtDesCurso = new JTextArea();
		scrollPane.setViewportView(txtDesCurso);
		pnlCurso.setLayout(gl_pnlCurso);
		contentPane.setLayout(gl_contentPane);
	}

	public static void LlenarTabla(int rutEmpr) {
		try {

			if (rutEmpr >= 0) {

				modelo.setRowCount(0);
				modelo.setColumnCount(0);

				ServicioComunicacionStub proxy = new ServicioComunicacionStub();
				ArrayList<PlanCapacitacion> listaPlanes = new ArrayList<>();
				ReadPlanByRutEmpresa readPlanEmpresa = new ReadPlanByRutEmpresa();
				readPlanEmpresa.setRutEmpresa(rutEmpr);
				String planesJson = proxy.readPlanByRutEmpresa(readPlanEmpresa).get_return();
				listaPlanes = new ObjectMapper().readValue(planesJson, new TypeReference<List<PlanCapacitacion>>() {
				});

				ArrayList<Object> columnas = new ArrayList<>();
				columnas.add("ID Plan");
				columnas.add("Nombre capacitación");
				columnas.add("Año capacitación");

				for (Object col : columnas) {
					modelo.addColumn(col);
				}

				tblPlanes.setModel(modelo);

				Object[] fila = new Object[modelo.getColumnCount()];
				for (int i = 0; i < listaPlanes.size(); i++) {
					fila[0] = listaPlanes.get(i).getId_plan();
					fila[1] = listaPlanes.get(i).getNombre_plan();
					fila[2] = listaPlanes.get(i).getAnio();
					modelo.addRow(fila);
				}

				tblPlanes.setModel(modelo);

				for (int i = 0; i < tblPlanes.getColumnCount(); i++) {
					utilidades.Ajustar.AnchoColumnas(tblPlanes, i);
				}

			}
		} catch (Exception ex) {
			// mandar mensaje
			JOptionPane.showMessageDialog(null, "Empresa no cuenta con un plan de capacitación. \n"
					+ "   Agregue un nuevo plan antes de proceder.");
		}
	}

}
