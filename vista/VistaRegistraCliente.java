package vista;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controlador.ControladorBotonesCapturista;
import modelo.ModeloRegistroCliente;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextArea;

public class VistaRegistraCliente extends JFrame {

	private JPanel laminaPrincipal;
	private JTextField nombreT;
	private JTextField emailT;
	private JTextField telefonoT;
	private JTextField direccionT;
	
	
	public VistaRegistraCliente() {
		setTitle("Registro de cliente");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 703, 431);
		laminaPrincipal = new JPanel();
		laminaPrincipal.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(laminaPrincipal);
		laminaPrincipal.setLayout(null);
		
		JLabel nombre = new JLabel("Nombre:");
		nombre.setBounds(10, 48, 86, 14);
		laminaPrincipal.add(nombre);
		
		nombreT = new JTextField();
		nombreT.setBounds(10, 66, 86, 20);
		laminaPrincipal.add(nombreT);
		nombreT.setColumns(10);
		
		JLabel email = new JLabel("Email:");
		email.setBounds(10, 109, 86, 14);
		laminaPrincipal.add(email);
		
		emailT = new JTextField();
		emailT.setBounds(10, 127, 86, 20);
		laminaPrincipal.add(emailT);
		emailT.setColumns(10);
		
		JLabel telefono = new JLabel("Telefono:");
		telefono.setBounds(10, 174, 86, 14);
		laminaPrincipal.add(telefono);
		
		telefonoT = new JTextField();
		telefonoT.setBounds(10, 192, 86, 20);
		laminaPrincipal.add(telefonoT);
		telefonoT.setColumns(10);
		
		JLabel direccion = new JLabel("Direccion:");
		direccion.setBounds(10, 236, 86, 14);
		laminaPrincipal.add(direccion);
		
		direccionT = new JTextField();
		direccionT.setBounds(10, 254, 86, 20);
		laminaPrincipal.add(direccionT);
		direccionT.setColumns(10);
		
		JTextArea textArea = new JTextArea();
		textArea.setLineWrap(true);
		textArea.setBounds(375, 92, 302, 153);
		laminaPrincipal.add(textArea);
		
		JButton botonRegistrar = new JButton("Registrar");
		botonRegistrar.addActionListener(new ControladorBotonesCapturista("crearCliente",nombreT,emailT,telefonoT,direccionT,textArea,laminaPrincipal));
		botonRegistrar.setBounds(238, 325, 108, 56);
		laminaPrincipal.add(botonRegistrar);
		
		JLabel lblNewLabel_4 = new JLabel("Registro de cliente");
		lblNewLabel_4.setFont(new Font("Sitka Small", Font.BOLD, 20));
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setBounds(92, 11, 267, 31);
		laminaPrincipal.add(lblNewLabel_4);
		
		JLabel descripcion = new JLabel("Descripcion del error:");
		descripcion.setBounds(374, 69, 182, 14);
		laminaPrincipal.add(descripcion);
	}
}
