using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Loja.Dominio.Exceptions
{
    public class ProdutoComValorZeradoException : ProdutoException
    {
        public ProdutoComValorZeradoException() : base("Valor do produto não deve ser zero.") { }
    }
}
