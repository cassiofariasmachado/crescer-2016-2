CREATE
  TABLE Colaborador
  (
    IDColaborador  INTEGER NOT NULL ,
    Nome           VARCHAR (50) NOT NULL ,
    DataNascimento DATETIME ,
    DataAdmissao   DATETIME
  )
  ON "default"
GO
ALTER TABLE Colaborador ADD CONSTRAINT PK_Colaborador_IDColaborador PRIMARY KEY
CLUSTERED (IDColaborador)
WITH
  (
    ALLOW_PAGE_LOCKS = ON ,
    ALLOW_ROW_LOCKS  = ON
  )
  ON "default"
GO

CREATE
  TABLE Projeto
  (
    IDProjeto       INTEGER NOT NULL ,
    Nome            VARCHAR (50) NOT NULL ,
    Responsavel     INTEGER NOT NULL ,
    DataInicio      DATETIME NOT NULL ,
    DataFimPrevisto DATETIME NOT NULL ,
    DataFimReal     DATETIME ,
    ValorPrevisto   DECIMAL (18,2) NOT NULL ,
    ValorRealizado  DECIMAL (18,2) ,
    ValorFaturado   DECIMAL (18,2)
  )
  ON "default"
GO
ALTER TABLE Projeto ADD CONSTRAINT PK_Projeto_IDProjeto PRIMARY KEY CLUSTERED (
IDProjeto)
WITH
  (
    ALLOW_PAGE_LOCKS = ON ,
    ALLOW_ROW_LOCKS  = ON
  )
  ON "default"
GO

CREATE
  TABLE ProjetoColaborador
  (
    IDProjetoColaborador INTEGER NOT NULL ,
    IDColaborador        INTEGER NOT NULL ,
    IDProjeto            INTEGER NOT NULL ,
    ParticipacaoPerc     DECIMAL (3,2) NOT NULL
  )
  ON "default"
GO
ALTER TABLE ProjetoColaborador ADD CONSTRAINT
PK_ProjetoColaborador_IDProjetoColaborador PRIMARY KEY CLUSTERED (
IDProjetoColaborador)
WITH
  (
    ALLOW_PAGE_LOCKS = ON ,
    ALLOW_ROW_LOCKS  = ON
  )
  ON "default"
GO

ALTER TABLE ProjetoColaborador
ADD CONSTRAINT FK_ProjetoColaborador_Colaborador FOREIGN KEY
(
IDColaborador
)
REFERENCES Colaborador
(
IDColaborador
)
ON
DELETE
  NO ACTION ON
UPDATE NO ACTION
GO

ALTER TABLE ProjetoColaborador
ADD CONSTRAINT FK_ProjetoColaborador_Projeto FOREIGN KEY
(
IDProjeto
)
REFERENCES Projeto
(
IDProjeto
)
ON
DELETE
  NO ACTION ON
UPDATE NO ACTION
GO

ALTER TABLE Projeto
ADD CONSTRAINT FK_Projeto_Colaborador FOREIGN KEY
(
Responsavel
)
REFERENCES Colaborador
(
IDColaborador
)
ON
DELETE
  NO ACTION ON
UPDATE NO ACTION
GO