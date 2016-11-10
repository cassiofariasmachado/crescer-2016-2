using System;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using Loja.Dominio;
using Loja.Tests.Mocks;
using System.Collections.Generic;
using Loja.Dominio.Exceptions;

namespace Loja.Tests
{
    [TestClass]
    public class ProdutoServicoTest
    {
        [TestMethod]
        public void BuscarProdutoPorIdDeveRetornarProdutoComId1()
        {
            ProdutoServico produtoServico = new ProdutoServico(new ProdutoRepositorioMock());

            Produto produto = produtoServico.BuscarProdutoPorId(1);

            Assert.AreEqual(1, produto.Id);
            Assert.AreEqual("Nescau", produto.Nome);
            Assert.AreEqual(5.99M, produto.Valor);
        }

        [TestMethod]
        public void BuscarProdutoPorIdQueNaoExisteDeveRetornarNull()
        {
            ProdutoServico produtoServico = new ProdutoServico(new ProdutoRepositorioMock());

            Produto produto = produtoServico.BuscarProdutoPorId(10);

            Assert.IsNull(produto);
        }

        [TestMethod]
        public void SalvarComProdutoComIdDiferenteDe0DeveEditarProduto()
        {
            ProdutoServico produtoServico = new ProdutoServico(new ProdutoRepositorioMock());

            Produto produto = new Produto()
            {
                Id = 1,
                Nome = "Toddy",
                Valor = 4.99M
            };

            produtoServico.Salvar(produto);

            Produto produtoEditado = produtoServico.BuscarProdutoPorId(1);

            Assert.AreEqual(1, produtoEditado.Id);
            Assert.AreEqual("Toddy", produtoEditado.Nome);
            Assert.AreEqual(4.99M, produtoEditado.Valor);
        }

        [TestMethod]
        public void SalvarComProdutoComIdIgualAZeroDeveIncluirProduto()
        {
            ProdutoServico produtoServico = new ProdutoServico(new ProdutoRepositorioMock());

            Produto produto = new Produto()
            {
                Id = 0,
                Nome = "Toddy",
                Valor = 5.50M
            };

            produtoServico.Salvar(produto);

            Produto produtoIncluido = produtoServico.BuscarProdutoPorId(4);

            Assert.AreEqual(4, produtoIncluido.Id);
            Assert.AreEqual("Toddy", produtoIncluido.Nome);
            Assert.AreEqual(5.50M, produtoIncluido.Valor);
        }

        [TestMethod]
        public void ExcluirDeveRemoverOProduto()
        {
            ProdutoServico produtoServico = new ProdutoServico(new ProdutoRepositorioMock());

            Produto produto = produtoServico.BuscarProdutoPorId(2);

            produtoServico.Excluir(produto);

            Produto produtoExcluido = produtoServico.BuscarProdutoPorId(4);

            Assert.IsNull(produtoExcluido);
        }

        [TestMethod]
        public void ListarProdutosDeveRetornarTodosOsProdutos()
        {
            ProdutoServico produtoServico = new ProdutoServico(new ProdutoRepositorioMock());

            IList<Produto> produtos = produtoServico.ListarProdutos();

            Assert.AreEqual(3, produtos.Count);
        }

        [TestMethod]
        [ExpectedException(typeof(ProdutoComNomePequenoException))]
        public void SalvarProdutoComTamanhoDeNomeMenorQue2DeveLancarException()
        {
            ProdutoServico produtoServico = new ProdutoServico(new ProdutoRepositorioMock());

            Produto produto = new Produto()
            {
                Nome = "Ué",
                Valor = 5.99M
            };

            produtoServico.Salvar(produto);
        }

        [TestMethod]
        public void SalvarProdutoComTamanhoDeNome3NaoDeveLancarException()
        {
            ProdutoServico produtoServico = new ProdutoServico(new ProdutoRepositorioMock());

            Produto produto = new Produto()
            {
                Nome = "Uva",
                Valor = 6.99M
            };

            produtoServico.Salvar(produto);

            Assert.AreEqual("Uva", produto.Nome);
        }

        [TestMethod]
        [ExpectedException(typeof(ProdutoComValorZeradoException))]
        public void ProdutoComValorZeroDeveLancarException()
        {
            ProdutoServico produtoServico = new ProdutoServico(new ProdutoRepositorioMock());

            Produto produto = new Produto()
            {
                Nome = "Toddy",
                Valor = 0.0M
            };

            produtoServico.Salvar(produto);
        }

        [TestMethod]
        public void ProdutoComValorZeroVirgulaUmNaoDeveLancarException()
        {
            ProdutoServico produtoServico = new ProdutoServico(new ProdutoRepositorioMock());

            Produto produto = new Produto()
            {
                Nome = "Toddy",
                Valor = 0.3M
            };

            produtoServico.Salvar(produto);

            Assert.AreEqual(0.3M, produto.Valor);
        }
    }
}
