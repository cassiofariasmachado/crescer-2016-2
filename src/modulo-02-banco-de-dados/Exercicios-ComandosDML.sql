-- Exercício 1 - Comandos SQL
SELECT *
INTO CidadeAux
FROM Cidade;

-- Exercício 2 - Comandos SQL
TRUNCATE TABLE CidadeAux;

INSERT INTO CidadeAux (IDCidade, Nome, UF)
	SELECT IDCidade, Nome, UF FROM Cidade;

SELECT * FROM CidadeAux;

-- Exercício 3 - Comandos SQL
CREATE TABLE Produto (

	IDProduto INT IDENTITY NOT NULL ,
	Nome VARCHAR(30) NOT NULL,
	Descricao VARCHAR(100) NOT NULL,
	DataCriacao DATETIME DEFAULT getdate() NOT NULL,
	LocalEstoque VARCHAR(40) NOT NULL,
	Quantidade DECIMAL(12,2) NOT NULL,
	Preco DECIMAL(12,2), -- 9999999999,99 ou seja, de 12 casas duas são decimais

	CONSTRAINT PK_Produto PRIMARY KEY (IDProduto)
	
);

-- Pode-se testar funções com SELECT
SELECT getdate();

-- Exercício 4 - Comandos SQL

INSERT INTO Produto (Nome, Descricao, DataCriacao, LocalEstoque, Quantidade, Preco)
	VALUES ('Omo', 'Sabão em pó multiação.', convert(DATETIME, '12/05/2019', 103), 'Setor de limpeza', 100, 7.99);

INSERT INTO Produto (Nome, Descricao, DataCriacao, LocalEstoque, Quantidade, Preco)
	VALUES ('Nescau', 'Achocolatado em pó radical.', convert(DATETIME, '12/02/2012', 103), 'Setor de bebidas', 200, 4.99);

SELECT * FROM Produto;