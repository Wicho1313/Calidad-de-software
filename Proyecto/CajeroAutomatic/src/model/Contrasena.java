package model;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.ContrasenaDAO;


@WebServlet("/Contrasena") 

public class Contrasena extends HttpServlet{
	private String idTarjeta;
	private String Contrasena;
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//getServletContext().getRequestDispatcher("/jsp/index.jsp").forward(request, response);
	System.out.print("LLEGO");
	}
//necesario para conectar el servlet de tarjeta con la clase tarjeta
public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	// Obtenemos un objeto Print Writer para enviar respuesta
	System.out.print("LLEGO");
	HttpSession session = req.getSession(true); 
	//es necesario traer los parametros req y res estos son los que consultan y traen la info de jsp al servlet
	this.ValidarContraseña(req,res,req.getParameter("Contrasena"),session);
	
	
}	

public Contrasena(String idTarjeta, String contrasena) {
	this.Contrasena = idTarjeta;
	idTarjeta = idTarjeta;
	
	// TODO Auto-generated constructor stub
}
public Contrasena()
{
	System.out.print("LLEGO");
}
public Tarjeta ValidarContraseña(HttpServletRequest req,HttpServletResponse res,String contrasena,HttpSession session){
	ContrasenaDAO td=new ContrasenaDAO();
	String idTarjeta =  (String) session.getAttribute("idTarjeta");
	try{
		
	if(td.consultarContrasena(contrasena,idTarjeta) != null){
	 
	 System.out.println("Se encontro");
	 // redirecciona
	 req.getRequestDispatcher("/Recibo.jsp").forward(req, res);;
	 
	}else{
			 
	 System.out.println("no se encontro");
	 int contador = 0;
	 if(contador<=2){
	 req.getRequestDispatcher("/contrasena.jsp").forward(req, res);;
	 contador++;
	 }else{
		 req.getRequestDispatcher("/ContraseñaIncorrecta.jsp").forward(req, res);;
	 }
			
	}
	}catch(Exception e){
		e.printStackTrace();
		String s="error";
		return null;
	}
	return null;
}
	
	
	
	
	
	
	
	
	
	public String getIdTarjeta() {
		return idTarjeta;
	}
	public void setIdTarjeta(String idTarjeta) {
		this.idTarjeta = idTarjeta;
	}
	public String getContraseña() {
		return Contrasena;
	}
	public void setContraseña(String contraseña) {
		Contrasena = contraseña;
	}
}
