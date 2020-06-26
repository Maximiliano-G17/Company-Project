package vista;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controlador.ControladorBotonesAdmin;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.Font;

public class VistaRegistrarUsuario extends JFrame {

	private JPanel contentPane;
	private JTextField dniT;
	private JTextField nombreT;
	private JPasswordField contraT;
	private JComboBox comboBox;
		
	public VistaRegistrarUsuario() {
		setTitle("Registrar nuevo usuario");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 553, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel dni = new JLabel("DNI:");
		dni.setVerticalAlignment(SwingConstants.BOTTOM);
		dni.setBounds(10, 65, 86, 14);
		contentPane.add(dni);
		
		dniT = new JTextField();
		dniT.setBounds(10, 85, 131, 20);
		contentPane.add(dniT);
		dniT.setColumns(10);
		
		JLabel nombre = new JLabel("NOMBRE:");
		nombre.setBounds(10, 120, 86, 14);
		contentPane.add(nombre);
		
		nombreT = new JTextField();
		nombreT.setBounds(10, 140, 131, 20);
		contentPane.add(nombreT);
		nombreT.setColumns(10);
		
		JLabel lblRegistrarUsuario = new JLabel("REGISTRAR USUARIO");
		lblRegistrarUsuario.setFont(new Font("Sitka Small", Font.BOLD | Font.ITALIC, 20));
		lblRegistrarUsuario.setHorizontalAlignment(SwingConstants.CENTER);
		lblRegistrarUsuario.setBounds(135, 11, 287, 14);
		contentPane.add(lblRegistrarUsuario);
		
		JLabel contra = new JLabel("CONTRASENIA:");
		contra.setBounds(10, 175, 86, 14);
		contentPane.add(contra);
		
		contraT = new JPasswordField();
		contraT.setBounds(10, 195, 131, 20);
		contentPane.add(contraT);
		
		comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"ADMIN", "CAPTURISTA", "TECNICO"}));
		comboBox.setBounds(336, 140, 138, 20);
		contentPane.add(comboBox);
		
		JButton botonRegistrar = new JButton("Registrar");
		botonRegistrar.addActionListener(new ControladorBotonesAdmin("registrarUsuario",comboBox,dniT,nombreT,contraT,this));
		botonRegistrar.setBounds(191, 291, 131, 40);
		contentPane.add(botonRegistrar);	
		
		JLabel lblCargo = new JLabel("CARGO:");
		lblCargo.setBounds(336, 120, 46, 14);
		contentPane.add(lblCargo);		
	}	
}
