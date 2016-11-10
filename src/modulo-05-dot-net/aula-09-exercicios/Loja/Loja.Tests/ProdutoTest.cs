using System;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using Loja.Dominio.Exceptions;
using Loja.Dominio;

namespace Loja.Tests
{
    [TestClass]
    public class ProdutoTest
    {
        [TestMethod]
        [ExpectedException(typeof (NomePequenoException))]
        public void ProdutoComTamanhoDeNomeMenorQue2DeveLancarException()
        {
            Produto produto = new Produto()
            {
                Nome = "Ué"
            };
        }

        [TestMethod]
        public void ProdutoComTamanhoDeNome3NaoDeveLancarException()
        {
            Produto produto = new Produto()
            {
                Nome = "Uva"
            };

            Assert.AreEqual("Uva", produto.Nome);
        }

        [TestMethod]
        [ExpectedException(typeof (ValorZeradoException))]
        public void ProdutoComValorZeroDeveLancarException()
        {
            Produto produto = new Produto()
            {
                Valor = 0.0M
            };
        }

        [TestMethod]
        public void ProdutoComValorZeroVirgulaUmNaoDeveLancarException()
        {
            Produto produto = new Produto()
            {
                Valor = 0.3M
            };

            Assert.AreEqual(0.3M, produto.Valor);
        }
    }
}
