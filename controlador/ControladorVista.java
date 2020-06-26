package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import modelo.ModeloRegistroUsuario;
import vista.VistaAdmin;
import vista.VistaCapturista;
import vista.VistaTecnico;

public class ControladorVista implements ActionListener{
	
	private ModeloRegistroUsuario modelo;
	private VistaCapturista capturista;
	private VistaTecnico tecnico;
	private JTextField usuarioT;
	private JPasswordField contraseñaT;
	private JFrame laminaPrincipal;
	
	public ControladorVista(JTextField usuarioT, JPasswordField contraseñaT,JFrame laminaPrincipal){
		this.usuarioT=usuarioT;
		this.contraseñaT=contraseñaT;
		this.laminaPrincipal=laminaPrincipal;
	}

	public void actionPerformed(ActionEvent e) {
		modelo=new ModeloRegistroUsuario();
		String name=usuarioT.getText();
		String psw=contraseñaT.getText();
		String login=modelo.login(name,psw);
		if(name.equals("") || psw.equals("")){
			JOptionPane.showMessageDialog(null, "Rellene todos los campos");
		}else if(login.equalsIgnoreCase("admin")){
			laminaPrincipal.setVisible(false);
			VistaAdmin v=new VistaAdmin();
			v.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			v.setVisible(true);
		}else if(login.equalsIgnoreCase("capturista")){
			laminaPrincipal.setVisible(false);
			capturista=new VistaCapturista();
			capturista.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			capturista.setVisible(true);
		}else if(login.equalsIgnoreCase("tecnico")){
			laminaPrincipal.setVisible(false);
			tecnico=new VistaTecnico();
			tecnico.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			tecnico.setVisible(true);
		}else{
			JOptionPane.showMessageDialog(null, "Usuario o contraseña incorrecta");
		}		
	}
}