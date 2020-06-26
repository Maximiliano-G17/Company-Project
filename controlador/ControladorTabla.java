package controlador;

/**
 * Class que sirve para obtener las filas(row) y las columnas
 */

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import javax.swing.table.AbstractTableModel;

public class ControladorTabla extends AbstractTableModel{
	private ResultSet rsRegistro;
	private ResultSetMetaData rsMetaData;
		
	public ControladorTabla(ResultSet rsRegistro){
		this.rsRegistro=rsRegistro;
		try {
			rsMetaData=rsRegistro.getMetaData();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public ControladorTabla(){
	}
	
	//sirve para obtener todo los datos de la bbdd
	public void ResultSetModeloTabla(){
		try {
			rsMetaData=rsRegistro.getMetaData();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
// obtengo el total de columnas de la base de dato
	public int getColumnCount() {
		try {
			return rsMetaData.getColumnCount();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}
	}
//obtengo el total de filas
	public int getRowCount() {
		try {
			rsRegistro.last();
			return rsRegistro.getRow();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}		
	}
	
	public String getColumnName(int c){
		
		try {
			return rsMetaData.getColumnName(c+1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "";
		}
	}

	public Object getValueAt(int arg0, int arg1) {
		try{
			rsRegistro.absolute(arg0+1);
			
			return rsRegistro.getObject(arg1 +1);
			
		}catch(Exception e){
			e.printStackTrace();
			return 0;
		}
	}	
}