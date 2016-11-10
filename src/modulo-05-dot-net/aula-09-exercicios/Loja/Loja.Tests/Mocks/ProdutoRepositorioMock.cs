using Loja.Dominio;
using Loja.Dominio.Interfaces;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Loja.Tests.Mocks
{
    class ProdutoRepositorioMock : IProdutoRepositorio
    {
        private IList<Produto> produtos;

        public ProdutoRepositorioMock()
        {
            this.produtos = new List<Produto>();
            this.produtos.Add(new Produto()
            {
                Id = 1,
                Nome = "Nescau",
                Valor = 5.99M
            });
            this.produtos.Add(new Produto()
            {
                Id = 2,
                Nome = "Ajax",
                Valor = 6.99M
            });
            this.produtos.Add(new Produto()
            {
                Id = 3,
                Nome = "Sucrilhos",
                Valor = 10.33M
            });
        }

        private int gerarProximoId()
        {
            int maiorId = 0;
            foreach (var produto in this.produtos)
            {
                if (produto.Id > maiorId)
                    maiorId = produto.Id;
            }
            return maiorId + 1;
        }

        public Produto BuscarProdutoPorId(int id)
        {
            return this.produtos.FirstOrDefault(produto => produto.Id == id);
        }

        public void EditarProduto(Produto produto)
        {
            for (int i = 0; i < produtos.Count; i++)
            {
                if (produtos[i].Id == produto.Id)
                {
                    produtos.RemoveAt(i);
                    produtos.Insert(i, produto);
                    break;
                }
            }
        }

        public void ExcluirProduto(Produto produto)
        {
            for (int i = 0; i < produtos.Count; i++)
            {
                if (produtos[i].Id == produto.Id)
                {
                    produtos.RemoveAt(i);
                    break;
                }
            }
        }

        public void IncluirProduto(Produto produto)
        {
            produto.Id = this.gerarProximoId();
            this.produtos.Add(produto);
        }

        public IList<Produto> ListarProdutos()
        {
            return this.produtos;
        }
    }
}
