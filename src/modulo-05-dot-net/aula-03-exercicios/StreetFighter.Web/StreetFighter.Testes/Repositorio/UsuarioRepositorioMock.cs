using StreetFighter.Repositorio;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using StreetFighter.Dominio;

namespace StreetFighter.Testes.Repositorio
{
    public class UsuarioRepositorioMock : UsuarioRepositorio
    {
        private List<Usuario> usuarios = new List<Usuario> {
                                                                new Usuario("joao paulo", "joaopaulo@gmail.com", "joaop", "b8cb9d3b6eab36d4bee7df01952652e2")
                                                           };

        protected override List<Usuario> lerUsuariosDoArquivoCsv()
        {
            return usuarios;
        }
    }
}
