package modelo;

import java.awt.BorderLayout;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;

import controlador.ControladorTabla;
import vista.Vista;

public class ModeloRegistroCliente {
	
	private Connection conexion;
	private PreparedStatement pStatement;
	private Statement statement;
	private ResultSet miRs;
	private JTable tabla;
	private JScrollPane x;
	private Vista vista;
	
	public ModeloRegistroCliente(){
		try{
			conexion=DriverManager.getConnection("jdbc:mysql://localhost:3306/empresa?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC&useSSL=false","root","");
			}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public void registrarCliente(String nombreT,String emailT,String telefonoT,String direccionT,String texto){
		if(nombreT==null || emailT==null || telefonoT==null ||direccionT==null ||texto==null){
			JOptionPane.showMessageDialog(null, "Ha ocurrido un error al momento de registrar la persona!, todos los campos tienen que estar llenos");
		}else {
			try{
				pStatement=conexion.prepareStatement("INSERT INTO CLIENTES (NOMBRE,EMAIL,TELEFONO,DIRECCION,DESCRIPCION) VALUES(?,?,?,?,?)");
	
				pStatement.setString(1, nombreT);
				pStatement.setString(2, emailT);
				pStatement.setString(3, telefonoT);
				pStatement.setString(4, direccionT);
				pStatement.setString(5, texto);
				
				pStatement.executeUpdate();
				
				JOptionPane.showMessageDialog(null, "Se ha registrado con exito!");
					
			}catch(SQLException e){
				System.out.println(e.getMessage());		
				JOptionPane.showMessageDialog(null, "Ha ocurrido un error al momento de registrar al cliente!");
			}
		}		
	}
	
	public void mostrarClientes(JPanel contentPane){	
		try{
			statement=conexion.createStatement();
			miRs=statement.executeQuery("SELECT * FROM CLIENTES");
			
			//creo un jtable para mostrar los datos
			tabla=new JTable(new ControladorTabla(miRs));
			x=new JScrollPane(tabla);
			contentPane.add(x,BorderLayout.CENTER);
			contentPane.validate();			
		}catch(Exception e){
			System.out.println(e.getMessage());		
		}
	}

	public void gestionErrorMostrarError(JComboBox comboBox, JTextArea areaProblema) {
		String tablaSeleccionada=(String)comboBox.getSelectedItem();
		try{			
			miRs=statement.executeQuery("SELECT DESCRIPCION FROM CLIENTES WHERE ID="+tablaSeleccionada);
			while(miRs.next()){
				areaProblema.setText(miRs.getString(1));
			}		
		}catch(SQLException e){
			e.printStackTrace();
		}
	}
	
	public void gestionErrorMostrarId(JComboBox comboBox) {
		try{
			statement=conexion.createStatement();
			miRs=statement.executeQuery("SELECT ID FROM CLIENTES");
			while(miRs.next()){
				comboBox.addItem(miRs.getString(1));
			}			
		}catch(SQLException e){
			e.printStackTrace();
		}		
	}	
}