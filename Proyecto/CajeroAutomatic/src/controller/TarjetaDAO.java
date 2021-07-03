package controller;

import model.Tarjeta;

import java.sql.*;


public class TarjetaDAO {
	
private PreparedStatement objPreparacionComando;
private ResultSet objColocarResultado;
private Connection objConexionBD;

public Tarjeta consultarTarjeta(String idTarjeta) throws SQLException{
	
	objPreparacionComando=null;
	objColocarResultado=null;
	objConexionBD=null;
	// el interrogante significa que necesita un  valor
	String sqlBusqueda="select * from Tarjeta where idTarjeta=?";
	Tarjeta tarjeta=null;
	
	try{
		objConexionBD=Conexion.conectar();
		//toma el comando y lo ejecuta en sql
		objPreparacionComando=objConexionBD.prepareStatement(sqlBusqueda);
		objPreparacionComando.setString(1, idTarjeta);
		
		// retorna un objeto
		objColocarResultado=objPreparacionComando.executeQuery();
		
		if(objColocarResultado.next()){
			//obtengo todos los atributos de la tarjeta
			tarjeta=new Tarjeta(objColocarResultado.getString(1)
					,objColocarResultado.getString(2)
					,objColocarResultado.getString(3)
					,objColocarResultado.getDate(4)
					,objColocarResultado.getInt(5)
					,objColocarResultado.getInt(5)
					,objColocarResultado.getInt(6));
		}
	}
		catch(Exception e){
			e.getMessage();
			e.printStackTrace();
		}finally{
			if(objPreparacionComando !=null){
			objPreparacionComando.close();
			}
			if(objConexionBD != null){
			objConexionBD.close();
			}
		}
System.out.println(tarjeta);
	return tarjeta;
}		
public boolean ActualizarSaldo(int SaldoTotal,String idTarjeta) throws SQLException{
	objPreparacionComando=null;
	objConexionBD=null;
	int update=0;
	// el interrogante significa que necesita un  valor
	String sqlBusqueda="UPDATE Tarjeta set SaldoTotal=? where idTarjeta = ?";
	Tarjeta tarjeta=null;
	
	try{
		objConexionBD=Conexion.conectar();
		//toma el comando y lo ejecuta en sql
		objPreparacionComando=objConexionBD.prepareStatement(sqlBusqueda);
		objPreparacionComando.setInt(1, SaldoTotal);
		objPreparacionComando.setString(2,idTarjeta);
		// retorna un objeto
		update=objPreparacionComando.executeUpdate();
		
		objPreparacionComando.close();
		objConexionBD.close();
		
		if(update > 0){
		return true;
		}
		else{
		return false;
		}
	}
		catch(Exception e){
			e.getMessage();
			e.printStackTrace();
			return false;
		}finally{
			if(objPreparacionComando !=null){
			objPreparacionComando.close();
			}
			if(objConexionBD != null){
			objConexionBD.close();
			}
		}
}		

}
