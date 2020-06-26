package vista;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controlador.ControladorBotonesTecnico;

import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;

public class VistaTecnico extends JFrame {

	private JPanel contentPane;
	
	public VistaTecnico() {
		setTitle("Panel de tecnico");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton botonGestion = new JButton("Gestion de error");
		botonGestion.addActionListener(new ControladorBotonesTecnico());
		botonGestion.setBounds(88, 84, 234, 105);
		contentPane.add(botonGestion);
		
		JLabel lblNewLabel = new JLabel("Bienvenido!");
		lblNewLabel.setFont(new Font("Eras Demi ITC", Font.BOLD, 20));
		lblNewLabel.setBounds(131, 11, 180, 27);
		contentPane.add(lblNewLabel);
	}
}
