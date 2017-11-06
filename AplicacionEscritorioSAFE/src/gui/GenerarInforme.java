package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTextField;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.awt.event.ActionEvent;
import com.toedter.calendar.JCalendar;
import java.awt.Color;

public class GenerarInforme extends JFrame {

	private JPanel contentPane;
	private JTextField txtAlumno;
	private JTextField txtNombreCurso;
	private JTextField txtExpositor;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GenerarInforme frame = new GenerarInforme();
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
	public GenerarInforme() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 362);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(51, 153, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblGenerarInformes = new JLabel("Generar informes");
		lblGenerarInformes.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblGenerarInformes.setBounds(10, 11, 161, 24);
		contentPane.add(lblGenerarInformes);

		JLabel lblNombreDelCurso = new JLabel("Nombre del curso:");
		lblNombreDelCurso.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNombreDelCurso.setBounds(10, 103, 140, 14);
		contentPane.add(lblNombreDelCurso);

		JLabel lblDictadoEl = new JLabel("Fecha Curso");
		lblDictadoEl.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblDictadoEl.setBounds(28, 141, 84, 14);
		contentPane.add(lblDictadoEl);

		JLabel lblNombreDeAlumno = new JLabel("Nombre de alumno");
		lblNombreDeAlumno.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNombreDeAlumno.setBounds(10, 62, 124, 14);
		contentPane.add(lblNombreDeAlumno);

		txtAlumno = new JTextField();
		txtAlumno.setBounds(122, 59, 222, 20);
		contentPane.add(txtAlumno);
		txtAlumno.setColumns(10);

		txtNombreCurso = new JTextField();
		txtNombreCurso.setBounds(122, 100, 222, 20);
		contentPane.add(txtNombreCurso);
		txtNombreCurso.setColumns(10);

		JLabel lblExpositor = new JLabel("Expositor:");
		lblExpositor.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblExpositor.setBounds(28, 263, 69, 14);
		contentPane.add(lblExpositor);

		txtExpositor = new JTextField();
		txtExpositor.setBounds(122, 260, 222, 19);
		contentPane.add(txtExpositor);
		txtExpositor.setColumns(10);

		JCalendar calendar = new JCalendar();
		calendar.setBounds(132, 141, 161, 115);
		contentPane.add(calendar);

		JButton btnNewButton = new JButton("Generar Informe");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// Se crea un documento el cual contendrá toda la información
				Document document = new Document();

				try {
					// Se define una ruta para el archivo
					PdfWriter.getInstance(document, new FileOutputStream("results/InformeCapacitación.pdf"));
					// Se abre el documento para empezar a cargarle información
					document.open();
					// Los párrafos serán nuestra principal fuente de información
					Paragraph paragraph1 = new Paragraph();
					// Se define una alineación central
					paragraph1.setAlignment(Element.ALIGN_CENTER);
					Paragraph paragraph2 = new Paragraph();

					paragraph2.setSpacingAfter(25);
					paragraph2.setSpacingBefore(25);
					paragraph2.setAlignment(Element.ALIGN_CENTER);
					paragraph2.setIndentationLeft(50);
					paragraph2.setIndentationRight(50);

					Paragraph paragraph3 = new Paragraph();
					paragraph3.setAlignment(Element.ALIGN_CENTER);
					Paragraph paragraph4 = new Paragraph();
					paragraph4.setAlignment(Element.ALIGN_CENTER);

					// Se capturan los datos registrados
					paragraph2.add("Se hace entrega del certificado al alumno: " + txtAlumno.getText());
					paragraph1.add("Por haber dictado el curso de: " + txtNombreCurso.getText());

					paragraph3.add("Dictado por: " + txtExpositor.getText());
					paragraph4.add("En la fecha: " + calendar.getDate().toGMTString());

					// Se agregan finalmente los párrafos con información al documento
					document.add(paragraph2);
					document.add(paragraph1);
					document.add(paragraph3);
					document.add(paragraph4);
					// Se confirma que no se agregará más información al documento, por lo tanto se
					// cierra
					document.close();

					// En caso de haber errores se presentará un mensaje
				} catch (DocumentException e) {
					e.printStackTrace();
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				}

			}
		});
		btnNewButton.setBounds(38, 289, 140, 23);
		contentPane.add(btnNewButton);

		JButton btnVolver = new JButton("Volver");
		btnVolver.setBounds(271, 289, 89, 23);
		contentPane.add(btnVolver);

	}
}
