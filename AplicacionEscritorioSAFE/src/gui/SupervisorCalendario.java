package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTable;
import com.toedter.calendar.JCalendar;
import javax.swing.JButton;

public class SupervisorCalendario extends JFrame {

	private JPanel contentPane;
	private JTable tblCapacitacion;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SupervisorCalendario frame = new SupervisorCalendario();
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
	public SupervisorCalendario() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 601, 380);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(51, 153, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblCalendarioDeCapacitaciones = new JLabel("Calendario de capacitaciones");
		lblCalendarioDeCapacitaciones.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblCalendarioDeCapacitaciones.setBounds(10, 33, 188, 14);
		contentPane.add(lblCalendarioDeCapacitaciones);

		tblCapacitacion = new JTable();
		tblCapacitacion.setBounds(20, 58, 368, 206);
		contentPane.add(tblCapacitacion);

		JCalendar calendar = new JCalendar();
		calendar.setBounds(422, 58, 160, 134);
		contentPane.add(calendar);

		JButton btnSubirArchivoxls = new JButton("Subir archivo .xls");
		btnSubirArchivoxls.setBounds(420, 203, 155, 23);
		contentPane.add(btnSubirArchivoxls);

		JButton btnVolverAInicio = new JButton("Volver a inicio");
		btnVolverAInicio.setBounds(266, 295, 111, 23);
		contentPane.add(btnVolverAInicio);
	}
}
