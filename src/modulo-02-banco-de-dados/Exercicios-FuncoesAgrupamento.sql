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
SELECT Nome
FROM Cidade
GROUP BY Nome, UF
HAVING COUNT(*) > 1;

-- Exercicio 5
SELECT MAX(IDAssociado) + 1 AS ProximoIDAssociado
FROM Associado;

-- Exercicio 6
SELECT NomeEmpregado,
	   Salario,
	   CASE 
			WHEN Salario < 1164.00     
				THEN 0   
			WHEN Salario > 2326.00
				THEN 27.5
			ELSE 15
	   END AS PercentualDeImpostoRenda
FROM Empregado;