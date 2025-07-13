<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Painel do Aluno</title>
    <link rel="stylesheet" href="style.css">
</head>
<body>
    <div class="login-container">
        <div class="login-box">
            <h2>
                Olá, <%= ((br.ifsp.edu.Aluno) session.getAttribute("usuarioLogado")).getNome() %>! 👋
            </h2>
            <p>Este é seu painel de acesso ao sistema.</p>
            <a href="index.jsp" class="lost-password">Sair</a>
        </div>
    </div>
</body>
</html>