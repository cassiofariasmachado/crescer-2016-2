using System;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using StreetFighter.Aplicativo;
using StreetFighter.Dominio;
using FakeItEasy;

namespace StreetFighter.Testes.Aplicativo
{
    [TestClass]
    public class UsuarioAplicativoTest
    {
        [TestMethod]
        public void BuscarUsuarioAutenticadoDeveBuscarUsuario()
        {
            var repositorioFake = A.Fake<IUsuarioRepositorio>();

            var aplicativo = new UsuarioAplicativo(repositorioFake);

            aplicativo.BuscarUsuarioAutenticado("cassio", "123");

            A.CallTo(() => repositorioFake.BuscarUsuario("cassio"))
                .MustHaveHappened();
        }
    }
}
