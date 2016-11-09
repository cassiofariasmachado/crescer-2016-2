using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Loja.Dominio.Interfaces
{
    public interface IServicoDeCriptografia
    {
        string Criptografar(string texto);
    }
}
