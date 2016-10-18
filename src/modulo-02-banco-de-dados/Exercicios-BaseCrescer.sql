-- Exercicio 1
SELECT COUNT(*) 
FROM   Pedido
WHERE  DataPedido BETWEEN convert(datetime, '01/09/2016', 103) AND
	   convert(datetime, '30/09/2016', 103);

-- Exercico 2
SELECT Pro.IDProduto,
	   Pro.Nome,
	   Pro.Situacao
FROM   ProdutoMaterial AS ProMat
INNER JOIN Produto AS Pro ON     ProMat.IDProduto = Pro.IDProduto
WHERE  ProMat.IDMaterial = 15836;

-- Exercicio 3
SELECT Nome,
	   RazaoSocial
FROM   Cliente
WHERE  RazaoSocial LIKE('%LTDA%') OR 
       Nome LIKE('%LTDA%');

-- Exercicio 4
INSERT INTO Produto(Nome, PrecoCusto, PrecoVenda, Situacao)
	   VALUES ('Galocha Maragato', 35.67, 77.95, 'A');

-- Exercicio 5
SELECT Pro.IDProduto,
	   Pro.Nome
FROM Produto AS Pro
LEFT JOIN PedidoItem AS ProIte ON Pro.IDProduto = Pro.IDProduto
WHERE ProIte.IDProduto IS NULL;

-- Exercicio 6
-- Cidade com mais clientes
SELECT TOP 1 WITH TIES Cid.UF, 
	              COUNT(*) AS QuantidadeClientes
FROM Cidade AS Cid
INNER JOIN Cliente AS Cli ON Cid.IDCidade = Cli.IDCidade
GROUP BY Cid.UF
ORDER BY QuantidadeClientes DESC;

-- Cidade com menos clientes
SELECT TOP 1 WITH TIES Cid.UF, 
	              COUNT(*) AS QuantidadeClientes
FROM Cidade AS Cid
INNER JOIN Cliente AS Cli ON Cid.IDCidade = Cli.IDCidade
GROUP BY Cid.UF
ORDER BY QuantidadeClientes;

-- Exercicio 7
-- B)
SELECT Ped.IDPedido,
	   Ped.DataEntrega,
	   Ped.ValorPedido,
	   PedIte.Quantidade AS QuantidadeItens
FROM PedidoItem AS PedIte
INNER JOIN ( SELECT * 
			 FROM Pedido 
			 WHERE DataEntrega BETWEEN convert(datetime, '01/10/2016', 103) AND
				   convert(datetime, '31/10/2016', 103) ) AS Ped ON Ped.IDPedido = PedIte.IDPedido
INNER JOIN ( SELECT * 
			 FROM ProdutoMaterial
			 WHERE IDMaterial IN (14650, 15703, 15836, 16003, 16604, 17226) AND 
			       Quantidade IS NOT NULL) AS ProMat ON PedIte.IDProduto = ProMat.IDProduto;

-- C) 
SELECT Cli.IDCliente,
	   Cli.Nome,
	   Cli.RazaoSocial,
	   Cli.Endereco,
	   Cli.Bairro,
	   Cli.CEP,
	   Cli.Situacao
FROM PedidoItem AS PedIte
INNER JOIN ( SELECT * 
			 FROM Pedido 
			 WHERE DataEntrega BETWEEN convert(datetime, '01/10/2016', 103) AND
				   convert(datetime, '31/10/2016', 103) ) AS Ped ON Ped.IDPedido = PedIte.IDPedido
INNER JOIN ( SELECT * 
			 FROM ProdutoMaterial
			 WHERE IDMaterial IN (14650, 15703, 15836, 16003, 16604, 17226) AND 
				   Quantidade IS NOT NULL ) AS ProMat ON PedIte.IDProduto = ProMat.IDProduto
INNER JOIN Cliente AS Cli ON Cli.IDCliente = Ped.IDCliente;

-- Exercicio 8
SELECT Pro.IDProduto,
	   Pro.Nome
FROM Produto AS Pro
WHERE NOT EXISTS( SELECT IDProduto 
                  FROM ProdutoMaterial AS ProMat
			      WHERE ProMat.IDProduto = Pro.IDProduto );

-- Exercicio 9 
SELECT TOP 1 WITH TIES SUBSTRING(Nome, 0, CHARINDEX(' ', Nome)) AS PrimeiroNome, 
	   COUNT(1) AS Quantidade
FROM Cliente
GROUP BY SUBSTRING(Nome, 0, CHARINDEX(' ', Nome))
ORDER BY Quantidade DESC;

-- Exercicio 10 
UPDATE Produto
SET Situacao = 'F'
FROM Produto AS Pro
INNER JOIN ( SELECT IDProduto 
			 FROM	 ProdutoMaterial
			 WHERE IDMaterial IN (14650, 15703, 15836, 16003, 16604, 17226) ) AS ProMat ON ProMat.IDProduto = Pro.IDProduto;

UPDATE Produto
SET Situacao = 'Q'
FROM Produto AS Pro
INNER JOIN PedidoItem AS PedIte ON PedIte.IDProduto = Pro.IDProduto
INNER JOIN ( SELECT IDProduto
			 FROM ProdutoMaterial
			 WHERE IDMaterial NOT IN (14650, 15703, 15836, 16003, 16604, 17226) ) AS ProMat ON ProMat.IDProduto = Pro.IDProduto
INNER JOIN ( SELECT IDPedido
		     FROM Pedido
		     WHERE DATEDIFF( MONTH, DataPedido, GETDATE() ) >= 2 ) AS Ped ON Ped.IDPedido = PedIte.IDPedido;


UPDATE Produto
SET Situacao = 'A'
FROM Produto AS Pro
INNER JOIN ( SELECT IDProduto
			 FROM ProdutoMaterial
			 WHERE IDMaterial NOT IN (14650, 15703, 15836, 16003, 16604, 17226) ) AS ProMat ON ProMat.IDProduto = Pro.IDProduto
INNER JOIN PedidoItem AS PedIte ON PedIte.IDProduto = Pro.IDProduto
INNER JOIN ( SELECT IDPedido 
		     FROM Pedido
		     WHERE DATEDIFF( MONTH, DataPedido, GETDATE() ) < 2 ) AS Ped ON Ped.IDPedido = PedIte.IDPedido;