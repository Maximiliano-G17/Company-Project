package vista;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;

import modelo.ModeloRegistroUsuario;

public class ListaUsuarios extends JFrame {

	private JPanel contentPane;
	private ModeloRegistroUsuario modelo;
	
	public ListaUsuarios() {
		modelo=new ModeloRegistroUsuario();
		setTitle("Usuarios Registrados");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(200, 100, 600, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		modelo.mostrarEmpleados(contentPane);
		
		JLabel lblNewLabel = new JLabel("Usuarios registrados");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblNewLabel, BorderLayout.NORTH);	
	}
}