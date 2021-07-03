<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cajero Automatico</title>
</head>

//<%String numeroTarjeta = request.getParameter("numero"); //
//UsuarioController usuarioController = new UsuarioController();
//usuarioController.consutalTarjeta(numeroTarjeta);
//%>//

<body>
<style type="text/css">
html,body { 
  overflow:hidden; 
}
</style>
<h1 style="text-align: center;"><img src="https://upload.wikimedia.org/wikipedia/commons/thumb/8/8d/Logo_bancosAval.png/245px-Logo_bancosAval.png" alt="3" width="245" height="200" /></h1>
<h1 style="text-align: center;">Seleccione tipo de cuenta</h1>
<form action="contrasena.jsp" method="post">
<center>
<input type="button" value="Cuenta Corriente" style='width:130px; height:50px' onClick="window.location.href='transacciones.jsp'">
<p>&nbsp;</p>
<input type="button" value="Cuenta ahorro" style='width:130px; height:50px' onClick="window.location.href='transacciones.jsp'">
</center>
<hl style="text-align: center;"><img src="https://www.fevi.com.co/wps/wcm/connect/fevi/e656ecea-a26a-4b95-85cd-c29b6f275367/slice-middle-01.png?MOD=AJPERES&amp;CACHEID=ROOTWORKSPACE.Z18_G0MI0J02LOFH40ABO3L5D53026-e656ecea-a26a-4b95-85cd-c29b6f275367-lAoInM5" alt="" width="100%" height="10%" /></hl>
</form>
</body>
</html>

</body>
</html>