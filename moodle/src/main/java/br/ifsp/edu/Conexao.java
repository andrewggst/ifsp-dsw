package br.ifsp.edu;

import java.sql.DriverManager;
import java.sql.Connection;

public class Conexao {
	public Connection getConexao(){
		String user = "root";
		String pass = "28008020";
		String banco = "Banco";
		String server = "localhost";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url ="jdbc:mysql://" + server + ":3306/"+banco;
			return DriverManager.getConnection(url, user, pass);
		} catch (Exception e) {
			System.err.println("Erro ao criar a conexão" + e.getMessage());
		}
		return null;
	}
	public void close(Connection conn) {
		if (conn != null) {
			try {
				conn.close();
			} catch (Exception e) {
				System.out.println("Erro ao fechar a conexão: "+e.getMessage());
			}
		}
	}
}