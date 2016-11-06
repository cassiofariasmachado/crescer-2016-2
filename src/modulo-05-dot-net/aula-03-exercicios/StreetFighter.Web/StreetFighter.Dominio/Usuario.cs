using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace StreetFighter.Dominio
{
    public class Usuario
    {
        public string Nome { get; }
        public string Email { get; }
        public string Login { get; }
        public string Senha { get; }

        public Usuario(string nome, string email, string login, string senha)
        {
            this.Nome = nome;
            this.Email = email;
            this.Login = login;
            this.Senha = senha;
        }
    }
}
