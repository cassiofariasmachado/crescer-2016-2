-- Inserindo valores na tabela Personagem
INSERT INTO Personagem (Nome, DataNascimento, Altura, Peso, Origem, GolpesEspeciais, UrlDaImagem, PersonagemOculto) 
			VALUES ('Chun-li', CONVERT(DATETIME, '12/12/2012', 103), 170, 59, 'China', 'Spining Bird Kick, Kikouken.','http://www.streetfighter.com.br/upload/editor/20120623181304_27.gif', 0);
INSERT INTO Personagem (Nome, DataNascimento, Altura, Peso, Origem, GolpesEspeciais, UrlDaImagem, PersonagemOculto) 
			VALUES ('Akuma', CONVERT(DATETIME, '13/01/1992', 103), 178, 80, 'Japao', 'Gouhadouken, Goushoryuken.', 'http://www.streetfighter.com.br/upload/editor/20131018003126_319.png', 0);
INSERT INTO Personagem (Nome, DataNascimento, Altura, Peso, Origem, GolpesEspeciais, UrlDaImagem, PersonagemOculto) 
			VALUES ('Sagat', CONVERT(DATETIME, '17/02/1991', 103), 189, 89, 'Africa do Sul', 'Tiger Genocide.', 'http://www.streetfighter.com.br/upload/editor/20131104191626_170.png', 1);
INSERT INTO Personagem (Nome, DataNascimento, Altura, Peso, Origem, GolpesEspeciais, UrlDaImagem, PersonagemOculto) 
			VALUES ('Balrog', CONVERT(DATETIME, '04/09/1968', 103), 198, 102, 'Estados Unidos', 'Turn Punch, Dash Straight, Dash Uppercut.', 'http://www.streetfighter.com.br/upload/editor/20131018003240_912.png', 1);
INSERT INTO Personagem (Nome, DataNascimento, Altura, Peso, Origem, GolpesEspeciais, UrlDaImagem, PersonagemOculto) 
			VALUES ('Blanka', CONVERT(DATETIME, '12/02/1966', 103), 192, 96, 'Brasil', 'Electric Thunder, Rolling Attack.', 'http://www.streetfighter.com.br/upload/editor/20120823194105_127.png', 0);

-- Inserindo valores na tabela Usuário
INSERT INTO Usuario (Nome, Email, Login, Senha)
			VALUES ('Cassio', 'cassiofariasmachado@yahoo.com', 'cassio', '62ad493901722f192190203ba08e91bc');
