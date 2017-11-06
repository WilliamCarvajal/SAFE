package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import entidades.ModuloCapacitacion.Curso;
import service.ServicioComunicacionIOExceptionException;
import service.ServicioComunicacionStub;
import service.ServicioComunicacionStub.ReadCursoByIdCurso;
import service.ServicioComunicacionStub.ReadCursoByIdPlan;
import service.ServicioComunicacionStub.UpdateCurso;

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
import java.io.IOException;
import java.io.StringWriter;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import org.apache.axis2.AxisFault;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class MantenedorCapacitacion extends JFrame {

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
	private JButton btnGuardarCambios;
	private JScrollPane scrollPane;
	private JTextArea txtDesCurso;
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
	private JPanel pnlCapacitaciones;
	private JLabel lblListadoDeCapacitaciones;
	private JButton btnEliminar;
	private JButton btnEditar;
	private JMenu mnAgregar;
	private JMenuItem mntmPlanDeCapacitacin_1;
	private JLabel label;
	public static JLabel lblNombreUsuario;
	public static JLabel lblRutEmpr = new JLabel();
	public static JTable tblCapacitaciones;
	public static JLabel lblIdPlan = new JLabel();
	public int idPlan;
	public int idCurso;

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
					MantenedorCapacitacion frame = new MantenedorCapacitacion();
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
	public MantenedorCapacitacion() {
		setTitle("Mantenedor de capacitaciones");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1188, 609);

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
				MantenedorCapacitacion mnPlan = new MantenedorCapacitacion();
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

		mnAgregar = new JMenu("Agregar");
		menuBar.add(mnAgregar);

		mntmPlanDeCapacitacin_1 = new JMenuItem("Plan de capacitaci\u00F3n");
		mntmPlanDeCapacitacin_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MantenedorPlanCapacitacion mPlan = new MantenedorPlanCapacitacion();
				mPlan.setVisible(true);
				dispose();
			}
		});
		mnAgregar.add(mntmPlanDeCapacitacin_1);

		mnEditar = new JMenu("Editar");
		menuBar.add(mnEditar);

		mntmPlanDeCapacitacin = new JMenuItem("Planes de capacitaci\u00F3n");
		mntmPlanDeCapacitacin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MantenedorPlanCapacitacion mPlan = new MantenedorPlanCapacitacion();
				mPlan.setVisible(true);
				dispose();
			}
		});
		mnEditar.add(mntmPlanDeCapacitacin);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(51, 153, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		pnlCurso = new JPanel();

		lblRegistroDeCapacitaciones = new JLabel("Mantenedor de capacitaciones");
		lblRegistroDeCapacitaciones.setFont(new Font("Tahoma", Font.BOLD, 12));

		pnlCapacitaciones = new JPanel();

		label = new JLabel("Bienvenido");

		lblNombreUsuario = new JLabel("NombreUsuario");

		lblRutEmpr.setForeground(new Color(51, 153, 255));

		lblIdPlan.setForeground(new Color(51, 153, 255));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup().addGap(22)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(Alignment.TRAILING,
										gl_contentPane.createSequentialGroup()
												.addComponent(pnlCapacitaciones, GroupLayout.PREFERRED_SIZE, 818,
														GroupLayout.PREFERRED_SIZE)
												.addPreferredGap(ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
												.addComponent(pnlCurso, GroupLayout.PREFERRED_SIZE, 266,
														GroupLayout.PREFERRED_SIZE)
												.addGap(21))
								.addGroup(gl_contentPane.createSequentialGroup()
										.addComponent(label, GroupLayout.PREFERRED_SIZE, 62, GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(lblNombreUsuario, GroupLayout.PREFERRED_SIZE, 162,
												GroupLayout.PREFERRED_SIZE)
										.addGap(41)
										.addComponent(lblRegistroDeCapacitaciones, GroupLayout.PREFERRED_SIZE, 228,
												GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.RELATED, 195, Short.MAX_VALUE)
										.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
												.addGroup(gl_contentPane.createSequentialGroup()
														.addComponent(lblRutEmpr).addGap(166))
												.addGroup(gl_contentPane.createSequentialGroup().addComponent(lblIdPlan)
														.addGap(43)))))));
		gl_contentPane.setVerticalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addGroup(gl_contentPane
				.createSequentialGroup().addContainerGap()
				.addGroup(gl_contentPane
						.createParallelGroup(Alignment.BASELINE).addComponent(label).addComponent(lblNombreUsuario)
						.addComponent(lblRegistroDeCapacitaciones).addComponent(lblRutEmpr).addComponent(lblIdPlan))
				.addGap(19)
				.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(pnlCurso, GroupLayout.PREFERRED_SIZE, 454, GroupLayout.PREFERRED_SIZE)
						.addComponent(pnlCapacitaciones, GroupLayout.DEFAULT_SIZE, 484, Short.MAX_VALUE))
				.addContainerGap()));

		lblListadoDeCapacitaciones = new JLabel("Listado de capacitaciones");
		lblListadoDeCapacitaciones.setFont(new Font("Tahoma", Font.BOLD, 12));

		btnEliminar = new JButton("Eliminar capacitaci\u00F3n");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int opcEliminar = JOptionPane.showConfirmDialog(null, "Se eliminará la capacitación \n ¿Está seguro?",
						"Confirmar", JOptionPane.YES_NO_OPTION);
				// 0 = Si, 1 = No

				if (opcEliminar == 0) {

					try {
						int row = tblCapacitaciones.getSelectedRow();
						int idCap = (Integer) tblCapacitaciones.getValueAt(row, 0);
						ServicioComunicacionStub proxy = new ServicioComunicacionStub();
						ObjectMapper mapper = new ObjectMapper();

						new Curso();
						ReadCursoByIdCurso readCurso = new ReadCursoByIdCurso();
						readCurso.setIdCurso(idCap);
						String capJson = proxy.readCursoByIdCurso(readCurso).get_return();
						mapper.readValue(capJson, Curso.class);

						/*
						 * DeleteEmpresa delEmpresa = new DeleteEmpresa();
						 * delEmpresa.setRutEmpresa(empr.getRut_empresa());
						 * 
						 * int eliminado = proxy.deleteEmpresa(delEmpresa).get_return();
						 * System.out.println(eliminado);
						 * 
						 * if (eliminado > 0) { JOptionPane.showMessageDialog(null,
						 * "Se eliminó de forma correcta la empresa");
						 * 
						 * DeleteCuentaUsuario deleteCuenta = new DeleteCuentaUsuario();
						 * deleteCuenta.setIdCuentaUsuario(idUsu);
						 * proxy.deleteCuentaUsuario(deleteCuenta);
						 * 
						 * LlenarTabla(rol4.getId_rol()); } else { JOptionPane.showMessageDialog(null,
						 * "No se eliminó la empresa"); }
						 */
					} catch (ServicioComunicacionIOExceptionException | IOException e1) {
						e1.printStackTrace();
					}
				}
			}
		});

		btnEditar = new JButton("Editar capacitaci\u00F3n");
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				try {
					int row = tblCapacitaciones.getSelectedRow();
					int idCap = (Integer) tblCapacitaciones.getValueAt(row, 0);
					ServicioComunicacionStub proxy = new ServicioComunicacionStub();
					ObjectMapper mapper = new ObjectMapper();

					Curso curso = new Curso();
					ReadCursoByIdCurso readCurso = new ReadCursoByIdCurso();
					readCurso.setIdCurso(idCap);
					String capJson = proxy.readCursoByIdCurso(readCurso).get_return();
					curso = mapper.readValue(capJson, Curso.class);

					txtNomCurso.setText(curso.getNombre_curso());
					txtLugarCurso.setText(curso.getLugar_curso());
					txtCantMin.setText(Integer.toString(curso.getMin_participantes()));
					txtCantMax.setText(Integer.toString(curso.getMax_participantes()));
					txtDesCurso.setText(curso.getDesc_curso());
					txtEmail.setText(curso.getCorreo_info());

					idPlan = curso.getId_plan_capacitacion();
					idCurso = curso.getId_curso();

				} catch (AxisFault e) {
					e.printStackTrace();
				} catch (JsonParseException e) {
					e.printStackTrace();
				} catch (JsonMappingException e) {
					e.printStackTrace();
				} catch (RemoteException e) {
					e.printStackTrace();
				} catch (ServicioComunicacionIOExceptionException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		});

		JScrollPane scrollPane_1 = new JScrollPane();
		GroupLayout gl_pnlCapacitaciones = new GroupLayout(pnlCapacitaciones);
		gl_pnlCapacitaciones.setHorizontalGroup(gl_pnlCapacitaciones.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlCapacitaciones.createSequentialGroup().addContainerGap(191, Short.MAX_VALUE)
						.addComponent(lblListadoDeCapacitaciones, GroupLayout.PREFERRED_SIZE, 203,
								GroupLayout.PREFERRED_SIZE)
						.addGap(179))
				.addGroup(gl_pnlCapacitaciones.createSequentialGroup().addGap(22)
						.addComponent(scrollPane_1, GroupLayout.PREFERRED_SIZE, 771, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(25, Short.MAX_VALUE))
				.addGroup(gl_pnlCapacitaciones.createSequentialGroup().addGap(304)
						.addGroup(gl_pnlCapacitaciones.createParallelGroup(Alignment.TRAILING, false)
								.addComponent(btnEditar, Alignment.LEADING, GroupLayout.DEFAULT_SIZE,
										GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(btnEliminar, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 205,
										Short.MAX_VALUE))
						.addContainerGap(309, Short.MAX_VALUE)));
		gl_pnlCapacitaciones.setVerticalGroup(gl_pnlCapacitaciones.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlCapacitaciones.createSequentialGroup().addContainerGap()
						.addComponent(lblListadoDeCapacitaciones).addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(scrollPane_1, GroupLayout.PREFERRED_SIZE, 314, GroupLayout.PREFERRED_SIZE)
						.addGap(18).addComponent(btnEliminar).addGap(18).addComponent(btnEditar)
						.addContainerGap(56, Short.MAX_VALUE)));

		tblCapacitaciones = new JTable();
		scrollPane_1.setViewportView(tblCapacitaciones);

		int idPlanCap = Integer.parseInt(lblIdPlan.getText());
		LlenarTabla(idPlanCap);

		pnlCapacitaciones.setLayout(gl_pnlCapacitaciones);

		label_1 = new JLabel("Datos de capacitaciones");
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setFont(new Font("Tahoma", Font.BOLD, 12));

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

		btnGuardarCambios = new JButton("Guardar cambios");
		btnGuardarCambios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Falta idCurso e idCapacitacion
				String nomCurso = txtNomCurso.getText();
				String lugCurso = txtLugarCurso.getText();
				int minPart = Integer.parseInt(txtCantMin.getText());
				int maxPart = Integer.parseInt(txtCantMax.getText());
				String desCurso = txtDesCurso.getText();
				String info = txtEmail.getText();

				try {
					ServicioComunicacionStub proxy = new ServicioComunicacionStub();
					StringWriter stringUpdCap = new StringWriter();
					ObjectMapper objectMapper = new ObjectMapper();

					Curso cur = new Curso();
					cur.setId_curso(idCurso);
					cur.setNombre_curso(nomCurso);
					cur.setLugar_curso(lugCurso);
					;
					cur.setMax_participantes(maxPart);
					cur.setMin_participantes(minPart);
					cur.setDesc_curso(desCurso);
					cur.setCorreo_info(info);
					cur.setId_plan_capacitacion(idPlan);

					objectMapper.writeValue(stringUpdCap, cur);
					String updCapJson = stringUpdCap.toString();
					UpdateCurso UpdCurso = new UpdateCurso();
					UpdCurso.setCursoJson(updCapJson);

					int actualizado = proxy.updateCurso(UpdCurso).get_return();
					;

					if (actualizado > 0) {
						JOptionPane.showMessageDialog(null, "Se actualizó exitosamente el curso");
						LlenarTabla(idPlan);
					} else {
						JOptionPane.showMessageDialog(null, "No se actualizó correctamente el curso...");
					}

				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, "Error al editar la capacitación.");
				}
			}
		});

		scrollPane = new JScrollPane();
		GroupLayout gl_pnlCurso = new GroupLayout(pnlCurso);
		gl_pnlCurso.setHorizontalGroup(gl_pnlCurso.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlCurso.createSequentialGroup().addGap(56)
						.addComponent(label_1, GroupLayout.PREFERRED_SIZE, 149, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(61, Short.MAX_VALUE))
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
												.addContainerGap()))))
				.addGroup(gl_pnlCurso.createSequentialGroup().addGap(59)
						.addComponent(btnGuardarCambios, GroupLayout.PREFERRED_SIZE, 143, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(506, Short.MAX_VALUE)));
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
						.addGap(18).addComponent(btnGuardarCambios).addContainerGap(23, Short.MAX_VALUE)));

		txtDesCurso = new JTextArea();
		scrollPane.setViewportView(txtDesCurso);
		pnlCurso.setLayout(gl_pnlCurso);
		contentPane.setLayout(gl_contentPane);
	}

	public static void LlenarTabla(int idPlan) {
		try {

			if (idPlan >= 0) {

				modelo.setRowCount(0);
				modelo.setColumnCount(0);

				ServicioComunicacionStub proxy = new ServicioComunicacionStub();
				ArrayList<Curso> listaCap = new ArrayList<>();
				ReadCursoByIdPlan readCursos = new ReadCursoByIdPlan();
				readCursos.setIdPlanCapacitacion(idPlan);
				String capJson = proxy.readCursoByIdPlan(readCursos).get_return();
				listaCap = new ObjectMapper().readValue(capJson, new TypeReference<List<Curso>>() {
				});

				ArrayList<Object> columnas = new ArrayList<>();
				columnas.add("ID curso");
				columnas.add("Nombre curso");
				columnas.add("Lugar");
				columnas.add("Mínimo participantes");
				columnas.add("Máximo participantes");
				columnas.add("Descripción");
				columnas.add("Correo");

				for (Object col : columnas) {
					modelo.addColumn(col);
				}

				tblCapacitaciones.setModel(modelo);

				Object[] fila = new Object[modelo.getColumnCount()];
				for (int i = 0; i < listaCap.size(); i++) {
					fila[0] = listaCap.get(i).getId_curso();
					fila[1] = listaCap.get(i).getNombre_curso();
					fila[2] = listaCap.get(i).getLugar_curso();
					fila[3] = listaCap.get(i).getMin_participantes();
					fila[4] = listaCap.get(i).getMax_participantes();
					fila[5] = listaCap.get(i).getDesc_curso();
					fila[6] = listaCap.get(i).getCorreo_info();
					modelo.addRow(fila);
				}

				tblCapacitaciones.setModel(modelo);

				for (int i = 0; i < tblCapacitaciones.getColumnCount(); i++) {
					utilidades.Ajustar.AnchoColumnas(tblCapacitaciones, i);
				}

			}
		} catch (Exception ex) {
			// mandar mensaje
			JOptionPane.showMessageDialog(null, "No se pudo cargar la lista de capacitaciones");
		}
	}
}
