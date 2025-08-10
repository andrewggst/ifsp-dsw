package br.ifsp.edu;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet responsável por processar requisições de cadastro de alunos.
 * Recebe os dados do formulário via POST, cria um objeto Aluno, e tenta inserir no banco de dados.
 */
@WebServlet(urlPatterns = "/cadastro")
public class ServletCadastro extends HttpServlet {

    /**
     * Processa a requisição POST do formulário de cadastro.
     * Extrai os parâmetros da requisição, cria o objeto Aluno e tenta persistir no banco.
     * Define uma mensagem de sucesso ou erro e redireciona para a página cadastro.jsp.
     *
     * @param req objeto {@link HttpServletRequest} contendo os dados da requisição
     * @param resp objeto {@link HttpServletResponse} para enviar a resposta ao cliente
     * @throws ServletException se ocorrer erro relacionado ao servlet
     * @throws IOException se ocorrer erro de entrada/saída durante o processamento
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Aluno aluno = new Aluno();
        aluno.setNome(req.getParameter("nome"));
        aluno.setIdade(req.getParameter("idade"));
        aluno.setSexo(req.getParameter("sexo"));
        aluno.setCpf(req.getParameter("cpf"));
        aluno.setEmail(req.getParameter("email"));
        aluno.setSenha(req.getParameter("senha"));
        aluno.setSenha(req.getParameter("matricula"));

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
