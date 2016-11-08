using StreetFighter.Dominio;
using StreetFighter.Dominio.Interfaces;
using StreetFighter.Infraestrutura;
using StreetFighter.Repositorio;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace StreetFighter.Aplicativo
{
    public class UsuarioAplicativo
    {
        private readonly IUsuarioRepositorio repositorio;

        public UsuarioAplicativo() : this(new UsuarioRepositorioAdo())
        {
        }

        internal UsuarioAplicativo(IUsuarioRepositorio repositorio)
        {
            this.repositorio = repositorio;
        }

        public Usuario BuscarUsuarioAutenticado(string login, string senha)
        {
            Usuario usuarioEncontrado = repositorio.BuscarUsuario(login);

            if (usuarioEncontrado == null)
                return null;

            string senhaDeComparacao =
                ServicoDeCriptografia.ConverterParaMD5($"{usuarioEncontrado.Email}_$_{senha}");

            if (usuarioEncontrado != null && usuarioEncontrado.Senha.Equals(senhaDeComparacao))
            {
                return usuarioEncontrado;
            }

            return null;
        }
    }

}
