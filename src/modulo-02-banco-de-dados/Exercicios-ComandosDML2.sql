-- Exercício 1 - Comandos SQL
SELECT NomeEmpregado 
FROM Empregado
ORDER BY DataAdmissao;

-- Exercício 2 - Comandos SQL
SELECT NomeEmpregado as Nome, 
	   Salario * 12 as SalarioAnual
FROM Empregado
WHERE Cargo = 'Atendente' OR 
	  Salario * 12 < 18000.00;
	  
-- Exercício 3 - Comandos SQL
SELECT IDCidade
FROM Cidade
WHERE Nome = 'Uberlândia';

-- Exercício 4 - Comandos SQL
SELECT Nome, 
	   IDCidade
FROM Cidade
WHERE UF = 'RS';