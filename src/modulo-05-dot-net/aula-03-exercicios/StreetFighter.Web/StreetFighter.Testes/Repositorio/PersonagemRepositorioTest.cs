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
        public void CriarPersonagemRepositorioRecebendoUmaListaDeStrings()
        {
            List<string> personagens = new List<string>(new string[] 
                                                                     {
                                                                        "1;Chun-li;12/12/2012;170;59;China;Spining Bird Kick, Kikouken.;http://www.streetfighter.com.br/upload/editor/20120623181304_27.gif;true",
                                                                        "2;Akuma;13/01/1992;178;80;Japão;Gouhadouken, Goushoryuken.;http://www.streetfighter.com.br/upload/editor/20131018003126_319.png;true"
                                                                     }
                                                       );

            var repositorio = new PersonagemRepositorio(personagens);

            Assert.AreEqual(1, repositorio.Personagens[0].Id);
            Assert.AreEqual(2, repositorio.Personagens[1].Id);
        }

        
    }
}
