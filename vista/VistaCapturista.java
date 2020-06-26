package vista;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controlador.ControladorBotonesCapturista;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;

public class VistaCapturista extends JFrame {

	private JPanel contentPane;
	
	public VistaCapturista() {
		setTitle("Sesion capturista");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 660, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel titulo = new JLabel("BIENVENIDO");
		titulo.setFont(new Font("Tw Cen MT", Font.BOLD, 20));
		titulo.setHorizontalAlignment(SwingConstants.CENTER);
		titulo.setBounds(225, 11, 172, 41);
		contentPane.add(titulo);
		
		crearBoton("Registrar cliente","registrarCliente",42, 90, 166, 144);
			
		crearBoton("Gestionar cliente","gestionarCliente",232, 90, 166, 144);
		
		crearBoton("Reporte tecnico","capturistaReporte",422, 90, 165, 144);
	}
	
	public void crearBoton(String nombreBoton,String controlador,int x,int y,int ancho,int alto ){
		JButton boton = new JButton(nombreBoton);
		boton.addActionListener(new ControladorBotonesCapturista(controlador));
		boton.setBounds(x, y, ancho, alto);
		contentPane.add(boton);
	}
}