package br.ifsp.edu;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class AlunoDAO {
	public Aluno login(String email, String senha) {
		Connection conn = null;
		try {
			conn = new Conexao().getConexao();
			String sql = "SELECT * FROM Aluno WHERE email = ? AND senha = ?";
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, email);
			statement.setString(2, senha);
			ResultSet rs = statement.executeQuery();
			while(rs.next()) {
				Aluno user = new Aluno();
				user.setNome(rs.getString("nome"));
				user.setIdade(rs.getString("idade"));
				user.setSexo(rs.getNString("sexo"));
				user.setCpf(rs.getNString("cpf"));
				user.setEmail(rs.getString("email"));
				user.setSenha(rs.getString("senha"));
				user.setIdAluno(rs.getString("idAluno"));
				String senhaDB = rs.getString("senha");
				return user;
			}
		} catch (Exception e) {
			System.err.println("Erro login: "+e.getMessage());
		}finally {
			new Conexao().close(conn);
		}
		return null;
	}
	
	public boolean emailExist(String email) {
		Connection conn = null;
		try {
			conn = new Conexao().getConexao();
			String sql = "SELECT 1 FROM Aluno WHERE email = ?";
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, email);
			ResultSet rs = statement.executeQuery();
			return rs.next();
		} catch (Exception e) {
			System.err.println("Erro emailExiste: " + e.getMessage());
		}finally {
			new Conexao().close(conn);
		}
		return false;
	}
	
	public boolean insertCadastro(Aluno aluno) {
		Connection conn = null;
		try {
			conn = new Conexao().getConexao();
			String sql ="insert into Aluno (nome, idade, sexo, cpf, email, senha) values (?,?,?,?,?,?)";
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, aluno.getNome());
			statement.setString(2, aluno.getIdade());
			statement.setString(3, aluno.getSexo());
			statement.setString(4, aluno.getCpf());
			statement.setString(5, aluno.getEmail());
			statement.setString(6, aluno.getSenha());
			statement.execute();
			return true;
			
		} catch (Exception e) {
			System.err.println("Erro cadastro: "+e.getMessage());
			return false;
		} finally {
			new Conexao().close(conn);
		}
	}
}