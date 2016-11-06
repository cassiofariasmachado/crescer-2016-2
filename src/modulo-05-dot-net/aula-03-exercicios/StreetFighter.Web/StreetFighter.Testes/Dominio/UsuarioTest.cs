using System;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using StreetFighter.Dominio;

namespace StreetFighter.Testes.Dominio
{
    [TestClass]
    public class UsuarioTest
    {
        [TestMethod]
        public void CriarUsuarioDeveCriarUsuarioComNomeEmailLoginESenha()
        {
            string nome = "joao paulo";
            string email = "joaopaulo@gmail.com";
            string login = "joaop";
            string senha = "b8cb9d3b6eab36d4bee7df01952652e2";

            Usuario usuario = new Usuario(nome, email, login, senha);

            Assert.AreEqual(nome, usuario.Nome);
            Assert.AreEqual(email, usuario.Email);
            Assert.AreEqual(login, usuario.Login);
            Assert.AreEqual(senha, usuario.Senha);
        }
    }
}
