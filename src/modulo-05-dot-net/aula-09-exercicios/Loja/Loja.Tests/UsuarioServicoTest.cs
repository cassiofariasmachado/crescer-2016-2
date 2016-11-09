using Loja.Dominio;
using Loja.Tests.Mocks;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Loja.Tests
{
    [TestClass]
    public class UsuarioServicoTest
    {
        [TestMethod]
        public void DeveAutenticarComSucesso()
        {
            var usuarioServico = new UsuarioServico(
                new UsuarioRepositorioMock(),
                new ServicoDeCriptografiaMock());

            Usuario usuario = usuarioServico.BuscarPorAutenticacao(
                "goku@bol.com", "abc123");

            Assert.IsNotNull(usuario);
        }

        [TestMethod]
        public void NaoDeveAutenticarComEmailInvalido()
        {
            var usuarioServico = new UsuarioServico(
                new UsuarioRepositorioMock(),
                new ServicoDeCriptografiaMock());

            Usuario usuario = usuarioServico.BuscarPorAutenticacao(
                "vegeta@yahoo.com", "abc123");

            Assert.IsNull(usuario);
        }

        [TestMethod]
        public void NaoDeveAutenticarComSenhaInvalida()
        {
            var usuarioServico = new UsuarioServico(
                new UsuarioRepositorioMock(),
                new ServicoDeCriptografiaMock());

            Usuario usuario = usuarioServico.BuscarPorAutenticacao(
                "goku@bol.com", "senhaErrada");

            Assert.IsNull(usuario);
        }

        [TestMethod]
        public void NaoDeveAutenticarComEmailESenhaInvalidos()
        {
            var usuarioServico = new UsuarioServico(
                new UsuarioRepositorioMock(),
                new ServicoDeCriptografiaMock());

            Usuario usuario = usuarioServico.BuscarPorAutenticacao(
                "emailErrado@hotmail.com", "senhaErrada");

            Assert.IsNull(usuario);
        }
    }
}
