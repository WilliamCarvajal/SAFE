package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;

public class MenuSupervisor extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuSupervisor frame = new MenuSupervisor();
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
	public MenuSupervisor() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 512, 300);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu mnCapacitaciones = new JMenu("Capacitaciones");
		menuBar.add(mnCapacitaciones);

		JMenuItem mntmNuevoPlan = new JMenuItem("Nuevo plan");
		mnCapacitaciones.add(mntmNuevoPlan);
		mntmNuevoPlan.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				RegistroPlanCapacitacion plan = new RegistroPlanCapacitacion();
				plan.setVisible(true);
			}
		});

		JMenuItem mntmMantenedor = new JMenuItem("Mantenedor");
		mnCapacitaciones.add(mntmMantenedor);
		mntmMantenedor.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				MantenedorCapacitacion cap = new MantenedorCapacitacion();
				cap.setVisible(true);
			}
		});

		JMenuItem mntmAsistencia = new JMenuItem("Asistencia");
		mnCapacitaciones.add(mntmAsistencia);

		JMenu mnCertificados = new JMenu("Certificados");
		menuBar.add(mnCertificados);

		JMenuItem mntmGenerarCertificados = new JMenuItem("Generar certificados");
		mnCertificados.add(mntmGenerarCertificados);
		mntmGenerarCertificados.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GenerarInforme info = new GenerarInforme();
				info.setVisible(true);
			}
		});

		JMenu mnEvaluaciones = new JMenu("Evaluaciones");
		menuBar.add(mnEvaluaciones);

		JMenuItem mntmPersonas = new JMenuItem("Personas");
		mnEvaluaciones.add(mntmPersonas);
		mntmPersonas.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				RedactarEvaluacionPersonas per = new RedactarEvaluacionPersonas();
				per.setVisible(true);
			}
		});

		JMenuItem mntmEmpresas = new JMenuItem("Empresas");
		mnEvaluaciones.add(mntmEmpresas);
		mntmEmpresas.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				RedactarEvaluacionEmpresa emp = new RedactarEvaluacionEmpresa();
				emp.setVisible(true);
			}
		});

		JMenu mnVisitasMdicas = new JMenu("Visitas m\u00E9dicas");
		menuBar.add(mnVisitasMdicas);

		JMenuItem mntmConsultarCalendario = new JMenuItem("Consultar calendario");
		mnVisitasMdicas.add(mntmConsultarCalendario);

		JMenuItem mntmAdministrarVisitas = new JMenuItem("Administrar visitas");
		mnVisitasMdicas.add(mntmAdministrarVisitas);

		JMenuItem mntmEnviarMailA = new JMenuItem("Enviar mail a m\u00E9dico");
		mnVisitasMdicas.add(mntmEnviarMailA);
		mntmEnviarMailA.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				EnviarMailVisMed mail = new EnviarMailVisMed();
				mail.setVisible(true);
			}
		});

		contentPane = new JPanel();
		contentPane.setBackground(new Color(51, 153, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblBienvenidoSupervisor = new JLabel("Bienvenido, supervisor");
		lblBienvenidoSupervisor.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblBienvenidoSupervisor.setBounds(173, 44, 140, 14);
		contentPane.add(lblBienvenidoSupervisor);

		JButton btnCerrarSesin = new JButton("Cerrar sesi\u00F3n");
		btnCerrarSesin.setBounds(190, 154, 116, 23);
		contentPane.add(btnCerrarSesin);
	}
}
