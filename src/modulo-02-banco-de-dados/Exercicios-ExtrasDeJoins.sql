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