package br.ifsp.edu;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * Classe responsável pelo acesso aos dados da entidade Aluno no banco de dados.
 * Fornece métodos para login com email e senha, verificação de existência de e-mail e cadastro de alunos no banco de dados.
 */
public class AlunoDAO {

    /**
     * Realiza o login do aluno buscando no banco pelo e-mail e senha fornecidos.
     * 
     * @param matricula a matricula do aluno para autenticação
     * @param senha a senha do aluno para autenticação
     * @return um objeto {@link Aluno} com os dados do aluno as credenciais forem válidas; {@code null} caso contrário
     */
    public Aluno login(String matricula, String senha) {
        Connection conn = null;
        try {
            conn = new Conexao().getConexao();
            String sql = "SELECT * FROM Aluno WHERE matricula = ? AND senha = ?";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, matricula);
            statement.setString(2, senha);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Aluno user = new Aluno();
                user.setNome(rs.getString("nome"));
                user.setIdade(rs.getString("idade"));
                user.setSexo(rs.getNString("sexo"));
                user.setCpf(rs.getNString("cpf"));
                user.setEmail(rs.getString("email"));
                user.setSenha(rs.getString("senha"));
                user.setMatricula(rs.getString(matricula));
                user.setIdAluno(rs.getString("idAluno"));
                return user;
            }
        } catch (Exception e) {
            System.err.println("Erro login: " + e.getMessage());
        } finally {
            new Conexao().close(conn);
        }
        return null;
    }

    /**
     * Verifica se uma matrícula já está registrado no banco de dados.
     * 
     * @param matricula a matricula a ser verificado
     * @return {@code true} se a matricula existir na tabela Aluno; {@code false} caso contrário
     */
    public boolean matriculaExist(String matricula) {
        Connection conn = null;
        try {
            conn = new Conexao().getConexao();
            String sql = "SELECT 1 FROM Aluno WHERE matricula = ?";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, matricula);
            ResultSet rs = statement.executeQuery();
            return rs.next();
        } catch (Exception e) {
            System.err.println("Erro matriculaExiste: " + e.getMessage());
        } finally {
            new Conexao().close(conn);
        }
        return false;
    }

    /**
     * Insere um novo aluno no banco de dados.
     * 
     * @param aluno objeto {@link Aluno} contendo os dados do novo aluno a ser cadastrado
     * @return {@code true} se o cadastro foi realizado com sucesso; {@code false} caso contrário
     */
    public boolean insertCadastro(Aluno aluno) {
        Connection conn = null;
        try {
            conn = new Conexao().getConexao();
            String sql = "insert into Aluno (nome, idade, sexo, cpf, email, senha, matricula) values (?,?,?,?,?,?,?)";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, aluno.getNome());
            statement.setString(2, aluno.getIdade());
            statement.setString(3, aluno.getSexo());
            statement.setString(4, aluno.getCpf());
            statement.setString(5, aluno.getEmail());
            statement.setString(6, aluno.getSenha());
            statement.setString(7, aluno.getMatricula());
            statement.execute();
            return true;
        } catch (Exception e) {
            System.err.println("Erro cadastro: " + e.getMessage());
            return false;
        } finally {
            new Conexao().close(conn);
        }
    }
}
