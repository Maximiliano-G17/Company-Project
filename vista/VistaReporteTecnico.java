package vista;


import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

import controlador.ControladorBotonesCapturista;
import modelo.ModeloConsultaTecnico;

public class VistaReporteTecnico extends JFrame {

	private JPanel contentPane;
	private ModeloConsultaTecnico tecnico;

	public VistaReporteTecnico() {
		tecnico = new ModeloConsultaTecnico();
		
		setBounds(400, 300, 454, 380);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel idCliente = new JLabel("Id cliente:");
		idCliente.setBounds(10, 11, 73, 14);
		contentPane.add(idCliente);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(10, 36, 73, 20);
		contentPane.add(comboBox);
		
		JLabel problema = new JLabel("Problema:");
		problema.setBounds(252, 11, 110, 14);
		contentPane.add(problema);
		
		JTextArea areaProblema = new JTextArea();
		areaProblema.setWrapStyleWord(true);
		areaProblema.setFont(new Font("Monospaced", Font.BOLD, 13));
		areaProblema.setEditable(false);
		areaProblema.setLineWrap(true);
		areaProblema.setBounds(252, 34, 172, 120);
		contentPane.add(areaProblema);
		
		JLabel lblSolucion = new JLabel("Solucion:");
		lblSolucion.setBounds(252, 192, 110, 14);
		contentPane.add(lblSolucion);
		
		JTextArea areaSolucion = new JTextArea();
		areaSolucion.setEditable(false);
		areaSolucion.setWrapStyleWord(true);
		areaSolucion.setLineWrap(true);
		areaSolucion.setBounds(252, 217, 176, 113);
		contentPane.add(areaSolucion);
		tecnico.MostrarId(comboBox);
		
		JButton btnMostrar = new JButton("mostrar");
		btnMostrar.addActionListener(new ControladorBotonesCapturista(comboBox, areaProblema, areaSolucion,"mostrarReporte",tecnico));
		btnMostrar.setBounds(77, 282, 89, 48);
		contentPane.add(btnMostrar);
	}
}
