CREATE TABLE Candidato
  (
    IDCandidato    INTEGER NOT NULL ,
    NomeCompleto   VARCHAR2 (100) NOT NULL ,
    NomePopular    VARCHAR2 (50) NOT NULL ,
    DataNascimento DATE NOT NULL ,
    RegistroTRE    VARCHAR2 (30) NOT NULL ,
    Foto           VARCHAR2 (150) NOT NULL ,
    NumeroEscolha  VARCHAR2 (2) NOT NULL ,
    IDCidade       INTEGER NOT NULL ,
    IDCargo        INTEGER NOT NULL ,
    IDPartido      INTEGER NOT NULL
  ) ;
ALTER TABLE Candidato ADD CONSTRAINT PK_Candidato_IDCandidato PRIMARY KEY ( IDCandidato ) ;
ALTER TABLE Candidato ADD CONSTRAINT UK_Candidato_NumeroEscolha UNIQUE ( NumeroEscolha ) ;
ALTER TABLE Candidato ADD CONSTRAINT UK_Candidato_RegistroTRE UNIQUE ( RegistroTRE ) ;


CREATE TABLE Cargo
  (
    IDCargo INTEGER NOT NULL ,
    Nome    VARCHAR2 (10) NOT NULL
  ) ;
ALTER TABLE Cargo ADD CONSTRAINT PK_Cargo_IDCargo PRIMARY KEY ( IDCargo ) ;


CREATE TABLE Cidade
  (
    IDCidade INTEGER NOT NULL ,
    Nome     VARCHAR2 (50) NOT NULL,
    IDEstado INTEGER NOT NULL
  ) ;
ALTER TABLE Cidade ADD CONSTRAINT PK_Cidade_IDCidade PRIMARY KEY ( IDCidade ) ;


CREATE TABLE Eleitor
  (
    IDEleitor      INTEGER NOT NULL ,
    NomeCompleto   VARCHAR2 (100) NOT NULL ,
    TituloEleitor  VARCHAR2 (20) NOT NULL ,
    RG             VARCHAR2 (10) NOT NULL ,
    DataNascimento DATE NOT NULL ,
    Zona           VARCHAR2 (3) NOT NULL ,
    Secao          VARCHAR2 (4) NOT NULL ,
    SituacaoVoto   VARCHAR2 (1) NOT NULL
  ) ;
ALTER TABLE Eleitor ADD CONSTRAINT PK_Eleitor_IDEleitor PRIMARY KEY ( IDEleitor ) ;
ALTER TABLE Eleitor ADD CONSTRAINT UK_Eleitor_RG UNIQUE ( RG ) ;
ALTER TABLE Eleitor ADD CONSTRAINT UK_Eleitor_TituloEleitor UNIQUE ( TituloEleitor ) ;


CREATE TABLE Estado
  (
    IDEstado INTEGER NOT NULL ,
    Nome     VARCHAR2 (50) NOT NULL ,
    UF       VARCHAR2 (2) NOT NULL
  ) ;
ALTER TABLE Estado ADD CONSTRAINT PK_Estado_IDEstado PRIMARY KEY ( IDEstado ) ;


CREATE TABLE Partido
  (
    IDPartido INTEGER NOT NULL ,
    Nome      VARCHAR2 (50) NOT NULL ,
    Sigla     VARCHAR2 (4) NOT NULL
  ) ;
ALTER TABLE Partido ADD CONSTRAINT PK_Partido_IDPartido PRIMARY KEY ( IDPartido ) ;


CREATE TABLE Voto
  ( IDVoto INTEGER NOT NULL , IDCandidato INTEGER NOT NULL
  ) ;
ALTER TABLE Voto ADD CONSTRAINT PK_Voto_IDVoto PRIMARY KEY ( IDVoto ) ;


ALTER TABLE Candidato ADD CONSTRAINT FK_Candidato_Cargo FOREIGN KEY ( IDCargo ) REFERENCES Cargo ( IDCargo ) ;

ALTER TABLE Candidato ADD CONSTRAINT FK_Candidato_Cidade FOREIGN KEY ( IDCidade ) REFERENCES Cidade ( IDCidade ) ;

ALTER TABLE Candidato ADD CONSTRAINT FK_Candidato_Partido FOREIGN KEY ( IDPartido ) REFERENCES Partido ( IDPartido ) ;

ALTER TABLE Cidade ADD CONSTRAINT FK_Cidade_Estado FOREIGN KEY ( IDEstado ) REFERENCES Estado ( IDEstado ) ;

ALTER TABLE Voto ADD CONSTRAINT FK_Voto_Candidato FOREIGN KEY ( IDCandidato ) REFERENCES Candidato ( IDCandidato ) ;