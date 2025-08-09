<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="style.css">
</head>

<body>
	<div class="login-container">
		<div class="login-box">
			<img
				src="https://moodle.ead.ifsp.edu.br/pluginfile.php/1/core_admin/logo/0x200/1750299736/Marca_IFSP_SimpVert.png"
				alt="Logo IFSP" class="login-logo">
			<%
				String sucesso = request.getParameter("sucesso");
			%>
			<div class="login-alert <%= (sucesso != null) ? "show" : "" %>">
  				Cadastro realizado com sucesso!
			</div>
			<div class="login-alert <%= (request.getAttribute("mensagem") != null) ? "show" : "" %>">
    			<%= request.getAttribute("mensagem") != null ? request.getAttribute("mensagem") : "" %>
			</div>
			<hr class="divider">

			<div class="login-authenticate">
				<h3>Cadastrar usando:</h3>
				<a href="https://suap.ifsp.edu.br" class="auth-button"> <img
					src="img/img-suap.jpeg" alt="Logo SUAP" class="auth-logo">
					SUAP IFSP
				</a> <a href="https://accounts.google.com" class="auth-button"> <img
					src="img/img-google.png" alt="Google" class="auth-logo">
					Google IFSP
				</a>
			</div>

			<hr class="divider">

			<div class="login-form">
				<form id="cadastro" action="cadastro" method="post">
				<h3>Preencha os campos:</h3>
					<input type="text" name="nome" placeholder="Nome completo" required>
					<br> 
					<input type="number" name="idade" placeholder="Idade" required>
					<br> 
				    <select name="sexo" id="sexo" required>
				        <option value="sexo">Sexo</option>
				        <option value="m">Masculino</option>
				        <option value="f">Feminino</option>
				        <option value="outro">Outro</option>
				    </select>
					<br>
					<input type="text" name="cpf" placeholder="CPF" required>
					<br> 
					<input type="email" name="email"placeholder="E-mail institucional" required> 
					<br>
					<input type="text" name="matricula" placeholder="Matrícula" required>
					<br>
					<input type="password" name="senha" placeholder="Crie uma senha" required>
					<br> 
					<input type="password" name="confirmarSenha"placeholder="Confirme a senha" required> 
					<br>
					<input type="submit" value="Cadastrar">
				</form>
				<a href="index.jsp" class="lost-password">Voltar para o login</a>
			</div>
		</div>
	</div>
</body>
</html>
