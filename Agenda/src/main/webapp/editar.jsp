<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Agenda de contatos</title>
<link rel="icon" href="imagens/phone.png">
<link rel="stylesheet" href="style.css">
</head>
<body>
	<h1>Editar novo contato</h1>
	<form name="frmContato" action="update">

		<table>
			<tr>
				<td><input type="text" name="idcon" id="Caixa3" readonly value="<%out.print(request.getAttribute("idcon"));%>"></td>
				<td><input type="text" name="nome" class="Caixa1" value="<%out.print(request.getAttribute("nome"));%>"></td>
				<td><input type="text" name="fone" class="Caixa2" value="<%out.print(request.getAttribute("fone"));%>"></td>
				<td><input type="text" name="email" class="Caixa1" value="<%out.print(request.getAttribute("email"));%>"></td>
			</tr>
		</table>
		<input type="button" value="Salvar" class="Botao1"
			onClick="validar()">
	</form>
	<script src="scripts/validador.js"></script>
</body>
</html>