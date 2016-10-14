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
INNER JOIN Produto AS Pro
ON     ProMat.IDProduto = Pro.IDProduto
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
SELECT Prod.IDProduto,
	   Prod.Nome
FROM Produto AS Prod
LEFT JOIN PedidoItem AS ProI
ON Prod.IDProduto = ProI.IDProduto
WHERE ProI.IDProduto IS NULL;

-- Exercicio 6
-- Cidade com mais clientes
SELECT TOP 1 WITH TIES Cid.UF, 
	              COUNT(*) AS QuantidadeClientes
FROM Cidade AS Cid
INNER JOIN Cliente AS Cli
ON Cid.IDCidade = Cli.IDCidade
GROUP BY Cid.UF
ORDER BY QuantidadeClientes DESC;

-- Cidade com menos clientes
SELECT TOP 1 WITH TIES Cid.UF, 
	              COUNT(*) AS QuantidadeClientes
FROM Cidade AS Cid
INNER JOIN Cliente AS Cli
ON Cid.IDCidade = Cli.IDCidade
GROUP BY Cid.UF
ORDER BY QuantidadeClientes;

-- Exercicio 7
-- B
SELECT *
FROM Pedido AS Ped
INNER JOIN PedidoItem AS PedI
ON Ped.IDPedido = PedI.IDPedido
INNER JOIN ( SELECT * 
			 FROM ProdutoMaterial AS ProdM
			 WHERE IDMaterial IN (14650, 15703, 15836, 16003, 16604, 17226) ) AS ProdM
ON PedI.IDProduto = ProdM.IDProduto
WHERE Ped.DataEntrega BETWEEN convert(datetime, '01/10/2016', 103) AND
				      convert(datetime, '31/10/2016', 103);

SELECT *
FROM PedidoItem AS PedI
INNER JOIN (SELECT * 
			FROM Pedido 
			WHERE DataEntrega BETWEEN convert(datetime, '01/10/2016', 103) AND
				      convert(datetime, '31/10/2016', 103)) AS Ped
ON Ped.IDPedido = PedI.IDPedido
INNER JOIN ( SELECT * 
			 FROM ProdutoMaterial AS ProdM
			 WHERE IDMaterial IN (14650, 15703, 15836, 16003, 16604, 17226) ) AS ProdM
ON PedI.IDProduto = ProdM.IDProduto




SELECT *
FROM Pedido;

SELECT *
FROM PedidoItem;

SELECT *
FROM ProdutoMaterial;




