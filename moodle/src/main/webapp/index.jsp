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
            <img src="https://cdn.stocksnap.io/img-thumbs/960w/tree-leaves_C22LOCLRVH.jpg" alt="Exemplo" class="login-logo">
            <div class="login-alert <%= (request.getAttribute("erroLogin") != null) ? "show" : "" %>">
            	<%= request.getAttribute("erroLogin") != null ? request.getAttribute("erroLogin") : "" %>
            </div>
            <hr class="divider">
            <div class="login-authenticate">
                <h3>Autenticar usando sua conta em:</h3>
                <a href="" class="auth-button">
                    <img src="https://cdn.stocksnap.io/img-thumbs/960w/tree-leaves_C22LOCLRVH.jpg" alt="Exemplo" class="auth-logo">
                    Exemplo
                </a>
                <a href="https://accounts.google.com" class="auth-button">
                    <img src="img/img-google.png" alt="Google" class="auth-logo">
                    Google
                </a>
            </div>

            <hr class="divider">
            <div class="login-help">
                
                <h3>Esta é a sua primeira vez aqui?</h3>
                <p><strong>Realize o primeiro acesso pelo SUAP IFSP e retorne ao Moodle para usar a autenticação pelo SUAP ou Google IFSP.</strong></p>
            </div>

            <hr class="divider">
            <div class="login-form">
                <form id="login"  action="login" method="post">
                    <input type="text" id="matricula" name="matricula" placeholder="Identificação de usuário"> 
                    <br>
                    <input type="password" id="senha" name="senha" placeholder="Senha"> 
                    <br>
                    <input type="submit" value="Acessar">
                </form>
                <a href="#" class="lost-password">Perdeu a senha?</a>
                <a href="cadastro.jsp" class="lost-password">Cadastre-se</a>
            </div>
        </div>
    </div>
</body>
</html>
