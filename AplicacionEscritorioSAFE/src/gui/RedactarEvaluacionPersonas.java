package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class RedactarEvaluacionPersonas extends JFrame {

	private JPanel contentPane;
	private JTextField txtTitulo;
	private JTextField txtAutor;
	private JTextField txtNomTrabajador;

	/**
	 * Launch the application.
	 * 
	 * @throws IOException
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RedactarEvaluacionPersonas frame = new RedactarEvaluacionPersonas();
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

	public RedactarEvaluacionPersonas() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 455, 371);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(51, 153, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblRedactarEvaluacin = new JLabel("Redactar Evaluaci\u00F3n a Trabajadores");
		lblRedactarEvaluacin.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblRedactarEvaluacin.setBounds(10, 11, 322, 16);
		contentPane.add(lblRedactarEvaluacin);

		JLabel lblTtulo = new JLabel("T\u00EDtulo:");
		lblTtulo.setBounds(20, 41, 46, 14);
		contentPane.add(lblTtulo);

		JLabel lblNewLabel = new JLabel("Cuerpo:");
		lblNewLabel.setBounds(20, 145, 46, 14);
		contentPane.add(lblNewLabel);

		txtTitulo = new JTextField();
		txtTitulo.setBounds(55, 38, 322, 20);
		contentPane.add(txtTitulo);
		txtTitulo.setColumns(10);

		JTextArea txtCuerpo = new JTextArea();
		txtCuerpo.setBounds(20, 170, 357, 122);
		contentPane.add(txtCuerpo);

		txtAutor = new JTextField();
		txtAutor.setBounds(55, 66, 322, 20);
		contentPane.add(txtAutor);
		txtAutor.setColumns(10);

		JLabel lblAutor = new JLabel("Autor:");
		lblAutor.setBounds(10, 66, 46, 14);
		contentPane.add(lblAutor);

		JButton btnGenerarPdf = new JButton("Generar PDF");
		btnGenerarPdf.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				Document document = new Document();

				try {
					PdfWriter.getInstance(document, new FileOutputStream("Informes/Evaluaciones Trabajadores/Informe "+txtNomTrabajador.getText()+".pdf"));

					document.open();
					Paragraph paragraph1 = new Paragraph();

					Paragraph paragraph2 = new Paragraph();

					paragraph2.setSpacingAfter(25);
					paragraph2.setSpacingBefore(25);
					paragraph2.setAlignment(Element.ALIGN_CENTER);
					paragraph2.setIndentationLeft(50);
					paragraph2.setIndentationRight(50);

					Paragraph paragraph3 = new Paragraph();
					Paragraph paragraph4 = new Paragraph();
					paragraph1.add(txtTitulo.getText());
					paragraph3.add("Autor: " + txtAutor.getText());
					paragraph4.add("Trabajador: " + txtNomTrabajador.getText());
					paragraph2.add(txtCuerpo.getText());

					document.add(paragraph1);
					document.add(paragraph3);
					document.add(paragraph4);
					document.add(paragraph2);
					document.close();

				} catch (DocumentException e) {
					e.printStackTrace();
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				}

			}

		});
		btnGenerarPdf.setBounds(248, 298, 129, 23);
		contentPane.add(btnGenerarPdf);

		JLabel lblNombreDeEmpresa = new JLabel("Nombre Trabajador");
		lblNombreDeEmpresa.setBounds(10, 107, 115, 14);
		contentPane.add(lblNombreDeEmpresa);

		txtNomTrabajador = new JTextField();
		txtNomTrabajador.setBounds(117, 104, 260, 20);
		contentPane.add(txtNomTrabajador);
		txtNomTrabajador.setColumns(10);
	}
}
