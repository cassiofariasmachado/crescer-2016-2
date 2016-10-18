-- Exercicio 7
SELECT Emp.NomeEmpregado,
	   DepEmp.NomeDepartamento AS DepartamentoEmpregado,
	   Ger.NomeEmpregado AS NomeGerente,
	   DepGer.NomeDepartamento AS DepartamentoGerente
FROM   Empregado Emp
INNER JOIN Empregado Ger ON Emp.IDGerente = Ger.IDEmpregado
INNER JOIN Departamento DepEmp ON Emp.IDDepartamento = DepEmp.IDDepartamento
INNER JOIN Departamento DepGer ON Ger.IDDepartamento = DepGer.IDDepartamento;

-- Exercicio 8
-- Criando copia
SELECT *
INTO EmpregadoCopia
FROM Empregado;

-- Fazendo update
BEGIN TRANSACTION
UPDATE Empregado
SET Salario += Salario * 0.145
FROM Empregado AS Emp
INNER JOIN Departamento AS Dep ON Emp.IDDepartamento = Dep.IDDepartamento
WHERE Dep.Localizacao = 'SAO PAULO';

-- Nesse caso seria melhor fazer um filtro com exists ou in, pois se realiza o update somente
-- em colunas de Empregado
BEGIN TRANSACTION
UPDATE Empregado
SET Salario = Salario * 0.145
WHERE EXISTS ( SELECT 1
			   FROM Departamento
			   WHERE Departamento.IDDepartamento = Empregado.IDDepartamento
			   AND Departamento.Localizacao = 'SAO PAULO' );

BEGIN TRANSACTION
UPDATE Empregado
SET Salario = Salario * 0.145
WHERE IDDepartamento IN ( SELECT IDDepartamento
						  FROM Departamento
						  WHERE Departamento.Localizacao = 'SAO PAULO' );
-- Teste
SELECT Emp.NomeEmpregado, 
	   Emp.Salario
FROM Empregado AS Emp
INNER JOIN Departamento AS Dep ON Emp.IDDepartamento = Dep.IDDepartamento
WHERE Dep.Localizacao = 'SAO PAULO';

-- Exercicio 9
SELECT SUM(Emp.Salario) - SUM(EmpCop.Salario)
FROM Empregado AS Emp
INNER JOIN EmpregadoCopia AS EmpCop ON Emp.IDEmpregado = EmpCop.IDEmpregado;

-- Exercicio 10
SELECT TOP 1 WITH TIES Dep.IDDepartamento,
					   Dep.NomeDepartamento, 
	                   Emp.Salario
FROM Empregado AS Emp
INNER JOIN Departamento AS Dep ON Emp.IDDepartamento = Dep.IDDepartamento
GROUP BY Dep.IDDepartamento, Dep.NomeDepartamento, Emp.Salario
ORDER BY Emp.Salario DESC;

-- Melhor utilizar exists nesse caso, pois utiliza somente informacoes de Departamento
SELECT Dep.IDDepartamento,
	   Dep.NomeDepartamento
FROM Departamento AS Dep
WHERE EXISTS (SELECT 1
			  FROM Empregado AS Emp
			  WHERE Emp.IDDepartamento = Dep.IDDepartamento
			  AND Emp.Salario = ( SELECT max(salario)
                                  FROM Empregado
                                  WHERE IDDepartamento IS NOT NULL ) );