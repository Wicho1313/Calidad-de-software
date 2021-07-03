package model;
import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.*;
//necesario para conectar el servlet de tarjeta con la clase tarjeta
@WebServlet("/Tarjeta")

//la clase se instancia a httpServlet
public class Tarjeta extends HttpServlet{
//atributos de la clase tarjeta
private String idTarjeta;
private String BancoAfiliado;
private String NombreUsuario;
private Date FechaAfiliacion;
private int SaldoTotal;
private int CuentaAhorro;
private int CuentaCorriente;


public Tarjeta() {
}
//necesario para conectar el servlet de tarjeta con la clase tarjeta
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
	this.ValidarTarjeta(req,res,req.getParameter("numero"),session);
	
	
}
// me trae todos los atributos que tiene la clase tarjeta , objetos
public Tarjeta(String idTarjeta, String bancoAfiliado, String nombreUsuario,
		Date fechaAfiliacion, int saldoTotal , int cuentaAhorro,int cuentaCorriente) {
	this.idTarjeta = idTarjeta;
	 
	BancoAfiliado = bancoAfiliado;
	NombreUsuario = nombreUsuario;
	FechaAfiliacion = fechaAfiliacion;
	SaldoTotal = saldoTotal;
	CuentaAhorro = cuentaAhorro;
	CuentaCorriente = cuentaCorriente;

	
}

// metodo validar tarjeta con los requerimientos del servlet y el valor que le llega del jsp
public Tarjeta ValidarTarjeta(HttpServletRequest req,HttpServletResponse res,String numeroTarjeta, HttpSession session){
	TarjetaDAO td=new TarjetaDAO();
	session.setAttribute("idTarjeta", numeroTarjeta);
	try{
	if(td.consultarTarjeta(numeroTarjeta) != null){
	 
	 System.out.println("Se encontro");
	 // redirecciona
	 req.getRequestDispatcher("/TipodeCuenta.jsp").forward(req, res);;
	 
	}else{
			 
	 System.out.println("no se encontro");
	 req.getRequestDispatcher("/Tarjetanoencontrada.jsp").forward(req, res);;
			 
			
	}
	}catch(Exception e){
		e.printStackTrace();
		String s="error";
		return null;
	}
	return null;
}
public boolean ActualizarSaldo (){
	TarjetaDAO td= new TarjetaDAO ();
	String s;
	try{
		
		SaldoTotal = SaldoTotal - 100 ;
		if(td.ActualizarSaldo(SaldoTotal, this.idTarjeta)){
			System.out.println(SaldoTotal);
			return true;
		}else{
			return false;
		}
	} catch(Exception e){
		e.printStackTrace();
		return false;
	}
}

//getters and setters
public String getIdTarjeta() {
	return idTarjeta;
}
public void setIdTarjeta(String idTarjeta) {
	this.idTarjeta = idTarjeta;
}
public String getBancoAfiliado() {
	return BancoAfiliado;
}
public void setBancoAfiliado(String bancoAfiliado) {
	BancoAfiliado = bancoAfiliado;
}
public String getNombreUsuario() {
	return NombreUsuario;
}
public void setNombreUsuario(String nombreUsuario) {
	NombreUsuario = nombreUsuario;
}
public Date getFechaAfiliacion() {
	return FechaAfiliacion;
}
public void setFechaAfiliacion(Date fechaAfiliacion) {
	FechaAfiliacion = fechaAfiliacion;
}
public int getSaldoTotal() {
	return SaldoTotal;
}
public void setSaldoTotal(int saldoTotal) {
	SaldoTotal = saldoTotal;
}
public int getCuentaAhorro() {
	return CuentaAhorro;
}
public void setCuentaAhorro(int cuentaAhorro) {
	CuentaAhorro = cuentaAhorro;
}
public int getCuentaCorriente() {
	return CuentaCorriente;
}
public void setCuentaCorriente(int cuentaCorriente) {
	CuentaCorriente = cuentaCorriente;
}


}
