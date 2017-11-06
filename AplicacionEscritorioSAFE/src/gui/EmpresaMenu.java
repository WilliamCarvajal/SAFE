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
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class EmpresaMenu extends JFrame {

	private JPanel contentPane;
	private JTable tblEmpresa;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EmpresaMenu frame = new EmpresaMenu();
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
	public EmpresaMenu() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 549, 339);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(51, 153, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblMenDeEmpresa = new JLabel("Men\u00FA de empresa");
		lblMenDeEmpresa.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblMenDeEmpresa.setBounds(10, 11, 123, 30);
		contentPane.add(lblMenDeEmpresa);

		tblEmpresa = new JTable();
		tblEmpresa.setBounds(20, 52, 289, 209);
		contentPane.add(tblEmpresa);

		JButton btnAtencionesMdicas = new JButton("Atenciones m\u00E9dicas");
		btnAtencionesMdicas.setBounds(319, 88, 204, 23);
		contentPane.add(btnAtencionesMdicas);

		JButton btnNewButton = new JButton("Ex\u00E1menes\r\n de trabajadores");
		btnNewButton.setBounds(319, 159, 204, 40);
		contentPane.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("Ingresar Trabajador al sistema");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				EmpresaRegistroCuenta emp = new EmpresaRegistroCuenta();
				emp.setVisible(true);
			}
		});
		btnNewButton_1.setBounds(319, 122, 204, 23);
		contentPane.add(btnNewButton_1);
	}
}
