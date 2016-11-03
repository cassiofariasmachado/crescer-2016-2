using System;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using StreetFighter.Dominio;

namespace StreetFighter.Testes.Dominio
{
    [TestClass]
    public class PersonagemTest
    {
        [TestMethod]
        public void CriaUmPersonagemComId()
        {
            int id = 1;
            string nome = "Chun-li";
            DateTime dataNascimento = new DateTime(2012, 12, 12);
            int altura = 170;
            double peso = 59;
            string origem = "China";
            string golpesEspeciais = "Spining Bird Kick, Kikouken.";
            string urlDaImagem = @"http://www.streetfighter.com.br/upload/editor/20120623181304_27.gif";
            bool personagemOculto = true;

            Personagem personagem = new Personagem( id, 
                                                    nome,
                                                    dataNascimento,
                                                    altura,
                                                    peso,
                                                    origem,
                                                    golpesEspeciais,
                                                    urlDaImagem,
                                                    personagemOculto);

            Assert.AreEqual(personagem.Id, id);
            Assert.AreEqual(personagem.Nome, nome);
            Assert.AreEqual(personagem.DataNascimento, dataNascimento);
            Assert.AreEqual(personagem.Altura, altura);
            Assert.AreEqual(personagem.Peso, peso);
            Assert.AreEqual(personagem.Origem, origem);
            Assert.AreEqual(personagem.GolpesEspeciais, golpesEspeciais);
            Assert.AreEqual(personagem.UrlDaImagem, urlDaImagem);
            Assert.AreEqual(personagem.PersonagemOculto, personagemOculto);
        }

        [TestMethod]
        public void CriaUmPersonagemSemId()
        {
            string nome = "Chun-li";
            DateTime dataNascimento = new DateTime(2012, 12, 12);
            int altura = 170;
            double peso = 59;
            string origem = "China";
            string golpesEspeciais = "Spining Bird Kick, Kikouken.";
            string urlDaImagem = @"http://www.streetfighter.com.br/upload/editor/20120623181304_27.gif";
            bool personagemOculto = true;

            Personagem personagem = new Personagem( nome,
                                                    dataNascimento,
                                                    altura,
                                                    peso,
                                                    origem,
                                                    golpesEspeciais,
                                                    urlDaImagem,
                                                    personagemOculto);

            Assert.AreEqual(personagem.Id, 0);
            Assert.AreEqual(personagem.Nome, nome);
            Assert.AreEqual(personagem.DataNascimento, dataNascimento);
            Assert.AreEqual(personagem.Altura, altura);
            Assert.AreEqual(personagem.Peso, peso);
            Assert.AreEqual(personagem.Origem, origem);
            Assert.AreEqual(personagem.GolpesEspeciais, golpesEspeciais);
            Assert.AreEqual(personagem.UrlDaImagem, urlDaImagem);
            Assert.AreEqual(personagem.PersonagemOculto, personagemOculto);
        }

        [TestMethod]
        public void CriaUmPersonagemComIdNaoInformandoUrlDaImagemEPersonagemOculto()
        {
            int id = 1;
            string nome = "Chun-li";
            DateTime dataNascimento = new DateTime(2012, 12, 12);
            int altura = 170;
            double peso = 59;
            string origem = "China";
            string golpesEspeciais = "Spining Bird Kick, Kikouken.";

            Personagem personagem = new Personagem( id,
                                                    nome,
                                                    dataNascimento,
                                                    altura,
                                                    peso,
                                                    origem,
                                                    golpesEspeciais );

            Assert.AreEqual(personagem.Id, id);
            Assert.AreEqual(personagem.Nome, nome);
            Assert.AreEqual(personagem.DataNascimento, dataNascimento);
            Assert.AreEqual(personagem.Altura, altura);
            Assert.AreEqual(personagem.Peso, peso);
            Assert.AreEqual(personagem.Origem, origem);
            Assert.AreEqual(personagem.GolpesEspeciais, golpesEspeciais);
            Assert.AreEqual(personagem.UrlDaImagem, "Não informado");
            Assert.AreEqual(personagem.PersonagemOculto, false);
        }
    }
}
