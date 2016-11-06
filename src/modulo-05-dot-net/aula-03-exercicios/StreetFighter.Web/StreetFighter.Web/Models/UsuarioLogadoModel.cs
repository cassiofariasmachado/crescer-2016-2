using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace StreetFighter.Web.Models
{
    public class UsuarioLogadoModel
    {
        public string Login { get; }

        public UsuarioLogadoModel(string login)
        {
            this.Login = login;
        }
    }
}