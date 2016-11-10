using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Loja.Dominio.Exceptions
{
    public class ProdutoComNomePequenoException : ProdutoException
    {
        public ProdutoComNomePequenoException() : base("Nome do produto não deve ter menos que 3 caracteres.") { }
    }
}
