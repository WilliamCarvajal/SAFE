package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.JButton;

public class VerEvaluacion extends JFrame {

	private JPanel contentPane;
	private JTable tblVerEval;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VerEvaluacion frame = new VerEvaluacion();
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
	public VerEvaluacion() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 490, 346);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(51, 153, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblVerEvaluacio = new JLabel("Formulario de evaluaci\u00F3n");
		lblVerEvaluacio.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblVerEvaluacio.setBounds(10, 27, 252, 20);
		contentPane.add(lblVerEvaluacio);

		tblVerEval = new JTable();
		tblVerEval.setBounds(10, 51, 321, 208);
		contentPane.add(tblVerEval);

		JButton btnEnviarInform = new JButton("Enviar Informe");
		btnEnviarInform.setBounds(341, 93, 112, 23);
		contentPane.add(btnEnviarInform);

		JButton btnNewButton = new JButton("Volver a inicio");
		btnNewButton.setBounds(341, 157, 112, 23);
		contentPane.add(btnNewButton);
	}

}
