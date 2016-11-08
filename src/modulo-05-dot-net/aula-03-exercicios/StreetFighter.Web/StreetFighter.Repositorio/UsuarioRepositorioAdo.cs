using StreetFighter.Dominio.Interfaces;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using StreetFighter.Dominio;
using System.Configuration;
using System.Data.SqlClient;

namespace StreetFighter.Repositorio
{
    public class UsuarioRepositorioAdo : RepositorioBase, IUsuarioRepositorio
    {
        public Usuario BuscarUsuario(string login)
        {
            Usuario usuario = null;

            using (var connection = new SqlConnection(ConnectionString))
            {
                connection.Open();

                string sql = $"SELECT TOP(1) * FROM Usuario WHERE Login = @param_login";

                var command = new SqlCommand(sql, connection);
                command.Parameters.Add(new SqlParameter("param_login", login));

                SqlDataReader reader = command.ExecuteReader();

                if (reader.Read())
                {
                    usuario = this.ConverterReaderParaUsuario(reader);
                }

                connection.Close();
            }
            return usuario;
        }

        private Usuario ConverterReaderParaUsuario(SqlDataReader reader)
        {
            return new Usuario( nome: reader["Nome"].ToString(),
                                email: reader["Email"].ToString(),
                                login: reader["Login"].ToString(),
                                senha: reader["Senha"].ToString() );
        }
    }
}
