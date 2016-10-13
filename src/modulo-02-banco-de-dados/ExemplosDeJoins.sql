-- Exemplos de Joins:

-- Explicito (inner join):
SELECT A.Nome AS NomeAssociado,
	   C.Nome AS NomeCidade
FROM Associado A
INNER JOIN Cidade C
ON A.IDCidade = C.IDCidade;

-- Implicito:
SELECT A.Nome AS NomeAssociado,
	   C.Nome AS NomeCidade
FROM Associado A,
	 Cidade C
WHERE A.IDCidade = C.IDCidade;

-- Left Join: força a exibicao das informacoes do lado esquerdo do join
SELECT A.Nome AS NomeAssociado,
	   C.Nome AS NomeCidade
FROM Associado A
LEFT JOIN Cidade C
ON A.IDCidade = C.IDCidade;

-- Right Join: força a exibicao das informacoes do lado direito do join
SELECT A.Nome AS NomeAssociado,
	   C.Nome AS NomeCidade
FROM Associado A
RIGHT JOIN Cidade C
ON A.IDCidade = C.IDCidade;

-- Self Join: utilizado para auto relacionamento
SELECT e.NomeEmpregado AS NomeEmpregado,
	   g.NomeEmpregado AS NomeGerente
FROM   Empregado e
INNER JOIN Empregado g
ON e.IDEmpregado = g.IDGerente;

-- Cross Join (produto cartesiano): NAO FAZER!!!
SELECT A.Nome AS NomeAssociado,
	   C.Nome AS NomeCidade
FROM Associado AS A, Cidade AS C

-- Sub-Queries:

-- EXISTS (Retorna true ou false, e encerra no primeiro true):
SELECT IDCidade, Nome
FROM Cidade C
WHERE EXISTS (SELECT * 
			  FROM Associado A
			  WHERE A.IDCIdade = C.IDCidade);

-- IN (Menos performatico que EXISTS, pois pega todos os itens):
SELECT IDCidade, Nome
FROM Cidade C
WHERE C.IDCidade IN (SELECT IDCidade 
			  FROM Associado);