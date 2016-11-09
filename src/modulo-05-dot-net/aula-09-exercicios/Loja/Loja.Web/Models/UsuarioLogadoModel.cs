using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace Loja.Web.Models
{
    public class UsuarioLogadoModel
    {
        public string Email { get; }

        public UsuarioLogadoModel(string email)
        {
            this.Email = email;
        }
    }
}