<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="service.TarefaService" %>    
<%@ page import="java.util.List" %>
<%@ page import="model.Tarefa" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Backend TODO</title>
	</head>
	<body>
		<h1>Tarefas</h1>
		
		<%
			TarefaService service = new TarefaService();
		
			List<Tarefa> lista = service.listarTarefas();

			out.println("<TABLE style='border: solid; font-size: 26px'>");
			
			for(Tarefa tarefa: lista){
					out.println("<TR>");
					out.println("<TD style='width: 15%; border-right: dashed'>" + tarefa.getId() + "</TD>");
					out.println("<TD style='width: 70%; border-right: dashed'>" + tarefa.getDescricao() + "</TD>");
					out.println("<TD style='width: 25%'>" + tarefa.getStatus() + "</TD>");
					out.println("</TR>");
			}
			
			out.println("</TABLE>");
		%>
		
		<p><a href="index.html">Voltar</a></p>
	</body>
</html>