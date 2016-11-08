using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace StreetFighter.Dominio
{
    public class Usuario
    {
        public int Id { get; set; }
        public string Nome { get; set; }
        public string Email { get; set; }
        public string Login { get; set; }
        public string Senha { get; set; }

        public Usuario(string nome, string email, string login, string senha)
        {
            this.Nome = nome;
            this.Email = email;
            this.Login = login;
            this.Senha = senha;
        }

    }
}
