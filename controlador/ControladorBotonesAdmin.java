package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import modelo.ModeloRegistroUsuario;
import vista.ListaUsuarios;
import vista.VistaCapturista;
import vista.VistaRegistrarUsuario;
import vista.VistaTecnico;

public class ControladorBotonesAdmin implements ActionListener{
	
	private VistaRegistrarUsuario vRUsuario;
	private ListaUsuarios lUsuarios;
	private VistaCapturista capturista;
	private VistaTecnico tecnico;
	private ModeloRegistroUsuario modelo;
	private String s;
	private JComboBox comboBox;
	private JTextField dniT,nombreT,contraT;
	
	public ControladorBotonesAdmin(String s){
		this.s=s;
	}
	public ControladorBotonesAdmin(String s,JComboBox comboBox,JTextField dniT,JTextField nombreT,JTextField contraT,VistaRegistrarUsuario vRUsuario){
		this.s=s;
		this.comboBox=comboBox;
		this.dniT=dniT;
		this.nombreT=nombreT;
		this.contraT=contraT;
		this.vRUsuario=vRUsuario;
	}
	
	public void actionPerformed(ActionEvent e) {
		if(s.equalsIgnoreCase("registrarUsuario")){
			modelo=new ModeloRegistroUsuario();
			String combo=(String)comboBox.getSelectedItem();
			modelo.registrarUsuario(dniT.getText(),nombreT.getText(),contraT.getText(),combo);
			vRUsuario.setVisible(false);
		}else if(s.equalsIgnoreCase("panelRegistrar")){
			vRUsuario=new VistaRegistrarUsuario();
			vRUsuario.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			vRUsuario.setVisible(true);
		}else if(s.equalsIgnoreCase("gestionarUsuario")){
			lUsuarios=new ListaUsuarios();
			lUsuarios.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			lUsuarios.setVisible(true);
		}else if(s.equalsIgnoreCase("panelCapturista")){
			capturista=new VistaCapturista();
			capturista.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			capturista.setVisible(true);
		}else if(s.equalsIgnoreCase("panelTecnico")){
			tecnico=new VistaTecnico();
			tecnico.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			tecnico.setVisible(true);
		}else if(s.equalsIgnoreCase("acercaDe")){
			JOptionPane.showMessageDialog(null, "ACA TENDRIA QUE IR ALGO");
		}else{
			System.exit(0);
		}
	}
}