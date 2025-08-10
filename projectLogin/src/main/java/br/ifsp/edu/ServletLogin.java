package br.ifsp.edu;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet responsável por lidar com o processo de login de alunos.
 * <p>
 * Esta servlet é mapeada para a URL <code>/login</code> e processa requisições HTTP POST.
 * Ela valida se a matrícula informada existe e, em seguida, verifica se a senha está correta.
 * Em caso de sucesso, cria uma sessão para o usuário autenticado e o redireciona para o dashboard.
 * Em caso de falha, retorna o usuário para a página de login com mensagens de erro apropriadas.
 * </p>
 * 
 * @see AlunoDAO
 * @see jakarta.servlet.http.HttpServlet
 */
@WebServlet(urlPatterns = "/login")
public class ServletLogin extends HttpServlet {

    /**
     * Processa requisições HTTP POST para autenticar um aluno.
     *
     * @param req  o {@link HttpServletRequest} contendo os parâmetros de login (matrícula e senha)
     * @param resp o {@link HttpServletResponse} usado para redirecionar ou reenviar a página
     * @throws ServletException se ocorrer um erro de servlet
     * @throws IOException se ocorrer um erro de entrada/saída
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String matricula = req.getParameter("matricula");
        String senha = req.getParameter("senha"); 

        AlunoDAO dao = new AlunoDAO();

        // Verifica se a matrícula existe
        if (!dao.matriculaExist(matricula)) {
            req.setAttribute("erroLogin", "Matrícula não cadastrada. Crie uma conta.");
            req.getRequestDispatcher("index.jsp").forward(req, resp);
            return;
        }

        // Tenta autenticar o aluno
        Aluno aluno = dao.login(matricula, senha);

        if (aluno == null) {
            // Senha incorreta
            req.setAttribute("erroLogin", "Senha incorreta.");
            req.getRequestDispatcher("index.jsp").forward(req, resp);
        } else {
            // Login bem-sucedido
            System.out.println("Olá, " + aluno.getNome() + " 👋");
            req.getSession().setAttribute("usuarioLogado", aluno);
            resp.sendRedirect("dashboard.jsp");
        }
    }
}
