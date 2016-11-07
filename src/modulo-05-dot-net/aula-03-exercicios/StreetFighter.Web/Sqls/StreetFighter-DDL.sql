CREATE TABLE Personagem (
	Id INTEGER IDENTITY,
	Nome VARCHAR(255) NOT NULL,
	DataNascimento DATETIME NOT NULL,
	Altura INTEGER NOT NULL,
	Peso DECIMAL(8,2) NOT NULL,
	Origem VARCHAR(255) NOT NULL,
	GolpesEspeciais VARCHAR(255) NOT NULL,
	UrlDaImagem VARCHAR(255) NOT NULL,
	PersonagemOculto BIT NOT NULL,

	CONSTRAINT PK_Personagem PRIMARY KEY(Id)
)

CREATE TABLE Usuario (
	Id INTEGER IDENTITY,
	Nome VARCHAR(255) NOT NULL,
	Email VARCHAR(255) NOT NULL,
	Login VARCHAR(255) NOT NULL,
	Senha VARCHAR(255) NOT NULL,

	CONSTRAINT PK_Usuario PRIMARY KEY(Id)
)