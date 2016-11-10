using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Loja.Dominio.Exceptions
{
    public class NomePequenoException : ProdutoException
    {
        public NomePequenoException() : base("Nome do produto não deve ter menos que 2 caracteres.") { }
    }
}
