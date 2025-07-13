package br.ifsp.edu;

import java.io.IOException;
import java.net.http.HttpRequest;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/cadastro")
public class ServletCadastro extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Aluno aluno = new Aluno();
		aluno.setNome(req.getParameter("nome"));
		aluno.setIdade(req.getParameter("idade"));
        aluno.setSexo(req.getParameter("sexo"));
        aluno.setCpf(req.getParameter("cpf"));
        aluno.setEmail(req.getParameter("email"));
        aluno.setSenha(req.getParameter("senha"));
        
        AlunoDAO dao = new AlunoDAO();
        boolean cadastroRealizado = dao.insertCadastro(aluno);
        if (cadastroRealizado) {
        	req.setAttribute("mensagem", "Cadastro realizado com sucesso!");
        } else {
            req.setAttribute("mensagem", "Erro ao cadastrar, tente novamente.");
        }
        resp.sendRedirect("cadastro.jsp?sucesso=true");
	}
}