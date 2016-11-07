using StreetFighter.Dominio;
using StreetFighter.Dominio.Interfaces;
using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace StreetFighter.Repositorio
{
    public class UsuarioRepositorio : IUsuarioRepositorio
    {
        const string CaminhoArquivo = @"C:\Users\Cassio\Documents\git\crescer-2016-2\src\modulo-05-dot-net\aula-03-exercicios\StreetFighter.Web\StreetFighter.Repositorio\usuario-repositorio.csv";

        protected virtual List<Usuario> lerUsuariosDoArquivoCsv()
        {
            string[] usuariosComoString = File.ReadAllLines(CaminhoArquivo);
            List<Usuario> usuarios = new List<Usuario>();

            foreach (string usuarioComoString in usuariosComoString)
            {
                string[] atributos = usuarioComoString.Split(';');
                Usuario usuario = new Usuario( atributos[0],
                                               atributos[1],
                                               atributos[2],
                                               atributos[3] );
                usuarios.Add(usuario);
            }

            return usuarios;
        }


        public Usuario BuscarUsuario(string login)
        {
            List<Usuario> usuarios = this.lerUsuariosDoArquivoCsv();

            return usuarios.FirstOrDefault(usuario => usuario.Login.Equals(login));
        }
    }
}
