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
        private ProdutoServico produtoServico;

        [TestInitialize]
        public void InicializarProdutoServico()
        {
            produtoServico = new ProdutoServico(new ProdutoRepositorioMock());
        }

        [TestMethod]
        public void BuscarProdutoPorIdDeveRetornarProdutoComId1()
        {
            Produto produto = produtoServico.BuscarProdutoPorId(1);

            Assert.AreEqual(1, produto.Id);
            Assert.AreEqual("Nescau", produto.Nome);
            Assert.AreEqual(5.99M, produto.Valor);
        }

        [TestMethod]
        public void BuscarProdutoPorIdQueNaoExisteDeveRetornarNull()
        {
            Produto produto = produtoServico.BuscarProdutoPorId(10);

            Assert.IsNull(produto);
        }

        [TestMethod]
        public void SalvarComProdutoComIdDiferenteDe0DeveEditarProduto()
        {
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
            Produto produto = produtoServico.BuscarProdutoPorId(2);

            produtoServico.Excluir(produto);

            Produto produtoExcluido = produtoServico.BuscarProdutoPorId(4);

            Assert.IsNull(produtoExcluido);
        }

        [TestMethod]
        public void ListarProdutosDeveRetornarTodosOsProdutos()
        {
            IList<Produto> produtos = produtoServico.ListarProdutos();

            Assert.AreEqual(3, produtos.Count);
        }

        [TestMethod]
        [ExpectedException(typeof(ProdutoComNomePequenoException))]
        public void SalvarIncluindoProdutoComNomeDeTamanhoMenorQue2DeveLancarException()
        {
            Produto produto = new Produto()
            {
                Nome = "Ué",
                Valor = 5.99M
            };

            produtoServico.Salvar(produto);
        }

        [TestMethod]
        [ExpectedException(typeof(ProdutoComNomePequenoException))]
        public void SalvarEditandoProdutoParaNomeComTamanhoMenorQue2DeveLancarException()
        {
            Produto produto = new Produto()
            {
                Id = 1,
                Nome = "Nc",
                Valor = 5.99M
            };

            produtoServico.Salvar(produto);
        }

        [TestMethod]
        public void SalvarIncluindoProdutoComTamanhoDeNome3NaoDeveLancarException()
        {
            Produto produto = new Produto()
            {
                Nome = "Uva",
                Valor = 6.99M
            };

            produtoServico.Salvar(produto);
        }

        [TestMethod]
        [ExpectedException(typeof(ProdutoComNomePequenoException))]
        public void SalvarIncluindoProdutoComNomeNuloDeveLancarException()
        {
            Produto produto = new Produto()
            {
                Nome = null,
                Valor = 6.99M
            };

            produtoServico.Salvar(produto);
        }

        [TestMethod]
        [ExpectedException(typeof(ProdutoComNomePequenoException))]
        public void SalvarIncluindoProdutoComNomeVazioDeveLancarException()
        {
            Produto produto = new Produto()
            {
                Nome = "",
                Valor = 6.99M
            };

            produtoServico.Salvar(produto);
        }

        [TestMethod]
        [ExpectedException(typeof(ProdutoComValorZeradoException))]
        public void SalvarIncluindoProdutoComValorZeroDeveLancarException()
        {
            Produto produto = new Produto()
            {
                Nome = "Toddy",
                Valor = 0.0M
            };

            produtoServico.Salvar(produto);
        }

        [TestMethod]
        [ExpectedException(typeof(ProdutoComValorZeradoException))]
        public void SalvarEditandoProdutoParaValorZeroDeveLancarException()
        {
            Produto produto = new Produto()
            {
                Id = 1,
                Nome = "Nescau",
                Valor = 0.0M
            };

            produtoServico.Salvar(produto);
        }

        [TestMethod]
        public void SalvarIncluindoProdutoComValorZeroPontoTresNaoDeveLancarException()
        {
            Produto produto = new Produto()
            {
                Nome = "Toddy",
                Valor = 0.3M
            };

            produtoServico.Salvar(produto);
        }

        [TestMethod]
        [ExpectedException(typeof (ProdutoDuplicadoException))]
        public void SalvarIncluindoProdutoComNomeJaExistenteDeveLancarException()
        {
            Produto produto = new Produto()
            {
                Nome = "Nescau",
                Valor = 5.99M
            };

            produtoServico.Salvar(produto);
        }

        [TestMethod]
        public void SalvarEditandoProdutoENaoModificandoNomeNaoDeveLancarException()
        {
            Produto produto = new Produto()
            {
                Id = 1,
                Nome = "Nescau",
                Valor = 7.99M
            };

            produtoServico.Salvar(produto);
        }
    }
}
