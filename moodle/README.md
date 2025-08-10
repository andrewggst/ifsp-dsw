# Projeto Moodle IFSP

Este repositório contém um projeto web para gerenciamento de alunos, desenvolvido na disciplina de Desenvolvimento de Software Web do IFSP.  
Ele inclui funcionalidades básicas de cadastro e login utilizando Servlets, JSP e conexão com banco MySQL.

---

## <img src="https://img.icons8.com/ios-glyphs/24/000000/book.png" alt="content" /> Conteúdo

- **ServletLogin** – Servlet para autenticação de alunos via matrícula e senha.  
- **ServletCadastro** – Servlet para cadastro de novos alunos.  
- **AlunoDAO** – Acesso ao banco de dados para operações com alunos.  
- **Aluno** – Modelo da entidade Aluno.  
- **Conexao** – Gerenciamento da conexão com o banco MySQL.  
- **JSPs** – Páginas `index.jsp`, `cadastro.jsp` e `dashboard.jsp`.  
- **aluno.sql** – Script para criação da tabela `Aluno`.

---

## <img src="https://img.icons8.com/ios-glyphs/24/000000/folder-invoices--v1.png" alt="folder" /> Organização do projeto

```
moodle/
├── src/main/java/br/ifsp/edu/
├── src/main/webapp/
├── aluno.sql
├── .gitignore
└── README.md
```

yaml
Copiar
Editar

---

## <img src="https://img.icons8.com/ios-glyphs/24/000000/rocket.png" alt="goal" /> Objetivo

Criar uma aplicação web simples para cadastro e login de alunos, exemplificando o uso de Servlets, JSP e JDBC.

---

## <img src="https://img.icons8.com/ios-glyphs/24/000000/gear.png" alt="setup" /> Configuração e uso

1. Configure o MySQL e crie o banco de dados.  
2. Execute o script `aluno.sql` para criar a tabela.  
3. Atualize as credenciais no arquivo `Conexao.java`:

   ```java
   String user = "seu_usuario";
   String pass = "sua_senha";
   String banco = "nome_do_banco";
- Adicione o driver MySQL Connector/J ao classpath do projeto.
[Download oficial do Tomcat](https://tomcat.apache.org/download-10.cgi)

  - A forma de adicionar o driver varia de acordo com a IDE (Eclipse, IntelliJ, VS Code etc.).
Consulte a documentação da sua IDE para saber como adicionar JARs externos ao classpath.

- Configure o Apache Tomcat como servidor.
[Download oficial do driver](https://dev.mysql.com/downloads/connector/j/)

  - A configuração também depende da IDE utilizada.
  - Verifique como registrar o Tomcat como servidor e rodar aplicações web em sua IDE.

- Inicie o Tomcat e acesse o projeto via navegador: [http://localhost:8080/moodle](http://localhost:8080/moodle)

## <img src="https://img.icons8.com/ios-glyphs/24/000000/warning-shield.png" alt="notice" /> Avisos

- Senhas são armazenadas em texto simples no banco – para ambientes reais, implemente criptografia (ex: BCrypt).

- Ajuste as configurações de banco, servidor e ambiente conforme sua máquina.

- Projeto com fins educacionais.

- Projeto inspirado visualmente na página de login do Moodle EaD do IFSP: [Moodle IFSP](https://moodle.ead.ifsp.edu.br/login/index.php)
