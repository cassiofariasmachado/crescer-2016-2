using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace StreetFighter.Dominio.Interfaces
{
    public interface IUsuarioRepositorio
    {
        Usuario BuscarUsuario(string login);
    }
}
