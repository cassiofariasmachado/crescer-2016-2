using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Loja.Dominio.Interfaces
{
    public interface IProdutoRepositorio
    {
        Produto BuscarProdutoPorId(int id);
        IList<Produto> ListarProdutos();
        void IncluirProduto(Produto produto);
        void EditarProduto(Produto produto);
        void ExcluirProduto(Produto produto);
    }
}
