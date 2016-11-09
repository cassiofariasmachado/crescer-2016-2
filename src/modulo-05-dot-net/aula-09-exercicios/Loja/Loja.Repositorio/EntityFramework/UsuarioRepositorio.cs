using Loja.Dominio;
using Loja.Dominio.Interfaces;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Loja.Repositorio.EntityFramework
{
    public class UsuarioRepositorio : IUsuarioRepositorio
    {
        public Usuario BuscarPorEmail(string email)
        {
            using (var context = new ContextoDeDados())
            {
                return context.Usuario.FirstOrDefault(u => u.Email.Equals(email));
            }
        }
    }
}
