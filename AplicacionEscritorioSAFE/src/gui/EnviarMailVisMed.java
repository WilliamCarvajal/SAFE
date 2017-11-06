package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.util.Properties;
import java.awt.event.ActionEvent;

public class EnviarMailVisMed extends JFrame {

	private JPanel contentPane;
	private JTextField txtDestinatario;
	private JTextField txtAsunto;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EnviarMailVisMed frame = new EnviarMailVisMed();
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
	public EnviarMailVisMed() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 320);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(51, 153, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblRedactarMailPara = new JLabel("Redactar mail para visita m\u00E9dica");
		lblRedactarMailPara.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblRedactarMailPara.setBounds(10, 11, 245, 14);
		contentPane.add(lblRedactarMailPara);

		JLabel lblDestinatario = new JLabel("Destinatario:");
		lblDestinatario.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblDestinatario.setBounds(10, 52, 90, 14);
		contentPane.add(lblDestinatario);

		JLabel lblAsunto = new JLabel("Asunto:");
		lblAsunto.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblAsunto.setBounds(10, 77, 67, 14);
		contentPane.add(lblAsunto);

		JLabel lblMensaje = new JLabel("Mensaje:");
		lblMensaje.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblMensaje.setBounds(10, 113, 67, 14);
		contentPane.add(lblMensaje);

		txtDestinatario = new JTextField();
		txtDestinatario.setBounds(87, 49, 306, 20);
		contentPane.add(txtDestinatario);
		txtDestinatario.setColumns(10);

		txtAsunto = new JTextField();
		txtAsunto.setBounds(87, 74, 306, 20);
		contentPane.add(txtAsunto);
		txtAsunto.setColumns(10);

		JTextArea txtMensaje = new JTextArea();
		txtMensaje.setBounds(10, 134, 383, 79);
		contentPane.add(txtMensaje);

		JButton btnEnviarCorreo = new JButton("Enviar correo");
		btnEnviarCorreo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String username = "safesolutiontest@gmail.com";
				String password = "safetest123";

				Properties props = new Properties();
				props.put("mail.smtp.auth", "true");
				props.put("mail.smtp.starttls.enable", "true");
				props.put("mail.smtp.host", "smtp.gmail.com");
				props.put("mail.smtp.port", "587");

				Session session = Session.getInstance(props, new javax.mail.Authenticator() {
					protected PasswordAuthentication getPasswordAuthentication() {
						return new PasswordAuthentication(username, password);
					}
				});

				try {

					Message message = new MimeMessage(session);
					message.setFrom(new InternetAddress("safesolutionsafe@gmail.com"));
					message.setRecipients(Message.RecipientType.TO,
							InternetAddress.parse(txtDestinatario.getText().trim()));
					message.setSubject(txtAsunto.getText().trim());
					message.setText(txtMensaje.getText());

					Transport.send(message);

					JOptionPane.showMessageDialog(null, "Correo enviado con éxito");

				} catch (MessagingException e) {
					throw new RuntimeException(e);

				}

			}
		});
		btnEnviarCorreo.setBounds(10, 236, 125, 23);
		contentPane.add(btnEnviarCorreo);

		JButton btnVolver = new JButton("Volver");
		btnVolver.setBounds(293, 236, 100, 23);
		contentPane.add(btnVolver);
	}
}
