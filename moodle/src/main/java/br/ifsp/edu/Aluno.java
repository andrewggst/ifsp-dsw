package br.ifsp.edu;

/**
 * Representa a entidade Aluno no banco de dados.
 */
public class Aluno {
	/** Identificador interno do aluno (chave primária). */
	private String idAluno;

	/** Nome completo do aluno. */
	private String nome;

	/** Idade do aluno. */
	private String idade;

	/** Sexo do aluno. */
	private String sexo;

	/** CPF do aluno. */
	private String cpf;

	/** Endereço de e-mail do aluno. */
	private String email;

	/** Senha usada para login. */
	private String senha;

	/** Código de matrícula do aluno, usado como identificador no sistema. */
	private String matricula;

	public String getIdUsuario() {
		return idAluno;
	}
	public void setIdAluno(String idALuno) {
		this.idAluno = idAluno;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getIdade() {
		return idade;
	}
	public void setIdade(String idade) {
		this.idade = idade;
	}
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public String getMatricula() {
		return matricula;
	}
	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
}
