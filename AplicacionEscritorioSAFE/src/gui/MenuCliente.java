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

public class MenuCliente extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuCliente frame = new MenuCliente();
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
	public MenuCliente() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(51, 153, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblBienvenidocliente = new JLabel("Bienvenido,Cliente");
		lblBienvenidocliente.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblBienvenidocliente.setBounds(153, 44, 124, 25);
		contentPane.add(lblBienvenidocliente);

		JButton btnNewButton = new JButton("Ver calendario de visitas m\u00E9dicas");
		btnNewButton.setBounds(90, 80, 246, 31);
		contentPane.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("Generar certificados de asistencia");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GenerarInforme info = new GenerarInforme();
				info.setVisible(true);
			}
		});
		btnNewButton_1.setBounds(90, 122, 246, 31);
		contentPane.add(btnNewButton_1);

		JButton btnCerrarSesin = new JButton("Cerrar sesi\u00F3n");
		btnCerrarSesin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Home hom = new Home();
				hom.setVisible(true);
				dispose();
			}
		});
		btnCerrarSesin.setBounds(174, 197, 103, 23);
		contentPane.add(btnCerrarSesin);
	}
}
