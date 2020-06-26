package vista;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controlador.ControladorBotonesCapturista;
import modelo.ModeloRegistroCliente;

import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.Font;

public class VistaGestionarProblema extends JFrame {

	private JPanel contentPane;
	private ModeloRegistroCliente cliente;
	
	public VistaGestionarProblema() {
		cliente=new ModeloRegistroCliente();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
		areaSolucion.setWrapStyleWord(true);
		areaSolucion.setLineWrap(true);
		areaSolucion.setBounds(252, 217, 176, 113);
		contentPane.add(areaSolucion);
		
		JButton btnEnviar = new JButton("Enviar");
		btnEnviar.addActionListener(new ControladorBotonesCapturista("enviarSolucion",contentPane,areaProblema,areaSolucion,comboBox));
		btnEnviar.setBounds(10, 282, 89, 48);
		contentPane.add(btnEnviar);
		cliente.gestionErrorMostrarId(comboBox);
		
		JButton btnMostrar = new JButton("mostrar");
		btnMostrar.addActionListener(new ControladorBotonesCapturista("mostrarProblema",comboBox,areaProblema,cliente));
		btnMostrar.setBounds(140, 282, 89, 48);
		contentPane.add(btnMostrar);
	}
}
