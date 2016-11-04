using System;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using System.Collections.Generic;
using FakeItEasy;
using StreetFighter.Repositorio;
using StreetFighter.Dominio;

namespace StreetFighter.Testes.Repositorio
{
    [TestClass]
    public class PersonagemRepositorioTest
    {
        [TestMethod]
        public void ListarPersonagensDeveRetornarAkuma()
        {
            PersonagemRepositorioMock repositorio = new PersonagemRepositorioMock();

            var personagens = repositorio.ListarPersonagens("Akuma");

            Assert.AreEqual("Akuma", personagens[0].Nome);
        }

        [TestMethod]
        public void IncluirPersonagemDeveAdicionarUmNovoPersonagemNoFimDaLista()
        {
            PersonagemRepositorioMock repositorio = new PersonagemRepositorioMock();

            repositorio.IncluirPersonagem(new Personagem(3, "Sagat", new DateTime(1991, 02, 17), 189, 89, "Africa do Sul", "Tiger Genocide.", @"http://www.streetfighter.com.br/upload/editor/20131104191626_170.png", false));

            Assert.AreEqual("Sagat", repositorio.ListarPersonagens()[2].Nome);
        }

        [TestMethod]
        public void EditarPersonagemDeveEditarONomeDoPersonagemComId2()
        {
            PersonagemRepositorioMock repositorio = new PersonagemRepositorioMock();

            repositorio.EditarPersonagem(new Personagem(2, "Gouki", new DateTime(1992, 01, 13), 178, 80, "Japão", "Gouhadouken, Goushoryuken.", @"http://www.streetfighter.com.br/upload/editor/20131018003126_319.png", true));

            Assert.AreEqual("Gouki", repositorio.ListarPersonagens()[1].Nome);
        }

        [TestMethod]
        public void ExcluirPersonagemDeveExcluirPersonagemComId2()
        {
            PersonagemRepositorioMock repositorio = new PersonagemRepositorioMock();

            repositorio.ExcluirPersonagem(new Personagem(2, "Akuma", new DateTime(1992, 01, 13), 178, 80, "Japão", "Gouhadouken, Goushoryuken.", @"http://www.streetfighter.com.br/upload/editor/20131018003126_319.png", true));

            Assert.AreEqual(1, repositorio.ListarPersonagens().Count);
        }
        
    }
}
