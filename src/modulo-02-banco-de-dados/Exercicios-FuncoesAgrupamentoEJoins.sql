-- Exercicio 1
SELECT NomeEmpregado, DATEDIFF( MONTH, DataAdmissao, convert(datetime, '31/12/2000', 103) ) AS MesesTrabalhadosAte2000
FROM Empregado 
WHERE DataAdmissao BETWEEN convert(datetime, '01/05/1980', 103) AND convert(datetime, '20/01/1982', 103);

-- Exercicio 2
SELECT MAX(Cargo)
FROM Empregado

-- Exercicio 3
SELECT UF, 
	   Count (*) AS QuantidadeDeCidades
FROM Cidade
GROUP BY UF;

-- Exercicio 4
SELECT Nome, 
	   UF
FROM Cidade C
WHERE EXISTS( SELECT * 
			  FROM Cidade AS Cid
			  WHERE C.Nome = Cid.Nome AND C.UF = Cid.UF );