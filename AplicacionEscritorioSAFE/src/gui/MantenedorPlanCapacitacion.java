package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import entidades.ModuloCapacitacion.Curso;
import entidades.ModuloCapacitacion.PlanCapacitacion;
import service.ServicioComunicacionIOExceptionException;
import service.ServicioComunicacionStub;
import service.ServicioComunicacionStub.DeleteCurso;
import service.ServicioComunicacionStub.DeletePlanCapactitacion;
import service.ServicioComunicacionStub.ReadCursoByIdCurso;
import service.ServicioComunicacionStub.ReadPlanByIdPlan;
import service.ServicioComunicacionStub.ReadPlanByRutEmpresa;
import service.ServicioComunicacionStub.UpdateCurso;
import service.ServicioComunicacionStub.UpdatePlanCapacitacion;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.StringWriter;
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

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class MantenedorPlanCapacitacion extends JFrame {

	private JPanel contentPane;
	private JLabel lblTitulo;
	private JLabel lblRutEmpresa;
	private JTextField txtRutEmpresa;
	private JTextField txtDvEmpresa;
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
	private JButton btnEditarPlan;
	private JButton btnEliminarPlan_1;
	private JMenu mnEditar;
	private JMenuItem mntmCapacitaciones;
	private JLabel label_1;
	public static JLabel lblNombreUsuario;
	private JScrollPane scrollPane;
	public static JTable tblPlanes;
	public static JLabel lblRutEmpr = new JLabel();
	public int idPlan;
	public int rutEmpresa;

	public static DefaultTableModel modelo = new DefaultTableModel() {
		public boolean isCellEditable(int fila, int columna) {
			return false;
		}
	};
	private JButton btnEditarCursosDel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MantenedorPlanCapacitacion frame = new MantenedorPlanCapacitacion();
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
	public MantenedorPlanCapacitacion() {
		setTitle("Mantenedor de planes de capacitaci\u00F3n");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 714, 574);

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
				MantenedorPlanCapacitacion mnPlan = new MantenedorPlanCapacitacion();
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

		mntmCapacitaciones = new JMenuItem("Capacitaciones");
		mntmCapacitaciones.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int row = tblPlanes.getSelectedRow();
				String idPl = (String) tblPlanes.getValueAt(row, 0);
				MantenedorCapacitacion.lblIdPlan.setText(idPl);
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

		lblRegistroDeCapacitaciones = new JLabel("Mantenedor de planes de capacitaci\u00F3n");
		lblRegistroDeCapacitaciones.setFont(new Font("Tahoma", Font.BOLD, 12));

		JPanel panel = new JPanel();

		label_1 = new JLabel("Bienvenido");

		lblNombreUsuario = new JLabel("NombreUsuario");

		lblRutEmpr.setForeground(new Color(51, 153, 255));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addGroup(gl_contentPane
				.createSequentialGroup().addGap(30)
				.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addGroup(gl_contentPane
						.createSequentialGroup()
						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(lblRegistroDeCapacitaciones, GroupLayout.PREFERRED_SIZE, 285,
										GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_contentPane.createSequentialGroup()
										.addComponent(panel, GroupLayout.PREFERRED_SIZE, 333,
												GroupLayout.PREFERRED_SIZE)
										.addGap(36).addComponent(pnlPlanCap, GroupLayout.PREFERRED_SIZE, 244,
												GroupLayout.PREFERRED_SIZE)))
						.addContainerGap(45, Short.MAX_VALUE))
						.addGroup(gl_contentPane.createSequentialGroup()
								.addComponent(label_1, GroupLayout.PREFERRED_SIZE, 62, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(lblNombreUsuario, GroupLayout.PREFERRED_SIZE, 162,
										GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED, 258, Short.MAX_VALUE)
								.addComponent(lblRutEmpr).addGap(140)))));
		gl_contentPane.setVerticalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup().addContainerGap()
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE).addComponent(label_1)
								.addComponent(lblNombreUsuario).addComponent(lblRutEmpr))
						.addPreferredGap(ComponentPlacement.UNRELATED).addComponent(lblRegistroDeCapacitaciones)
						.addGap(21)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(pnlPlanCap, GroupLayout.PREFERRED_SIZE, 287, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_contentPane.createSequentialGroup().addGap(1).addComponent(panel,
										GroupLayout.PREFERRED_SIZE, 375, GroupLayout.PREFERRED_SIZE)))
						.addContainerGap(57, Short.MAX_VALUE)));

		JLabel lblListadoDePlanes = new JLabel("Listado de planes de capacitaci\u00F3n");
		lblListadoDePlanes.setFont(new Font("Tahoma", Font.BOLD, 12));

		btnEditarPlan = new JButton("Editar plan");
		btnEditarPlan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					int row = tblPlanes.getSelectedRow();
					idPlan = (Integer) tblPlanes.getValueAt(row, 0);
					rutEmpresa = Integer.parseInt(lblRutEmpr.getText());
					ServicioComunicacionStub proxy = new ServicioComunicacionStub();
					ObjectMapper mapper = new ObjectMapper();

					PlanCapacitacion plan = new PlanCapacitacion();
					ReadPlanByIdPlan readPlan = new ReadPlanByIdPlan();
					readPlan.setIdPlan(idPlan);
					String planJson = proxy.readPlanByIdPlan(readPlan).get_return();
					plan = mapper.readValue(planJson, PlanCapacitacion.class);

					txtNombrepPlan.setText(plan.getNombre_plan());
					txtAnio.setText(Integer.toString(plan.getAnio()));
				} catch (ServicioComunicacionIOExceptionException | IOException e) {
					e.printStackTrace();
				}			
			}
		});

		btnEliminarPlan_1 = new JButton("Eliminar plan");
		btnEliminarPlan_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int opcEliminar = JOptionPane.showConfirmDialog(null, "Se eliminará la capacitación \n ¿Está seguro?",
						"Confirmar", JOptionPane.YES_NO_OPTION);
				// 0 = Si, 1 = No

				if (opcEliminar == 0) {

					try {
						int row = tblPlanes.getSelectedRow();
						int idPl = (Integer)tblPlanes.getValueAt(row, 0);
						ServicioComunicacionStub proxy = new ServicioComunicacionStub();

						DeletePlanCapactitacion delPlan = new DeletePlanCapactitacion();
						delPlan.setIdPlan(idPl);

						int eliminado = proxy.deletePlanCapactitacion(delPlan).get_return();

						if (eliminado > 0) {
							JOptionPane.showMessageDialog(null, "Se eliminó de forma correcta el plan de capacitación");
							LlenarTabla(Integer.parseInt(lblRutEmpr.getText()));
						} else {
							JOptionPane.showMessageDialog(null, "No se eliminó el plan de capacitación");
						}

					} catch (ServicioComunicacionIOExceptionException | IOException e1) {
						e1.printStackTrace();
					}
				}
			}
		});

		scrollPane = new JScrollPane();

		btnEditarCursosDel = new JButton("Editar cursos del plan");
		btnEditarCursosDel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int row = tblPlanes.getSelectedRow();
				String idPlan = tblPlanes.getValueAt(row, 0).toString();
				MantenedorCapacitacion.lblIdPlan.setText(idPlan);
				MantenedorCapacitacion mCap = new MantenedorCapacitacion();
				mCap.setVisible(true);
				dispose();
			}
		});
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
				gl_panel.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_panel.createSequentialGroup().addGap(28)
								.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
										.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 278,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(lblListadoDePlanes))
								.addContainerGap(27, Short.MAX_VALUE))
						.addGroup(gl_panel.createSequentialGroup().addContainerGap(89, Short.MAX_VALUE)
								.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING, false)
										.addComponent(btnEliminarPlan_1, Alignment.LEADING, GroupLayout.DEFAULT_SIZE,
												GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(btnEditarPlan, Alignment.LEADING, GroupLayout.DEFAULT_SIZE,
												GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(btnEditarCursosDel, Alignment.LEADING, GroupLayout.DEFAULT_SIZE,
												157, Short.MAX_VALUE))
								.addGap(87)));
		gl_panel.setVerticalGroup(gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup().addContainerGap().addComponent(lblListadoDePlanes).addGap(7)
						.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 206, GroupLayout.PREFERRED_SIZE)
						.addGap(18).addComponent(btnEditarPlan).addGap(18).addComponent(btnEliminarPlan_1).addGap(18)
						.addComponent(btnEditarCursosDel).addContainerGap(13, Short.MAX_VALUE)));

		tblPlanes = new JTable();
		int rut = Integer.parseInt(lblRutEmpr.getText());
		LlenarTabla(rut);
		scrollPane.setViewportView(tblPlanes);
		panel.setLayout(gl_panel);

		lblTitulo = new JLabel("Datos de plan de capacitaci\u00F3n");
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 12));

		lblRutEmpresa = new JLabel("Rut empresa");

		txtRutEmpresa = new JTextField();
		txtRutEmpresa.setColumns(10);

		txtDvEmpresa = new JTextField();
		txtDvEmpresa.setColumns(10);

		JLabel label = new JLabel("-");

		lblNombrePlanDe = new JLabel("Nombre plan de capacitaci\u00F3n");

		txtNombrepPlan = new JTextField();
		txtNombrepPlan.setColumns(10);

		lblNewLabel = new JLabel("A\u00F1o de aplicaci\u00F3n del plan");

		txtAnio = new JTextField();
		txtAnio.setColumns(10);

		JButton btnGuardarCambios = new JButton("Guardar cambios");
		btnGuardarCambios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String nomPlan = txtNombrepPlan.getText();
				int anio = Integer.parseInt(txtAnio.getText());

				try {
					ServicioComunicacionStub proxy = new ServicioComunicacionStub();
					StringWriter stringUpdPlan = new StringWriter();
					ObjectMapper objectMapper = new ObjectMapper();

					PlanCapacitacion plan = new PlanCapacitacion();
					plan.setId_plan(idPlan);
					plan.setNombre_plan(nomPlan);
					plan.setAnio(anio);
					plan.setRut_empresa(rutEmpresa);

					objectMapper.writeValue(stringUpdPlan, plan);
					String updPlanJson = stringUpdPlan.toString();
					UpdatePlanCapacitacion UpdPlan = new UpdatePlanCapacitacion();
					UpdPlan.setPlanJson(updPlanJson);

					int actualizado = proxy.updatePlanCapacitacion(UpdPlan).get_return();

					if (actualizado > 0) {
						JOptionPane.showMessageDialog(null, "Se actualizó exitosamente el plan de capacitación");
						LlenarTabla(idPlan);
					} else {
						JOptionPane.showMessageDialog(null, "No se actualizó correctamente el plan de capacitación...");
					}

				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, "Error al editar el plan de capacitación");
				}

			}
		});
		GroupLayout gl_pnlPlanCap = new GroupLayout(pnlPlanCap);
		gl_pnlPlanCap.setHorizontalGroup(gl_pnlPlanCap.createParallelGroup(Alignment.TRAILING).addGroup(gl_pnlPlanCap
				.createSequentialGroup().addGap(19)
				.addGroup(gl_pnlPlanCap.createParallelGroup(Alignment.LEADING, false).addComponent(lblNewLabel)
						.addComponent(lblRutEmpresa).addComponent(lblNombrePlanDe).addComponent(txtNombrepPlan)
						.addGroup(gl_pnlPlanCap.createSequentialGroup()
								.addComponent(txtRutEmpresa, GroupLayout.PREFERRED_SIZE, 127,
										GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(label, GroupLayout.PREFERRED_SIZE, 12, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(txtDvEmpresa, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE))
						.addComponent(txtAnio))
				.addContainerGap(37, Short.MAX_VALUE))
				.addGroup(gl_pnlPlanCap.createSequentialGroup().addContainerGap(31, Short.MAX_VALUE)
						.addComponent(lblTitulo).addGap(25))
				.addGroup(Alignment.LEADING,
						gl_pnlPlanCap
								.createSequentialGroup().addGap(38).addComponent(btnGuardarCambios,
										GroupLayout.PREFERRED_SIZE, 162, GroupLayout.PREFERRED_SIZE)
								.addContainerGap(44, Short.MAX_VALUE)));
		gl_pnlPlanCap.setVerticalGroup(gl_pnlPlanCap.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlPlanCap.createSequentialGroup().addContainerGap().addComponent(lblTitulo).addGap(15)
						.addComponent(lblRutEmpresa).addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(gl_pnlPlanCap.createParallelGroup(Alignment.BASELINE)
								.addComponent(txtRutEmpresa, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(label).addComponent(txtDvEmpresa, GroupLayout.PREFERRED_SIZE,
										GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGap(11).addComponent(lblNombrePlanDe).addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(txtNombrepPlan, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addGap(11).addComponent(lblNewLabel).addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(txtAnio, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addGap(36).addComponent(btnGuardarCambios).addContainerGap(100, Short.MAX_VALUE)));
		pnlPlanCap.setLayout(gl_pnlPlanCap);
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
			JOptionPane.showMessageDialog(null, "Empresa no cuenta con planes de capacitación");
		}
	}
}
