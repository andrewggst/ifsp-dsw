package br.ifsp.edu;

import java.sql.DriverManager;
import java.sql.Connection;

/**
 * Classe responsável por gerenciar a conexão com o banco de dados MySQL.
 * Fornece métodos para abrir e fechar conexões.
 */
public class Conexao {

    /**
     * Cria e retorna uma conexão com o banco de dados MySQL utilizando as configurações definidas.
     *
     * @return um objeto {@link Connection} conectado ao banco de dados; {@code null} se ocorrer algum erro na conexão
     */
    public Connection getConexao() {
        String user = "";
        String pass = "";
        String banco = "";
        String server = "localhost";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://" + server + ":3306/" + banco;
            return DriverManager.getConnection(url, user, pass);
        } catch (Exception e) {
            System.err.println("Erro ao criar a conexão: " + e.getMessage());
        }
        return null;
    }

    /**
     * Fecha a conexão com o banco de dados, caso ela esteja aberta.
     *
     * @param conn a conexão {@link Connection} a ser fechada; pode ser {@code null}
     */
    public void close(Connection conn) {
        if (conn != null) {
            try {
                conn.close();
            } catch (Exception e) {
                System.out.println("Erro ao fechar a conexão: " + e.getMessage());
            }
        }
    }
}
