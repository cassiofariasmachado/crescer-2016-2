using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Loja.Dominio.Exceptions
{
    public class ValorZeradoException : ProdutoException
    {
        public ValorZeradoException() : base("Valor do produto não deve ser zero.") { }
    }
}
