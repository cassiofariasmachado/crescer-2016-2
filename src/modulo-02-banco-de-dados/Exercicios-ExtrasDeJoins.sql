-- Exericio 1
-- TO-DO: revisar.
SELECT Cid.UF,
	   CliPed.Nome,
	   CliPed.IDCliente,
	   CliPed.QuantidadePedidos
FROM ( SELECT TOP 1 WITH TIES Cli.IDCidade,
							  Cli.IDCliente,
						      Cli.Nome,
							  COUNT(*) AS QuantidadePedidos
	   FROM Cliente AS Cli
	   INNER JOIN ( SELECT IDCliente
				    FROM Pedido 
					WHERE DATEDIFF( MONTH, DataPedido, GETDATE() ) <= 3 ) AS Ped ON Ped.IDCliente = Cli.IDCliente
	   GROUP BY Cli.IDCliente, Cli.Nome, Cli.IDCidade
	   ORDER BY QuantidadePedidos DESC ) AS CliPed
INNER JOIN Cidade AS Cid ON Cid.IDCidade = CliPed.IDCidade
ORDER BY Cid.UF;

-- Exercicio 2
-- TO-DO: revisar
SELECT Cli.IDCliente,
	   Cli.Nome AS Nome_Cliente,
	   Cid.Nome AS Nome_Cidade,
	   Cid.UF
FROM Cliente AS Cli
INNER JOIN Cidade AS Cid ON Cid.IDCidade = Cli.IDCidade
WHERE Cid.Nome IN ( SELECT Nome
					FROM Cidade
					GROUP BY Nome
					HAVING COUNT(1) > 1 );

-- Exercicio 3
SELECT MIN(IDCidade),
	   Nome
FROM Cidade
GROUP BY Nome
HAVING COUNT(1) > 1;

-- Exericio 4
SELECT TOP 30 WITH TIES Pro.IDProduto,
						Pro.Nome,
						SUM ( Pro.PrecoVenda - Pro.PrecoCusto ) AS Total_Lucro
FROM Produto AS Pro
INNER JOIN PedidoItem AS PedIte ON PedIte.IDProduto = Pro.IDProduto
INNER JOIN Pedido AS Ped ON Ped.IDPedido = PedIte.IDPedido
WHERE YEAR(Ped.DataPedido) = 2016
GROUP BY Pro.IDProduto, Pro.Nome
ORDER BY Total_Lucro DESC;