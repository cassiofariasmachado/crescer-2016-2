-- Script de apoio para criar e popular tabela

create table Projeto  (
	Projeto             varchar(100),
	Responsavel         varchar(100),
	DataInicio          varchar(100),
	DataFimPrevisto     date,
	DataFimReal         date,
	ValorPrevisto       decimal(18,2),
	ValorRealizado      decimal(18,2),
	ValorFaturado       decimal(18,2),
	Empregado           varchar(100),
	ParticipacaoPerc    decimal(3,2)
);

insert into Projeto Values ('Projeto Atenas II', 'Heitor de Troia', convert(datetime, '21/07/2001',103), convert(datetime, '28/07/2011', 103),  convert(datetime, '10/04/2011', 103), 7851532326.14, 1969532326.14, 2500532326.14, 'Dardano', 1.00 );
insert into Projeto Values ('Projeto Atenas II', 'Heitor de Troia', convert(datetime, '21/07/2001',103), convert(datetime, '28/07/2011', 103),  convert(datetime, '10/04/2011', 103), 7851532326.14, 1969532326.14, 2500532326.14, 'Laomedonte', 1.00 );
insert into Projeto Values ('Projeto Atenas II', 'Heitor de Troia', convert(datetime, '21/07/2001',103), convert(datetime, '28/07/2011', 103),  convert(datetime, '10/04/2011', 103), 7851532326.14, 1969532326.14, 2500532326.14, 'Carlos Saldanha', 0.10 );
insert into Projeto Values ('Projeto Atenas II', 'Heitor de Troia', convert(datetime, '21/07/2001',103), convert(datetime, '28/07/2011', 103),  convert(datetime, '10/04/2011', 103), 7851532326.14, 1969532326.14, 2500532326.14, 'Pr�amo', 1.00 );
insert into Projeto Values ('Projeto Atenas II', 'Heitor de Troia', convert(datetime, '21/07/2001',103), convert(datetime, '28/07/2011', 103),  convert(datetime, '10/04/2011', 103), 7851532326.14, 1969532326.14, 2500532326.14, 'P�ris', 1.00 );
insert into Projeto Values ('Apollo XIII', 'James Lovell',          convert(datetime, '02/01/2010',103), convert(datetime, '25/04/2016', 103),  convert(datetime, '17/04/2016', 103), 350754000.65, 386754014.38, 386754014.38, 'Fred Haise', 1.00 );
insert into Projeto Values ('Apollo XIII', 'James Lovell',          convert(datetime, '02/01/2010',103), convert(datetime, '25/04/2016', 103),  convert(datetime, '17/04/2016', 103), 350754000.65, 386754014.38, 386754014.38, 'John Swigert', 1.00 );
insert into Projeto Values ('Apollo XIII', 'James Lovell',          convert(datetime, '02/01/2010',103), convert(datetime, '25/04/2016', 103),  convert(datetime, '17/04/2016', 103), 350754000.65, 386754014.38, 386754014.38, 'John Young', 0.90 );
insert into Projeto Values ('Apollo XIII', 'James Lovell',          convert(datetime, '02/01/2010',103), convert(datetime, '25/04/2016', 103),  convert(datetime, '17/04/2016', 103), 350754000.65, 386754014.38, 386754014.38, 'Charles Duke Jr', 0.90 );
insert into Projeto Values ('Apollo XIII', 'James Lovell',          convert(datetime, '02/01/2010',103), convert(datetime, '25/04/2016', 103),  convert(datetime, '17/04/2016', 103), 350754000.65, 386754014.38, 386754014.38, 'Carlos Saldanha', 0.10 );
insert into Projeto Values ('Sputinik', 'Ivan Korolev',             convert(datetime, '25/12/2009',103), convert(datetime, '25/10/2012', 103),  convert(datetime, '25/10/2012', 103), 79853154.50, 55953154.50, 79853154.50, 'Laika', 1.00 );
insert into Projeto Values ('Sputinik', 'Ivan Korolev',             convert(datetime, '25/12/2009',103), convert(datetime, '25/10/2012', 103),  convert(datetime, '25/10/2012', 103), 79853154.50, 55953154.50, 79853154.50, 'Carlos Saldanha', 0.10 );
insert into Projeto Values ('Vostok I', 'Sergei Korolev',           convert(datetime, '09/11/2005',103), convert(datetime, '12/04/2016', 103),  convert(datetime, '12/04/2016', 103), 765876200.00, 610176200.00, 765876200.00, 'Yuri Gagarin', 1.00 );
insert into Projeto Values ('Vostok I', 'Sergei Korolev',           convert(datetime, '09/11/2005',103), convert(datetime, '12/04/2016', 103),  convert(datetime, '12/04/2016', 103), 765876200.00, 610176200.00, 765876200.00, 'Kerim Kerimov', 1.00 );
insert into Projeto Values ('Vostok I', 'Sergei Korolev',           convert(datetime, '09/11/2005',103), convert(datetime, '12/04/2016', 103),  convert(datetime, '12/04/2016', 103), 765876200.00, 610176200.00, 765876200.00, 'Carlos Saldanha', 0.10 );
insert into Projeto Values ('Vostok I', 'Sergei Korolev', convert(datetime, '09/11/2005',103), convert(datetime, '12/04/2016', 103), convert(datetime, '12/04/2016', 103), 765876200.00, 610176200.00, 765876200.00, 'Valentina Tereshkova', 0.85 );

-- Exercicio 1
SELECT Empregado
FROM Projeto
GROUP BY Empregado
HAVING count(*) > 1;

-- Exercicio 2
SELECT DISTINCT Projeto
FROM Projeto
WHERE ValorFaturado > ValorRealizado;

-- Exercicio 3
SELECT DISTINCT Projeto, 
	   (valorFaturado - valorRealizado) / valorRealizado AS PercentualDePrejuizo
FROM Projeto
WHERE ValorFaturado < ValorRealizado;

-- Exercicio 4
SELECT DISTINCT Empregado AS NomeCompleto, 
	   CASE 
			WHEN CHARINDEX(' ', Empregado) = 0
				THEN Empregado
				ELSE SUBSTRING(Empregado, 1, CHARINDEX(' ', Empregado) - 1)
	   END AS PrimeiroNome
FROM Projeto;