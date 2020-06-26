package vista;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controlador.ControladorBotonesAdmin;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;

public class VistaAdmin extends JFrame {

	private JPanel contentPane;
	
	public VistaAdmin() {
		setTitle("Sesion Administrador");	
		setBounds(500, 300, 689, 425);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
				
		JLabel bienvenido = new JLabel("BIENVENIDO!");
		bienvenido.setFont(new Font("Tw Cen MT", Font.BOLD, 29));
		bienvenido.setHorizontalAlignment(SwingConstants.CENTER);
		bienvenido.setBounds(165, 31, 304, 28);
		contentPane.add(bienvenido);
		
		crearBoton("Registrar","panelRegistrar",21, 113, 173, 76);
		
		crearBoton("Gestionar empleados","gestionarUsuario",469, 113, 166, 76);
		
		crearBoton("Panel capturista","panelCapturista",21, 255, 173, 76);
		
		crearBoton("Panel tecnico","panelTecnico",252, 255, 166, 76);
		
		crearBoton("Acerca de","acercaDe",469,255,166,76);
		
		crearBoton("S","salir",574,352,52,23);
	}
	
	public void crearBoton(String nombreBoton,String controlador,int x,int y,int ancho,int alto ){
		JButton boton = new JButton(nombreBoton);
		boton.addActionListener(new ControladorBotonesAdmin(controlador));
		boton.setBounds(x, y, ancho, alto);
		contentPane.add(boton);
	}
}