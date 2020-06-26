package vista;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controlador.ControladorVista;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPasswordField;

public class Vista extends JFrame {
	
	public static void main(String[] args) {
		Vista vista = new Vista();
		vista.setVisible(true);
	}
	
	public Vista() {
		setTitle("Inicio de sesion");
		setBounds(550, 300, 450, 300);
		JPanel laminaPrincipal = new JPanel();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		laminaPrincipal.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(laminaPrincipal);
		laminaPrincipal.setLayout(null);
					
		JLabel usuario = new JLabel("Usuario:");
		usuario.setBounds(187, 86, 83, 14);
		laminaPrincipal.add(usuario);
		
		JTextField usuarioT = new JTextField();
		usuarioT.setBounds(171, 108, 86, 20);
		laminaPrincipal.add(usuarioT);
		usuarioT.setColumns(10);
		
		JLabel contraseña = new JLabel("Contrasenia:");
		contraseña.setBounds(181, 139, 89, 14);
		laminaPrincipal.add(contraseña);
		
		JPasswordField contraseñaT = new JPasswordField();
		contraseñaT.setBounds(171, 164, 86, 20);
		laminaPrincipal.add(contraseñaT);
		
		JButton botonConectar = new JButton("Conectar");
		botonConectar.addActionListener(new ControladorVista(usuarioT,contraseñaT,this));
		botonConectar.setBounds(157, 227, 118, 23);
		laminaPrincipal.add(botonConectar);		
	}	
}