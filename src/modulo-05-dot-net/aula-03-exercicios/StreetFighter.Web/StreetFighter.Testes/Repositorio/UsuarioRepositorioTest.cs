using Microsoft.VisualStudio.TestTools.UnitTesting;
using StreetFighter.Dominio;
using StreetFighter.Testes.Repositorio.Mocks;

namespace StreetFighter.Testes.Repositorio
{
    [TestClass]
    public class UsuarioRepositorioTest
    {
        [TestMethod]
        public void BuscaUsuarioDeveRetornarOUsuarioSeExistirUsuarioComOMesmoLogin()
        {
            UsuarioRepositorioMock repositorio = new UsuarioRepositorioMock();

            Usuario usuario = repositorio.BuscarUsuario("joaop");

            Assert.AreEqual("joao paulo", usuario.Nome);
        }

        [TestMethod]
        public void BuscaUsuarioDeveRetornarNullSeNaoExistirUsuarioComOMesmoLogin()
        {
            UsuarioRepositorioMock repositorio = new UsuarioRepositorioMock();

            Usuario usuario = repositorio.BuscarUsuario("pedro");

            Assert.IsNull(usuario);
        }


    }
}
