<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%-- comentário em JSP aqui: nossa primeira página JSP --%>
<%
	String mensagem = "Bem vindo ao sistema.";
%>
<% out.println(mensagem); %> <br>

<% String desenvolvido = "Desenvolvido por (SEU NOME AQUI)"; %>

<%= desenvolvido %><br />

<% System.out.println("Tudo foi executado!"); %>
</body>
</html>