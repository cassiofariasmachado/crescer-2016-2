using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Loja.Dominio.Exceptions
{
    public class ProdutoDuplicadoException : ProdutoException
    {
        public ProdutoDuplicadoException() : base("Já existe um produto com este nome.") { }
    }
}
