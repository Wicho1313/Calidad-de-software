<%@page import="controller.ContrasenaDAO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cajero Automatico</title>
</head>


<body >

	<h1 style="text-align: center;"><img src="https://upload.wikimedia.org/wikipedia/commons/thumb/8/8d/Logo_bancosAval.png/245px-Logo_bancosAval.png" alt="" width="245" height="239" /></h1>
<h1 style="text-align: center;">Ingrese Contraseņa</h1>
<form action="Contrasena" method="post">
<center>
	        <p>Ingrese Clave:</p>
        <input type="text" name="Contrasena">
 <%-- onclick significa que ese metodo se activa al dar click --%> 
        <input type="submit" value="Validar" onclick="validarContrasena()" style='width:100px; height:20px'>
          
	
</center>  	  
</center>
<p>&nbsp;</p>
<p>&nbsp;</p>
<p>&nbsp;</p>
<p><img style="text-align: center;" src="https://www.fevi.com.co/wps/wcm/connect/fevi/e656ecea-a26a-4b95-85cd-c29b6f275367/slice-middle-01.png?MOD=AJPERES&amp;CACHEID=ROOTWORKSPACE.Z18_G0MI0J02LOFH40ABO3L5D53026-e656ecea-a26a-4b95-85cd-c29b6f275367-lAoInM5" alt="" width="100%" height="100%" /></p>

</form>

</body>
</html>

</body>
</html>