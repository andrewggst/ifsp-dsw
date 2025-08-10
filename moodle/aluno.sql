create database Aluno;
use Aluno;

create table Tabela(
	idAluno int auto_increment primary key not null,
    nome varchar(150),
    idade int,
    sexo char(1),
    cpf varchar(15),
    email varchar(150),
    senha varchar(50),
    matricula varchar(9)
);
