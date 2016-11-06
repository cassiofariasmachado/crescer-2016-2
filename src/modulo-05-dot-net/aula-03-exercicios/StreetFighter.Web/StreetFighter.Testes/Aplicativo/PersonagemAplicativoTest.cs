using System;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using StreetFighter.Dominio;
using StreetFighter.Aplicativo;
using FakeItEasy;

namespace StreetFighter.Testes.Aplicativo
{
    [TestClass]
    public class PersonagemAplicativoTest
    {
        [TestMethod]
        public void SalvarPersonagemComId0DeveIncluir()
        {
            var repositorioFake = A.Fake<IPersonagemRepositorio>();

            var aplicativo = new PersonagemAplicativo(repositorioFake);
            var personagem = new Personagem("João", new DateTime(1997, 08, 12), 159, 89.9, "São Leopoldo", "Soco forte");

            aplicativo.Salvar(personagem);

            A.CallTo(() => repositorioFake.IncluirPersonagem(personagem))
                .MustHaveHappened();
        }

        [TestMethod]
        public void SalvarPersonagemComId1DeveEditar()
        {
            var repositorioFake = A.Fake<IPersonagemRepositorio>();

            var aplicativo = new PersonagemAplicativo(repositorioFake);
            var personagem = new Personagem(1, "João", new DateTime(1997, 08, 12), 159, 89.9, "São Leopoldo", "Soco forte");

            aplicativo.Salvar(personagem);

            A.CallTo(() => repositorioFake.EditarPersonagem(personagem))
                .MustHaveHappened();
        }

        [TestMethod]
        public void ListarPersonagensDeveListar()
        {
            var repositorioFake = A.Fake<IPersonagemRepositorio>();

            var aplicativo = new PersonagemAplicativo(repositorioFake);

            aplicativo.ListaPersonagens("");

            A.CallTo(() => repositorioFake.ListarPersonagens(""))
                .MustHaveHappened();
        }

        [TestMethod]
        public void BuscarPersonagemPorIdDeveBuscar()
        {
            var repositorioFake = A.Fake<IPersonagemRepositorio>();

            var aplicativo = new PersonagemAplicativo(repositorioFake);

            aplicativo.BuscarPersonagemPorId(3);

            A.CallTo(() => repositorioFake.BuscarPersonagemPorId(3))
                .MustHaveHappened();
        }

        [TestMethod]
        public void ExcluirPersonagemDeveExcluir()
        {
            var repositorioFake = A.Fake<IPersonagemRepositorio>();

            var aplicativo = new PersonagemAplicativo(repositorioFake);
            var personagem = new Personagem(1, "João", new DateTime(1997, 08, 12), 159, 89.9, "São Leopoldo", "Soco forte");

            aplicativo.ExcluirPersonagem(personagem);

            A.CallTo(() => repositorioFake.ExcluirPersonagem(personagem))
                .MustHaveHappened();
        }

    }
}
