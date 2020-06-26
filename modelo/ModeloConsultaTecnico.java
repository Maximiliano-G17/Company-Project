package modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

public class ModeloConsultaTecnico {
	
	private Connection conexion;
	private PreparedStatement pStatement;
	private Statement statement;
	private ResultSet miRs;
	
	public ModeloConsultaTecnico(){
		try{
			conexion=DriverManager.getConnection("jdbc:mysql://localhost:3306/empresa?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC&useSSL=false","root","");
			}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public void enviarProblema(JComboBox comboBox, JTextArea areaProblema,JTextArea areaSolucion) {
		// TODO Auto-generated method stub
		if(areaSolucion==null){
			System.out.println("El problema aun no fue solucionado, rellene el campo de la solucion");
		}else{
			try{
				pStatement=conexion.prepareStatement("INSERT INTO TECNICO (ID,PROBLEMA,SOLUCION) VALUES(?,?,?)");
	
				pStatement.setInt(1, comboBox.getSelectedIndex()+1);
				pStatement.setString(2, areaProblema.getText());
				pStatement.setString(3, areaSolucion.getText());
				
				pStatement.executeUpdate();
				
				JOptionPane.showMessageDialog(null, "Se ha registrado con exito la solucion!");
					
			}catch(Exception e){
				System.out.println(e.getMessage());		
				JOptionPane.showMessageDialog(null, "Ha ocurrido un error al momento de guardar la solucion!");
			}
		}		
	}	
	
	public void MostrarId(JComboBox comboBox) {
		try{
			statement=conexion.createStatement();
			miRs=statement.executeQuery("SELECT ID FROM TECNICO");
			while(miRs.next()){
				comboBox.addItem(miRs.getString(1));
			}			
		}catch(Exception e){
			e.printStackTrace();
		}		
	}
	
	public void mostrarErrorSolucion(JComboBox comboBox, JTextArea areaProblema,JTextArea areaSolucion) {
		String tablaSeleccionada=(String)comboBox.getSelectedItem();
		try{			
			miRs=statement.executeQuery("SELECT PROBLEMA,SOLUCION FROM TECNICO WHERE ID="+tablaSeleccionada);
			while(miRs.next()){
				areaProblema.setText(miRs.getString(1));
				areaSolucion.setText(miRs.getString(2));
			}		
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}