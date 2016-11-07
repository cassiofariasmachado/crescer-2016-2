using System;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using StreetFighter.Dominio;
using StreetFighter.Dominio.Exceptions;

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

            Personagem personagem = new Personagem(id, nome, dataNascimento, altura, peso, origem, golpesEspeciais, urlDaImagem, personagemOculto);

            Assert.AreEqual(id, personagem.Id);
            Assert.AreEqual(nome, personagem.Nome);
            Assert.AreEqual(dataNascimento, personagem.DataNascimento);
            Assert.AreEqual(altura, personagem.Altura);
            Assert.AreEqual(peso, personagem.Peso);
            Assert.AreEqual(origem, personagem.Origem);
            Assert.AreEqual(golpesEspeciais, personagem.GolpesEspeciais);
            Assert.AreEqual(urlDaImagem, personagem.UrlDaImagem);
            Assert.AreEqual(personagemOculto, personagem.PersonagemOculto);
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

            Personagem personagem = new Personagem(nome, dataNascimento, altura, peso, origem, golpesEspeciais, urlDaImagem, personagemOculto);

            Assert.AreEqual(null, personagem.Id);
            Assert.AreEqual(nome, personagem.Nome);
            Assert.AreEqual(dataNascimento, personagem.DataNascimento);
            Assert.AreEqual(altura, personagem.Altura);
            Assert.AreEqual(peso, personagem.Peso);
            Assert.AreEqual(origem, personagem.Origem);
            Assert.AreEqual(golpesEspeciais, personagem.GolpesEspeciais);
            Assert.AreEqual(urlDaImagem, personagem.UrlDaImagem);
            Assert.AreEqual(personagemOculto, personagem.PersonagemOculto);
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

            Personagem personagem = new Personagem(id, nome, dataNascimento, altura, peso, origem, golpesEspeciais);

            Assert.AreEqual(id, personagem.Id);
            Assert.AreEqual(nome, personagem.Nome);
            Assert.AreEqual(dataNascimento, personagem.DataNascimento);
            Assert.AreEqual(altura, personagem.Altura);
            Assert.AreEqual(peso, personagem.Peso);
            Assert.AreEqual(origem, personagem.Origem);
            Assert.AreEqual(golpesEspeciais, personagem.GolpesEspeciais);
            Assert.AreEqual("Não informado", personagem.UrlDaImagem);
            Assert.AreEqual(false, personagem.PersonagemOculto);
        }

        [TestMethod]
        public void CriaUmPersonagemRecebendoUmArrayDeStringComoParametro()
        {
            string personagemComoString = @"1;Chun-li;12/12/2012;170;59;China;Spining Bird Kick, Kikouken.;http://www.streetfighter.com.br/upload/editor/20120623181304_27.gif;true";

            Personagem personagem = new Personagem(personagemComoString.Split(';'));

            Assert.AreEqual(1, personagem.Id);
            Assert.AreEqual("Chun-li", personagem.Nome);
            Assert.AreEqual(new DateTime(2012, 12, 12), personagem.DataNascimento);
            Assert.AreEqual(170, personagem.Altura);
            Assert.AreEqual(59, personagem.Peso);
            Assert.AreEqual("China", personagem.Origem);
            Assert.AreEqual("Spining Bird Kick, Kikouken.", personagem.GolpesEspeciais);
            Assert.AreEqual(@"http://www.streetfighter.com.br/upload/editor/20120623181304_27.gif", personagem.UrlDaImagem);
            Assert.AreEqual(true, personagem.PersonagemOculto);
        }

        [TestMethod]
        [ExpectedException(typeof (PalavraReservadaException), "Não é permitido cadastrar personagens overpowered.")]
        public void CriarPesonagemComNomeNunesDeveLançarException()
        {
            int id = 1;
            string nome = "Nunes";
            DateTime dataNascimento = new DateTime(2012, 12, 12);
            int altura = 140;
            double peso = 70;
            string origem = "Taquara";
            string golpesEspeciais = "Piada fake.";

            Personagem personagem = new Personagem(id, nome, dataNascimento, altura, peso, origem, golpesEspeciais);
        }

        [TestMethod]
        [ExpectedException(typeof(LocalDeOrigemException), "Somente um personagem pode ser dessa região e esse personagem não é o Bernardo.")]
        public void CriarPesonagemComOrigemMorroDaPedraDeveLançarException()
        {
            int id = 1;
            string nome = "Bernardo";
            DateTime dataNascimento = new DateTime(2012, 12, 12);
            int altura = 180;
            double peso = 89;
            string origem = "Morro da pedra";
            string golpesEspeciais = "Transformar café e playlist de foco em código.";

            Personagem personagem = new Personagem(id, nome, dataNascimento, altura, peso, origem, golpesEspeciais);
        }

        [TestMethod]
        public void PersonagemToStringDeveRetornarTodosOsAtributosDoPersonagemComoString()
        {
            string personagemComoString = @"1;Chun-li;12/12/2012;170;59;China;Spining Bird Kick, Kikouken.;http://www.streetfighter.com.br/upload/editor/20120623181304_27.gif;true";

            Personagem personagem = new Personagem(personagemComoString.Split(';'));

            Assert.AreEqual(personagemComoString.ToUpperInvariant(), personagem.ToString().ToUpperInvariant());
        }
    }
}
