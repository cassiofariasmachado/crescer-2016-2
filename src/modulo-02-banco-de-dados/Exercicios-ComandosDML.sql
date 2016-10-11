-- Exercício 1 - Comandos SQL
SELECT *
INTO CidadeAuxAux
FROM Cidade;

-- Exercício 2 - Comandos SQL
TRUNCATE TABLE CidadeAux;

SELECT *
INTO CidadeAux
FROM Cidade;

insert into CidadeAux (IDCidade, Nome, UF)
   values (1, 'Sao Leopoldo', 'RS');
insert into CidadeAux (IDCidade, Nome, UF)
   values (2, 'Porto Alegre', 'RS');
insert into CidadeAux (IDCidade, Nome, UF)
   values (3, 'Parobe', 'RS');
insert into CidadeAux (IDCidade, Nome, UF)
   values (4, 'Taquara', 'RS');
insert into CidadeAux (IDCidade, Nome, UF)
   values (105, 'São Paulo', 'SP');
insert into CidadeAux (IDCidade, Nome, UF)
   values (106, 'Guarulhos', 'SP');
insert into CidadeAux (IDCidade, Nome, UF)
   values (27, 'Rio de Janeiro', 'RJ');
insert into CidadeAux (IDCidade, Nome, UF)
   values (108, 'Brasilia', 'DF');
insert into CidadeAux (IDCidade, Nome, UF)
   values (109, 'Belo Horizonte', 'MG');
insert into CidadeAux (IDCidade, Nome, UF)
   values (110, 'Uberlândia', 'MG');
insert into CidadeAux (IDCidade, Nome, UF)
   values (5, 'CidadeAux de Alagoas', 'AL');
insert into CidadeAux (IDCidade, Nome, UF)
   values (6, 'Maceio', 'AL');
insert into CidadeAux (IDCidade, Nome, UF)
   values (7, 'Itu', 'SP');
insert into CidadeAux (IDCidade, Nome, UF)
   values (8, 'Campinas', 'SP');
insert into CidadeAux (IDCidade, Nome, UF)
   values (9, 'Guaratingueta', 'SP');
insert into CidadeAux (IDCidade, Nome, UF)
   values (10, 'Santa Barbara', 'MG');
insert into CidadeAux (IDCidade, Nome, UF)
   values (11, 'Campos dos Goitacases', 'RJ');
insert into CidadeAux (IDCidade, Nome, UF)
   values (12, 'Sao Gabriel', 'RS');
insert into CidadeAux (IDCidade, Nome, UF)
   values (13, 'Brasopolis', 'MG');
insert into CidadeAux (IDCidade, Nome, UF)
   values (14, 'Cristina', 'MG');
insert into CidadeAux (IDCidade, Nome, UF)
   values (15, 'Umbuzeiro', 'PB');
insert into CidadeAux (IDCidade, Nome, UF)
   values (16, 'Vicosa', 'MG');
insert into CidadeAux (IDCidade, Nome, UF)
   values (17, 'Macae', 'RJ');
insert into CidadeAux (IDCidade, Nome, UF)
   values (18, 'Sao Luis', 'MA');
insert into CidadeAux (IDCidade, Nome, UF)
   values (19, 'Cuiaba', 'MT');
insert into CidadeAux (IDCidade, Nome, UF)
   values (20, 'Sao Borja', 'RS');
insert into CidadeAux (IDCidade, Nome, UF)
   values (21, 'Natal', 'RN');
insert into CidadeAux (IDCidade, Nome, UF)
   values (22, 'Diamantina', 'MG');
insert into CidadeAux (IDCidade, Nome, UF)
   values (23, 'Campo Grande', 'MS');
insert into CidadeAux (IDCidade, Nome, UF)
   values (24, 'Fortaleza', 'CE');
insert into CidadeAux (IDCidade, Nome, UF)
   values (25, 'Bage', 'RS');
insert into CidadeAux (IDCidade, Nome, UF)
   values (26, 'Bento Goncalves', 'RS');
insert into CidadeAux (IDCidade, Nome, UF)
   values (28, 'Pinheiro', 'MA');
insert into CidadeAux (IDCidade, Nome, UF)
   values (29, 'Salvador', 'BA');
insert into CidadeAux (IDCidade, Nome, UF)
   values (30, 'Garanhuns', 'PE');
Insert into CidadeAux (IDCidade, Nome, UF)
   values (31, 'São Paulo', 'SP');    
Insert into CidadeAux (IDCidade, Nome, UF)
   values (32, 'Guarulhos', 'SP');    
Insert into CidadeAux (IDCidade, Nome, UF)
   values (33, 'Rio de Janeiro', 'RJ');    
Insert into CidadeAux (IDCidade, Nome, UF)
   values (34, 'Brasilia', 'DF');    
Insert into CidadeAux (IDCidade, Nome, UF)
   values (35, 'Belo Horizonte', 'MG');        
Insert into CidadeAux (IDCidade, Nome, UF)
   values  (36, 'Uberlândia', 'MG');      
Insert into CidadeAux (IDCidade, Nome, UF)
   values  (37, 'Santana do Livramento', 'RS');
Insert into CidadeAux (IDCidade, Nome, UF)
   values  (38, 'Santa Maria', 'RS');
Insert into CidadeAux (IDCidade, Nome, UF)
   values  (39, 'Santa Rosa', 'RS');
Insert into CidadeAux (IDCidade, Nome, UF)
values (40, 'São Francisco de Paula', 'RS');

-- Exercício 3 - Comandos SQL

CREATE TABLE Produto (

	IDProduto INT IDENTITY NOT NULL ,
	Nome VARCHAR(30) NOT NULL,
	Descricao VARCHAR(100) NOT NULL,
	DataCriacao DATETIME NOT NULL,
	LocalEstoque VARCHAR(40) NOT NULL,
	Quantidade INT NOT NULL,
	Preco DECIMAL(12,2),

	CONSTRAINT PK_Produto PRIMARY KEY (IDProduto)
	
);

-- Exercício 4 - Comandos SQL

INSERT INTO Produto (Nome, Descricao, DataCriacao, LocalEstoque, Quantidade, Preco)
	VALUES ('Omo', 'Sabão em pó multiação.', 'Setor de limpeza', 100, 7,99);

INSERT INTO Produto (Nome, Descricao, DataCriacao, LocalEstoque, Quantidade, Preco)
	VALUES ('Nescau', 'Achocolatado em pó radical.', 'Setor de bebidas', 200, 4,99);