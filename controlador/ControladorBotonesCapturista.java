package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import modelo.ModeloConsultaTecnico;
import modelo.ModeloRegistroCliente;
import vista.ListaClientes;
import vista.VistaRegistraCliente;
import vista.VistaReporteTecnico;

public class ControladorBotonesCapturista implements ActionListener{

	private ModeloConsultaTecnico tecnicoModelo;
	private VistaReporteTecnico tecnicoReporte;
	private JComboBox comboBox;
	private JTextArea areaProblema;
	private JTextArea areaSolucion;
	private String s;
	private JPanel contentPane, laminaPrincipal;
	private ModeloRegistroCliente cliente;
	private ListaClientes lClientes;
	private VistaRegistraCliente rCliente;
	private JTextField nombreT, emailT, telefonoT,direccionT;
	private JTextArea textArea;
	
	public ControladorBotonesCapturista(String s){
		this.s=s;
	}
	
	public ControladorBotonesCapturista(JComboBox comboBox, JTextArea areaProblema,JTextArea areaSolucion,String s,ModeloConsultaTecnico tecnicoModelo){
		this.comboBox=comboBox;
		this.areaProblema=areaProblema;
		this.areaSolucion=areaSolucion;
		this.s=s;
		this.tecnicoModelo=tecnicoModelo;
	}
	
	public ControladorBotonesCapturista(String s,JComboBox comboBox,JTextArea areaProblema,ModeloRegistroCliente cliente){
		this.s=s;
		this.areaProblema=areaProblema;
		this.comboBox=comboBox;
		this.cliente=cliente;
	}
	
	public ControladorBotonesCapturista(String s,JPanel contentPane, JTextArea areaProblema,JTextArea areaSolucion,JComboBox comboBox){
		this.s=s;
		this.contentPane=contentPane;
		this.areaProblema=areaProblema;
		this.areaSolucion=areaSolucion;
		this.comboBox=comboBox;
	}
		
	public ControladorBotonesCapturista(String s, JTextField nombreT, JTextField emailT, JTextField telefonoT,
			JTextField direccionT, JTextArea textArea,JPanel laminaPrincipal) {
		this.s=s;
		this.nombreT=nombreT;
		this.emailT=emailT;
		this.telefonoT=telefonoT;
		this.direccionT=direccionT;
		this.textArea=textArea;
		this.laminaPrincipal=laminaPrincipal;
	}

	public void actionPerformed(ActionEvent e) {
		if(s.equalsIgnoreCase("mostrarReporte")){//se encuentra en la VistaReporteTecnico
			tecnicoModelo.mostrarErrorSolucion(comboBox, areaProblema, areaSolucion);
		}else if(s.equalsIgnoreCase("capturistaReporte")){//se encuentra en la clase VistaCapturista
			tecnicoReporte=new VistaReporteTecnico();
			tecnicoReporte.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			tecnicoReporte.setVisible(true);
		}else if(s.equalsIgnoreCase("enviarSolucion")){//se encuentra en la clase VistaGestionarProblema
			tecnicoModelo=new ModeloConsultaTecnico();
			tecnicoModelo.enviarProblema(comboBox,areaProblema,areaSolucion);
			contentPane=new JPanel();
			contentPane.setVisible(false);
		}else if(s.equalsIgnoreCase("mostrarProblema")){//se encuentra en la clase VistaGestionarProblema
			cliente.gestionErrorMostrarError(comboBox,areaProblema);
		}else if(s.equalsIgnoreCase("gestionarCliente")){//se encuentra en la clase VistaCapturista
			lClientes=new ListaClientes();
			lClientes.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			lClientes.setVisible(true);
		}else if(s.equalsIgnoreCase("registrarCliente")){//se encuentra en la clase VistaCapturista
			rCliente=new VistaRegistraCliente();
			rCliente.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			rCliente.setVisible(true);
		}else if(s.equalsIgnoreCase("crearCliente")){//se encuentra en la clase VistaRegistraCliente
			cliente=new ModeloRegistroCliente();
			cliente.registrarCliente(nombreT.getText(), emailT.getText(), telefonoT.getText(), direccionT.getText(),textArea.getText());
			laminaPrincipal.setVisible(false);
		}
	}
}