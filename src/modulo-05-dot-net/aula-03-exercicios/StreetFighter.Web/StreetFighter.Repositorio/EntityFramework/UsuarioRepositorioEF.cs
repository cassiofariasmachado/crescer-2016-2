using StreetFighter.Dominio.Interfaces;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using StreetFighter.Dominio;

namespace StreetFighter.Repositorio.EntityFramework
{
    public class UsuarioRepositorioEF : IUsuarioRepositorio
    {
        public Usuario BuscarUsuario(string login)
        {
            using (var contexto = new DatabaseContext())
            {
                return contexto.Usuario.FirstOrDefault(personagem => personagem.Login.Equals(login));
            }
        }
    }
}
