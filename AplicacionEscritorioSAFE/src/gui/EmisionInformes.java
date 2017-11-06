package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Color;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import entidades.ModuloEvaluaciones.DetalleEvaluación;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JCheckBox;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JMenuBar;

public class EmisionInformes extends JFrame {

	private JPanel contentPane;
	private JTable table;
	public static JLabel lblNombreUsuario;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EmisionInformes frame = new EmisionInformes();
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
	public EmisionInformes() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 411);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(51, 153, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JLabel lblListadoDeInformes = new JLabel("Listado de informes de evaluaci\u00F3n");
		lblListadoDeInformes.setFont(new Font("Tahoma", Font.BOLD, 11));

		JPanel panel = new JPanel();

		JLabel lblBienvenido = new JLabel("Bienvenido");

		lblNombreUsuario = new JLabel("NombreUsuario");
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addGroup(gl_contentPane
				.createSequentialGroup().addGap(26)
				.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(panel, GroupLayout.PREFERRED_SIZE, 370, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblListadoDeInformes, GroupLayout.PREFERRED_SIZE, 220, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_contentPane.createSequentialGroup()
								.addComponent(lblBienvenido, GroupLayout.PREFERRED_SIZE, 62, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.UNRELATED).addComponent(lblNombreUsuario,
										GroupLayout.PREFERRED_SIZE, 162, GroupLayout.PREFERRED_SIZE)))
				.addContainerGap(28, Short.MAX_VALUE)));
		gl_contentPane.setVerticalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup().addContainerGap()
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE).addComponent(lblBienvenido)
								.addComponent(lblNombreUsuario))
						.addPreferredGap(ComponentPlacement.UNRELATED).addComponent(lblListadoDeInformes).addGap(18)
						.addComponent(panel, GroupLayout.DEFAULT_SIZE, 264, Short.MAX_VALUE).addGap(20)));

		table = new JTable();
		table.setModel(new DefaultTableModel(
				new Object[][] { { null, null, null }, { null, null, null }, { null, null, null }, { null, null, null },
						{ null, null, null }, { null, null, null }, },
				new String[] { "New column", "New column", "New column" }));

		JCheckBox chkbxAutorizado = new JCheckBox("Autorizado");

		JCheckBox chkbxRevisado = new JCheckBox("Revisado");

		JLabel lblObservacin = new JLabel("Observaci\u00F3n");

		JScrollPane scrollPane = new JScrollPane();

		GroupLayout gl_panel = new GroupLayout(panel);
		JTextArea txtObservacion = new JTextArea();
		scrollPane.setViewportView(txtObservacion);
		panel.setLayout(gl_panel);
		contentPane.setLayout(gl_contentPane);

		JButton btnEmitirAIngeniero = new JButton("Emitir a ingeniero");
		btnEmitirAIngeniero.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int autorizado = ObtenerAutorizado();
				int revisado = ObtenerRevisado();
				String obs = txtObservacion.getText();

				try {
					DetalleEvaluación detalle = new DetalleEvaluación();
					detalle.setAutorizado(autorizado);
					detalle.setRevisado(revisado);
					detalle.setObservación(obs);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

			private int ObtenerAutorizado() {
				if (chkbxAutorizado.isSelected()) {
					return 1;
				}
				return 0;
			}

			private int ObtenerRevisado() {
				if (chkbxRevisado.isSelected()) {
					return 1;
				}
				return 0;
			}
		});

		gl_panel.setHorizontalGroup(gl_panel.createParallelGroup(Alignment.LEADING).addGroup(gl_panel
				.createSequentialGroup().addGap(24)
				.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(table, GroupLayout.PREFERRED_SIZE, 323, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_panel.createSequentialGroup()
								.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_panel.createSequentialGroup().addComponent(chkbxAutorizado)
												.addGap(12).addComponent(lblObservacin, GroupLayout.PREFERRED_SIZE, 71,
														GroupLayout.PREFERRED_SIZE))
										.addComponent(chkbxRevisado))
								.addPreferredGap(ComponentPlacement.RELATED).addComponent(scrollPane)))
				.addContainerGap(23, Short.MAX_VALUE))
				.addGroup(gl_panel.createSequentialGroup().addGap(129).addComponent(btnEmitirAIngeniero)
						.addContainerGap(152, Short.MAX_VALUE)));
		gl_panel.setVerticalGroup(gl_panel.createParallelGroup(Alignment.LEADING).addGroup(gl_panel
				.createSequentialGroup().addGap(23)
				.addComponent(table, GroupLayout.PREFERRED_SIZE, 107, GroupLayout.PREFERRED_SIZE).addGap(18)
				.addGroup(gl_panel.createParallelGroup(Alignment.LEADING, false)
						.addGroup(gl_panel.createSequentialGroup()
								.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE).addComponent(chkbxAutorizado)
										.addComponent(lblObservacin))
								.addGap(18).addComponent(chkbxRevisado))
						.addComponent(scrollPane))
				.addGap(18).addComponent(btnEmitirAIngeniero).addContainerGap(18, Short.MAX_VALUE)));
	}
}
