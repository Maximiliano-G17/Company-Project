package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import vista.VistaGestionarProblema;

public class ControladorBotonesTecnico implements ActionListener{
	
	private VistaGestionarProblema gProblema;

	public void actionPerformed(ActionEvent e) {	
		gProblema=new VistaGestionarProblema();
		gProblema.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		gProblema.setVisible(true);					
	}	
}