package modelo;
import java.awt.BorderLayout;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import controlador.ControladorTabla;
import vista.Vista;
import vista.VistaRegistrarUsuario;

public class ModeloRegistroUsuario {
	
	private Connection conexion;
	private PreparedStatement pStatement;
	private Statement statement;
	private ResultSet miRs;
	private DatabaseMetaData datosBBDD;
	private JTable tabla;
	private JScrollPane x;
	private Vista vista;
	
	public ModeloRegistroUsuario(){
		vista = new Vista();
		try{
			conexion=DriverManager.getConnection("jdbc:mysql://localhost:3306/empresa?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC&useSSL=false","root","");
			datosBBDD=conexion.getMetaData();
			miRs=datosBBDD.getTables("empresa", null, null, null);
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	public String login(String name, String psw) {
		String cargo="";
		try{
			pStatement=conexion.prepareStatement("SELECT CARGO FROM EMPLEADOS WHERE NOMBRE=? AND CONTRA=?");

			pStatement.setString(1, name);
			pStatement.setString(2, psw);
			miRs=pStatement.executeQuery();
			
			while(miRs.next()){
				cargo=miRs.getString(1);
			}
			
			return cargo;
				
		}catch(Exception e){
			System.out.println(e.getMessage());				
		}
		return "";
	}
	
	public void registrarUsuario(String dni,String name,String contra,String combo){
		if(dni==null || name==null || contra==null ||combo==null){
			JOptionPane.showMessageDialog(null, "Ha ocurrido un error al momento de registrar la persona!, todos los campos tienen que estar llenos");
		}else {
			try{
				pStatement=conexion.prepareStatement("INSERT INTO EMPLEADOS (DNI,NOMBRE,CONTRA,CARGO) VALUES(?,?,?,?)");
	
				pStatement.setString(1, dni);
				pStatement.setString(2, name);
				pStatement.setString(3, contra);
				pStatement.setString(4, combo);
				
				pStatement.executeUpdate();
				
				JOptionPane.showMessageDialog(null, "Se ha registrado con exito!");
			}catch(Exception e){
				System.out.println(e.getMessage());		
				JOptionPane.showMessageDialog(null, "Ha ocurrido un error al momento de registrar la persona!, todos los campos tienen que estar llenos");
			}
		}		
	}
	
	public void mostrarEmpleados(JPanel contentPane){
		try{
			statement=conexion.createStatement();
			miRs=statement.executeQuery("SELECT * FROM EMPLEADOS");
			
			//creo un jtable para mostrar los datos
			tabla=new JTable(new ControladorTabla(miRs));
			x=new JScrollPane(tabla);
			contentPane.add(x,BorderLayout.CENTER);
			contentPane.validate();			
		}catch(Exception e){
			System.out.println(e.getMessage());		
		}
	}
}