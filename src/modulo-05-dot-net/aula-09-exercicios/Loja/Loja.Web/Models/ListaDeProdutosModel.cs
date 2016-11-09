using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace Loja.Web.Models
{
    public class ListaDeProdutosModel
    {
        public IList<ProdutoModel> Produtos { get; set; }

        public ListaDeProdutosModel(IList<ProdutoModel> produtos)
        {
            this.Produtos = produtos;
        }
    }
}