package vista;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import modelo.ModeloRegistroCliente;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;

public class ListaClientes extends JFrame {

	private JPanel contentPane;
	private ModeloRegistroCliente cliente;

	public ListaClientes() {
		setTitle("Lista clientes registrados");
		cliente =new ModeloRegistroCliente();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		cliente.mostrarClientes(contentPane);
			
		JLabel lblNewLabel = new JLabel("Clientes registrados");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblNewLabel, BorderLayout.NORTH);	
	}
}
