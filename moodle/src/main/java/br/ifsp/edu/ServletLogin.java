package br.ifsp.edu;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/login")
public class ServletLogin extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String email = req.getParameter("email");
		String senha = req.getParameter("senha"); 
		AlunoDAO dao = new AlunoDAO();
		if (!dao.emailExist(email)) {
            req.setAttribute("erroLogin", "Email não cadastrado. Crie uma conta.");
            req.getRequestDispatcher("index.jsp").forward(req, resp);
            return;
        }
		
        Aluno aluno = dao.login(email, senha);

        if (aluno == null) {
            req.setAttribute("erroLogin", "Senha incorreta.");
            req.getRequestDispatcher("index.jsp").forward(req, resp);
        } else {
            System.out.println("Olá, " + aluno.getNome() + " 👋");
            req.getSession().setAttribute("usuarioLogado", aluno);
            resp.sendRedirect("dashboard.jsp");
        }
	}
}