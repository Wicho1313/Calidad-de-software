package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;



import model.Contrasena;
import model.Tarjeta;

public class ContrasenaDAO {
	private PreparedStatement objPreparacionComando;
	private ResultSet objColocarResultado;
	private Connection objConexionBD;

	public Contrasena consultarContrasena(String Contrasena, String idTarjeta) throws SQLException{
		
		objPreparacionComando=null;
		objColocarResultado=null;
		objConexionBD=null;
		// el interrogante significa que necesita un  valor
		String sqlBusqueda="select * from Contraseña where idTarjeta=?";
		Contrasena contrasena=null;
		
		try{
			objConexionBD=Conexion.conectar();
			//toma el comando y lo ejecuta en sql
			objPreparacionComando=objConexionBD.prepareStatement(sqlBusqueda);
			objPreparacionComando.setString(1, idTarjeta);
			
			// retorna un objeto
			objColocarResultado=objPreparacionComando.executeQuery();
			
			if(objColocarResultado.next()){
				//obtengo todos los atributos de la tarjeta
				contrasena=new Contrasena(objColocarResultado.getNString(1),objColocarResultado.getNString(2));
				if(contrasena.getContraseña().equals(Contrasena))
				{
					return contrasena;
				}else{
					return null;
				}
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

		return contrasena;
}
}
