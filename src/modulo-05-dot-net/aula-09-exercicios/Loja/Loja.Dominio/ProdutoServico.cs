using Loja.Dominio.Exceptions;
using Loja.Dominio.Interfaces;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Loja.Dominio
{
    public class ProdutoServico
    {
        private IProdutoRepositorio produtoRepositorio;

        public ProdutoServico(IProdutoRepositorio produtoRepositorio)
        {
            this.produtoRepositorio = produtoRepositorio;
        }

        public IList<Produto> ListarProdutos()
        {
            return this.produtoRepositorio.ListarProdutos();
        }

        public Produto BuscarProdutoPorId(int id)
        {
            return this.produtoRepositorio.BuscarProdutoPorId(id);
        }

        public void Salvar(Produto produto)
        {
            this.validarProduto(produto);

            if (produto.Id == 0)
                this.produtoRepositorio.IncluirProduto(produto);
            else
                this.produtoRepositorio.EditarProduto(produto);
        }

        public void Excluir(Produto produto)
        {
            this.produtoRepositorio.ExcluirProduto(produto);
        }

        private void validarProduto(Produto produto)
        {
            if (produto.Valor == 0.0M)
                throw new ProdutoComValorZeradoException();

            if (produto.Nome.Count() < 3)
                throw new ProdutoComNomePequenoException();

            if (this.produtoRepositorio.BuscarProdutoPorNome(produto.Nome) != null)
                throw new ProdutoDuplicadoException();
        }
    }
}
